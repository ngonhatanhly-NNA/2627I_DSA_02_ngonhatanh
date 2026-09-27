package Week3.BTTH;
import java.util.Stack;
import java.util.Scanner;

câuclass SimpleTextEditor{
    private StringBuilder text;
	private Stack<String[]> history; // loại thao tác và tham số
	
	public SimpleTextEditor(){
		this.text = new StringBuilder();
		this.history = new Stack<>();
	}
	
	// Thao tác 1: thêm chuỗi
	public void append(String w){
		history.push(new String[]{"1", String.valueOf(w.length()))});
		text.append(w);
	}
	
	public void delete(int k){
		String deleteStr = text.substring(text.length() - k);
		history.push(new String[]{"2", deleteStr});
		text.delete(text.length() - k, text.length());
	}
	
	public void print(){
		System.out.println(text.charAt(k - 1));
	}
	
	public void undo(){
		if (history.isEmpty()) return;
		
		String[] lastOp = history.pop();
        
        if (lastOp[0].equals("1")) { 
            int k = Integer.parseInt(lastOp[1]);
            text.delete(text.length() - k, text.length());
        } 
        else if (lastOp[0].equals("2")) { 
            text.append(lastOp[1]);
        }
	}
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        
        SimpleTextEditor editor = new SimpleTextEditor();
        
        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            
            if (type == 1) {
                String w = scanner.next();
                editor.append(w);
            } 
            else if (type == 2) {
                int k = scanner.nextInt();
                editor.delete(k);
            } 
            else if (type == 3) {
                int k = scanner.nextInt();
                editor.print(k);
            } 
            else if (type == 4) {
                editor.undo();
            }
        }
        
        scanner.close();
    }
}