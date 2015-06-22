package org.tearsofaunicorn.auspost.domestic.postcode.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tearsofaunicorn.auspost.domestic.postcode.search.model.AustralianState;
import org.tearsofaunicorn.auspost.domestic.postcode.search.model.Locality;
import org.tearsofaunicorn.auspost.domestic.postcode.search.model.SearchResponse;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostcodeSearchClientTest {

    private PostcodeSearchClient client;

    @Before
    public void setup() {
        String apiKey = System.getProperty("AusPostApiKey");
        Assert.assertNotNull(apiKey);

        this.client = new PostcodeSearchClient(apiKey);
    }

    @Test
    public void testQuery() throws Exception {
        String q = "6011";
        AustralianState state = AustralianState.WA;

        SearchResponse response = client.prepareSearch(q)
                .setState(state)
                .excludePostBoxes(true)
                .executeGet();

        Assert.assertNotNull(response);
        List<Locality> localities = response.getLocalities();
        Assert.assertNotNull(localities);
        Assert.assertThat(localities.size(), equalTo(2));

        Locality locality = localities.get(0);
        Assert.assertThat(locality.getCategory(), equalTo("COTTESLOE"));

        locality = localities.get(1);
        Assert.assertThat(locality.getCategory(), equalTo("PEPPERMINT GROVE"));
    }

    @Test
    public void testWithoutState() throws Exception {
        String q = "Armadale";

        SearchResponse response = client.prepareSearch(q)
                .excludePostBoxes(true)
                .executeGet();

        Assert.assertNotNull(response);
        List<Locality> localities = response.getLocalities();
        Assert.assertNotNull(localities);
        Assert.assertThat(localities.size(), equalTo(2));

        Stream<Locality> stream = localities.stream();

        Assert.assertTrue(stream.anyMatch(l -> l.getState() == AustralianState.VIC));
        Assert.assertTrue(stream.anyMatch(l -> l.getState() == AustralianState.WA));
    }

    @Test
    public void testExcludePostBoxes() throws Exception {
        String q = "Claremont";

        SearchResponse response = client.prepareSearch(q)
                .executeGet();

        Assert.assertNotNull(response);
        List<Locality> localities = response.getLocalities();
        int withPoBoxesCount = localities.size();

        response = client.prepareSearch(q)
                .excludePostBoxes(true)
                .executeGet();

        Assert.assertNotNull(response);
        localities = response.getLocalities();
        int excludePoBoxesCount = localities.size();

        Assert.assertNotEquals(withPoBoxesCount, excludePoBoxesCount);
    }

}