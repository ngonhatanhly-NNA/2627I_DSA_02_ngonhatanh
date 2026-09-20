
import java.util.Scanner;


public class LocalMinimumOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        int localMin = findLocalMinimum(arr);
        if (localMin != -1) {
            System.out.println("A local minimum is found at index: " + localMin);
        } else {
            System.out.println("No local minimum found.");
        }

        scanner.close();
    }


    public static int findLocalMinimum(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return -1; // No elements in the array
        }

        if (n == 1 || arr[0] < arr[1]) {
            return 0; // First element is a local minimum
        }

        if (arr[n - 1] < arr[n - 2]) {
            return n - 1; // Last element is a local minimum
        }

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid; // Found a local minimum
            } else if (arr[mid] > arr[mid - 1]) {
                right = mid - 1; // Search in the left half
            } else {
                left = mid + 1; // Search in the right half
            }
        }

        return -1; // No local minimum found
    }
}
