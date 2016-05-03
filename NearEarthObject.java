import java.util.Date;
import big.data.*;

/**
 * This class represents a record in the database of asteroids currently tracked
 * by NASA
 * 
 * @author Kevin Lau Kevin.c.lau@stonybrook.edu 109048204
 *
 */
public class NearEarthObject {

	private int referenceID; 
	private String name;	
	private double absoluteMagnitude;
	private double averageDiameter;
	private boolean isDangerous;
	private long closestApproachDate;
	private double missDistance;
	private String orbitingBody;

	
	/**
	 * Default constructor 
	 * @param referenceID
	 * @param name
	 * @param absoluteMagnitude
	 * @param minDiameter
	 * used to calculate the average diameter
	 * @param maxDiameter
	 * used to calculate the average diameter
	 * @param isDangerous
	 * @param closestDateTimestamp
	 * @param missDistance
	 * @param orbitingBody
	 */
	public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter,
			double maxDiameter, boolean isDangerous, long closestDateTimestamp, double missDistance,
			String orbitingBody) {

		this.referenceID = referenceID;
		this.name = name;
		this.absoluteMagnitude = absoluteMagnitude;
		this.averageDiameter = (minDiameter + maxDiameter) / 2;
		this.isDangerous = isDangerous;
		this.closestApproachDate = closestDateTimestamp;
		this.missDistance = missDistance;
		this.orbitingBody = orbitingBody;

	}

	//below are getters and setters for all member variables of the class
	public int getReferenceID() {
		return referenceID;
	}

	public void setReferenceID(int referenceID) {
		this.referenceID = referenceID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAbsoluteMagnitude() {
		return absoluteMagnitude;
	}

	public void setAbsoluteMagnitude(double absoluteMagnitude) {
		this.absoluteMagnitude = absoluteMagnitude;
	}

	public double getAverageDiameter() {
		double round = Math.round(averageDiameter * 1000.0) / 1000.0;
		return round;
	}

	public void setAverageDiameter(double averageDiameter) {
		this.averageDiameter = averageDiameter;
	}

	public boolean isDangerous() {
		return isDangerous;
	}

	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}

	public long getClosestApproachDate() {
		return closestApproachDate;
	}

	public void setClosestApproachDate(long closestApproachDate) {
		this.closestApproachDate = closestApproachDate;
	}

	public double getMissDistance() {
		return missDistance;
	}

	public void setMissDistance(double missDistance) {
		this.missDistance = missDistance;
	}

	public String getOrbitingBody() {
		return orbitingBody;
	}

	public void setOrbitingBody(String orbitingBody) {
		this.orbitingBody = orbitingBody;
	}

	public String toString() {
		String represent = (" " + getReferenceID() + "     " + getName() + "    " + getAbsoluteMagnitude() + "    "
				+ getAverageDiameter() + "     " + isDangerous() + "     "
				+ String.format("%tD", getClosestApproachDate()) + "     " + getMissDistance());
		represent += "     " + getOrbitingBody();
		return represent;
	}
}
