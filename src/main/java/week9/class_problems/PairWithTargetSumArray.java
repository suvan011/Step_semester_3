import java.util.*;
public class PairWithTargetSumArray {
    static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int value : nums) {
            if (seen.contains(target - value)) return true;
            seen.add(value);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));
        System.out.println(hasPairWithSum(new int[]{3, 3}, 6));
    }
}
// Time: O(n) average; additional space: O(n).