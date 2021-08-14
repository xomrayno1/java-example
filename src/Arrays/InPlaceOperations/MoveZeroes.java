package Arrays.InPlaceOperations;
/*
 * Title: Remove Element
 * Date: 14/08/2021
 * Author: Tam Nguyen
 */

/*
 * Description: Given an integer array nums, 
 * 		move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * Example 1: Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
 * Example 2: Input: nums = [0] Output: [0]
 */
public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		
	}
	//	0,1,0,3,12	1,0,0,3,12   1,3,0,0,12 	1,3,0,0,12
	//	j	  		  j			   j			    j
	//	  i				i 			   i				i
	
	// 1,0,0,3,12
	// 1,0,3,0,12
	// 1,3,0,0,12
	//1,3,0,12,0,
	//1,3,12,0,0
	public static void moveZeroes(int[] nums) {
		// i tìm index  != 0 
		// j giữ index // swap a[j] với a[i]
		int length = nums.length;
		int j = 0 ;
		for(int i = 0 ; i < length ; i++) {
			if(nums[i] != 0) {
				int temp = nums[j]; // swap
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}
		}
		
        for(int num : nums) {
        	System.out.println(num);
        }
    }
}
