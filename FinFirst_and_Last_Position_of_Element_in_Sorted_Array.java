class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int beginIndex = findBeginning(nums,target);
       // System.out.println("Begin index is "+beginIndex);
        int endIndex = findEnd(nums,target); 
        
        return new int[]{beginIndex,endIndex};
    }
    
    int findBeginning(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(low == high){
                if(nums[mid] == target) return mid;
                else return -1;
            }
            
            if(high == low+1){
                if(nums[low] != target && nums[high] != target){
                    return -1;
                }else{
                    if(nums[low] == target) return low>0 ? low-1 : 0;
                    else return high;
                }
            }
            
            if(nums[mid] == target){
                if(mid==low){
                    return mid;
                }else{
                    if(nums[mid-1] != target) return mid;
                }
                
                high = mid;
            }else{
                if(nums[mid] > target) high = mid;
                else low = mid;
            }
        }
        return -1;
    }
    
    int findEnd(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(low == high){
                if(nums[mid] == target) return mid;
                else return -1;
            }
            
            if(high == low+1){
                if(nums[low] != target && nums[high] != target){
                    return -1;
                }else{
                    if(nums[high] == target) return high<nums.length-1 ? high+1 : high;
                    else return low;
                }
            }
            
            if(nums[mid] == target){
                
                if(nums[mid+1] != target) return mid;  
                low = mid;
            }else{
                if(nums[mid] > target) high = mid;
                else low = mid;
            }
        }
        return -1;
    }
}
