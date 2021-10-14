package iteration;

class Interval {
    private final int start;
    private int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean isWithin(Interval i) {
        return (this.start >= i.start && this.start <= i.end) ||
                (this.end >= i.start && this.end <= i.end);
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }
}
