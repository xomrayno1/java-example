package Arrays;
/*
 * Title: Squares of a Sorted Array
 * Date: 30/07/2021
 * Author: Tam Nguyen
 */
/*
 * Description: Given an integer array nums sorted in non-decreasing order, 
 * 		return an array of the squares of each number sorted in non-decreasing order.
 * Example 1: Input: nums = [-4,-1,0,3,10] Output: [0,1,9,16,100]
 * Example 2: Input: nums = [-7,-3,2,3,11] Output: [4,9,9,49,121]
 */
public class SquaresOfSortedArray {
	public static void main(String[] args) {
		int[] nums = {-7,-3,2,3,11};
		int[] arr = sortedSquares(nums);
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static int squares(int num) {
        return num * num;
    }
	
	public static int[] sort(int[] nums) {
		for(int i = 0 ; i < nums.length ; i++) {
			for(int j = i + 1 ; j < nums.length ; j++) {
				if(nums[i] > nums[j]) { //1 3 2 5
					int swap = nums[i];
					nums[i] = nums[j];
					nums[j] = swap;
				}
			}
		}
        return nums;
    }
	
	public static int[] sortedSquares(int[] nums) {
		int[] newsNum = new int[nums.length];
		for(int i = 0 ; i < nums.length ; i++) {
			newsNum[i] = squares(nums[i]);
		}
        return sort(newsNum);
    }

	 
	 
}
