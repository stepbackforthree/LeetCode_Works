import org.junit.Test;

import java.util.Arrays;

public class ShellSort {
    void shellSort(int[] nums) {
        int length = nums.length;

        int increment = length;
        int i, j, k;

        do {
            increment = increment / 3 + 1;

            for (i = 0; i < increment; ++i) {
                for (j = i + increment; j < length; j += increment) {
                    if (nums[j] < nums[j - increment]) {
                        int temp = nums[j];
                        for (k = j - increment; k >= 0 && temp < nums[k]; k -= increment) {
                            nums[k + increment] = nums[k];
                        }
                        nums[k + increment] = temp;
                    }
                }
            }
        } while (increment > 1);
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 4, 6, 3, 10, 5, 2, 8, 12, 9};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
