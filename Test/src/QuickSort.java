import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start, j = end;
        int baseVal = nums[start];

        while (i < j) {
            while (i < j && nums[j] >= baseVal) {
                j--;
            }

            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            while (i < j && nums[i] < nums[j]) {
                i++;
            }

            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = baseVal;

        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 4, 6, 3, 10, 5, 2, 8, 12, 9};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
