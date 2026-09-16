import java.util.Arrays;

class EqualPairs{
    public static int coutnEqualPairs(int[] a){
        int n = a.length;
        int count = 0;
        Arrays.sort(a); // O(NlogN)
        
        while (i < n){
            int j = i;
            while (j < n && a[j] == a[i]){
                j++;
            }
            long freq = j - i;
            cont += freq;
            i = j;
        }
        return count;
    }
}
