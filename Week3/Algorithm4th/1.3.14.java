import java.util.NoSuchElementException;

class ResizingArrayQueueOfStrings {
    private String[] q;       // Mảng chứa các phần tử
    private int head = 0;     // Chỉ số của phần tử đầu hàng đợi
    private int tail = 0;     // Chỉ số của vị trí sẽ chèn phần tử tiếp theo
    private int n = 0;        // Số lượng phần tử hiện có

    public ResizingArrayQueueOfStrings() {
        q = new String[2]; // Khởi tạo mảng ban đầu
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    // Hàm thay đổi kích thước mảng và sắp xếp lại các phần tử
    private void resize(int capacity) {
        String[] temp = new String[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = q[(head + i) % q.length]; // Dịch chuyển theo vòng tròn
        }
        q = temp;
        head = 0;
        tail = n;
    }

    public void enqueue(String item) {
        if (n == q.length) resize(2 * q.length); // Mảng đầy -> X2
        q[tail++] = item;
        if (tail == q.length) tail = 0;          // Wrap-around nếu tail chạm cuối
        n++;
    }

    public String dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        String item = q[head];
        q[head] = null;                          // Tránh loitering (rò rỉ bộ nhớ)
        head++;
        if (head == q.length) head = 0;          // Wrap-around nếu head chạm cuối
        n--;
        // Nếu số phần tử chỉ còn 1/4 dung lượng mảng -> Thu nhỏ 1/2
        if (n > 0 && n == q.length / 4) resize(q.length / 2);
        return item;
    }
}