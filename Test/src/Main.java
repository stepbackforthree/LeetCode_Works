import org.junit.Test;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[][] inputs = new int[][]{{910281, 204893, 736213}, {924362, 937935, 524007}, {652577, 199113, 582984}};

        boolean[][] used = new boolean[inputs.length][inputs[0].length];
        findNext(0, 0, inputs, 0, 0, used);

        for (Integer i : list) {
            System.out.println(i);
        }

    }

    static void findNext(int currX, int currY, int[][] inputs, int count, int sum, boolean[][] used) {
        if (currX == inputs.length - 1 && currY == inputs[0].length - 1) {
            list.add(sum / count);
        }

        used[currX][currY] = true;
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE, up = Integer.MIN_VALUE, down = Integer.MIN_VALUE;
        int currValue = inputs[currX][currY];
        boolean[][] temp = new boolean[used.length][used[0].length];

        for (int i = 0; i < used.length; ++i) {
            for (int j = 0; j < used[0].length; ++j) {
                temp[i][j] = used[i][j];
            }
        }

        if (currX > 0 && !used[currX-1][currY]) {
            findNext(currX-1, currY, inputs, count+1, sum+currValue, temp);
        }

        if (currX < inputs[0].length - 1 && !used[currX+1][currY]) {
            findNext(currX+1, currY, inputs, count+1, sum+currValue, temp);
        }

        if (currY > 0 && !used[currX][currY-1]) {
            findNext(currX, currY-1, inputs, count+1, sum+currValue, temp);
        }

        if (currY < inputs.length - 1 && !used[currX][currY+1]) {
            findNext(currX, currY+1, inputs, count+1, sum+currValue, temp);
        }

        //return Math.max(left, Math.max(right, Math.max(up, down)));
    }
}
