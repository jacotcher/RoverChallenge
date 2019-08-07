package marsRoverChallenge.Testing;


import org.junit.jupiter.api.Test;

import org.junit.Assert;
import marsRoverChallenge.Rover;

class MarsRoverTest {
	
	@Test
	public void roverIsInitiated() {
		Rover roverOne = new Rover();
		Assert.assertEquals("N", roverOne.getDirectionFacing());
	}
	
	@Test
	public void roverCanTurnLeft() {
		Rover roverOne = new Rover();
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
		Rover roverOne = new Rover();
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
		Rover roverOne = new Rover();
		roverOne.setDirectionFacing("N");
		roverOne.setLeftCoordinate(0);
		roverOne.setRightCoordinate(0);
		roverOne.move();
		Assert.assertEquals(0, roverOne.getLeftCoordinate());
		Assert.assertEquals(1, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCanMoveEast() {
		Rover roverOne = new Rover();
		roverOne.setDirectionFacing("E");
		roverOne.setLeftCoordinate(0);
		roverOne.setRightCoordinate(0);
		roverOne.move();
		Assert.assertEquals(1, roverOne.getLeftCoordinate());
		Assert.assertEquals(0, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCanMoveSouth() {
		Rover roverOne = new Rover();
		roverOne.setDirectionFacing("S");
		roverOne.setLeftCoordinate(3);
		roverOne.setRightCoordinate(3);
		roverOne.move();
		Assert.assertEquals(3, roverOne.getLeftCoordinate());
		Assert.assertEquals(2, roverOne.getRightCoordinate());
	}
	
	@Test
	public void roverCanMoveWest() {
		Rover roverOne = new Rover();
		roverOne.setDirectionFacing("W");
		roverOne.setLeftCoordinate(3);
		roverOne.setRightCoordinate(3);
		roverOne.move();
		Assert.assertEquals(2, roverOne.getLeftCoordinate());
		Assert.assertEquals(3, roverOne.getRightCoordinate());
	}
	

}
