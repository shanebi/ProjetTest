package voronoi.fortunes_algorithm;

import java.util.Comparator;

/**
 * Comparator for the Site class.
 */
public class EventPriorityComparator implements Comparator<Event> {

	@Override
	public int compare(Event event1, Event event2) {
		Point event1_location = event1.location();
		Point event2_location = event2.location();
		
		int x_compare = Integer.compare(event1_location.x, event2_location.x);
		int y_compare = Integer.compare(event1_location.y, event2_location.y);
		
		// site1 is < site 2 if site1.y < site2.y OR (site1.y == site2.y AND site1.x < site2.x)
		if(y_compare == 0) {
			return x_compare;
		} else {
			return y_compare;
		}
	}
}
