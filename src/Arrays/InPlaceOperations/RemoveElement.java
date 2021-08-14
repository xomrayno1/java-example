package Arrays.InPlaceOperations;

public class RemoveElement {
	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		int val = 2;
		int k = removeElement(nums, val);
		System.out.println("k = "+k);
	}
 
	public static int removeElement(int[] nums, int val) {
		int length = nums.length ;
		int j = 0;
		int k = 0;
		for(int i = 0 ; i < length ; i++) {
			if(nums[i] != val) {
				nums[j] = nums[i];
				j++;
				k++;
			}
		}
        return k;
    }
}
