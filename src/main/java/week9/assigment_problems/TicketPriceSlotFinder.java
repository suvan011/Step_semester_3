public class TicketPriceSlotFinder {
    static int findSlot(int[] prices, int newPrice) {
        int low = 0, high = prices.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prices[mid] < newPrice) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};
        System.out.println(findSlot(prices, 150));
        System.out.println(findSlot(prices, 210));
        System.out.println(findSlot(prices, 300));
    }
}
// Binary search: O(log n) time, O(1) additional space; linear scan: O(n).