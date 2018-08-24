### 27. Remove Element

### Problem

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

**Example:**

Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

### Solution

双指针，分别指向去除的第一个元素位置和遍历位置

cpp
```cpp
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int count = 0;
        for (auto e : nums){
            if (e != val)
                nums[count++] = e;
        }
        return count;
    }
};
```
java
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        // 双指针
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
```