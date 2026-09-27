import java.util.Scanner;
import java.util.Stack;

class InfixToPostfix {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Stack<String> ops = new Stack<>();
		
		while (sc.hasNext()){
			String s = sc.next();
			
			if (s.equals("{")){
				continue;
			} else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				ops.push(s);
			} else if (s.equals(")")) {
                // Gặp ngoặc đóng -> đưa toán tử ra sau
                System.out.print(ops.pop() + " ");
			} else {
				System.out.print(s + " ");
			}
		System.out.println();
		sc.close();
	}
}