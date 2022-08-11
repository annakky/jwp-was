package webserver.requestV2;

import java.net.URI;
import java.net.URISyntaxException;

public class RequestPath {
    private final URI uri;
    private final String path;
    private final Parameter parameters;

    private RequestPath(URI uri, String path, Parameter parameter) {
        this.uri = uri;
        this.path = path;
        this.parameters = parameter;
    }

    static RequestPath parse(String rawPath) throws URISyntaxException {
        URI uri = new URI(rawPath);
        String queryString = uri.getQuery();

        return new RequestPath(uri, uri.getPath(), new Parameter(queryString));
    }

    public URI getUri() {
        return uri;
    }

    public String getPath() {
        return path;
    }

    public String getParameter(String key) {
        return parameters.getParameter(key);
    }
}
