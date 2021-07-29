package Arrays;
/*
 * Title: Find Numbers with Even Number of Digits
 * Date: 30/07/2021
 * Author: Tam Nguyen
 */
/*
 * Description: Given an array nums of integers, return how many of them contain an even number of digits.
 * Example 1: Input: nums = [12,345,2,6,7896] __ Output: 2
 * Example 2: Input: nums = [555,901,482,1771] __ Output: 1
 */

public class FindNumbersWithEvenNumberOfDigits {

	public static void main(String[] args) {
		int[] nums = {555,901,482,1771};
		int count = findNumbers(nums);
		System.out.println("Count : " + count);
	}
	
	public static int findNumbers(int[] nums) {
		int count = 0;
		for(int i = 0 ; i < nums.length; i++ ) {
			int result = countNumber(nums[i]);
			if(result % 2 == 0) {
				count++;
			}
		}
		return count;
    }
	public static int countNumber(int number) {
		int count = 0;
		while(number > 0 ) {
			count++;
			number = number / 10;
		}
		return count; 
	}
	 
}
