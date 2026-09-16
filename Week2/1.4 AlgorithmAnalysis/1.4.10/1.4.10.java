class Solution{
    public static int indexOfFirst(int[] a, int key){
        int low = 0;
        int high = a.length - 1;
        int result = -1; // Lưu lại chỉ số nhỏ nhất tìm thấy 

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (a[mid] == key){
                result = mid; // Lưu lại vị trí tìm thấy
                high = mid - 1; // Tìm kiếm ở nửa trái để tìm vị trí đầu tiên
            } else if (a[mid] < key){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}