import java.util.Comparator;

/**
 * Compares two instances of NearEarthObjects based on their diameter
 * 
 * @author Kevin Lau kevin.c.lau@stonybrook.edu 109048204
 *
 */
public class DiameterComparator implements Comparator<NearEarthObject> {

	/**
	 * Compare method returns 0 if they are equal returns 1 if argument 1 is
	 * greater than argument 2 otherwise return -1
	 */
	@Override
	public int compare(NearEarthObject o1, NearEarthObject o2) {
		if (o1.getAverageDiameter() == o2.getAverageDiameter())
			return 0;
		else if (o1.getAverageDiameter() > o2.getAverageDiameter())
			return 1;
		else
			return -1;
	}

}
