package interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class P3 {
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void mergeIntervals(Interval arr[])
    {
        if (arr.length <= 0)
            return;

        var stack=new Stack<Interval>();

        Arrays.sort(arr, Comparator.comparingInt(i -> i.start));

        stack.push(arr[0]);

        for (int i = 1 ; i < arr.length; i++)
        {
            Interval top = stack.peek();

            if (top.end < arr[i].start)
                stack.push(arr[i]);

            else if (top.end < arr[i].end)
            {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty())
        {
            Interval t = stack.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        }

    }

    public static void main(String args[]) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }
}
