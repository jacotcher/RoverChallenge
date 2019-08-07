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

}
