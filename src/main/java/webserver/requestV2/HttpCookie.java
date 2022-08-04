package webserver.requestV2;

import java.util.Objects;

public class HttpCookie {
    private final String name;
    private final String value;

    public HttpCookie(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        HttpCookie that = (HttpCookie) other;

        return this.name.equalsIgnoreCase(that.getName());
    }

    @Override
    public String toString() {
        return name + "=" + value;
    }
}
