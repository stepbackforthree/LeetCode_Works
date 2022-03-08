import java.util.Arrays;
import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int upBound = Integer.parseInt(sc.nextLine());
        //int upBound = sc.nextInt();

        String secondLine = sc.nextLine();

        String[] second = secondLine.split(" ");

        int[] prices = new int[second.length];
        int[] gap = new int[second.length];
        int index = 0;

        for (String s : second) {
            prices[index] = Integer.parseInt(s);
            gap[index] = upBound - prices[index];
            index++;
        }

        int count = 0;
        int remain = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] > Integer.MIN_VALUE) {
                int max = Integer.MIN_VALUE;
                int idx = -1;
                for (int j = i+1; j < prices.length; ++j) {
                    if (prices[j] > Integer.MIN_VALUE && prices[j] <= gap[i]) {
                        if (prices[j] > max) {
                            max = prices[j];
                            idx = j;
                        }
                    }
                }
                if (max > Integer.MIN_VALUE || idx != -1) {
                    count++;
                    prices[i] = Integer.MIN_VALUE;
                    prices[idx] = Integer.MIN_VALUE;
                } else {
                    remain++;
                }
            }
        }

        System.out.println(count+remain+second.length%2);
    }
}
