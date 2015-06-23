package au.com.auspost.api.postcode.search.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * A single post code locality
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Locality {

    @XmlElement
    private String category;

    @XmlElement
    private Integer id;

    @XmlElement
    private String location;

    @XmlElement
    private Integer postcode;

    @XmlElement
    private AustralianState state;

    @XmlElement
    private Float latitude;

    @XmlElement
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

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
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
