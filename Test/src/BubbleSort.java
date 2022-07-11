import org.junit.Test;

import java.util.Arrays;

public class BubbleSort {
    void bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; ++i) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(j, j + 1, nums);
                }
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
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
