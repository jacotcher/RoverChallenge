package marsRoverChallenge.Testing;


import org.junit.jupiter.api.Test;

import org.junit.Assert;
import marsRoverChallenge.Rover;
import marsRoverChallenge.MarsPlateau;
import marsRoverChallenge.Plateau;

class MarsRoverTest {
	
	@Test
	public void plateauIsInitiated() {
		Plateau plateau = new Plateau(3,3);
		Assert.assertNotNull(plateau);
	}
	
	@Test
	public void roverIsInitiated() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau);
		Assert.assertNotNull(roverOne);
	}
	
	@Test
	public void roverCanTurnLeft() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau);
		roverOne.setDirectionFacing("N");
		roverOne.turnLeft();
		Assert.assertEquals("W", roverOne.getDirectionFacing());
		roverOne.turnLeft();
		Assert.assertEquals("S", roverOne.getDirectionFacing());
		roverOne.turnLeft();
		Assert.assertEquals("E", roverOne.getDirectionFacing());
		roverOne.turnLeft();
		Assert.assertEquals("N", roverOne.getDirectionFacing());
	}
	
	@Test
	public void roverCanTurnRight() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau);
		roverOne.setDirectionFacing("N");
		roverOne.turnRight();
		Assert.assertEquals("E", roverOne.getDirectionFacing());
		roverOne.turnRight();
		Assert.assertEquals("S", roverOne.getDirectionFacing());
		roverOne.turnRight();
		Assert.assertEquals("W", roverOne.getDirectionFacing());
		roverOne.turnRight();
		Assert.assertEquals("N", roverOne.getDirectionFacing());
		
	}
	
	@Test
	public void roverCanMoveNorth() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau);
		roverOne.setDirectionFacing("N");
		roverOne.setLeftCoordinate(0);
		roverOne.setRightCoordinate(0);
		roverOne.move();
		Assert.assertEquals(0, roverOne.getLeftCoordinate());
		Assert.assertEquals(1, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCanMoveEast() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau);
		roverOne.setDirectionFacing("E");
		roverOne.setLeftCoordinate(0);
		roverOne.setRightCoordinate(0);
		roverOne.move();
		Assert.assertEquals(1, roverOne.getLeftCoordinate());
		Assert.assertEquals(0, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCanMoveSouth() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau);
		roverOne.setDirectionFacing("S");
		roverOne.setLeftCoordinate(3);
		roverOne.setRightCoordinate(3);
		roverOne.move();
		Assert.assertEquals(3, roverOne.getLeftCoordinate());
		Assert.assertEquals(2, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCanMoveWest() {
		Plateau plateau = new Plateau(5, 5);
		Rover roverOne = new Rover(plateau);
		roverOne.setDirectionFacing("W");
		roverOne.setLeftCoordinate(3);
		roverOne.setRightCoordinate(3);
		roverOne.move();
		Assert.assertEquals(2, roverOne.getLeftCoordinate());
		Assert.assertEquals(3, roverOne.getRightCoordinate());
	}
	
	
	@Test
	public void roverCantGoOffPlateauNorth() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau);
		roverOne.setLeftCoordinate(2);
		roverOne.setRightCoordinate(3);
		roverOne.setDirectionFacing("N");
		roverOne.move();
		Assert.assertEquals(3, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCantGoOffPlateauEast() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau);
		roverOne.setLeftCoordinate(3);
		roverOne.setRightCoordinate(2);
		roverOne.setDirectionFacing("E");
		roverOne.move();
		Assert.assertEquals(3, roverOne.getLeftCoordinate());
	}
	
	@Test
	public void roverCantGoOffPlateauSouth() {
		Plateau plateau = new Plateau(3,3);
		Rover roverOne = new Rover(plateau);
		roverOne.setLeftCoordinate(2);
		roverOne.setRightCoordinate(0);
		roverOne.setDirectionFacing("S");
		roverOne.move();
		Assert.assertEquals(0, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCantGoOffPlateauWest() {
		Plateau plateau = new Plateau(0,2);
		Rover roverOne = new Rover(plateau);
		roverOne.setLeftCoordinate(0);
		roverOne.setRightCoordinate(2);
		roverOne.setDirectionFacing("W");
		roverOne.move();
		Assert.assertEquals(0, roverOne.getLeftCoordinate());
	}
	
//	Put in tests about reading input 
	@Test
	public void programCanReadRoverLocation() {
		Plateau plateau = new Plateau(5,5);
		Rover roverOne = new Rover(plateau);
		MarsPlateau.readRoverLocation("4 5 E", roverOne);
		Assert.assertEquals(4, roverOne.getLeftCoordinate());
		Assert.assertEquals(5, roverOne.getRightCoordinate());
		Assert.assertEquals("E", roverOne.getDirectionFacing());
	}
	
	@Test
	public void roverCanInterpretInstructions() {
		Plateau plateau = new Plateau(5,5);
		Rover roverOne = new Rover(plateau);
		roverOne.setLeftCoordinate(1);
		roverOne.setRightCoordinate(1);
		roverOne.setDirectionFacing("E");
		roverOne.interpretInstructions("MLMMRM");
		Assert.assertEquals(3, roverOne.getLeftCoordinate());
		Assert.assertEquals(3, roverOne.getRightCoordinate());
		Assert.assertEquals("E", roverOne.getDirectionFacing());
	}
	
	@Test 
	public void roverCanPrintLocation() {
		Plateau plateau = new Plateau(5,5);
		Rover roverOne = new Rover(plateau);
		roverOne.setLeftCoordinate(5);
		roverOne.setRightCoordinate(2);
		roverOne.setDirectionFacing("E");	
		Assert.assertEquals("5 2 E", roverOne.locationToString());
	}
	

}
