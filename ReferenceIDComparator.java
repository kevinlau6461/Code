import java.util.Comparator;

/**
 * Compares two NearEarthObjects based on their ReferenceID
 * 
 * @author Kevin Lau kevin.c.lau@stonybrook.edu 109048204
 *
 */
public class ReferenceIDComparator implements Comparator<NearEarthObject> {

	/**
	 * Compare method returns 0 if they are equal returns 1 if argument 1 is
	 * greater than argument 2 otherwise return -1
	 */
	@Override
	public int compare(NearEarthObject arg0, NearEarthObject arg1) {
		if (arg0.getReferenceID() == arg1.getReferenceID())
			return 0;
		else if (arg0.getReferenceID() > arg1.getReferenceID())
			return 1;
		else
			return -1;

	}
}
