import big.data.*;
import java.util.Scanner;

/**
 * This class allows a user to view datasets obtained from the NASA NeoW API.
 * 
 * @author Kevin Lau kevin.c.lau@stonybrook.edu 109048204
 *
 */
public class NeoViewer {

	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);

		NeoDatabase dataBase = new NeoDatabase();

		System.out.println("Welcome to NEO Viewer!\n");

		while (true) {
			System.out.println("Option Menu:\n");
			System.out.println("A) Add a page to the database\n" + "S) Sort the database\n"
					+ "P) Print the database as a table\n" + "Q) Quit\n");

			System.out.println("Select a menu option: ");

			String choice = input.nextLine();

			switch (choice.toUpperCase()) {

			case "A": {
				System.out.println("Enter the page to load: ");

				int pageNumber = input.nextInt();
				try {
					String url = dataBase.buildQueryURL(pageNumber);

					dataBase.addAll(url);

					System.out.println("Page loaded successfully!");
					input.nextLine();
					break;
				} catch (Exception e) {
					System.out.println("Invalid input");
					input.nextLine();
					break;
				}

			}
			case "P": {
				dataBase.printTable();
				break;
			}
			case "S": {
				System.out.println("R) Sort by referenceID\n" + "D) Sort by diameter\n" + "A) Sort by approach date\n"
						+ "M) Sort by miss distance\n");
				System.out.println("Select a menu option: ");
				String mchoice = input.nextLine();
				try{
				switch (mchoice.toUpperCase()) {

				case "R": {
					dataBase.sort(new ReferenceIDComparator());
					break;
				}
				case "D": {
					dataBase.sort(new DiameterComparator());
					break;
				}
				case "A": {
					dataBase.sort(new ApproachDateComparator());
					break;
				}
				case "M": {
					dataBase.sort(new MissDistanceComparator());
					break;
				}

				default:
					System.out.println("Not a valid input");
				}

				break;
				}
				catch(Exception e){
					System.out.println("The database is empty.");
					break;
				}
			}
			case "Q": {
				System.out.println("Program terminating normally");
				System.exit(0);
			}
			default:
				System.out.println("Not a valid input");

			}
			System.out.println();

		}
	}
}
