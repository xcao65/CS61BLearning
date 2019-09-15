package OA;

import java.util.ArrayList;
import java.util.List;

public class HitBoat {
    public String getNumber(int n, String S, String T) {
        //construct boat:   S, map[i][j] = 1
        //iterate through hits: modify hits as 2
        //iterate through boats and count hit and sunken
        int hit = 0;
        int sunken = 0;
        int[][] map = new int[n][n];
        String[] sArr = S.split(",");

        for (String btStr : sArr) {
            String[] btArr = btStr.split(" ");
            int[] sIndex = calIndex(btArr[0]);
            int[] eIndex = calIndex(btArr[1]);
            int iS = sIndex[0];
            int jS = sIndex[1];
            int iE = eIndex[0];
            int jE = eIndex[1];
            int i = iS;
            while (i <= iE) {
                int j = jS;
                while (j <= jE) {
                    map[i][j] = 1;
                    j++;
                }
                i++;
            }
        }
        String[] tArr = T.split(" ");
        for (String tStr : tArr) {
            int[] index = calIndex(tStr);
            int i = index[0];
            int j = index[1];
            map[i][j] = 2;
        }

        for (String btStr : sArr) {
            int tmpCt = 0;
            String[] btArr = btStr.split(" ");
            int[] sIndex = calIndex(btArr[0]);
            int[] eIndex = calIndex(btArr[1]);
            int iS = sIndex[0];
            int jS = sIndex[1];
            int iE = eIndex[0];
            int jE = eIndex[1];
            int i = iS;
            while (i <= iE) {
                int j = jS;
                while (j <= jE) {
                    if (map[i][j] == 2) tmpCt++;
                    j++;
                }
                i++;
            }
            int boatSize = (iE - iS + 1) * (jE - jS + 1);
            if (tmpCt == 0) {
                continue;
            } else if (tmpCt == boatSize) {
                sunken++;
            } else if (tmpCt < boatSize) {
                hit++;
            } else {
                continue;
            }
        }
        String res = sunken + "," + hit;
        return res;
    }

    private int[] calIndex(String p_str) {
        int[] sIndex = new int[2];
        if (Character.isDigit(p_str.charAt(1))) {
            sIndex[0] = Integer.parseInt(p_str.substring(0,2)) - 1;
            sIndex[1] = p_str.charAt(2) - 'A';
        } else {
            sIndex[0] = Integer.parseInt(p_str.substring(0,1)) - 1;
            sIndex[1] = p_str.charAt(1) - 'A';
        }
        return sIndex;
    }

    public String getNumberM(int n, String S, String T) {
        //boats List[boat[iS,jS,iE,jE,size,count]]
        String[] boatArr = S.split(",");
        int m = boatArr.length;
        int[][] boats = new int[m][6];
        for (int i = 0; i < m; i++) {
            String boat = boatArr[i];
            String[] indexArr = boat.split(" ");
            int[] sIndex = calIndex(indexArr[0]);
            int[] eIndex = calIndex(indexArr[1]);
            boats[i][0] = sIndex[0];
            boats[i][1] = sIndex[1];
            boats[i][2] = eIndex[0];
            boats[i][3] = eIndex[1];
            boats[i][4] = (eIndex[0] - sIndex[0] + 1) * (eIndex[1] - sIndex[1] + 1);
        }

        String[] tArr = T.split(" ");
        for (String hit : tArr) {
            int[]index = calIndex(hit);

        }
        return "";
    }
}
