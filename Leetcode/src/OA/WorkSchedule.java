package OA;

import java.util.ArrayList;
import java.util.List;

public class WorkSchedule {
    public static List<String> getSchedue(String input, int maxHours, int maxPerDay) {
        char[] arr = input.toCharArray();
        List<String> res = new ArrayList<>();
        int[] left = new int[8];
        left[7] = 0;
        left[6] = (arr[6] == '?') ? maxPerDay : arr[6] - '0';
        for (int i = 5; i >= 0; i--) {
            left[i] = left[i + 1] + ((arr[i] == '?') ? maxPerDay : arr[i] - '0');
        }

        backTracking(arr, maxHours, maxPerDay, "", res, left);
        return res;
    }

    private static void backTracking(char[] arr, int maxHours, int maxPerDay, String cur, List<String> res, int[] left) {
        int index = cur.length();
        if (index == 7) {
            if (maxHours == 0) res.add(cur);
            return;
        }
        if (arr[index] != '?') {
            cur += arr[index];
            backTracking(arr, maxHours - (arr[index] - '0'), maxPerDay, cur, res, left);
        } else {
            for (int i = 0; i <= maxPerDay && (maxHours - i) >= 0; i++) {
                if ((maxHours - i) <= left[index + 1]) backTracking(arr, maxHours - i, maxPerDay, cur + i, res, left);
            }
        }
        return;
    }
}
