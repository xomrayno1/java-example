package Arrays.InPlaceOperations;
/*
 * Title: Remove Element
 * Date: 14/08/2021
 * Author: Tam Nguyen
 */

/*
 * Description: Given an array arr, 
 * 		replace every element in that array with the greatest element among the elements to its right, 
 * 		and replace the last element with -1.
 * After doing so, return the array.
 * Example 1: Input: arr = [17,18,5,4,6,1] Output: [18,6,6,6,1,-1]
 * Example 2: Input: arr = [400] Output: [-1]
 */
public class ReplaceElementsWithGreatestElementOnRightSide {
	public static void main(String[] args) {
		int[] arr = {17,18,5,4,6,1};
		int[] news = replaceElements(arr);
		for(int item : news) {
			System.out.println(item);
		}
	}
	//17,18,5,4,6,1
	//17,18,5,4,6,1
	//17,18,5,4,6,-1 max = 1 temp = 6 
	//17,18,5,4,1,-1 max = 6 temp = 4
	//17,18,5,6,1,-1 max = 6 temp = 5
	//17,18,6,6,1,-1 max = 6 temp = 18
	//18,6,6,6,1,-1 max = 18 temp = 17 
	//17,6,6,6,1,-1 
	
	public static int[] replaceElements(int[] arr) {
		int length = arr.length;
		int max = arr[length - 1];
		arr[length - 1] = -1;
		int temp = 0;
		for(int i = length - 2 ; i >= 0 ; i--) {
			temp = arr[i];
			arr[i] = max;
			max = Math.max(temp, max);
		}
        
        return arr;
	}
	
//	public static int[] replaceElements(int[] arr) {
//		int length = arr.length;
//		for(int i = 0 ; i < length; i++) {
//			int max = -1;
//			for(int j = i + 1 ; j < length; j++) {
//				if(max < arr[j]) {
//					max = arr[j];
//				}
//			}
//			arr[i] = max;
//		}
//		return arr;
//	}

}
