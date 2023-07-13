package rockpaperscissorsgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends RockPaperScissors {

	private static Scanner sc = new Scanner(System.in);
	static int rating;

	static int getPlayerRating(String userName) { // checks if userExistsInFile. If yes then return rating else return 0
		File fileObject = new File(".\\ratings.txt");

		try {
			Scanner scanner = new Scanner(fileObject);
			while (scanner.hasNext()) {
				String str = scanner.next();
				if (str.equals(userName)) {
					int rating = scanner.nextInt();
					scanner.close();
					return rating;
				}
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {

		System.out.print("Enter your name: ");
		String userName = sc.nextLine();
		System.out.println("Hello, " + userName);

		rating = getPlayerRating(userName);

		System.out.println("Enter the options : ");
		String options = sc.nextLine();

		if (options.length() > 0) {
			String[] optionsArray = null;
			try {
				optionsArray = options.split(",");
			} catch (Exception ex) {
				System.out.println("Please enter game options as --> a,b,c,d");
			}
			initializeGameOptions(optionsArray);
		} else {
			initializeGameOptions();
		}
		System.out.println("Okay, let's start");
		while (true) {
			String userInput = sc.nextLine().trim().toLowerCase(); // trim() removes extra whitespaces from both sides
																	// of the string
			if (userInput.equals("!exit")) {
				System.out.println("Bye!");
				break;
			}
			if (userInput.equals("!rating")) {
				System.out.println("Your rating: " + rating);
				continue;
			}
			if (!gameOptions.contains(userInput)) {
				System.out.println("Invalid input");
				continue;
			}
			determineWinner(userInput, computerChosesOption());
		} // end of while

	}// end of main()

}