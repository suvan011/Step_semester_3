import java.util.*;
public class PairWithTargetSum {
    static boolean bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) return true;
        return false;
    }
    static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(target - x)) return true;
            seen.add(x);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15}, b = {3, 4, 6};
        System.out.println(hasPairWithSum(a, 9));
        System.out.println(hasPairWithSum(b, 20));
        System.out.println("Brute force: " + bruteForce(a, 9));
    }
}
// Brute force: O(n^2) time, O(1) space. HashSet: O(n) average time, O(n) additional space.