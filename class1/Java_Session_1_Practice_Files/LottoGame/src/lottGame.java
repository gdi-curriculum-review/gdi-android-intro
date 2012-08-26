import java.lang.Math;
import java.util.Scanner;
public class lottGame {
	
	
	public static void main(String[] args) {
		 int guess;
		 int answer;
		 Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Guess a number between 1 and 6");
		guess =  sc.nextInt();
		answer = (int)(Math.random()*6+1);
		if (guess==answer){
			System.out.println("Congratulations! You guessed right!");
		}
		else {
			System.out.println("Sorry, that wasn't right. The correct answer was " + answer+".");
		}
	}

}
