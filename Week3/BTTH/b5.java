import java.util.Scanner;

class CylinderStack{
	private int[] cylinders;
	private int topIndex;
	private int totalHeight;
	
	public CylinderStack(int[] cylinders){
		this.cylinders = cylinders;
		this.topIndex = 0;
		this.totalHeight = calculateInitialHeight();
	}
	
	private calculateInitialHeight(){
		int sum = 0;
		for (int h: cylinders){
			sum += h;
		}
		return sum;
	}
	
	public int getHeight(){
		return totalHeight;
	}
	
	public void pop(){
		if (topIndex < cylinders.length()){
			totalHeight -= cylinders[topIndex];
			topIndex++;
		}
	}
}

class EqualStacksSolver {
    private CylinderStack stack1;
    private CylinderStack stack2;
    private CylinderStack stack3;

    public EqualStacksSolver(int[] h1, int[] h2, int[] h3) {
        this.stack1 = new CylinderStack(h1);
        this.stack2 = new CylinderStack(h2);
        this.stack3 = new CylinderStack(h3);
    }

    // Hàm thực thi logic tìm chiều cao cân bằng
    public int findMaxEqualHeight() {
        while (true) {
            int h1 = stack1.getHeight();
            int h2 = stack2.getHeight();
            int h3 = stack3.getHeight();

            // Nếu 3 chồng cao bằng nhau (hoặc cùng bằng 0 khi đã rút hết)
            if (h1 == h2 && h2 == h3) {
                return h1;
            }

            // Tìm chồng cao nhất và rút đĩa
            if (h1 >= h2 && h1 >= h3) {
                stack1.pop();
            } else if (h2 >= h1 && h2 >= h3) {
                stack2.pop();
            } else {
                stack3.pop();
            }
        }
    }
}

public class b5 {
    // Hàm main chỉ dùng để nhập liệu và gọi hàm test thử
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng đĩa của 3 chồng
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        int[] h1 = new int[n1];
        for (int i = 0; i < n1; i++) h1[i] = scanner.nextInt();

        int[] h2 = new int[n2];
        for (int i = 0; i < n2; i++) h2[i] = scanner.nextInt();

        int[] h3 = new int[n3];
        for (int i = 0; i < n3; i++) h3[i] = scanner.nextInt();

        // Khởi tạo Solver và in kết quả
        EqualStacksSolver solver = new EqualStacksSolver(h1, h2, h3);
        System.out.println(solver.findMaxEqualHeight());

        scanner.close();
    }
}