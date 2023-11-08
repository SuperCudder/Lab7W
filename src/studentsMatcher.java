import java.util.*;

/**
 * studentsMatcher holds two methods, findMatches and calcSim, both methods work
 * to find the similarities between a key and their value pairs, determining how
 * similar the values for each key are to eachother and storing those similar
 * keys into a treeMap
 * 
 * @author Jonah Kastelic
 * @version 8 November, 2023
 */
public class studentsMatcher {

	/**
	 * findMatches finds the similarities between a key and their value pairs,
	 * determining how similar the values for each key are using calcSim to
	 * eachother and storing those similar keys into a treeMap
	 * 
	 * @param map input map from CSV file read
	 * @return map
	 */
	public static TreeMap<String, String> findMatches(TreeMap<String, TreeSet<String>> map) {
		String student = "";
		String student2 = "";
		TreeMap<String, String> nameMap = new TreeMap<String, String>();
		for (Map.Entry<String, TreeSet<String>> entry : map.entrySet()) {
			student = entry.getKey();
			TreeSet<String> movie = entry.getValue();
			int maxSim = -1;
			for (Map.Entry<String, TreeSet<String>> nextStudent : map.entrySet()) {
				student2 = nextStudent.getKey();
				if (!student.equals(student2)) {
					TreeSet<String> movie2 = nextStudent.getValue();
					int sim = calcSim(movie, movie2);

					if (sim > maxSim) {
						nameMap.replace(student, student2, student2);
						maxSim = sim;
					} else if (sim == maxSim) {
						nameMap.put(student, student2);
					}
				}
			}

		}
		return nameMap;

	}

	/**
	 * calcSim uses the intersection and union of student's movie treeSets
	 * 
	 * @param student1Movies first students treeset
	 * @param student2Movies second students treemap
	 * @return similarity value between sets
	 */
	private static int calcSim(TreeSet<String> student1Movies, TreeSet<String> student2Movies) {
		if (student1Movies.isEmpty() && student2Movies.isEmpty()) {
			return 0;
		}

		TreeSet<String> moviesTogether = new TreeSet<>(student1Movies);
		moviesTogether.addAll(student2Movies);

		TreeSet<String> moviesMatch = new TreeSet<>(student1Movies);
		moviesMatch.retainAll(student2Movies);

		return (int) (((double) moviesMatch.size() / moviesTogether.size()) * 100);

	}
}
