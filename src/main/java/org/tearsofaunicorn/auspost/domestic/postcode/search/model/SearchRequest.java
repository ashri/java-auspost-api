package org.tearsofaunicorn.auspost.domestic.postcode.search.model;

/**
 * _TODO:_ Write summary
 */
public class SearchRequest {

    private String state;
    private boolean excludePostOfficeBoxes;

    public SearchRequest setState(String state) {
        this.state = state;
        return this;
    }

    public SearchRequest excludePostBoxes(boolean exclude) {
        this.excludePostOfficeBoxes = exclude;
        return this;
    }

    public SearchResponse executeGet() {
        return null;
    }

}
