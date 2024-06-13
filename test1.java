/**
 * test1
 */
public class test1 {

    public static void main(String[] args) {
        int[] nums_list = { 1, 2, 5, 7, 10, 18, 20, 50, 200 };
        System.out.println(binary_search(nums_list, 10));
    }

    public static int binary_search(int[] nums_list, int value) {
        int right = nums_list.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums_list[mid] == value) {
                return mid;
            } else if (nums_list[mid] > value) {
                right = mid - 1;
            } else if (nums_list[mid] < value) {
                left = mid + 1;
            }

        }
        return -1;
    }
}