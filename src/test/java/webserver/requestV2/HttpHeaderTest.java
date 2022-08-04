package webserver.requestV2;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpHeaderTest {
    @Test
    @DisplayName("Header String 리스트가 주어졌을 때 key value 형태로 헤더를 파싱할 수 있다.")
    void parseTest() {
        List<String> headerString = List.of(
                "Host: localhost:8080",
                "Connection: keep-alive",
                "Test: test: test"
        );

        HttpHeader httpHeaders = HttpHeader.parse(headerString);

        assertEquals(httpHeaders.getHeader("Host"), "localhost:8080");
        assertEquals(httpHeaders.getHeader("Connection"), "keep-alive");
        assertEquals(httpHeaders.getHeader("Test"), "test: test");
    }

    @Test
    @DisplayName("헤더를 추가할 수 있다.")
    void emptyConstructorTest() {
        HttpHeader httpHeaders = new HttpHeader();

        httpHeaders.addHeader("Host", "localhost:8080");
        httpHeaders.addHeader("Connection", "keep-alive");

        assertEquals(httpHeaders.getHeader("Host"), "localhost:8080");
        assertEquals(httpHeaders.getHeader("Connection"), "keep-alive");
    }
}
