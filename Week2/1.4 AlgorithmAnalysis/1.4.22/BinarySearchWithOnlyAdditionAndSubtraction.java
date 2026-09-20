import java.util.Scanner;


public class BinarySearchWithOnlyAdditionAndSubtraction {
    public static boolean fibonacciSearch(int[] arr, int x){
        int n = arr.length;

        // Tìm số Fibonacci lớn nhất nhỏ hơn hoặc bằng n
        int fibM2 = 0; // (m-2)'th Fibonacci số
        int fibM1 = 1; // (m-1)'th Fibonacci số
        int fibM = fibM2 + fibM1; // m'th Fibonacci số

        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibM2, n - 1);

            if (arr[i] < x) {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            } else if (arr[i] > x) {
                offset = i;
                fibM = fibM2;
                fibM1 = fibM1 - fibM2;
                fibM2 = fibM - fibM1;
            } else {
                return true; // Tìm thấy phần tử
            }
        }

        return false; // Không tìm thấy phần tử
    }
    

    public static main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the element to search for: ");
        int x = scanner.nextInt();

        boolean found = fibonacciSearch(arr, x);
        if (found) {
            System.out.println("Element " + x + " found in the array.");
        } else {
            System.out.println("Element " + x + " not found in the array.");
        }
    }
}
