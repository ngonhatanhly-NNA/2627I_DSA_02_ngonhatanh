public class BinarySearchFraction {

    // Hàm giả lập câu hỏi: "x có nhỏ hơn y không?"
    // Trong bài thật, x là số bí mật mà ta không biết.
    static boolean less(double x, double y) {
        return x < y;
    }

    static String findFraction(double x, int N) {
        double lo = 0.0;
        double hi = 1.0;

        // Thu hẹp khoảng chứa x
        while (hi - lo >= 1.0 / (N * (double) N)) {

            double mid = lo + (hi - lo) / 2.0;

            if (less(x, mid)) {
                // x < mid
                hi = mid;
            } else {
                // x >= mid
                lo = mid;
            }
        }

        // Tìm phân số p/q nằm trong khoảng [lo, hi]
        for (int q = 1; q < N; q++) {
            int p = (int) Math.ceil(lo * q);

            if (p > 0 && p < q &&
                (double) p / q <= hi) {

                return p + "/" + q;
            }
        }

        return "Không tìm thấy";
    }

    public static void main(String[] args) {
        double x = 3.0 / 7.0;
        int N = 10;

        System.out.println(findFraction(x, N));
    }
}