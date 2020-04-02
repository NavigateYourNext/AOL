package co.za.absa.TestUtilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitParaPhrase 
{
	//public static void splitPara(String paraPhrase)

	/*public static void main(String[] args)
	{
		String[] extractedDigits = splitPara("Please type the following characters from your password, 1, 4 and 5. This is password character number 1.");
		String[] getExtractedCharacters = getRequiredCharacters(extractedDigits, "password1");
	}
*/
	public static String[] splitPara(String paraPhrase)
	{
		String temp = paraPhrase;
		String digits = null;
		String extractedDigits[] = new String[3];


		Pattern pattern  = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(temp);

		int j=0;
		while(matcher.find() && j!=3)
		{
			digits = matcher.group();
			extractedDigits[j]=digits;
			j++;
		}

		return extractedDigits;	

	}

	public static String[] getRequiredCharacters(String[] extractedDigits,String paraPhrase)
	{
		char[] phraseArray = paraPhrase.toCharArray();
		String[] getPhraseCharacters = new String[3];
		
		int i=0;
		for(int j=0; j<extractedDigits.length; j++)
		{
			getPhraseCharacters[i] = Character.toString(phraseArray[Integer.parseInt(extractedDigits[j])-1]);
			i++;
		}
		
		
		return getPhraseCharacters;

	}
}
