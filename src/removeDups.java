
public class removeDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3}));
	}
	
    public static int removeDuplicates(int[] nums) {
        
        int j = 1;
        boolean replace = false;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                if(!replace){
                    replace = true;
                    nums[j++] = nums[i];
                }
            }
            else{
                replace = false;
                nums[j++] = nums[i];
            }
        }
        return j;
    }

}
