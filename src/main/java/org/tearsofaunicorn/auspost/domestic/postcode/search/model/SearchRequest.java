package org.tearsofaunicorn.auspost.domestic.postcode.search.model;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class SearchRequest {

    private static final Logger LOG = LoggerFactory.getLogger("auspost.domestic.postcode.search");

    private final String apiKey;
    private final String endpoint;

    private OkHttpClient httpClient;
    private Unmarshaller unmarshaller;

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

    public SearchRequest unmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
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

    public SearchResponse executeGet() throws Exception {
        if (httpClient == null) {
            httpClient = new OkHttpClient();
        }
        if (unmarshaller == null) {
            JAXBContext jaxbContext = JAXBContext.newInstance(SearchResponse.class);
            unmarshaller = jaxbContext.createUnmarshaller();
        }

        String url = buildUrl();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("AUTH-KEY", apiKey)
                .build();

        LOG.trace("Request URL: {}", url);

        Response response = httpClient.newCall(request).execute();
        String responseBody = response.body().string();

        LOG.trace("Response body: {}", responseBody);

        return (SearchResponse) unmarshaller.unmarshal(new StringReader(responseBody));
    }

    protected String buildUrl() {
        StringBuilder url = new StringBuilder(endpoint);
        url.append("?q=");
        url.append(query);
        if (state != null) {
            url.append("&state=");
            url.append(state.name());
        }
        if (excludePostOfficeBoxes) {
            url.append("&excludePostBoxFlag=");
            url.append("true");
        }
        return url.toString();
    }
}
