import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
//Easy
public class RotenOrange {

    private static Queue<Orange> formFreshOrangeQ(int[][] matrix) {
        Queue<Orange> elementQueue = new LinkedList<Orange>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1)
                    elementQueue.offer(new Orange(row, col));
            }
        }
        return elementQueue;
    }

    private static boolean isValid(int row, int col, int matrix[][]) {
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length);
    }

    private static int minimumTimeToRotAllOranges(int[][] matrix, Queue<Orange> freshOrangeQ, int minTime) {
        minTime++;
        Queue<Orange> toBeRotten = new LinkedList<Orange>();
        Queue<Orange> stillFresh = new LinkedList<Orange>();

        while (!freshOrangeQ.isEmpty()) {
            Orange orange = freshOrangeQ.poll();
            int row = orange.row;
            int col = orange.col;

            if (isValid(row - 1, col, matrix) && matrix[row - 1][col] == 2
                    || isValid(row + 1, col, matrix) && matrix[row + 1][col] == 2
                    || isValid(row, col - 1, matrix) && matrix[row][col - 1] == 2
                    || isValid(row, col + 1, matrix) && matrix[row][col + 1] == 2) {
                toBeRotten.add(orange);
            } else {
                stillFresh.add(orange);
            }
        }

        if (stillFresh.isEmpty()) {
            return minTime;
        }

        if (toBeRotten.isEmpty()) {
            return -1;
        } else {
            while (!toBeRotten.isEmpty()) {
                Orange orange = toBeRotten.poll();
                matrix[orange.row][orange.col] = 2;
            }
        }
        return minimumTimeToRotAllOranges(matrix, stillFresh, minTime);
    }

    public static void main(String args[]) {
        Queue<Orange> freshOrangeQ;
        int[][] matrix = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 }, };

        int minTime = 0;
        freshOrangeQ = formFreshOrangeQ(matrix);
        minTime = minimumTimeToRotAllOranges(matrix, freshOrangeQ, minTime);
        System.out.println("Minimum time to rot all oranges :" + minTime);
    }
}