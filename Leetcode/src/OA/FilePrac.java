package OA;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FilePrac {
    public static void readAndWrite (String name) {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader(name));
            outputStream = new PrintWriter(new BufferedWriter(new FileWriter("src/output.txt")));

            Map<String, Integer> map = new HashMap<>();

            String l = "";
            while ((l = inputStream.readLine()) != null) {
                map.put(l, map.getOrDefault(l, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int val = entry.getValue();
                outputStream.println(key + " " + val);
            }

            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
