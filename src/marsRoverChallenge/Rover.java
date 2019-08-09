package marsRoverChallenge;

/**
 * A class containing the methods that are needed to create an instance of the Rover object.
 * @author James Cotcher
 *
 */
public class Rover {
	
	/** 
	 * Name is the variable given to identify a rover
	 */
	private String name;
	/**
	 * leftCoordinate is the left coordinate of the current position of the rover.
	 */
	private int leftCoordinate;
	/**
	 * rightCoordinate is the right coordinate of the current position of the rover 
	 */
	private int rightCoordinate;
	/**
	 * directionFacing is the current direction that the rover is facing.
	 */
	private String directionFacing;
	/**
	 * plateau is an instance of Plateau that this Rover is navigating
	 */
	public Plateau plateau;
	
	/**
	 * Constructor method for creating the rover
	 * @author James Cotcher
	 * @param plateau an instance of the Plateau object that the rover will be 'navigating'
	 * @param name The name of the rover, used for identification purposes.
	 */
	public Rover(Plateau plateau, String name){
        this.plateau = plateau;
        this.name = name;
        
    }
	
	/**
	 * turnLeft will turn the rover left 90 degrees from it's current orientation
	 * @author James Cotcher
	 */
	public void turnLeft() {
		switch (this.directionFacing) {
			case "N":
				this.directionFacing = "W";
				break;
			case "W":
				this.directionFacing = "S";
				break;
			case "S": 
				this.directionFacing = "E";
				break;
			case "E":
				this.directionFacing = "N";
				break;
		}
		
	}
	/**
	 * turnRight will turn the rover right 90 degrees from it's current orientation
	 * @author James Cotcher
	 */
	public void turnRight() {
		switch (this.directionFacing) {
			case "N":
				this.directionFacing = "E";
				break;
			case "E":
				this.directionFacing = "S";
				break;
			case "S": 
				this.directionFacing = "W";
				break;
			case "W":
				this.directionFacing = "N";
				break;
		}
		
	}
	/**
	 * move will move the rover one square forward depending on it's orientation.
	 * If the rover is going to go off the side of the plateau, then the rover will not move, and the system will print which side of the plateau you are hitting.
	 * @author James Cotcher
	 */
	public void move() {
		switch (this.directionFacing) {
		case "N":
			if((this.rightCoordinate + 1) <= this.plateau.getHeight()) {
				this.rightCoordinate += 1;
			} else {
				System.out.println("If you moved any more north, the rover would fall off the plateau! This 'move' instruction was ignored.");
			}
			break;
			
		case "E":
			if((this.leftCoordinate + 1) <= this.plateau.getWidth()) {
				this.leftCoordinate += 1;
			} else {
				System.out.println("If you moved any more east, the rover would fall off the plateau! This 'move' instruction was ignored.");
			}
			break;
			
		case "S": 
			if((this.rightCoordinate - 1) >= 0) {
				this.rightCoordinate -= 1;
			} else {
				System.out.println("If you moved any more south, the rover would fall off the plateau! This 'move' instruction was ignored.");
			}
			break;
			
		case "W":
			if((this.leftCoordinate - 1) >= 0) {
				this.leftCoordinate -= 1;
			} else {
				System.out.println("If you moved any more west, the rover would fall off the plateau! This 'move' instruction was ignored.");
			}
			break;
		}
	}
	/**
	 * interpretInstructions will interpret each character in a string of instructions, and perform those actions. The string can contain any number of 'L''R' and 'M'.
	 * @param instructions - the user input instructions that are to be interpreted 
	 * @author James Cotcher
	 */
	public void interpretInstructions(String instructions) {
		for(int i=0; i<instructions.length(); i++) {
			switch(instructions.charAt(i)) {
				case 'L': 
					this.turnLeft();
					break;
				case 'R':
					this.turnRight();
					break;
				case 'M':
					this.move();
					break;
			}
		}
	}
	

	/**
	 * locationToString will return the current position and orientation of the rover
	 * @author James Cotcher
	 * @return The current position and orientation of the Rover.
	 */
	public String locationToString() {
		return leftCoordinate + " "+ rightCoordinate + " " + directionFacing;
	}
	
	/**
	 * 
	 * getName returns the name of the rover used for identification purposes
	 * @return name The name of the rover used for identification purposes
	 */
	public String getName() {
		return this.name;
	}
	

	/**
	 * getLeftCoordinate will get the left coordinate of the Rover's position
	 * @author James Cotcher
	 * @return leftCoordinate the left coordinate of the rover's position
	 */
	public int getLeftCoordinate() {
		return leftCoordinate;
	}
	/**
	 * setLeftCoordinate will set the left coordinate of the Rover's position
	 * @author James Cotcher
	 * @param leftCoordinate an integer representing the desired left-coordinate of the Rover
	 */
	public void setLeftCoordinate(int leftCoordinate) {
		this.leftCoordinate = leftCoordinate;
	}
	/**
	 * getRightCoordinate will get the right coordinate of the Rover's position
	 * @author James Cotcher
	 * @return rightCoordinate the right coordinate of the rover's position
	 */
	public int getRightCoordinate() {
		return rightCoordinate;
	}
	/**
	 * setRightCoordinate will set the right coordinate of the Rover's position
	 * @author James Cotcher
	 * @param rightCoordinate an integer representing the desired right-coordinate of the Rover
	 */
	public void setRightCoordinate(int rightCoordinate) {
		this.rightCoordinate = rightCoordinate;
	}
	/**
	 * getdirectionFacing will get the direction that the Rover is facing
	 * @author James Cotcher
	 * @return directionFacing is a one-character String of either "N", "E", "S" or "W".
	 */
	public String getDirectionFacing() {
		return directionFacing;
	}
	/**
	 * setdirectionFacing will set the direction that the Rover is facing
	 * @author James Cotcher
	 * @param directionFacing is a one-character String of either "N", "E", "S" or "W".
	 */
	public void setDirectionFacing(String directionFacing) {
		this.directionFacing = directionFacing;
	}
	

	
	
	
}
