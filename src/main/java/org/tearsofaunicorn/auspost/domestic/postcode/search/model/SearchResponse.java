package org.tearsofaunicorn.auspost.domestic.postcode.search.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * The postcode search response containing the matching localities
 */
@XmlRootElement(name = "localities")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResponse {

    @XmlElement(name = "locality")
    private List<Locality> localities = new ArrayList<>();

    public List<Locality> getLocalities() {
        return localities;
    }

    public void setLocalities(List<Locality> localities) {
        this.localities = localities;
    }
}
