import java.util.Iterator;
import java.util.NoSuchElementException;

class Stack<Item> implements Iterable<Item>{
	private Node first;
	private int N;
	
	public class Node{
		private Item item;
		private Node next;
	}
// Khởi tạo stack rỗng
    public Stack() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null; // hoặc N == 0
    }

    public int size() {
        return N;
    }

    // Đẩy phần tử vào đỉnh stack
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    // Lấy và xóa phần tử ở đỉnh stack
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    // --- YÊU CẦU BÀI 1.3.7 ---
    // Trả về phần tử mới nhất được thêm vào stack mà không pop nó ra
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
    }

    // Cung cấp iterator duyệt từ đỉnh đến đáy stack
    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // Kiểm thử hoạt động của peek()
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Hà Nội");
        stack.push("Đà Nẵng");
        stack.push("TP. Hồ Chí Minh");

        // Xem phần tử trên đỉnh
        System.out.println("Phần tử đỉnh (peek): " + stack.peek()); // In ra: TP. Hồ Chí Minh
        System.out.println("Kích thước sau khi peek: " + stack.size()); // Vẫn là 3

        // Thao tác pop thông thường
        System.out.println("Pop đỉnh: " + stack.pop()); // Lấy TP. Hồ Chí Minh ra
        System.out.println("Phần tử đỉnh mới (peek): " + stack.peek()); // In ra: Đà Nẵng
        System.out.println("Kích thước hiện tại: " + stack.size()); // Còn 2
    }
}