package webserver.requestV2;

import java.net.URISyntaxException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestPathTest {
    @Test
    @DisplayName("요청 URL이 주어졌을 때 URI 와 Path로 파싱할 수 있다.")
    void parseTest() throws URISyntaxException {
        String requestURL = "/users?name=%ED%85%8C%EC%8A%A4%ED%8A%B8&nickname=test";

        RequestPath requestPath = RequestPath.parse(requestURL);

        assertEquals(requestPath.getPath(), "/users");
        assertEquals(requestPath.getUri().getQuery(), "name=테스트&nickname=test");
        assertEquals(requestPath.getParameter("name"), "테스트");
        assertEquals(requestPath.getParameter("nickname"), "test");
    }
}
