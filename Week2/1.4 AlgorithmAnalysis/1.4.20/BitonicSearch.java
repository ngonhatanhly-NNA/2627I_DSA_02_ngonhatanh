import java.util.Scanner;

public class BitonicSearch {
    public static int findPeak(int[] a){
        int low = 0;
        int high = a.length - 1;

        while (low < high){
            int mid = low + (high - low) / 2;
            if (a[mid] < a[mid + 1]){
                low = mid + 1; // in incresing part of the array
            } else {
                high = mid; // in decreasing part of the array or mid
            }
        }
        return low;
    }

    public static boolean binarySearchIncreasing(int[] a, int low, int high, int x){
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (a[mid] == x){
                return true;
            } else if (a[mid] < x){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static boolean binarySearchDecreasing(int[] a, int low, int high, int x){
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (a[mid] == x){
                return true;
            } else if (a[mid] > x){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static boolean bitonicSearch(int[] a, int x) {

        int peak = findPeak(a);

        // Kiểm tra đỉnh
        if (a[peak] == x) {
            return true;
        }

        // Tìm ở phía tăng
        if (binarySearchIncreasing(a, 0, peak - 1, x)) {
            return true;
        }

        // Tìm ở phía giảm
        return binarySearchDecreasing(a, peak + 1, a.length - 1, x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the bitonic array: ");
        int n = scanner.nextInt();

        int[] a = new int[n];
        System.out.println("Enter the elements of the bitonic array:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int x = scanner.nextInt();

        boolean found = bitonicSearch(a, x);
        if (found) {
            System.out.println(x + " is present in the bitonic array.");
        } else {
            System.out.println(x + " is not present in the bitonic array.");
        }

        scanner.close();
    }
}