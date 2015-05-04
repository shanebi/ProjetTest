package voronoi.fortunes_algorithm;

/**
 * This is a helper class to define a point in 2D space.
 */
public class Point {
	public int x;
	public int y;
	
	/**
	 * Make a new point
	 * @param x the x location
	 * @param y the y location
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Find the Euclidean distance from this point to the given point.
	 * 
	 * @param p the point to test
	 * @return the distance to the point
	 */
	public double distance_to(Point p) {
		return Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y = this.y), 2));
	}
}