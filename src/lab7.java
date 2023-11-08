import java.io.FileNotFoundException;
import java.util.*;
/**
 * Lab7 tester class for each team members subtask classes
 * @author Jonah Kastelic
 */
public class lab7 {
	public static void main(String[] args) throws FileNotFoundException {
		myFileReader reader = new myFileReader();

		TreeMap<String, TreeSet<String>> map = reader.readFileToTreeMap(args[0]);
		System.out.println(studentsMatcher.findMatches(map).toString());

	}
}
