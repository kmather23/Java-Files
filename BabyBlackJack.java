import java.util.Random;
import java.util.Scanner;

public class BabyBlackjack
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);

		String HitMe = "hit";
		String PlayAgain = "Y";


		while ((PlayAgain == "Y") || (PlayAgain == "y")) {


			Random r = new Random();
			int min = 1;  
			int max = 11;

			//defines ranges of acceptable randoms
			int PlayerCard1 = r.nextInt(max - min + 1) + min;
			int PlayerCard2 = r.nextInt(max - min + 1) + min;
			int PlayerTotal = PlayerCard1 + PlayerCard2;
			int PlayerTotalHit = PlayerTotal;
			int DealerCard1 = r.nextInt(max - min + 1) + min;
			int DealerCard2 = r.nextInt(max - min + 1) + min;
			int DealerTotal = DealerCard1 + DealerCard2;
			int NextCard = 0;
			
			System.out.println( "Welcome to black jack" );
			System.out.println("");
			System.out.println( "The Dealer drew a " + DealerCard1 + " his other card is hidden and his total is unknown");
			System.out.println( "\nYou drew a " + PlayerCard1 + " and a " + PlayerCard2 );		
			System.out.println( "Your total is " + PlayerTotal );	
			System.out.println("");

			if (PlayerTotal <= 21) {
			System.out.println("Would you like to 'hit' or to 'stay'?");
			HitMe = keyboard.nextLine();
			}

			else {
				HitMe = "stay";
			}


			while ((!HitMe.equals("hit")) && (!HitMe.equals("hit")) && (!HitMe.equals("stay")) && (!HitMe.equals("stay"))) {
				System.out.println("Unacceptable response, please type 'hit' or 'stay'");
				HitMe = keyboard.nextLine();
			}


			//checks to see if you want another card and also doesn't allow you to take one if you are equal to or over 21
			while (HitMe.equals("hit") || HitMe.equals("hit")) {
				PlayerTotalHit = r.nextInt(max - min + 1) + min;
				PlayerTotal += PlayerTotalHit;
				System.out.println("You Drew a " + PlayerTotalHit + " \nyour total is " + PlayerTotal);
				
					
					if (PlayerTotal < 21) {
					System.out.println("\nWould you like to 'hit' or to 'stay'?");
					HitMe = keyboard.nextLine();
					}

					else {
					HitMe = "stay";
					System.out.println( "Your total exceeds 21. You've gone bust" );
					}

				//Catch unknown responses
				while ((!HitMe.equals("hit")) && (!HitMe.equals("HIT")) && (!HitMe.equals("stay")) && (!HitMe.equals("STAY"))) {
					System.out.println("Unacceptable response, please type 'hit' or stay");
					HitMe = keyboard.nextLine();
				}
			}

			if (DealerTotal <= 16) {
			System.out.println("\n\nDealer's turn");
			System.out.println("Dealer's hidden card is " + DealerCard2 + "\nhis total is " + DealerTotal);

			}
			//Dealer will always hit at a total lower than 17
			while (DealerTotal <= 16) {
			System.out.println("\nDealer chooses to hit");
			NextCard += (r.nextInt(max - min + 1) + min);
			DealerTotal += NextCard;
			System.out.println("He draws a " + NextCard + "\nhis total is " + DealerTotal);
			}
		
			//If the dealer's gone bust YOU WIN!	
			if (PlayerTotal < 21 && DealerTotal > 21) {
				System.out.println("");
				System.out.println( "The Dealer's total is " + DealerTotal);
				System.out.println( "Your total is " + PlayerTotal);
				System.out.println("");
				System.out.println("YOU WIN!");
			}
			//If you've gone bust the dealer wins
			else if (PlayerTotal > 21 && DealerTotal < 21) {
				System.out.println("");
				System.out.println( "The Dealer's total is " + DealerTotal);
				System.out.println( "Your total is " + PlayerTotal);
				System.out.println("");
				System.out.println("You Lose");
			}
			//If you both bust dealer wins
			else if (PlayerTotal > 21 && DealerTotal > 21) {
				System.out.println("");
				System.out.println( "The Dealer's total is " + DealerTotal);
				System.out.println( "Your total is " + PlayerTotal);
				System.out.println("");
				System.out.println("You Lose");
			}
			//If both are under 21 and dealer is higher you lose
			else if (PlayerTotal < DealerTotal) {
				System.out.println("");
				System.out.println( "The Dealer's total is " + DealerTotal);
				System.out.println( "Your total is " + PlayerTotal);
				System.out.println("");
				System.out.println("You Lose");
			}
			//If both are under 21 and you are higher YOU WIN!
			else if (PlayerTotal > DealerTotal) {
				System.out.println("");
				System.out.println( "The Dealer's total is " + DealerTotal);
				System.out.println( "Your total is " + PlayerTotal);
				System.out.println("");
				System.out.println("YOU WIN!");
			}
			//If both are under 21 and both are equal you lose
			else if (PlayerTotal == DealerTotal) {
				System.out.println("");
				System.out.println( "The Dealer's total is " + DealerTotal);
				System.out.println( "Your total is " + PlayerTotal);
				System.out.println("");
				System.out.println("Dealer Wins");
			}	
			//If both are under 21 and dealer is higher you lose
			else {
				System.out.println("unknown exception");
			}


		System.out.println("Would you like to play again (Y/N?)"); 
		PlayAgain = keyboard.nextLine();

			while ((!PlayAgain.equals("Y")) && (!PlayAgain.equals("y")) && (!PlayAgain.equals("N")) && (!PlayAgain.equals("n"))) {
						System.out.println("Unacceptable response, please type 'Y' or 'N'");
						PlayAgain = keyboard.nextLine();
					}

			if (!PlayAgain.equals("Y") && !PlayAgain.equals("y")) {
				System.out.println("\nGoodbye");
			}

			else {
				PlayAgain = "Y";
				System.out.println("\n******************************************************************");
				System.out.println("\n");
			}
		}	
	
	}
	
}
