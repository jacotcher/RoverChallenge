package marsRoverChallenge;

import java.util.Scanner;


/**
 * Contains the main method of the mars Rover program as well as methods for reading user input.
 * @author James Cotcher
 */
public class MarsPlateau {
	/**
	 * The main method. It reads the user input, initialises a plateau and 2 rovers and manipulates their position
	 * @author James Cotcher
	 */
	public static void main(String[] args){	
		
		Scanner input = new Scanner(System.in);	
		
//		Initialise Scanner for user Input
		
		int[] plateauSize = getPlateauSizeFromInput(readInput(input));
		Plateau plateau = new Plateau(plateauSize[0], plateauSize[1]);
			
//		Read instructions for size of plateau and construct plateau and 2 Rovers
		
		
		Rover roverOne = new Rover(plateau);
		Rover roverTwo = new Rover(plateau);
		
// 		Read each Rover's locations and instructions
		readRoverLocation(readInput(input), roverOne);
		String roverOneInstructions = readInput(input);
		readRoverLocation(readInput(input), roverTwo);
		String roverTwoInstructions = readInput(input);
		input.close();	
		
//		Interpret the instructions of rover one, and perform those actions, then repeat for rover 2
		roverOne.interpretInstructions(roverOneInstructions);
		roverTwo.interpretInstructions(roverTwoInstructions);
		
//		Print output of where the Rovers are
		System.out.println(roverOne.locationToString());
		System.out.println(roverTwo.locationToString());
		
		
	}

	
	/**
	 * Reads the next line of input from the user
	 *
	 * @author James Cotcher
	 * @param 'input' a Scanner object to facilitate reading of user input
	 * @return the entered input as a string
	 */
	public static String readInput(Scanner input) {
		String line = input.nextLine();
		return line;
	}
	
	/**
	 * Interprets the Rover's location and heading from the user input before setting each value.
	 * @author James Cotcher
	 * @param 'line' a String containing the user's input
	 * @param 'rover' The rover object that is going to be affected
	 */
	public static void readRoverLocation(String line, Rover rover) {
		int leftCoordinate = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		String remainingString = line.substring(line.indexOf(" ")+1, line.length());
		int rightCoordinate = Integer.parseInt(remainingString.substring(0, line.indexOf(" ")));
		String directionFacing = line.substring(line.length()-1);
		rover.setLeftCoordinate(leftCoordinate);
		rover.setRightCoordinate(rightCoordinate);
		rover.setDirectionFacing(directionFacing);	
	}

	/**
	 * Interprets the plateau top-right coordinates from the user input 
	 * @author James Cotcher
	 * @return the top-right coordinates of the plateau
	 * @param 'line' a String containing the user's input
	 */
	public static int[] getPlateauSizeFromInput(String line) {
		int leftCoordinate = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		int rightCoordinate = Integer.parseInt(line.substring(line.indexOf(" ")+1, line.length()));
		int[] plateauSize = {leftCoordinate, rightCoordinate};
		
		return plateauSize;		
	}
}

