package OA;

import java.util.HashMap;
import java.util.Map;

public class EvalDivision {

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String nume = equations[i][0];
            String deno = equations[i][1];
            Map<String, Double> numeMap = null;
            Map<String, Double> denoMap = null;

            if (map.containsKey(nume)) {
                numeMap = map.get(nume);
            }
            if (map.containsKey(deno)) {
                denoMap = map.get(deno);
            }
            if (numeMap == null) numeMap = new HashMap<>();
            if (denoMap == null) denoMap = new HashMap<>();

            //numeMap: nume/deno = values[i]
            //denoMap: deno/nume = 1 / values[i]
            numeMap.put(deno, values[i]);
            denoMap.put(nume, 1.0 / values[i]);
        }

        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1])) {
                results[i] = -1;
            } else {
                double res = 1.0;
                results[i] = dfs(res, queries[i][0], queries[i][1], map);
            }
        }
        return results;
    }

    private static double dfs(double res, String nume, String deno, Map<String, Map<String, Double>> map) {
        Map<String, Double> numeMap = map.get(nume);
        if (numeMap.containsKey(deno)) {
            return res * numeMap.get(deno);
        }
        for (String tmpDeno : numeMap.keySet()) {
            double tmpRes = dfs(res * numeMap.get(tmpDeno), tmpDeno, deno, map);
            if (tmpRes != -1) return tmpRes;
        }
        return -1;
    }
}
