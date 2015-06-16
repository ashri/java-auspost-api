package org.tearsofaunicorn.auspost.domestic.postcode.search.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The postcode search response containing the matching localities
 */
public class SearchResponse {

    @JsonProperty
    private List<Locality> localities;

    public List<Locality> getLocalities() {
        return localities;
    }

    public void setLocalities(List<Locality> localities) {
        this.localities = localities;
    }
}
