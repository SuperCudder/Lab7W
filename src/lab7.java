import java.io.FileNotFoundException;
import java.lang.reflect.Array;
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
        List<String> nameList = new ArrayList<>(map.keySet());

		System.out.println(movieNight.rankMovies(map, nameList));
	}
}
