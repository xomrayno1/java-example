package Arrays;
/*
 * Title: Max Consecutive Ones
 * Date: 30/07/2021
 * Author: Tam Nguyen
 */
/*
 * Description:  Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * Example 1: Input: nums = [1,1,0,1,1,1] __ Output: 3
 * Example 2: Input: nums = [1,0,1,1,0,1] __  Output: 2
 * Constraints: nums[i] is either 0 or 1.	 
 */

public class MaxConsecutiveOnes {
	
	public static void main(String[] args) {
		int[] nums = {1,0,1,1,0,1};
		int max = findMaxConsecutiveOnes(nums);
		System.out.println("max is " + max);
	}
	
	//[1,1,0,1,1,1]
	//[1,0,1,1,0,1]
	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int max = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			if(nums[i] == 1) {
				count++;
				if(count > max) { //#2
					max = count;	//#2
				}//#2
			}else {
				count = 0;
//				if(count > max) {
//					max = count;	#me
//				}
			}
		}
//		if(count > max) {
//			max = count;	#me
//		}
        return max;
    }
	 
}
