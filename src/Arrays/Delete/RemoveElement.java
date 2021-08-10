package Arrays.Delete;
/*
 * Title: Remove Element
 * Date: 10/08/2021
 * Author: Tam Nguyen
 */

/*
 * Description: Given an integer array nums and an integer val, 
 * 	remove all occurrences of val in nums in-place. 
 * 	The relative order of the elements may be changed.
 * Return k after placing the final result in the first k slots of nums.
 * Example 1: Input: nums = [3,2,2,3], val = 3 Output: 2, nums = [2,2,_,_]
 * Example 2: Input: nums = [0,1,2,2,3,0,4,2], val = 2 Output: 5, nums = [0,1,4,0,3,_,_,_]
 */

public class RemoveElement {
	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2 };
		int val = 2;
		int k = removeElement(nums, val);
		System.out.println("k= " + k);
	}
//	public static int removeElement(int[] nums, int val) {
//		int k = 0 ;
//		int length = nums.length;
//		for(int i = length - 1; i >= 0 ;  i--) {
//			if(nums[i] == val) {
//				for(int j = i ; j < length - 1  ; j++) {
//					nums[j] = nums[j + 1];
//				}
//				k++;
//			}
//		}
//		return nums.length - k;
//    }
	public static int removeElement(int[] nums, int val) {
		int j = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) { // thay vì tìm val 
								// tìm khác val giữ cái khoá j tại vị trí == val 
								// tìm cái khác val  swap vs == val
				nums[j] = nums[i];
				j++;
				count++;
			}
		}
		return count;
	}
}
