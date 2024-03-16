package iteration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MergeOverlappingIntervalsTest {

    private List<Interval> intervals;

    @BeforeEach
    public void setUp() {
        intervals = new ArrayList<>();
    }

    @Test
    public void no_overlapping_intervals() {
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 6));
        intervals.add(new Interval(7, 8));

        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals(intervals);
        List<Interval> result = mergeOverlappingIntervals.merge();

        assertEquals(3, result.size());

        assertEquals(1, result.get(0).getStart());
        assertEquals(3, result.get(0).getEnd());

        assertEquals(5, result.get(1).getStart());
        assertEquals(6, result.get(1).getEnd());

        assertEquals(7, result.get(2).getStart());
        assertEquals(8, result.get(2).getEnd());
    }

    @Test
    public void merges_one_overlapping_interval() {
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 5));

        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals(intervals);
        List<Interval> result = mergeOverlappingIntervals.merge();

        assertEquals(1, result.size());

        assertEquals(1, result.get(0).getStart());
        assertEquals(5, result.get(0).getEnd());
    }


    @Test
    public void last_intervals_are_overlapping() {
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(10, 20));
        intervals.add(new Interval(15, 30));

        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals(intervals);
        List<Interval> result = mergeOverlappingIntervals.merge();

        assertEquals(3, result.size());

        assertEquals(1, result.get(0).getStart());
        assertEquals(3, result.get(0).getEnd());

        assertEquals(6, result.get(1).getStart());
        assertEquals(7, result.get(1).getEnd());

        assertEquals(10, result.get(2).getStart());
        assertEquals(30, result.get(2).getEnd());
    }

    @Test
    public void first_intervals_are_overlapping() {
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 30));
        intervals.add(new Interval(40, 50));

        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals(intervals);
        List<Interval> result = mergeOverlappingIntervals.merge();

        assertEquals(3, result.size());

        assertEquals(1, result.get(0).getStart());
        assertEquals(10, result.get(0).getEnd());

        assertEquals(15, result.get(1).getStart());
        assertEquals(30, result.get(1).getEnd());

        assertEquals(40, result.get(2).getStart());
        assertEquals(50, result.get(2).getEnd());
    }

    @Test
    public void merges_a_mixture_of_overlapping_and_non_overlapping_intervals() {
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(7, 9));
        intervals.add(new Interval(11, 12));
        intervals.add(new Interval(12, 14));
        intervals.add(new Interval(13, 15));
        intervals.add(new Interval(15, 20));
        intervals.add(new Interval(28, 30));
        intervals.add(new Interval(40, 50));
        intervals.add(new Interval(45, 55));
        intervals.add(new Interval(50, 60));
        intervals.add(new Interval(100, 101));

        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals(intervals);
        List<Interval> result = mergeOverlappingIntervals.merge();

        assertEquals(6, result.size());

        assertEquals(1, result.get(0).getStart());
        assertEquals(5, result.get(0).getEnd());

        assertEquals(7, result.get(1).getStart());
        assertEquals(9, result.get(1).getEnd());

        assertEquals(11, result.get(2).getStart());
        assertEquals(20, result.get(2).getEnd());

        assertEquals(28, result.get(3).getStart());
        assertEquals(30, result.get(3).getEnd());

        assertEquals(40, result.get(4).getStart());
        assertEquals(60, result.get(4).getEnd());

        assertEquals(100, result.get(5).getStart());
        assertEquals(101, result.get(5).getEnd());
    }

    @Test
    public void one_interval() {
        intervals.add(new Interval(1, 3));

        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals(intervals);
        List<Interval> result = mergeOverlappingIntervals.merge();

        assertEquals(1, result.size());

        assertEquals(1, result.get(0).getStart());
        assertEquals(3, result.get(0).getEnd());
    }

    @Test
    public void one_large_interval() {
        intervals.add(new Interval(1, 100));
        intervals.add(new Interval(1, 20));
        intervals.add(new Interval(10, 11));
        intervals.add(new Interval(50, 100));

        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals(intervals);
        List<Interval> result = mergeOverlappingIntervals.merge();

        assertEquals(1, result.size());

        assertEquals(1, result.get(0).getStart());
        assertEquals(100, result.get(0).getEnd());
    }
}