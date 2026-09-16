import java.util.Arrays;

public class ClosestPairs {
    public static void main(String[] args) {
        double[] a = {7.2, 1.5, 10.0, 3.3, 3.1};

        double[] result = closestPair(a);

        System.out.println("Closest pair:");
        System.out.println(result[0] + " " + result[1]);

        System.out.println("Difference: "
                + Math.abs(result[0] - result[1]));
    }

    public static double[] closestPair(double[] a) {
        Arrays.sort(a);
        double minDiff = Double.MAX_VALUE;
        double x = 0, y = 0;

        for (int i = 0; i < a.length - 1; i++) {
            double diff = Math.abs(a[i] - a[i + 1]);
            if (diff < minDiff) {
                minDiff = diff;
                x = a[i];
                y = a[i + 1];
            }
        }   

        return new double[]{x, y};
    }
}