import org.junit.Test;

import java.util.Arrays;

public class InsertSort {
    void insertSort(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return;
        }

        for (int i = 1; i < length; ++i) {
            int temp = nums[i];
            int j;

            for (j = i - 1; j >= 0 && temp < nums[j]; --j) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 4, 6, 3, 10, 5, 2, 8, 12, 9};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
