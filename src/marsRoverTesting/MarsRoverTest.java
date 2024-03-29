package marsRoverTesting;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.*;





import marsRoverChallenge.Rover;
import marsRoverChallenge.MarsPlateau;
import marsRoverChallenge.Plateau;

class MarsRoverTest {
	
	@Test
	public void plateauIsInitiated() {
		Plateau plateau = new Plateau(3,3);
		Assertions.assertNotNull(plateau);
	}
	
	@Test
	public void roverIsInitiated() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau, "RoverOne");
		Assertions.assertNotNull(roverOne);
	}
	
	@Test
	public void roverCanTurnLeft() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setDirectionFacing("N");
		roverOne.turnLeft();
		Assertions.assertEquals("W", roverOne.getDirectionFacing());
		roverOne.turnLeft();
		Assertions.assertEquals("S", roverOne.getDirectionFacing());
		roverOne.turnLeft();
		Assertions.assertEquals("E", roverOne.getDirectionFacing());
		roverOne.turnLeft();
		Assertions.assertEquals("N", roverOne.getDirectionFacing());
	}
	
	@Test
	public void roverCanTurnRight() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setDirectionFacing("N");
		roverOne.turnRight();
		Assertions.assertEquals("E", roverOne.getDirectionFacing());
		roverOne.turnRight();
		Assertions.assertEquals("S", roverOne.getDirectionFacing());
		roverOne.turnRight();
		Assertions.assertEquals("W", roverOne.getDirectionFacing());
		roverOne.turnRight();
		Assertions.assertEquals("N", roverOne.getDirectionFacing());
		
	}
	
	@Test
	public void roverCanMoveNorth() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setDirectionFacing("N");
		roverOne.setLeftCoordinate(0);
		roverOne.setRightCoordinate(0);
		roverOne.move();
		Assertions.assertEquals(0, roverOne.getLeftCoordinate());
		Assertions.assertEquals(1, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCanMoveEast() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setDirectionFacing("E");
		roverOne.setLeftCoordinate(0);
		roverOne.setRightCoordinate(0);
		roverOne.move();
		Assertions.assertEquals(1, roverOne.getLeftCoordinate());
		Assertions.assertEquals(0, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCanMoveSouth() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setDirectionFacing("S");
		roverOne.setLeftCoordinate(3);
		roverOne.setRightCoordinate(3);
		roverOne.move();
		Assertions.assertEquals(3, roverOne.getLeftCoordinate());
		Assertions.assertEquals(2, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCanMoveWest() {
		Plateau plateau = new Plateau(5, 5);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setDirectionFacing("W");
		roverOne.setLeftCoordinate(3);
		roverOne.setRightCoordinate(3);
		roverOne.move();
		Assertions.assertEquals(2, roverOne.getLeftCoordinate());
		Assertions.assertEquals(3, roverOne.getRightCoordinate());
	}
	
	
	@Test
	public void roverCantGoOffPlateauNorth() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setLeftCoordinate(2);
		roverOne.setRightCoordinate(3);
		roverOne.setDirectionFacing("N");
		roverOne.move();
		Assertions.assertEquals(3, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCantGoOffPlateauEast() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setLeftCoordinate(3);
		roverOne.setRightCoordinate(2);
		roverOne.setDirectionFacing("E");
		roverOne.move();
		Assertions.assertEquals(3, roverOne.getLeftCoordinate());
	}
	
	@Test
	public void roverCantGoOffPlateauSouth() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setLeftCoordinate(2);
		roverOne.setRightCoordinate(0);
		roverOne.setDirectionFacing("S");
		roverOne.move();
		Assertions.assertEquals(0, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCantGoOffPlateauWest() {
		Plateau plateau = new Plateau(0,2);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setLeftCoordinate(0);
		roverOne.setRightCoordinate(2);
		roverOne.setDirectionFacing("W");
		roverOne.move();
		Assertions.assertEquals(0, roverOne.getLeftCoordinate());
	}
	
	
	@Test
	public void roverCanInterpretInstructions() {
		Plateau plateau = new Plateau(10,8);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setLeftCoordinate(5);
		roverOne.setRightCoordinate(5);
		roverOne.setDirectionFacing("N");
		roverOne.interpretInstructions("LRMLRLMMMLM");
		Assertions.assertEquals(2, roverOne.getLeftCoordinate());
		Assertions.assertEquals(5, roverOne.getRightCoordinate());
		Assertions.assertEquals("S", roverOne.getDirectionFacing());
	}
	
	@Test 
	public void roverCanPrintLocation() {
		Plateau plateau = new Plateau(5,5);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setLeftCoordinate(5);
		roverOne.setRightCoordinate(2);
		roverOne.setDirectionFacing("E");	
		Assertions.assertEquals("5 2 E", roverOne.locationToString());
	}
	
	@Test
	public void roverCanReadLocation() {
		Plateau plateau = new Plateau(5,5);
		Rover roverOne = new Rover(plateau, "RoverOne");
	    String input = "2 3 W";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner userInput = new Scanner(System.in);
		MarsPlateau.readRoverLocation(roverOne, userInput);
		Assertions.assertEquals(2, roverOne.getLeftCoordinate());
		Assertions.assertEquals(3, roverOne.getRightCoordinate());
		Assertions.assertEquals("W", roverOne.getDirectionFacing());		
	}
	
	@Test
	public void canGetPlateauSizeFromInput() {
		String input = "10 8";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner userInput = new Scanner(System.in);
	    int[] plateauSize = MarsPlateau.getPlateauSizeFromInput(userInput);
	    Assertions.assertEquals(10, plateauSize[0]);
	    Assertions.assertEquals(8, plateauSize[1]);
	}
	
	@Test
	public void roverCanReadInstructions() {
		Plateau plateau = new Plateau(10,10);
		Rover roverOne = new Rover(plateau, "RoverOne");
		roverOne.setLeftCoordinate(5);
		roverOne.setRightCoordinate(5);
		roverOne.setDirectionFacing("N");
	    String input = "LRMLRLMMMLM";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner userInput = new Scanner(System.in);
		String checkedInstruction = MarsPlateau.readRoverInstructions(userInput, roverOne);
		Assertions.assertEquals("LRMLRLMMMLM", checkedInstruction);
	}
	
	
	
	
	
}
