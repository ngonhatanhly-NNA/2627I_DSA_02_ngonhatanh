public class FarthestPair {
    public static void main(String[] args) {
        double[] a = {3.5, -2.0, 7.1, 1.2, 4.8};

        double[] result = farthestPair(a);

        System.out.println("Farthest pair:");
        System.out.println(result[0] + " " + result[1]);

        System.out.println("Difference: "
                + Math.abs(result[0] - result[1]));
    }

    public static double[] farthestPair(double[] a) {
        if (a == null || a.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (double x : a){
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
        }

        return new double[]{min, max};
    }
}
