class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum=0;
        while(right<nums.length){
            sum += nums[right];
            while(sum >= target){
                int len = right-left+1;
                if(len<ans){
                    ans = len;
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if(ans == Integer.MAX_VALUE){
            ans = 0;
        }
        return ans;
    }
}
