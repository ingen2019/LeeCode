package com.example.ingen.LeeCode;

/**
 * 二分查找
 */
class BinarySearch {

    /**
     * TestCase          Target
     * [5]               5
     * [5]               -5
     * [2,5]             2
     * [2,5]             5
     * [-1,0,3,5,9,12]   9
     * [-1,0,3,5,9,12]   2
     */
    int[] nums = {-1,0,3,5,9,12};
    int target = 9;

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        solution.search(solution.nums, solution.target);
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int end = len -1;
        int start = 0;
        int searchIndex = (end - start) / 2;
        //只有一个元素
        if(len == 1){
            if(target == nums[0]){
                return 0;
            }
            return -1;
        }
        while(end - start >= 1){
            if(target == nums[searchIndex]){
                return searchIndex;
            }else if(target > nums[searchIndex]){
                start = searchIndex;
                searchIndex = ((end - start) / 2) + searchIndex;
                if(end - start == 1){
                    searchIndex = searchIndex + 1;
                }
            }else if(target < nums[searchIndex]){
                end = searchIndex;
                searchIndex = searchIndex - ((end - start) / 2) ;
                if(end - start == 1){
                    searchIndex = searchIndex - 1;
                }
            }
            if(end == start){
                if(target == nums[start]){
                    return start;
                }
                return -1;
            }
            if(end - start == 1){
                if(target == nums[searchIndex]){
                    return searchIndex;
                }
                return -1;
            }
        }
        return -1;
    }
}