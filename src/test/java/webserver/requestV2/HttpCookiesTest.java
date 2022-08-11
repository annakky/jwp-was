package webserver.requestV2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpCookiesTest {
    @Test
    @DisplayName("Cookie를 가진 헤더가 주어졌을 때 key value로 쿠키를 얻을 수 있다.")
    void test() {
        HttpHeader header = new HttpHeader();
        header.addHeader("Cookie", "logined=true; name=test");

        HttpCookies cookies = new HttpCookies(header);

        assertEquals(cookies.getCookie("logined"), new HttpCookie("logined", "true"));
        assertEquals(cookies.getCookie("name"), new HttpCookie("name", "test"));
    }
}
