package au.com.auspost.api.postcode.search.model;

import org.junit.Assert;
import org.junit.Test;

public class SearchRequestTest {

    @Test
    public void testQuery() throws Exception {
        String request = new SearchRequest("apiKey", "http://test.com").query("query").buildUrl();
        Assert.assertTrue(request.contains("q=query"));
    }

    @Test
    public void testSetState() throws Exception {
        String request = new SearchRequest("apiKey", "http://test.com").setState(AustralianState.WA).buildUrl();
        Assert.assertTrue(request.contains("state=WA"));
    }

    @Test
    public void testExcludePostBoxes() throws Exception {
        String request = new SearchRequest("apiKey", "http://test.com").excludePostBoxes(true).buildUrl();
        Assert.assertTrue(request.contains("excludePostBoxFlag=true"));
    }

}