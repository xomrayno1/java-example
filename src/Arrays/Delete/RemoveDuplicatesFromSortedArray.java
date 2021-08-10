package Arrays.Delete;
/*
 * Title: Remove Duplicates From Sorted Array
 * Date: 11/08/2021
 * Author: Tam Nguyen
 */

/*
 * Description: Given an integer array nums sorted in non-decreasing order, 
 * 	remove the duplicates in-place such that each unique element appears only once. 
 * 	The relative order of the elements should be kept the same.
 * Example 1: Input: nums = [1,1,2] Output: 2, nums = [1,2,_]
 * Example 2: Input: nums = [0,0,1,1,1,2,2,3,3,4] Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 */
public class RemoveDuplicatesFromSortedArray {
	
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int k = removeDuplicates(nums);
		System.out.println(" k == " + k);
	}
	
	// 0,0,1,1,1,2,2,3,3,4 
	// 0,0,1,1,1,2,2,3,3,4 i = 0 j = 1
	// 0,1,1,1,1,2,2,3,3,4 i = 1 j = 1
	// 0,1,1,1,1,2,2,3,3,4 i = 2 j = 2
	// 0,1,1,1,1,2,2,3,3,4 i = 3 j = 2
	// 0,1,2,1,1,2,2,3,3,4 i = 4 j = 2
	// 0,1,2,1,1,2,2,3,3,4 i = 5 j = 3
	// 0,1,2,3,1,2,2,3,3,4 i = 6 j = 3
	// 0,1,2,3,1,2,2,3,3,4 i = 7 j = 4
	// 0,1,2,3,4,2,2,3,3,4 i = 8 j = 4
	public static int removeDuplicates(int[] nums) {
		int count = 1 ;
		int j = 1;
		for(int i = 0 ; i < nums.length - 1; i++) {
			if(nums[i] != nums[i + 1]){
				nums[j] = nums[i + 1];
				j++;
				count++;
			}
		}
        return count;
    }
}
