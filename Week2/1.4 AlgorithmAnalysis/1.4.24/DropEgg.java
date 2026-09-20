import java.util.Scanner;

public class DropEgg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of eggs: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of floors: ");
        int k = scanner.nextInt();
        int result = dropEgg(n, k);
        System.out.println("Minimum number of trials in worst case with " + n + " eggs and " + k + " floors is: " + result);
    }
  
    private static boolean isBroken(int floor, int actualFloor) {
        return floor >= actualFloor;
        
    }
    public static int binarySearch(int n, int actualFloor) {
        int dropCount = 0;

        if (isBroken(1, actualFloor)){
            System.out.println("Egg breaks at floor 1");
            return 1;
        }
        int curr = 1;
        while (curr < n) {
            dropCount++;
            if (isBroken(curr, actualFloor)) {
                break; // Vỡ, dừng lại để xác định khoảng
            }
            curr *= 2;
        }
        int low = curr / 2 + 1;
        int high = Math.min(curr, n);
        int ans = high;

        // CHặt nhị phân trong khoảng nhỏ vừa tìm
        while (low <= high) {
            dropCount++;
            int mid = low + (high - low) / 2;

            if (isBroken(mid, actualFloor)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("[Cách 2] Số lần thả: " + dropCount);
        return ans;
    }
}
