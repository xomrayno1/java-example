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
	public static boolean validMountainArray(int[] arr) {  
		int len = arr.length;
		if(len < 3 ) {
			return false;
		}
		boolean flagUp = false;
        boolean flagDown = false;
        int i = 0;
        while(i <= len - 2){
            if(arr[i] < arr[i+1]){
                flagUp = true;
                i++;
                continue;
            } else
                break;
        }
        while(i <= len - 2){
            if(arr[i] > arr[i+1]){
                flagDown = true;
                i++;
                continue;
            } else
                break;
        }
        return flagUp && flagDown && (i == len-1);
	}
	 
}
