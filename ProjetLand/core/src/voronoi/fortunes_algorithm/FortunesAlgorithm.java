package voronoi.fortunes_algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * This is an implementation of Fortune's Algoriothm[1]. A new instance can be created with a set of sites, or without for a set of sites to be generated within a given bounds.
 * Layers can then be gathered from the object; the sites and the polygons it generates for the sites.
 * 
 * [1]:  Steven Fortune. A sweepline algorithm for Voronoi diagrams. Proceedings of the second annual symposium on Computational geometry. Yorktown Heights, New York, United States, pp.313–322. 1986
 *
 */
public class FortunesAlgorithm {
	/**
	 * The events that need to be considered.
	 */
	private PriorityQueue<Event> events;
	
	/**
	 * The sites that have been made.
	 */
	private ArrayList<Site> sites;
	
	/**
	 * The binary tree for the beach line.
	 */
	private BinaryTree<Event> beach_line_tree;
	
	/**
	 * This creates a new instance of the Fortune's algorithm wrapper, which will generate a set of Sites for itself within the given bounds
	 * 
	 * @param min_x the minimum Y coordinate
	 * @param min_y the minimum Y coordinate
	 * @param max_x the maximum X coordinate
	 * @param max_y the maximum Y coordinate
	 * @param number the number of sites to create
	 */
	public FortunesAlgorithm(int min_x, int min_y, int max_x, int max_y, int number) {
		// Set up the data stores
		this.events = new PriorityQueue<Event>(number, new EventPriorityComparator());
		this.sites = new ArrayList<Site>(number);
		
		// Make the number of sites needed
		Site s;
		for(int i = 0; i < number; i++) {
			s = new Site(min_x, min_y, max_x, max_y, this.sites);
			this.events.offer(s);
			this.sites.add(s);
		}
		
		// We now have a series of points that have been ordered correctly.
		// Start processing the events
		Event event;
		while(!events.isEmpty()) {
			// Look at the top of the sites queue and the top of the circles queue
			event = events.poll();
			beach_line_tree = event.process(beach_line_tree);
		}
		
		// Clean up
	}
	
	public ArrayList<Site> sites() {
		return this.sites;
	}
}
