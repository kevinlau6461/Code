import java.util.Comparator;

/**
 * Compares to instances of NearEarthObjects based on their ApproachDate
 * 
 * @author Kevin Lau kevin.c.lau@stonybrook.edu 109048204
 *
 */
public class ApproachDateComparator implements Comparator<NearEarthObject> {

	/**
	 * Compare method returns 0 if they are equal returns 1 if argument 1 is
	 * greater than argument 2 otherwise return -1
	 */
	@Override
	public int compare(NearEarthObject o1, NearEarthObject o2) {
		if (o1.getClosestApproachDate() == o2.getClosestApproachDate())
			return 0;
		else if (o1.getClosestApproachDate() > o2.getClosestApproachDate())
			return 1;
		else
			return -1;
	}

}
