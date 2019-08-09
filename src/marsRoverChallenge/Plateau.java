package marsRoverChallenge;

/** 
 * This class contains the contructor method, getters and setters that are needed to create an instance of Plateau
 * @author James Cotcher
 */
public class Plateau {
	
	private int width;
	private int height;
	
	/**
	 * Constructor method that sets the size of the plateau
	 * @author James Cotcher
	 * @param width an integer that is equivalent to the left coordinate of the top right of the plateau
	 * @param height an integer that is equivalent to the right coordinate of the top right of the plateau
	 */
	public Plateau(int width, int height) {
		this.width = width;
		this.height = height;
		
	}
	/**
	 * get method that returns the width of the plateau
	 * @author James Cotcher
	 * @return the width of the plateau
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * get method that returns the height of the plateau
	 * @author James Cotcher
	 * @return the width of the plateau
	 */
	public int getHeight() {
		return height;
	}
}
