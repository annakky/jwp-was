package webserver.requestV2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpCookieTest {
    @Test
    @DisplayName("HttpCookie를 String으로 변환 테스트")
    void cookieToStringTest() {
        HttpCookie cookie = new HttpCookie("Content-Type", "application/json");

        assertEquals(cookie.toString(), "Content-Type=application/json");
    }

    @Test
    @DisplayName("HttpCookie 동등 비교 테스트")
    void cookieEqualsTest() {
        HttpCookie base = new HttpCookie("Content-Type", "application/json");
        HttpCookie other = new HttpCookie("Content-Type", "text/html");

        assertEquals(base, other);
    }
}
