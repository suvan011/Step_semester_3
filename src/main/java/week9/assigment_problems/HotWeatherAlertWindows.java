public class HotWeatherAlertWindows {
    static int countAlerts(int[] readings, int k, int threshold) {
        int sum = 0, count = 0;
        for (int i = 0; i < k; i++) sum += readings[i];
        if (sum >= k * threshold) count++;
        for (int i = k; i < readings.length; i++) {
            sum += readings[i] - readings[i - k];
            if (sum >= k * threshold) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countAlerts(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    }
}
// Recalculating each block: O(n*k). Sliding window: O(n) time, O(1) additional space.