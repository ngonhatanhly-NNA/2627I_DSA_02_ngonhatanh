import java.util.Scanner;
import java.util.Stack;

public class Parentheses {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 1. Nếu là ngoặc mở -> push vào stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // 2. Nếu là ngoặc đóng
            else if (c == ')' || c == ']' || c == '}') {
                // Gặp ngoặc đóng mà stack rỗng -> thiếu ngoặc mở tương ứng
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Đối chiếu cặp ngoặc tương ứng
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        // 3. Duyệt xong chuỗi, stack rỗng nghĩa là mọi ngoặc mở đều đã được đóng khớp
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println(isBalanced(s));
        }
        scanner.close();
    }
}