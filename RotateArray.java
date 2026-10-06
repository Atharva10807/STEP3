import java.util.Arrays;

public class RotateArray {
    static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        k = k % nums.length;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(rotateArray(nums, k)));
    }
}
