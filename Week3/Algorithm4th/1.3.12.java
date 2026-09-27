class StackUtils {
    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> temp = new Stack<>();
        Stack<String> result = new Stack<>();

        // Lặp qua stack gốc (từ Top -> Bottom), đẩy vào temp
        // Lúc này temp sẽ chứa các phần tử với thứ tự bị đảo ngược
        for (String s : stack) {
            temp.push(s); 
        }

        // Lặp qua temp (từ Top -> Bottom của temp), đẩy vào result
        // Thứ tự sẽ được đảo lại như stack ban đầu
        for (String s : temp) {
            result.push(s);
        }

        return result;
    }
}