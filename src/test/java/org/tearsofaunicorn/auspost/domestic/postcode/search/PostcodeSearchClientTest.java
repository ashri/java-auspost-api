package org.tearsofaunicorn.auspost.domestic.postcode.search;

import org.junit.Assert;
import org.junit.Test;
import org.tearsofaunicorn.auspost.domestic.postcode.search.model.SearchResponse;

public class PostcodeSearchClientTest {

    @Test
    public void testQuery() {
        String q = "6011";
        String state = "WA";
        SearchResponse response = new PostcodeSearchClient("123456").prepareSearch(q).setState(state).excludePostBoxes(true).executeGet();
        Assert.fail("Implement test");
    }

    @Test
    public void testWithState() {
        Assert.fail("Implement test");
    }

    @Test
    public void testWithExcludePostBoxes() {
        Assert.fail("Implement test");
    }

}