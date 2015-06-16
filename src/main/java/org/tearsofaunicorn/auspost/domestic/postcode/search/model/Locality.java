package org.tearsofaunicorn.auspost.domestic.postcode.search.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A single post code locality
 */
public class Locality {

    @JsonProperty
    private String category;

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String location;

    @JsonProperty
    private Integer postCode;

    @JsonProperty
    private AustralianState state;

    @JsonProperty
    private Float latitude;

    @JsonProperty
    private Float longitude;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public AustralianState getState() {
        return state;
    }

    public void setState(AustralianState state) {
        this.state = state;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
