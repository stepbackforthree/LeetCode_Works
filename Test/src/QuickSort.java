import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    void quickSort(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }

        int l = left, r = right;
        int std = nums[left];

        while (l < r) {
            while (l < r && nums[r] >= std) {
                r--;
            }

            while (l < r && nums[l] <= std) {
                l++;
            }

            if (l < r) {
                swap(l, r, nums);
            }
        }

        swap(left, l, nums);

        quickSort(left, l - 1, nums);
        quickSort(l + 1, right, nums);
    }

    void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 4, 6, 3, 10, 5, 2, 8, 12, 9};
        quickSort(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
    }
}
