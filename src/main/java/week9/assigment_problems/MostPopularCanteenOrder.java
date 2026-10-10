import java.util.*;
public class MostPopularCanteenOrder {
    static String[] mostPopular(String[] orders) {
        Map<String, Integer> count = new HashMap<>();
        for (String item : orders) count.put(item, count.getOrDefault(item, 0) + 1);
        String best = orders[0];
        for (String item : orders)
            if (count.get(item) > count.get(best)) best = item;
        return new String[]{best, String.valueOf(count.get(best))};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostPopular(new String[]{"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"})));
        System.out.println(Arrays.toString(mostPopular(new String[]{"tea", "coffee", "coffee", "tea"})));
    }
}
// Time: O(n) average; additional space: O(u), where u is the number of unique items.