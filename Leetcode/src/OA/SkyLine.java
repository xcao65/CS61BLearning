package OA;

import java.util.*;

public class SkyLine {
    class Rec {
        private int left;
        private int right;
        private int height;

        public Rec(int p_left, int p_right, int p_height) {
            this.left = p_left;
            this.right = p_right;
            this.height = p_height;
        }

        public int getL() {
            return this.left;
        }

        public int getR() {
            return this.right;
        }

        public int getH() {
            return this.height;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        Queue<Rec> lPQ = new PriorityQueue<>(new Comparator<Rec>() {
            @Override
            public int compare(Rec x, Rec y) {
                return x.getL() - y.getL();
            }
        });

        Queue<Rec> rPQ = new PriorityQueue<>((Rec r1, Rec r2) -> r1.getR() - r2.getR());
        PriorityQueue<Rec> hPQ = new PriorityQueue<>((Rec r1, Rec r2) -> r2.getH() - r1.getH());
        Queue<Integer> cPQ = new PriorityQueue<>((a, b) -> a - b);

        for (int[] bld : buildings) {
            Rec curBld = new Rec(bld[0], bld[1], bld[2]);
            lPQ.add(curBld);
            rPQ.add(curBld);
            cPQ.add(bld[0]);
            cPQ.add(bld[1]);
        }

        //use set to exclude duplicates
        List<int[]> res = new ArrayList<>();

        while (!cPQ.isEmpty()) {
            int c = cPQ.poll();

            //update Recs
            //check if c passes r of Rec
            while (!rPQ.isEmpty() && rPQ.peek().getR() <= c) {
                //since l < r, once c >= r, Rec must be in hPQ
                Rec passed = rPQ.poll();
                hPQ.remove(passed);
            }
            //check if c reaches new blds
            while (!lPQ.isEmpty() && lPQ.peek().getL() <= c) {
                Rec reached = lPQ.poll();
                hPQ.add(reached);
            }

            int height = (hPQ.isEmpty()) ? 0 : hPQ.peek().getH();
            // if (res.size() > 0 && res.get(res.size() - 1)[1] == height) continue;
            res.add(new int[] {c, height});
        }

        return res;
    }
}
