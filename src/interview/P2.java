package interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P2 {
       static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

        public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

           Set<Integer> delete = new HashSet<>();
            int bound = intervals.size(), startIndex = 0;
            for (int i1 = 0; i1 < bound; i1++) {
                Interval interval = intervals.get(i1);
                if (interval.start <= newInterval.start && interval.end > newInterval.start) {
                    newInterval.start = interval.start;
                    startIndex = i1;
                }
                if (interval.start < newInterval.end && interval.end >= newInterval.end) {
                    newInterval.end = interval.end;
                }
            }


            IntStream.range(0, intervals.size()).forEachOrdered(i -> {
                Interval interval = intervals.get(i);
                if (interval.start >= newInterval.start
                        && interval.end > newInterval.start
                        && interval.start < newInterval.end
                        && interval.end <= newInterval.end) {
                    delete.add(i);
                }
            });


            ArrayList<Interval> intervals1 = IntStream.range(0, intervals.size()).filter(i -> !delete.contains(i)).mapToObj(intervals::get).collect(Collectors.toCollection(ArrayList::new));

            intervals1.add(startIndex,newInterval);

            return intervals1;
        }

    public static void main(String[] args) {
        ArrayList<Interval> li = new ArrayList();
        li.add(new Interval(1,2));
        li.add(new Interval(3,5));
        li.add(new Interval(6,7));
        li.add(new Interval(8,10));
        li.add(new Interval(12,16));

        System.out.println("==========");

        li = insert(li,new Interval(4,10));

        li.forEach(e->{
            System.out.println(e.start+" "+e.end);
        });

    }
}
