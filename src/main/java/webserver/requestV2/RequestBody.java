package webserver.requestV2;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import utils.StringUtils;

public class RequestBody {
    private static final String BODY_DELIMITER = "&";
    private static final String KEY_VALUE_DELIMITER = "=";

    private HashMap<String, String> body;

    private RequestBody(HashMap<String, String> body) {
        this.body = body;
    }

    public RequestBody(String bodyString) {
        HashMap<String, String> body = new HashMap<>();
        String[] params = bodyString.split(BODY_DELIMITER);

        for (String param : params) {
            String[] split = param.split(KEY_VALUE_DELIMITER);
            body.put(split[0], StringUtils.decodeUrlEncoding(split[1]));
        }
        this.body = body;
    }

    public String getValue(String key) {
        return body.get(key);
    }
}
