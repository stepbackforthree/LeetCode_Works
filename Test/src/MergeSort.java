import org.junit.Test;

import java.util.Arrays;

public class MergeSort {
    void mergeSort(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }

        int mid = low + (high - low) / 2;

        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
    }

    void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        // 把较小的数据先加入到新数组中
        while (i <= mid && j<= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余数据移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边剩余数据移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 用新数组的数据覆盖原数组
        for (int x = 0; x < temp.length; ++x) {
            nums[x + low] = temp[x];
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 4, 6, 3, 10, 5, 2, 8, 12, 9};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
