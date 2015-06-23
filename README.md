Java Client for the Australia Post Postcode Search API
==================

A Java library providing a client for the [Australia Post][auspost]
[APIs][apis]. At this stage only the [Postcode Search][explorer] service is
implemented.

## Basic Usage

```java
   PostcodeSearchClient client = new PostcodeSearchClient(apiKey);
   SearchResponse response = client.prepareSearch(q).executeGet();
```

The Client requires an API key, [which Australia Post provides][apiKey], in order to
successfully make requests. The API key must be configured as a System
property (`-D`) under the name `AusPostApiKey`.

More examples using the library can be seen in the unit tests.


## Building the Java Australia Post API client

A Maven POM is provided with the library. The Java8 SDK is required to build
and use the library.

To build and install the library:

```shell
  mvn install
```

By default, the `PostcodeSearchClientTest` which actually executes against the
remote API is `@Ignored` and an [API key is required][apiKey] to run the tests.

## Using the library in your project

The release versions of the library are deployed to Github which means you will
need to add a repository to your Maven POM:

```xml
  <repositories>
    <repository>
      <id>auspost-mvn-repo</id>
      <url>https://raw.github.com/ashri/auspost-api/mvn-repo/</url>
      <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
      </snapshots>
    </repository>
  </repositories>
```

You can then reference the library as a dependency using the following:

```xml
  <dependencies>
    <dependency>
      <groupId>com.threeheadedmonkey.auspost</groupId>
      <artifactId>auspost-postcode-search</artifactId>
      <version>1.0.0</version>
    </dependency>
  </dependencies>
```

## Copyright

Copyright (c) 2015 Ashley Richardson. See [LICENSE][] for details.

[auspost]: https://www.auspost.com.au
[apis]: https://developers.auspost.com.au/apis
[explorer]: https://developers.auspost.com.au/apis/pac/explorer/postcode-search
[apiKey]: https://developers.auspost.com.au/apis/pacpcs-registration
[license]: https://github.com/ashri/auspost-api/blob/master/LICENSE.md
