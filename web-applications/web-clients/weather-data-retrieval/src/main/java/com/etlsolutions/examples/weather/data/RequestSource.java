package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.SettingConstants.*;


/**
 *
 * @author zc
 */
public final class RequestSource {
    
    private final RequestMethod requesttMethod;
    private final RequestLocation requestLocation;
    private final RequestToken requestToken;
    private final String url;

    public RequestSource(RequestMethod requesttMethod, RequestLocation requestLocation, RequestToken requestToken) {
        this.requesttMethod = requesttMethod;
        this.requestLocation = requestLocation;
        this.requestToken = requestToken;
        this.url = URL_BASE.replace(REQUEST_METHOD_TOKEN, requesttMethod.getMethodToken()).replace(LOCATION_TOKEN, requestLocation.getId()).replace(REQUEST_INTERVAL_TOKEN, requesttMethod.getInterval()).replace(REQUEST_TOEKN, requestToken.getValue());
    }

    public RequestMethod getRequesttMethod() {
        return requesttMethod;
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
}
