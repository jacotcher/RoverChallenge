package marsRoverChallenge;

public class Rover {
	
	private int leftCoordinate;
	private int rightCoordinate;
	private String directionFacing = "N"; 

	public Rover(){
//		this.leftCoordinate = leftCoordinate;
//        this.rightCoordinate = rightCoordinate;
        this.directionFacing = directionFacing;
        
    }
	
//	Methods
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
	public void move() {
		switch (this.directionFacing) {
		case "N":
			this.rightCoordinate += 1;
			break;
		case "E":
			this.leftCoordinate += 1;
			break;
		case "S": 
			this.rightCoordinate -= 1;
			break;
		case "W":
			this.leftCoordinate -= 1;
			break;
		}
	}

	
//	Getters and setters
	public int getLeftCoordinate() {
		return leftCoordinate;
	}

	public void setLeftCoordinate(int leftCoordinate) {
		this.leftCoordinate = leftCoordinate;
	}

	public int getRightCoordinate() {
		return rightCoordinate;
	}

	public void setRightCoordinate(int rightCoordinate) {
		this.rightCoordinate = rightCoordinate;
	}

	public String getDirectionFacing() {
		return directionFacing;
	}

	public void setDirectionFacing(String directionFacing) {
		this.directionFacing = directionFacing;
	}
	
	
	
}
