package iteration;

import java.util.ArrayList;
import java.util.List;

class MergeOverlappingIntervals {

    private final List<Interval> intervals;

    MergeOverlappingIntervals(List<Interval> intervals) {
        this.intervals = intervals;
    }

    List<Interval> merge() {
        List<Interval> results = new ArrayList<>();
        Interval current = intervals.get(0);

        for (int i = 1; i <= intervals.size(); i++) {
            Interval next = null;

            if (isNotLast(i)) next = intervals.get(i);

            if (next != null && next.isWithin(current)) {
                if(next.getEnd() >= current.getEnd())
                    current.setEnd(next.getEnd());
            } else {
                results.add(current);
                if(isNotLast(i)) current = intervals.get(i);
            }
        }

        return results;
    }

    private boolean isNotLast(int i) {
        return !(i == intervals.size());
    }

}
