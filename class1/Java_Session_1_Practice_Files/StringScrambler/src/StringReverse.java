import java.lang.Math;
import java.util.Scanner;
import java.lang.String;
public class StringReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word;
		char[] characters;
		String reversedWord="";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a word");
		word =  sc.next();
		
		characters=word.toCharArray();
		/***counting backwards from end of array to beginning, 
		 * add characters to string reversedWord. You could have 
		 * just printed out each character backwards as well, without
		 * adding it to a string.
		 ****/
		for (int i=characters.length-1; i>-1; i--){
		
			reversedWord=reversedWord + characters[i];
		}
		/*For each character in the array, swap it with another random character.
		 * First, place the character into a temp character, 
		 * then set the original character to the random character,
		 * then set the random character to the temp character (what the original character used to be).
		 */
		for (int i=0; i<characters.length; i++){
			int randomIndex=(int)(Math.random()*characters.length);
			char temp=characters[i];
				characters[i]=characters[randomIndex];
				characters[randomIndex]=temp;
			
		}
		System.out.println("You're word backwards ");
		System.out.println(reversedWord);
		System.out.println("You're word scrambled ");
		System.out.println(characters);
	}

}
