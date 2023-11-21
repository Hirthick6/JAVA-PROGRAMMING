/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrk1;

public class SeriesCalculator {
    public static double calculateSeries(double x, int n) throws Exception {
        if (n < 0) {
            throw new Exception("Invalid input: Power cannot be negative");
        }

        double result = 1;
        double term = 1;
        for (int i = 1; i <= n; i++) {
            term *= x;
            result += term;
        }
        return result;
    }
}
