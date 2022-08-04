package webserver.requestV2;

import enums.HttpMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpRequestV2 {
    private HttpMethod method;
    private RequestPath path;
    private HttpHeader headers;
    private Map<String, String> parameters;
    private Map<String, String> body;
    private Map<String, HttpCookie> cookies;

    public HttpRequestV2(InputStream inputStream) throws IOException {
        List<String> request = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        String line = br.readLine();
        request.add(line);

        while (!line.equals("")) {
            line = br.readLine();
            request.add(line);
        }
    }
}
