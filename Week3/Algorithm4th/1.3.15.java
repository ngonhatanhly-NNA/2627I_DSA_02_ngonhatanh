import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class KthFromLast {
    public static void main(String[] args) {
        if (args.length == 0) return;
        int k = Integer.parseInt(args[0]);
        
        Queue<String> queue = new Queue<>();

        // Đọc liên tục từ input chuẩn cho đến khi hết
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
            // Giữ cho queue chỉ có tối đa k phần tử
            if (queue.size() > k) {
                queue.dequeue();
            }
        }

        // Sau khi đọc xong, phần tử đầu tiên của queue chính là string thứ k từ cuối lên
        if (queue.size() == k) {
            StdOut.println(queue.dequeue());
        } else {
            StdOut.println("Input không có đủ " + k + " phần tử.");
        }
    }
}