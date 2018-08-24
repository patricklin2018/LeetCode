class Solution {
    int threeSumClosest(vector<int>& nums, int target) {
        int size = nums.size(), gap = 0x7fffffff, sum;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < size - 2; ++i){
            int j = i + 1, k = size - 1;
            while (j < k){
                int tmp = nums[i] + nums[j] + nums[k];
                if (abs(target - tmp) < gap){
                    gap = abs(target - tmp);
                    sum = tmp;
                }
                tmp < target ? j++ : k--;
            }
        }
        return sum;
    }
}