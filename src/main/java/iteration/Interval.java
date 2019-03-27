package iteration;

import lombok.Data;

@Data
class Interval {
    private int start;
    private int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean isWithin(Interval i) {
        return (this.getStart() >= i.getStart() && this.getStart() <= i.getEnd()) ||
                (this.getEnd() >= i.getStart() && this.getEnd() <= i.getEnd());
    }
}
