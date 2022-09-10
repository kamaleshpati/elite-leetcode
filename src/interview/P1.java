package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//MAX SUM CONTINOUS SUBARRAY
class P1{
    public static void main(String[] args) {
        Integer arr[] = new Integer[]{-3,-1,1, 2, 3, 4, -10};
        List<Integer> li = new ArrayList<>();
        Collections.addAll(li, arr);
        int sum = li.stream().mapToInt(e -> e).sum();
        System.out.println(maxContinousSumSubArray(li));
        System.out.println(maxContinousSumSubArray(li,sum,sum,0,li.size()-1));
    }

    private static int maxContinousSumSubArray(List<Integer> asList) {
        int size = asList.size();
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + asList.get(i);
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    private static int maxContinousSumSubArray(List<Integer> asList, int sum, int big, int start, int end) {
        if(start == end)
            return big;


        sum = Math.subtractExact(sum,asList.get(start));
        big = asList.get(start);
        big = Math.max(big,maxContinousSumSubArray(asList,sum,big,start+1,end));
        sum = Math.addExact(sum,asList.get(start));
        sum= Math.subtractExact(sum,asList.get(end));
        big = Math.max(big,sum);
        big = Math.max(big,maxContinousSumSubArray(asList,sum,big,start,end-1));
        return big;
    }



}