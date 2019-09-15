package OA;

import java.util.HashMap;
import java.util.Map;

public class HaffMan {
    public String decode(String[] map, String decoded) {
        if (decoded == null || decoded.length() == 0) return "";

        //construct map
        Map<String, String> dic = new HashMap<>();
        for (String ele : map) {
            String[] mapping = ele.split("\t");
            dic.put(mapping[1], mapping[0]);
        }
        String res = "";
        for (int i = 0; i < decoded.length(); i++) {
            int head = i;
            while (i < decoded.length() && !dic.containsKey(decoded.substring(head, i + 1))) {
                //include i
                i++;
            }
            res += dic.get(decoded.substring(head, i + 1));
        }
        return res;
    }
}
