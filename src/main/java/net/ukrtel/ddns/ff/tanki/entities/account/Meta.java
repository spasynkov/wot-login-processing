package net.ukrtel.ddns.ff.tanki.entities.account;

public class Meta {
    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "{" +
                "count=" + count +
                '}';
    }
}