import java.util.Scanner;
import java.util.Stack;

class CompleteParentheses{
	Scanner sc = new Scanner(System.in);
	Stack<String> ops = new Stack<>();
	Stack<String> vals = new Stack<>();
	
	while (sc.hasNext()){
		String s = sc.next();
		
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			ops.push(s);
		} else if (s.equals(")")){
			String op = ops.pop();
			String v2 = vals.pop();
			String v1 = vals.pop();
			
			String supExpr = "(" + v1 + " op " + v2 + ")";
			val.push(supExpr);
		} else {
			vals.push(s);
		}
	}
	
	System.out.println(vals.pop());
        scanner.close();
}