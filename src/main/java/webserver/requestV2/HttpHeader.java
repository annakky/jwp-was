package webserver.requestV2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpHeader {
    private static final String DELIMITER = ": ";

    private final Map<String, String> headers;

    private HttpHeader(Map<String, String> headers) {
        this.headers = headers;
    }

    public HttpHeader() {
        this.headers = new HashMap<>();
    }

    static HttpHeader parse(List<String> headerString) {
        HashMap<String, String> headers = new HashMap<>();

        headerString.forEach(header -> {
            String[] split = header.split(DELIMITER);
            String key = split[0];
            String value = String.join(DELIMITER, Arrays.asList(split).subList(1, split.length));

            headers.put(key, value);
        });

        return new HttpHeader(headers);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getHeader(String key) {
        return headers.get(key);
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }
}
