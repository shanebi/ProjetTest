package voronoi.fortunes_algorithm;

import java.util.ArrayList;
import java.util.Random;

/**
 * A site is a point in the Voronoi diagram that the polygons will be formed around.
 * This is basically a point in 2D space.
 * 
 * We want to create sites with random xy locations within a bound space, and also maintain a
 * list of the sites that have currently been created. When we create a new site, we want to ensure that
 * it is not within a 5-unit distance of an existing site.
 */
public class Site implements Event {
	/**
	 * The distance from which all sites must be.
	 */
	private static final int SITE_GRACE_DISTACE = 10;
	
	/**
	 * The random generator used for the site generation.
	 */
	private static Random rand;
	
	/**
	 * The location of the site.
	 */
	private Point location;
	
	/**
	 * Accessor for the location of the Site.
	 * 
	 * @return the coordinates of the site
	 */
	public Point location() {
		return this.location;
	}
	
	/**
	 * Create a new Site based around a set of existing points, within a bound space.
	 * 
	 * @param min_x the minimum X that is permitted
	 * @param min_y the minimum Y that is permitted
	 * @param max_x the maximum X that is permitted
	 * @param max_y the maximum Y that is permitted
	 * @param sites the sites that have been made so far
	 */
	public Site(int min_x, int min_y, int max_x, int max_y, ArrayList<Site> existing_sites) {
		int random_x, random_y;
		do {
			// Get a random X within the given bounds
			random_x = random_within(min_x, max_x);
		
			// Get a random Y within the given bounds
			random_y = random_within(min_y, max_y);
		} while(has_clash(random_x, random_y, existing_sites));
		
		// Set the data
		this.location = new Point(random_x, random_y);
	}
	
	@Override
	public BinaryTree<Event> process(BinaryTree<Event> tree) {
		if(tree == null) {
			return new BinaryTree<Event>(this, new EventPriorityComparator());
		} else {
			return tree;
		}
	}
	
	/**
	 * Find the Euclidean distance from this site to the given point.
	 * 
	 * @param p the point to test
	 * @return the distance to the point
	 */
	public double distance_to(Point p) {
		return this.location.distance_to(p);
	}
	
	/**
	 * Get a random integer within the given bounds.
	 * 
	 * @param min the minimum bound
	 * @param max the maximum bound
	 * @return the random number
	 */
	private int random_within(int min, int max) {
		// Initialise the random generator if needed
		if(Site.rand == null) {
			Site.rand = new Random();
		}
		return Site.rand.nextInt(max - min) + min;
	}

	/**
	 * Check if there is a clash between the given xy and an existing site.
	 * 
	 * @param x the x location to check
	 * @param y the y location to check
	 * @param existing_sites the existing sites to check
	 * @return true if there is a clash; false otherwise
	 */
	private boolean has_clash(int x, int y, ArrayList<Site> existing_sites) {
		// Fast return if there are no sites to compare against
		if(existing_sites.isEmpty()) {
			return false;
		}
		Point test = new Point(x, y);
		for(Site site : existing_sites) {
			if(site.location().distance_to(test) <= SITE_GRACE_DISTACE) {
				return true;
			}
		}
		return false;
	}

}
