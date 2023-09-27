import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


// SOLUTION
public class Solution {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // stores count as key, index as value
        map.put(0, -1); // this is important say length of 6, for below, when i 5, 5- -1 = 6.
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1 ? 1 : -1); // ++ or -- count if 1 or 0 found
            if (map.containsKey(count)) { // if count already found, means = number of 0's and 1's between past 'i'
                // and currrent 'i'. say count is 3 at index 2, later count of 3 found again at index 6.
                maxlen = Math.max(maxlen, i - map.get(count)); // then current len is 6-2 = 4. if 4>maxLen, reassign
            } else { // new count only
                map.put(count, i);
            } // no rewriting of value to current index so store first time count x occured for longest length
        }
        return maxlen;
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