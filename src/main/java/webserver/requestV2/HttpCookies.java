package webserver.requestV2;

import java.util.HashMap;

public class HttpCookies {
    private static final String COOKIE_DELIMITER = ";";
    private static final String COOKIE_HEADER = "Cookie";
    private static final String KEY_VALUE_DELIMITER = "=";

    private final HashMap<String, HttpCookie> cookies;

    private HttpCookies(HashMap<String, HttpCookie> cookies) {
        this.cookies = cookies;
    }

    public HttpCookies(HttpHeader headers) {
        HashMap<String, HttpCookie> cookies = new HashMap<>();
        String cookieHeader = headers.getHeader(COOKIE_HEADER);
        String[] cookieStrings = cookieHeader.split(COOKIE_DELIMITER);

        for (String cookieString : cookieStrings) {
            HttpCookie cookie = new HttpCookie(cookieString);
            cookies.put(cookie.getName(), cookie);
        }

        this.cookies = cookies;
    }

    public HttpCookie getCookie(String key) {
        return cookies.get(key);
    }
}
