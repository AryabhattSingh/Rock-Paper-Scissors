package rockpaperscissorsgame;

import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissors {
	
	static final ArrayList<String> gameOptions = new ArrayList<>();
	static int gameOptionsLength = 0;
	
	static void initializeGameOptions() {
		gameOptions.add("rock");
		gameOptions.add("paper");
		gameOptions.add("scissors");
		gameOptionsLength = gameOptions.size();
	}
	
	static void initializeGameOptions(String[] optionsArray) {
		for (int i = 0; i < optionsArray.length; i++) {
			gameOptions.add(optionsArray[i]);
		}
		gameOptionsLength = optionsArray.length;
	}

	static String computerChosesOption() {
		Random rand = new Random();
		int randomIndex =  rand.nextInt(0, gameOptionsLength);
		return gameOptions.get(randomIndex);
	}
	
	static void determineWinner(String userInputtedOption, String computerChosenOption) {
		
		if (userInputtedOption.equals(computerChosenOption)) {
			System.out.println("There is a draw (" + userInputtedOption + ")");
			Main.rating += 50;
			return;
		}
		
		// below is for when there is no draw
		
		int indexOfUserInputtedOption = gameOptions.indexOf(userInputtedOption);
		ArrayList<String> leftGameOptionsByUser = new ArrayList<>();
		
		for (int i = indexOfUserInputtedOption + 1; i < gameOptions.size(); i++) {
			leftGameOptionsByUser.add(gameOptions.get(i));
		}
		for (int i = 0; i < indexOfUserInputtedOption; i++) {
			leftGameOptionsByUser.add(gameOptions.get(i));
		}
		
		int midOfLeftGameOptions = leftGameOptionsByUser.size() / 2;
		int indexOfComputerChosenOption = leftGameOptionsByUser.indexOf(computerChosenOption);
		
		if (indexOfComputerChosenOption < midOfLeftGameOptions) {
			System.out.println("Sorry, but the computer chose " + computerChosenOption);
		}
		else {
			System.out.println("Well done. The computer chose " + computerChosenOption + " and failed");
			Main.rating += 100;
		}
		
	}
	
}
