import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class movieNight {

	
	/**
	 * @author Jove
	 * 
	 * Chooses the first student from the list of names. It goes through the student's list of movies.
	 * For every movie in the list it goes through every student in the list of names, checking their set for the current movie.
	 * If there is a student that doesn't also have the current movie in their set it removes the movie from the main student's set.
	 * 
	 * @param inMap a TreeMap. Key of String, value of TreeSet of String. Contains every student's list of movies.
	 * @param nameList a List. The list of every student's name.
	 * @return True or False. True if there is some movie that is common to every student's list of movies. False otherwise.
	 */
	protected static boolean rankMovies(TreeMap<String,TreeSet<String>> inMap, List<String> nameList) {
		String student = nameList.get(0);
		for(String movie : inMap.get(student)) {
			Iterator<String> listItr = nameList.iterator();
			while(listItr.hasNext()) {
				TreeSet<String> otherMovies = inMap.get(listItr.next());
				if(	!otherMovies.contains(movie)) {
					inMap.get(student).remove(movie);
				}
			}
		}
		if(!inMap.get(student).isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	
}
