public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

// contiguous means just in order. like [0,1,1,0,1,1,0].
// longest subarray is [0,1,1,0] where # of 0's = 2 and 1's = 2;
// however could be [0,0,0,0,1,1,1,1] and you count 4 consecutive
// zeros without realizing this is valid for length of 8.


//this is not right either. their examples are the problem not my coding. lord.
//class Solution {
//    public int findMaxLength(int[] nums) {
//        int[] temp = new int[2];
//        for(int i: nums){
//            temp[i]++;
//        }
//        return 2*Math.min(temp[0],temp[1]);
//    }
//}

// both attemps having trouble with account for when non-pair found to restore current value and zero out others without
// being super redudnant. making this way too hard. they don't have to be consecutive like 0101010. can be 0001110. and
// longest length is 6. just create another array.

// Second attempt
//class Solution {
//    public int findMaxLength(int[] nums) {
//        int longLen = 0;
//        int curLen =0;
//        int b0 = 0;
//        int b1 = 0;
//
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] == 0){
//                b0++;
//            } else {
//                b1++;
//            }
//            if(b0 == 1 && b1 == 1){
//                curLen++;
//                b0 = 0;
//                b1 = 0;
//            } else if (b0 > 1){
//                b0 = 1;
//                b1 = 0;
//                curLen = 1;
//            } else if (b1 > 1){
//                b0 = 0;
//                b1 = 1;
//                curLen = 1;
//            } else{
//                curLen ++;
//            }
//            if (curLen > longLen && curLen >= 2){
//                longLen = curLen;
//                if(b0 > 0 || b1 > 0){
//                    longLen--;
//                }
//            }
//        }
//        return longLen;
//    }
//}



// first attempt
//class Solution {
//    public int findMaxLength(int[] nums) {
//        int longLen = 0;
//        int curLen =0;
//        int b0 = 0;
//        int b1 = 0;
//        for(int i: nums){
//            if(i == 0){
//                b0++;
//            } else {
//                b1++:
//            }
//            if(!Math.abs(b1-b0) <2 ){
//                curLen++;
//                if(curLen > longLen){
//                    longLen = curLen;
//                }
//            } else{
//                curLen = 0;
//            }
//        }
//        return longLen;
//    }
//}