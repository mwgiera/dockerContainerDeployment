package codeinside.app.collections;

import java.util.Objects;

public final class Key {
    private final long id;
    private final String code;

    public Key(long id, String code) {
        this.id = id;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key k = (Key) o;
        return id == k.id && Objects.equals(code, k.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }
}
