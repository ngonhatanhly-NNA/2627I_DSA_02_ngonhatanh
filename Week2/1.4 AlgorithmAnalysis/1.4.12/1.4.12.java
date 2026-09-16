import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



class Solution {
    public static void main(String[] args) {
        
    }

    public int[] findIntersection(int[] list1, int[] list2){
        int n = list1.length;
        int m = list2.length;

        List<Integer> commonElements = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < n && j < m){
            if (list1[i] == list2[j]){
                commonElements.add(list1[j]);
                i++;
                j++;
            } else if (list1[i] <= list2[j]){
                i++;
            } else {
                j++;
            }
        }

        return commonElements.stream().mapToInt(Integer::intValue).toArray();
    }


}