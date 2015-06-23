package au.com.auspost.api.postcode.search;

import au.com.auspost.api.postcode.search.model.AustralianState;
import au.com.auspost.api.postcode.search.model.Locality;
import au.com.auspost.api.postcode.search.model.SearchResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@Ignore
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

        Assert.assertTrue(localities.stream().anyMatch(l -> l.getLocation().equals("COTTESLOE")));
        Assert.assertTrue(localities.stream().anyMatch(l -> l.getLocation().equals("PEPPERMINT GROVE")));
    }

    @Test
    public void testWithoutState() throws Exception {
        String q = "Armadale";

        SearchResponse response = client.prepareSearch(q)
                .executeGet();

        Assert.assertNotNull(response);
        List<Locality> localities = response.getLocalities();
        Assert.assertNotNull(localities);
        Assert.assertThat(localities.size(), equalTo(4));

        Assert.assertTrue(localities.stream().anyMatch(l -> l.getState() == AustralianState.VIC));
        Assert.assertTrue(localities.stream().anyMatch(l -> l.getState() == AustralianState.WA));
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