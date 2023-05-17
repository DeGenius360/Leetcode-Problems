import java.util.Arrays;
import java.util.HashMap;

class TwoSum{
    /*Could try the bruteforce approach
     * Scan through the array and pick elements in twos
     * Add them and check if the sum is the target.
     * If not, discard them
     */

    //Approach 1: assume the answers are consecutive
    public static int[] twosum(int[] nums, int target){
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    //Approach 2: Handle cases where the numbers aren't consecutive
    public static int[] twosum2(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
   public static void main(String[] args) {
        int[] nums =  {2,7,11,15};
        int target = 9;
        int [] answer = twosum2(nums, target);
        System.out.print(Arrays.toString(answer));
    }
    
}