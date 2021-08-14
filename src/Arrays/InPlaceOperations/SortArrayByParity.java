package Arrays.InPlaceOperations;
/*
 * Title: Remove Element
 * Date: 14/08/2021
 * Author: Tam Nguyen
 */

/*
 * Description: Given an integer array nums, 
 * 		move all the even integers at the beginning of the array followed by all the odd integers.
 * Return any array that satisfies this condition.
 * Example 1: Input: nums = [3,1,2,4]  Output: [2,4,3,1]
 * Example 2: Input: nums = [0]  Output: [0]
 */
public class SortArrayByParity {
	public static void main(String[] args) {
		int[] nums = {3,6,1,2,4};
		int[] arr = sortArrayByParity(nums);
		for(int element : arr) {
			System.out.println(element);
		}
	}

	public static int[] sortArrayByParity(int[] nums) {
		int length = nums.length;
		int j = 0;
		for(int i = 0 ; i < length ; i++) {
			if(nums[i]  % 2 == 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}
		return nums;
	}

}
