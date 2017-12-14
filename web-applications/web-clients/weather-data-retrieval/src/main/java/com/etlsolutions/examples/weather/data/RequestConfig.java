package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.SettingConstants.*;

/**
 * The RequestConfig class contains the parameters to send a request.
 *
 * @author zc
 */
public final class RequestConfig {

    private final RequestMethod requestMethod;
    private final RequestLocation requestLocation;
    private final RequestToken requestToken;
    private final String url;

    public RequestConfig(RequestMethod requesttMethod, RequestLocation requestLocation, RequestToken requestToken) {
        this.requestMethod = requesttMethod;
        this.requestLocation = requestLocation;
        this.requestToken = requestToken;
        this.url = URL_BASE.replace(REQUEST_METHOD_TOKEN, requesttMethod.getMethodToken()).replace(LOCATION_TOKEN, requestLocation.getId()).replace(REQUEST_INTERVAL_TOKEN, requesttMethod.getInterval()).replace(REQUEST_TOEKN, requestToken.getValue());
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public RequestLocation getRequestLocation() {
        return requestLocation;
    }

    public RequestToken getRequestToken() {
        return requestToken;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "RequesConfig{" + "method=" + requestMethod + ", location=" + requestLocation + ", user token=" + requestToken + ", url=" + url + "}";
    }
}
