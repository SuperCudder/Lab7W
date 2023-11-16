import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * rankedMovies - Ranks movies coming from a students list of favorites 
 * @author Ellis Fitzgerald
 * @version 8 November 2023
 */
public class moviesRating {
    
    // Used for my own list version
    public static ArrayList<String> rankedList;
      
    
    /**
     * Uses a TreeMap to organize movies based on ranking
     * @param values
     * @return
     */
    public static List<String> rankMovies(TreeMap<String, TreeSet<String>> values) {
        TreeMap<String, Integer> rankedMovies = new TreeMap<String, Integer>();
        for(String student : values.keySet()) {
            for(String movie : values.get(student)) {
                rankedMovies.putIfAbsent(movie, 0);
                rankedMovies.put(movie, rankedMovies.get(movie) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> entries = new ArrayList(rankedMovies.entrySet());
        entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        List<String> sortedMovies = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entries) {
            sortedMovies.add(entry.getKey());
        }
        
        return sortedMovies;
    }
    
    
    /**
     * Ranks movies using a list and swap method
     * @param values
     * @return
     */
    public static ArrayList<String> rankMoviesMyVersion(TreeMap<String, TreeSet<String>> values) {
        rankedList = new ArrayList<String>();
        for(String student : values.keySet()) {
            TreeSet<String> favorites = values.get(student);
            for(String movie : favorites) {
                if(rankedList.contains(movie) && rankedList.get(0) != movie) {
                    swap(movie, rankedList.indexOf(movie));
                }
                else {
                    rankedList.add(movie);
                }
            }
        }
        return rankedList;
    }
    
    
    /**
     * 
     * @param movie
     * @param index
     */
    public static void swap(String movie, int index) {
        String temporaryReplacement = rankedList.get(index - 1);
        rankedList.set(index - 1, movie);
        rankedList.set(index, temporaryReplacement);
    }

}
