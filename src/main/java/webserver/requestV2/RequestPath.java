package webserver.requestV2;

import java.net.URI;
import java.net.URISyntaxException;

public class RequestPath {
    private final URI uri;
    private final String path;

    private RequestPath(URI uri, String path) {
        this.uri = uri;
        this.path = path;
    }

    static RequestPath parse(String rawPath) throws URISyntaxException {
        URI uri = new URI(rawPath);
        return new RequestPath(uri, uri.getPath());
    }

    public URI getUri() {
        return uri;
    }

    public String getPath() {
        return path;
    }
}
