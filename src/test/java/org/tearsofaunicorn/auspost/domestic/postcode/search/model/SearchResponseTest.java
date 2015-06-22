package org.tearsofaunicorn.auspost.domestic.postcode.search.model;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.Scanner;

public class SearchResponseTest {

    @Test
    public void testParseXml() throws Exception {
        String xml = new Scanner(this.getClass().getResourceAsStream("/example.xml"), "UTF-8").useDelimiter("\\A").next();

        JAXBContext jaxbContext = JAXBContext.newInstance(SearchResponse.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SearchResponse searchResponse = (SearchResponse) unmarshaller.unmarshal(new StringReader(xml));

        Assert.assertNotNull(searchResponse);

        Assert.assertNotNull(searchResponse.getLocalities());
        Assert.assertEquals(1, searchResponse.getLocalities().size());

        Locality locality = searchResponse.getLocalities().get(0);
        Assert.assertNotNull(locality.getCategory());
        Assert.assertNotNull(locality.getPostcode());
        Assert.assertNotNull(locality.getState());
        Assert.assertNotNull(locality.getLocation());
        Assert.assertNotNull(locality.getLatitude());
        Assert.assertNotNull(locality.getLongitude());
    }
}