package webserver.requestV2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterTest {
    @Test
    @DisplayName("queryString이 주어졌을 때 key value로 parameter 분리할 수 있다")
    void test() {
        String queryString = "name=테스트&nickname=test";

        Parameter parameter = new Parameter(queryString);

        assertEquals(parameter.getParameter("name"), "테스트");
        assertEquals(parameter.getParameter("nickname"), "test");
    }
}
