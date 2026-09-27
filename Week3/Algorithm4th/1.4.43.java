class StackBenchmark {

    // Hàm đo thời gian cho ResizingArrayStack
    public static double timeResizingArray(int n) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        long startTime = System.nanoTime();
        
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0; // Đổi sang giây
    }

    // Hàm đo thời gian cho LinkedStack
    public static double timeLinkedList(int n) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        long startTime = System.nanoTime();
        
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0; // Đổi sang giây
    }

    public static void main(String[] args) {
        int[] N_VALUES = {100_000, 1_000_000, 10_000_000}; 

        System.out.printf("%-12s | %-20s | %-20s\n", "N", "Resizing Array (s)", "Linked List (s)");
        System.out.println("---------------------------------------------------------------");
        
        for (int n : N_VALUES) {
            double timeArray = timeResizingArray(n);
            double timeLinked = timeLinkedList(n);
            System.out.printf("%-12d | %-20.5f | %-20.5f\n", n, timeArray, timeLinked);
        }
    }
}