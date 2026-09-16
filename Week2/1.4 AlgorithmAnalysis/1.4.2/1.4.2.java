import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

class ThreeSum {

    // Do not instantiate.
    private ThreeSum() { }

    /**
     * Prints to standard output the (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param a the array of integers
     */
	 
	// Gốc: 2 lần brute-force dẫn đến tràn só và nhiều lần chạy k cần thiết với các dữ liêu to, 
	// Thoiwf gian ban đầu là O(n^3) 
	//	public static void printAll(int[] a) {
	//		int n = a.length;
	//		for (int i = 0; i < n; i++) {
	//			for (int j = i+1; j < n; j++) {
	//				for (int k = j+1; k < n; k++) {
	//					if (a[i] + a[j] + a[k] == 0) {
	//						StdOut.println(a[i] + " " + a[j] + " " + a[k]);
	//					}
	//				}
	//			}
	//		}
	//	}

    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param  a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     *         such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a) {
        int n = a.length;
		
		int[] sortedA = a.clone();
		Arrays.sort(sortedA);
        int count = 0;
		
        for (int i = 0; i < n; i++) {
			if (sortedA[i] > 0) break; // Số nhỏ nhất âm thì + mấy sô sau mới thành k đc
            
			int left = i + 1;
			int right = n - 1;
			
			while (left < right) {
				int sum = sortedA[i] + sortedA[left] + sortedA[right]; 

				if (sum == 0) {
					// Trường hợp tất cả các phần tử từ left đến right đều giống nhau
					if (sortedA[left] == sortedA[right]) {
						int numElements = right - left + 1;
						count += (numElements * (numElements - 1)) / 2; // Tổ hợp chập 2
						break; // Đã đếm xong toàn bộ đoạn giữa left và right
					} 
					// Trường hợp 2 đầu khác nhau, đếm số lượng phần tử trùng lặp ở mỗi đầu
					else {
						int leftVal = sortedA[left];
						int rightVal = sortedA[right];
						int countLeft = 0;
						int countRight = 0;
						
						while (left <= right && sortedA[left] == leftVal) {
							countLeft++;
							left++;
						}
						while (left <= right && sortedA[right] == rightVal) {
							countRight++;
							right--;
						}
						count += countLeft * countRight;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
        }
        return count;
    }

    /**
     * Reads in a sequence of integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)  {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}