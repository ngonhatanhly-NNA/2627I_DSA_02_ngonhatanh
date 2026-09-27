import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings {
    private String[] a; // Mảng lưu trữ các phần tử
    private int N;      // Số lượng phần tử hiện có trong ngăn xếp

    // Khởi tạo stack với sức chứa (capacity) cố định
    public FixedCapacityStackOfStrings(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Dung lượng không thể âm");
        }
        a = new String[capacity];
        N = 0;
    }

    // Kiểm tra stack có rỗng không
    public boolean isEmpty() {
        return N == 0;
    }

    // Kiểm tra stack đã đầy chưa (Yêu cầu bài 1.3.1)
    public boolean isFull() {
        return N == a.length;
    }

    // Trả về số lượng phần tử hiện có
    public int size() {
        return N;
    }

    // Đẩy một phần tử vào stack
    public void push(String item) {
        if (isFull()) {
            throw new RuntimeException("Stack đã đầy (Stack overflow)!");
        }
        a[N++] = item;
    }

    // Lấy và xóa phần tử trên đỉnh stack
    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack đang rỗng (Stack underflow)!");
        }
        String item = a[--N];
        a[N] = null; // Tránh hiện tượng loitering (giúp Garbage Collector thu hồi bộ nhớ)
        return item;
    }

    // Test thử chương trình
    public static void main(String[] args) {
        int capacity = 3;
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(capacity);

        System.out.println("Ban đầu isEmpty(): " + stack.isEmpty()); // true
        System.out.println("Ban đầu isFull(): " + stack.isFull());   // false

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Sau khi thêm 3 phần tử size(): " + stack.size()); // 3
        System.out.println("Đã đầy chưa isFull(): " + stack.isFull());        // true

        System.out.println("Pop: " + stack.pop()); // C
        System.out.println("Sau khi pop 1 phần tử isFull(): " + stack.isFull()); // false
    }
}