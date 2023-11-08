import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class myFileReader{

    public TreeMap<String, TreeSet<String>> readFileToTreeMap(String filePath) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(filePath);
        Scanner scnr = new Scanner(input);
        TreeMap<String, TreeSet<String>> map = new TreeMap<String, TreeSet<String>>();
        while (scnr.hasNext()) {
            TreeSet<String> set = new TreeSet<String>();
            String line = scnr.nextLine();
            String[] info = line.split(",");
            String country = info[0];
            for (int i = 1; i < info.length; ++i) {
                set.add(info[i]);
            }
            map.put(country, set);
        }
        scnr.close();
        return map;
    }

}
