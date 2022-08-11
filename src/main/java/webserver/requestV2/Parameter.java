package webserver.requestV2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Parameter {
    private static final String PARAMETER_DELIMITER = "&";
    private static final String KEY_VALUE_DELIMITER = "=";

    private final HashMap<String, String> parameters;

    private Parameter(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }

    public Parameter(String queryString) {
        HashMap<String, String> parameters = new HashMap<>();
        String[] params = queryString.split(PARAMETER_DELIMITER);
        for (String param : params) {
            String[] split = param.split(KEY_VALUE_DELIMITER);
            parameters.put(split[0], split[1]);
        }

        this.parameters = parameters;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }
}
