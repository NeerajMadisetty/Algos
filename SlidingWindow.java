class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int first = 0;
        
        int second = 0;
        
        int sum = nums[0];
        int length = Integer.MAX_VALUE;
        
        while(second < nums.length){
            if(sum < target) {
                second++;
                if(second == nums.length) break;
                sum+=nums[second];
                continue;
            }else{
                if(length > second-first+1) length = second- first + 1;
                if(first<second) {
                    sum-=nums[first];
                    first++;
                }
                else {
                    second++;
                }
            }
        }
        
        return length==Integer.MAX_VALUE ? 0 : length;
    }
}