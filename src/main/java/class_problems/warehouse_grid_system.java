package class_problems;
import java.util.Scanner;
public class warehouse_grid_system {
    Here is the complete Java implementation for the warehouse grid summary problem.

            Java
package class_problems;

import java.util.Scanner;

    public class warehouse_grid_system {

        // Helper class to hold the coordinate pair (row, col)
        public static class Coordinate {
            int row;
            int col;

            public Coordinate(int row, int col) {
                this.row = row;
                this.col = col;
            }

            @Override
            public String toString() {
                return "(" + row + ", " + col + ")";
            }
        }

        // Result container holding total items and the coordinate of the maximum bin
        public static class SummaryResult {
            long totalItems;
            Coordinate maxCoordinate;

            public SummaryResult(long totalItems, Coordinate maxCoordinate) {
                this.totalItems = totalItems;
                this.maxCoordinate = maxCoordinate;
            }

            @Override
            public String toString() {
                return "(" + totalItems + ", " + maxCoordinate + ")";
            }
        }

        /**
         * Computes the total item count and locates the first bin with the maximum items.
         *
         * @param grid 2D array representing the warehouse floor layout
         * @return SummaryResult containing totalItems and maxCoordinate
         */
        public static SummaryResult warehouseSummary(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return new SummaryResult(0, new Coordinate(-1, -1));
            }

            long totalItems = 0;
            int maxItems = -1;
            int maxRow = 0;
            int maxCol = 0;

            int m = grid.length;
            int n = grid[0].length;

            // Traverse row-by-row, left-to-right
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    int currentVal = grid[r][c];
                    totalItems += currentVal;

                    // Strict inequality '>' preserves the first occurrence on ties
                    if (currentVal > maxItems) {
                        maxItems = currentVal;
                        maxRow = r;
                        maxCol = c;
                    }
                }
            }

            return new SummaryResult(totalItems, new Coordinate(maxRow, maxCol));
        }

        public static void main(String[] args) {
            int[][] grid = {
                    {4, 9, 2},
                    {7, 1, 6},
                    {3, 12, 5}
            };

            SummaryResult result = warehouseSummary(grid);
            System.out.println("Output: " + result);
            // Expected Output: (49, (2, 1))
        }
}
