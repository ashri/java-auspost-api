package org.tearsofaunicorn.auspost.domestic.postcode.search;

import org.tearsofaunicorn.auspost.domestic.postcode.search.model.SearchRequest;

/**
 * Client to search for Postcode information with Australia Post
 */
public class PostcodeSearchClient {

    public static final String DEFAULT_ENDPOINT = "https://auspost.com.au/api/postcode/search";
    private final String apiKey;
    private String endpoint;

    public PostcodeSearchClient(String apiKey) {
        this.apiKey = apiKey;
        this.endpoint = DEFAULT_ENDPOINT;
    }

    public PostcodeSearchClient setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public SearchRequest prepareSearch(String query) {
        return new SearchRequest(apiKey, endpoint);
    }

}
