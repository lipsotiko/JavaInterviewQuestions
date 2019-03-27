package collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ListPerformanceTest {

    private ListPerformance listPerformance;

    @Before
    public void setUp() {
        listPerformance = new ListPerformance();
    }

    @Test
    public void assert_on_collection_durations() {
        add_duration_is_faster_for_linked_lists();
        get_duration_is_faster_for_array_lists();
        remove_duration_is_faster_for_linked_lists();
    }

    void add_duration_is_faster_for_linked_lists() {
        assertTrue(listPerformance.linkedListAddDuration() < listPerformance.arrayListAddDuration());
    }

    void get_duration_is_faster_for_array_lists() {
        assertTrue(listPerformance.arrayListGetDuration() < listPerformance.linkedListGetDuration());
    }

    void remove_duration_is_faster_for_linked_lists() {
        assertTrue(listPerformance.linkedListRemoveDuration() < listPerformance.arrayListRemoveDuration());
    }
}
