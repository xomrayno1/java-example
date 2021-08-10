package Arrays.Search;
/*
 * Title: Valid Mountain Array
 * Date: 11/08/2021
 * Author: Tam Nguyen
 */

/*
 * Description: Given an array of integers arr, 
 * 		return true if and only if it is a valid mountain array.
 * Example 1: Input: arr = [2,1] Output: false
 * Example 2: Input: arr = [3,5,5] Output: false
 * Example 3: Input: arr = [0,3,2,1] Output: true
 */
public class ValidMountainArray {
	public static void main(String[] args) {
		int[] arr = {3,5,5};
		boolean flag = validMountainArray(arr);
		System.out.println(flag);
	}
	//0,3,2,1
	public static boolean validMountainArray(int[] arr) {
		int length = arr.length;
		if(length < 3 ) {
			return false;
		}
		boolean flag = false;
		for(int i = 0 ; i < arr.length; i++) {
			if(flag) {
				//check đi xuống
				if(arr[i - 1] <= arr[i]) return false;
			}else {
				//check đi lên
				if(arr[i] >= arr[i + 1]) {
					flag = true;
				}
			}
		}
		return true;
	}
}
