import java.util.*;
public class MergeTokenQueues {
    static int[] mergeTokens(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
            result[k++] = a[i] <= b[j] ? a[i++] : b[j++];
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeTokens(new int[]{3, 8, 15, 20}, new int[]{5, 8, 12})));
        System.out.println(Arrays.toString(mergeTokens(new int[]{}, new int[]{4, 9})));
    }
}
// Time: O(m+n); output space: O(m+n). Join + sort: O((m+n) log(m+n)).