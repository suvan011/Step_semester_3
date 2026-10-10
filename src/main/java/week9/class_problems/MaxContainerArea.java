public class MaxContainerArea {
    static int maxContainerArea(int[] heights) {
        int left = 0, right = heights.length - 1, best = 0;
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            best = Math.max(best, area);
            if (heights[left] < heights[right]) left++;
            else right--;
        }
        return best;
    }
    static int bruteForce(int[] heights) {
        int best = 0;
        for (int i = 0; i < heights.length; i++)
            for (int j = i + 1; j < heights.length; j++)
                best = Math.max(best, Math.min(heights[i], heights[j]) * (j - i));
        return best;
    }
    public static void main(String[] args) {
        System.out.println(maxContainerArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
// Brute force: O(n^2). Two pointers: O(n) time, O(1) additional space.