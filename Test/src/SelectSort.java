import org.junit.Test;

import java.util.Arrays;

public class SelectSort {
    void selectSort(int[] nums) {
        int length = nums.length;

        for (int i =  0; i < length; ++i) {
            int index = i;
            for (int j = i + 1; j < length; ++j) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            if (index != i) {
                swap(i, index, nums);
            }
        }
    }

    void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 4, 6, 3, 10, 5, 2, 8, 12, 9};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
