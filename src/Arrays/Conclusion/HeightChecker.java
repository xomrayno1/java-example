package Arrays.Conclusion;

import java.util.Arrays;

/*
 * Title: Max Consecutive Ones
 * Date: 14/08/2021
 * Author: Tam Nguyen
 */

/*
 * Example 1: Input: heights = [1,1,4,2,1,3] Output: 3
 * Example 2: Input: heights = [5,1,2,3,4]  Output: 5
 * Example 3: Input: heights = [1,2,3,4,5] Output: 0
 */
public class HeightChecker {
	public static void main(String[] args) {
		int[] heights = {1,1,4,2,1,3};
		int result = heightChecker(heights);
		System.out.println(result);
	}
	
	public static int heightChecker(int[] heights) {
		int[] arr = heights.clone();
		int heightChecker = 0;
		
		Arrays.sort(arr);
		int length = heights.length;
		for(int i = 0 ; i < length ; i++) {
			if(heights[i] != arr[i]) {
				heightChecker++;
			}
		}
		
        return heightChecker;
    }

}
