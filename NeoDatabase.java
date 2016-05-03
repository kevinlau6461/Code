import big.data.DataSource;
import java.util.*;

/**
 * This class contains and manages the NeaarEarthObject records using an array
 * list as the data structure for the database
 * 
 * @author Kevin Lau kevin.c.lau@stonybrook.edu 109048204
 *
 */
public class NeoDatabase {

	public static final String API_KEY = "Vy7qoEvivxLQBW5rKEA6IXwgX0QChuq2HcCatw8z";
	public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";

	ArrayList<NearEarthObject> dataBase = new ArrayList<NearEarthObject>(); // used
																			// to
																			// store
																			// NearEarthObjects

	/**
	 * empty default constructor
	 */
	public NeoDatabase() {
	};

	/**
	 * Builds a query URL given a page number
	 * 
	 * @param pageNumber
	 *            desired page number to extract
	 * @return returns URL of the proper page number
	 * @throws IllegalArgumentException
	 *             throws exception if page isn't between 0 and 175
	 */
	public String buildQueryURL(int pageNumber) throws IllegalArgumentException {
		if (pageNumber <= 0 || pageNumber >= 175)
			throw new IllegalArgumentException();
		return (API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY);
	}

	/**
	 * Opens a connection to the data source indicated by queryURL and adds all
	 * NearEarthObjects found in the datasheet
	 * 
	 * @param queryURL
	 *            url used to extract data from
	 * @throws IllegalArgumentException
	 *             throws exception if the url is null
	 */
	public void addAll(String queryURL) throws IllegalArgumentException {
		if (queryURL.equals(null))
			throw new IllegalArgumentException();
		DataSource ds = DataSource.connectJSON(queryURL);
		ds.load();

		NearEarthObject[] page = ds.fetchArray("NearEarthObject", "near_earth_objects/neo_reference_id",
				"near_earth_objects/name", "near_earth_objects/absolute_magnitude_h",
				"near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min",
				"near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max",
				"near_earth_objects/is_potentially_hazardous_asteroid",
				"near_earth_objects/close_approach_data/epoch_date_close_approach",
				"near_earth_objects/close_approach_data/miss_distance/kilometers",
				"near_earth_objects/close_approach_data/orbiting_body");

		/**
		 * assigns each NearEarthObject extracted to an index of thge array list
		 */
		for (int i = 0; i < page.length; i++)
			dataBase.add(page[i]);

	}

	/**
	 * Sorts the database using the specified Comparator of NearEarthObjects
	 * 
	 * @param comp
	 *            comparator of NearEarthObjects which will be used to sort the
	 *            database
	 * @throws EmptyStackException
	 *             throws exception if the list is empty
	 */
	public void sort(Comparator<NearEarthObject> comp) throws EmptyStackException {
		if (dataBase.isEmpty())
			throw new EmptyStackException();
		Collections.sort(dataBase, comp);
	}

	/**
	 * Displays the database in a neat, tabular form, listing all member
	 * variables for each NearEarthObject.
	 */
	public void printTable() {

		System.out.println("     ID   |      Name    | Mag. | Diameter | Danger | Close Date | Miss Dist | Orbits");
		System.out.println("======================================================================================");
		for (int i = 0; i < dataBase.size(); i++) {
			System.out.println(dataBase.get(i).toString());
		}
	}

}
