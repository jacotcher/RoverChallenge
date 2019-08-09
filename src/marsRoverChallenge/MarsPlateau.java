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
		
//		Try to read the first line and initialise the plateau		
		int[] plateauSize = getPlateauSizeFromInput(input);
		Plateau plateau = new Plateau(plateauSize[0], plateauSize[1]);
			
//		Construct 2 Rovers 
		Rover roverOne = new Rover(plateau, "RoverOne");
		Rover roverTwo = new Rover(plateau, "RoverTwo");
		
// 		Read each Rover's locations and instructions
		readRoverLocation(roverOne, input);
		String roverOneInstructions = readRoverInstructions(input, roverOne);
		readRoverLocation(roverTwo, input);
		String roverTwoInstructions = readRoverInstructions(input, roverTwo);
		
		input.close();
		
//		Interpret the instructions of rover one, and perform those actions, then repeat for rover 2
		roverOne.interpretInstructions(roverOneInstructions);
		roverTwo.interpretInstructions(roverTwoInstructions);
		
//		Print output of where the Rovers are
		System.out.println(roverOne.locationToString());
		System.out.println(roverTwo.locationToString());		
		
	}
	
	/** Reads user input for rover's instructions, and checks whether the user has entered correct input with regex.
	 * 
	 * @author James Cotcher
	 * @param input A Scanner object for reading the user input
	 * @param rover The Rover that the instructions are for
	 * @return line The correctly formatted instructions for the rover
	 */
	public static String readRoverInstructions(Scanner input, Rover rover) {
		System.out.println("Now enter the instructions for " + rover.getName());
		boolean matchesRegex = false;
		String line = null;
		while(matchesRegex == false) {
			line = input.nextLine();
			if(line.matches("^[RL M]+$")) {
				matchesRegex=true;
			}
			else {
				System.out.println("Your instructions contain characters that are not R, L or M. Please fix your instructions and try again.");
			}
		}
		
		return line;
	}
	
	/**
	 * Interprets the Rover's location and heading from the user input before setting each value.
	 * @author James Cotcher
	 * @param input A Scanner object that is used to read the user's input
	 * @param rover The rover object that is going to be affected
	 */
	public static void readRoverLocation(Rover rover, Scanner input) {	
		boolean matchesRegex = false;
		String line = null;
		System.out.println("Now enter the location of " + rover.getName());
		while (matchesRegex == false) {
			
			line = input.nextLine();
			if(line.matches("^\\d+\\s\\d+\\s[NESW]$")) {
				
				int leftCoordinate = Integer.parseInt(line.substring(0, line.indexOf(" ")));
				String remainingString = line.substring(line.indexOf(" ")+1, line.length());
				int rightCoordinate = Integer.parseInt(remainingString.substring(0, line.indexOf(" ")));
				String directionFacing = line.substring(line.length()-1);
				if(leftCoordinate <= rover.plateau.getWidth() && leftCoordinate >= 0 && rightCoordinate <= rover.plateau.getHeight() && rightCoordinate >= 0) {
					rover.setLeftCoordinate(leftCoordinate);
					rover.setRightCoordinate(rightCoordinate);
					rover.setDirectionFacing(directionFacing);	
					matchesRegex = true;
				}
				else {
					System.out.println("The location you have given is not on the plateau! Please try again");
				}
			}
			else {
				System.out.println("Your location of the first rover needs to be in the form 5 5 E, where the 5s can be replaced by any integer, and the E can be replaced with N, E, S or W. Try again");
			}
		}
		
		
	}

	/**
	 * Interprets the plateau top-right coordinates from the user input 
	 * @author James Cotcher
	 * @return the top-right coordinates of the plateau
	 * @param input a Scanner object that is used to read user input
	 */
	public static int[] getPlateauSizeFromInput(Scanner input) {
		boolean matchesRegex = false;
		String line = null;
		System.out.println("Enter the top right coordinates of the plateau");
		while (matchesRegex == false) {
			
			line = input.nextLine();
			if(line.matches("^\\d+\\s\\d+$")) {
				matchesRegex = true;
			}
			else {
				System.out.println("Make sure the plateau coordinates are 2 numbers seperated by a whitespace");
			}
		}
		int leftCoordinate = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		int rightCoordinate = Integer.parseInt(line.substring(line.indexOf(" ")+1, line.length()));
		int[] plateauSize = {leftCoordinate, rightCoordinate};
		
		
		return plateauSize;		
	}
}

