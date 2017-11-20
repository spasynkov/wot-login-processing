package net.ukrtel.ddns.ff.tanki.entities.account;

public class Meta {
    private long count;

    public long getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meta)) return false;

        Meta meta = (Meta) o;

        return count == meta.count;
    }

    @Override
    public int hashCode() {
        return (int) (count ^ (count >>> 32));
    }

    @Override
    public String toString() {
        return "Meta{" +
                "count=" + count +
                '}';
    }
}