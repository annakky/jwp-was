package webserver.requestV2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestBodyTest {
    @Test
    @DisplayName("Body String이 주어졌을 때 key, value 형태로 저장할 수 있다.")
    void test() {
        String bodyString = "name=%ED%85%8C%EC%8A%A4%ED%8A%B8&nickname=test";

        RequestBody body = new RequestBody(bodyString);

        assertEquals(body.getValue("name"), "테스트");
        assertEquals(body.getValue("nickname"), "test");
    }
}
