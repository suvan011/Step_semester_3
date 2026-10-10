public class WarehouseGridSummary {
    static void warehouseSummary(int[][] grid) {
        int total = 0, max = -1, maxRow = 0, maxCol = 0;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > max) {
                    max = grid[r][c]; maxRow = r; maxCol = c;
                }
            }
        System.out.println("(" + total + ", (" + maxRow + ", " + maxCol + "))");
    }
    public static void main(String[] args) {
        warehouseSummary(new int[][]{{4, 9, 2}, {7, 1, 6}, {3, 12, 5}});
    }
}
// Time: O(m*n); additional space: O(1).