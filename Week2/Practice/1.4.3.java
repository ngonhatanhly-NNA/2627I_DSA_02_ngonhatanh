// Sửa DoublingTest để dùng StdDraw vẽ các đồ thị chuẩn và log-log giống như trong bài giảng, điều chỉnh tỷ lệ để đồ thị luôn luôn chiếm một vùng lớn trên cửa sổ chương trình.

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
/**
 *  The {@code DoublingTest} class provides a client for measuring
 *  the running time of a method using a doubling test.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/14analysis">Section 1.4</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;

    // This class should not be instantiated.
    private DoublingTest() { }

    /**
     * Returns the amount of time to call {@code ThreeSum.count()} with <em>n</em>
     * random 6-digit integers.
     * @param n the number of integers
     * @return amount of time (in seconds) to call {@code ThreeSum.count()}
     *   with <em>n</em> random 6-digit integers
     */
    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        int ignore = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    /**
     * Prints table of running times to call {@code ThreeSum.count()}
     * for arrays of size 250, 500, 1000, 2000, and so forth.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        StdDraw.setCanvasSize(800, 400);
        
        ArrayList<Integer> nList = new ArrayList<>();
        ArrayList<Double> tList = new ArrayList<>();

        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);
            
            nList.add(n);
            tList.add(time);
            
            drawPlots(nList, tList);
        }
    }
	
	// Hamf vẽ đồ thị và log-log
	private static void drawPlots(ArrayList<Integer> nList, ArrayList<Double> tList) {
        StdDraw.clear();
        // Cài đặt hệ tọa độ bao quát: X từ -0.1 đến 2.1 (để chia 2 nửa), Y từ -0.1 đến 1.2
        StdDraw.setXscale(-0.1, 2.1);
        StdDraw.setYscale(-0.2, 1.2);

        // Tiêu đề
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.5, 1.1, "Đồ thị Chuẩn (N vs T)");
        StdDraw.text(1.5, 1.1, "Đồ thị Log-Log (log N vs log T)");

        int size = nList.size();
        if (size == 0) return;

        double maxN = nList.get(size - 1);
        double maxT = Math.max(tList.get(size - 1), 0.001); // Tránh lỗi chia 0

        // Vẽ Đồ thị Chuẩn (Bên trái, màu đỏ)
        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 0; i < size; i++) {
            double x = nList.get(i) / maxN;          // Chuẩn hóa X về khoảng [0, 1]
            double y = tList.get(i) / maxT;          // Chuẩn hóa Y về khoảng [0, 1]
            
            StdDraw.setPenRadius(0.015);
            StdDraw.point(x, y);
            
            if (i > 0) {
                double prevX = nList.get(i - 1) / maxN;
                double prevY = tList.get(i - 1) / maxT;
                StdDraw.setPenRadius(0.003);
                StdDraw.line(prevX, prevY, x, y);
            }
        }

        // Vẽ Đồ thị Log-Log (Bên phải, màu xanh)
        if (size > 1) {
            double minLogN = Math.log(nList.get(0));
            double maxLogN = Math.log(maxN);
            double minLogT = Math.log(Math.max(tList.get(0), 0.001));
            double maxLogT = Math.log(maxT);
            
            double rangeLogN = Math.max(maxLogN - minLogN, 1e-6);
            double rangeLogT = Math.max(maxLogT - minLogT, 1e-6);

            StdDraw.setPenColor(StdDraw.BLUE);
            for (int i = 0; i < size; i++) {
                double curLogN = Math.log(nList.get(i));
                double curLogT = Math.log(Math.max(tList.get(i), 0.001));
                
                // Chuẩn hóa về [0, 1] sau đó cộng thêm 1 để đẩy sang nửa phải của màn hình
                double x = 1.0 + (curLogN - minLogN) / rangeLogN; 
                double y = (curLogT - minLogT) / rangeLogT;
                
                StdDraw.setPenRadius(0.015);
                StdDraw.point(x, y);
                
                if (i > 0) {
                    double prevLogN = Math.log(nList.get(i - 1));
                    double prevLogT = Math.log(Math.max(tList.get(i - 1), 0.001));
                    double prevX = 1.0 + (prevLogN - minLogN) / rangeLogN;
                    double prevY = (prevLogT - minLogT) / rangeLogT;
                    
                    StdDraw.setPenRadius(0.003);
                    StdDraw.line(prevX, prevY, x, y);
                }
            }
        }
    }
}