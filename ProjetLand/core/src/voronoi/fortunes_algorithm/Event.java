package voronoi.fortunes_algorithm;

/**
 * This interface defines an event that occurs during the sweep of the algorithm.
 * It consists of two properties; a priority and a process.
 */
public interface Event {
	/**
	 * The location of the event.
	 * @return the location as a Point
	 */
	public Point location();
	
	/**
	 * The process to take place when this event is called.
	 * 
	 * @param tree the current tree state
	 */
	public BinaryTree<Event> process(BinaryTree<Event> tree);
}
