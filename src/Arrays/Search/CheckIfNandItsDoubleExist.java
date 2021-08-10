package Arrays.Search;
/*
 * Title: Check If N and Its Double Exist
 * Date: 11/08/2021
 * Author: Tam Nguyen
 */

/*
 * Description: Given an array arr of integers, 
 * 		check if there exists two integers N and M such that N is the double of M 
 * 										( i.e. N = 2 * M).
 * More formally check if there exists two indices i and j such that :
 * 			i != j
 * 			0 <= i, j < arr.length
 * 			arr[i] == 2 * arr[j]
 * 
 * Example 1: Input: arr = [10,2,5,3] Output: true
 * Example 2: Input: arr = [7,1,14,11] Output: true
 * Example 3: Input: arr = [3,1,7,11] Output: false
 */
public class CheckIfNandItsDoubleExist {
	public static void main(String[] args) {
		int[] arr = {-2,0,10,-19,4,6,-8};
		boolean flag = checkIfExist(arr);
		System.out.println(flag);
	}

	// [10,2,5,3]
	// [7,1,14,11]
	// [3,1,7,11]
	//[-2,0,10,-19,4,6,-8]
	public static boolean checkIfExist(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0 ; j < arr.length ; j++) {
				if(arr[i] == 2 * arr[j] && j != i) {
					return true;
				}
			}
		}
		return false;
	}
}
