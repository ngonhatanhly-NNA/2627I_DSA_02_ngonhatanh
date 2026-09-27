import java.util.Scanner;
import java.util.Stack;

class EvaluatePostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Double> vals = new Stack<>();

        while (scanner.hasNext()) {
            String s = scanner.next();

            if (s.equals("+")) {
                double v2 = vals.pop();
                double v1 = vals.pop();
                vals.push(v1 + v2);
            } else if (s.equals("-")) {
                double v2 = vals.pop();
                double v1 = vals.pop();
                vals.push(v1 - v2);
            } else if (s.equals("*")) {
                double v2 = vals.pop();
                double v1 = vals.pop();
                vals.push(v1 * v2);
            } else if (s.equals("/")) {
                double v2 = vals.pop();
                double v1 = vals.pop();
                vals.push(v1 / v2);
            } else {
                // Ép kiểu chuỗi số sang double
                vals.push(Double.parseDouble(s));
            }
        }

        System.out.println(vals.pop());
        scanner.close();
    }
}