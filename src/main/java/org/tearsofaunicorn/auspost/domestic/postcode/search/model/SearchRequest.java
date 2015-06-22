package org.tearsofaunicorn.auspost.domestic.postcode.search.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SearchRequest {

    private final String apiKey;
    private final String endpoint;

    private OkHttpClient httpClient;
    private ObjectMapper objectMapper;

    private String query;
    private AustralianState state;
    private boolean excludePostOfficeBoxes;

    public SearchRequest(String apiKey, String endpoint) {
        this.apiKey = apiKey;
        this.endpoint = endpoint;
    }

    public SearchRequest httpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public SearchRequest objectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        return this;
    }

    public SearchRequest query(String query) {
        this.query = query;
        return this;
    }

    public SearchRequest setState(AustralianState state) {
        this.state = state;
        return this;
    }

    public SearchRequest excludePostBoxes(boolean exclude) {
        this.excludePostOfficeBoxes = exclude;
        return this;
    }

    public SearchResponse executeGet() throws IOException {
        if (httpClient == null) {
            httpClient = new OkHttpClient();
        }
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        Request request = new Request.Builder()
                .url(buildUrl())
                .build();

        Response response = httpClient.newCall(request).execute();
        String responseBody = response.body().string();

        return objectMapper.readValue(responseBody, SearchResponse.class);
    }

    protected String buildUrl() {
        StringBuilder url = new StringBuilder(endpoint);
        url.append("?apiKey=");
        url.append(apiKey);
        url.append("&q=");
        url.append(query);
        if (state != null) {
            url.append("&state=");
            url.append(state.name());
        }
        if (excludePostOfficeBoxes) {
            url.append("&excludepostboxflag=");
            url.append("true");
        }
        return url.toString();
    }
}
