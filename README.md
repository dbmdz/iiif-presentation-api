:warning: **NOTE**: This has been deprecated by https://github.com/dbmdz-iiif-apis :warning:

# IIIF Presentation API Java Libraries

[![Build Status](https://travis-ci.org/dbmdz/iiif-presentation-api.svg?branch=next)](https://travis-ci.org/dbmdz/iiif-presentation-api)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/864f6c728d6f4e6fbddd24e5a517687c)](https://www.codacy.com/app/ralf-eichinger/iiif-presentation-api?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dbmdz/iiif-presentation-api&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/dbmdz/iiif-presentation-api/branch/master/graph/badge.svg)](https://codecov.io/gh/dbmdz/iiif-presentation-api)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![GitHub release](https://img.shields.io/github/release/dbmdz/iiif-presentation-api.svg?maxAge=2592000)](https://github.com/dbmdz/iiif-presentation-api/releases)
[![Maven Central](https://img.shields.io/maven-central/v/de.digitalcollections/iiif-presentation-api.svg?maxAge=2592000)](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22iiif-presentation-api%22)

These Java libraries implement the IIIF Presentation API and provide Manifest generation (see <a href="http://iiif.io/api/presentation/2.0/">http://iiif.io/api/presentation/2.0/</a>):

"The IIIF Presentation API specifies a web service that returns JSON-LD structured documents that together describe the structure and layout of a digitized object or other collection of images and related content. Many different styles of viewer can be implemented that consume the information to enable a rich and dynamic user experience, consuming content from across collections and hosting institutions."

## Features

- IIIF Presentation API 2.0.0 conform
- Embeddable Spring components: Spring MVC Controller, Spring Services, Spring Repository
- Model classes for building typesafe manifest instance
- Access to manifests over project specific Resolver-plugin mechanism.
- Command-line Manifest-Generator example

## Usage

### Maven dependencies

Depending on what library you want use, these are the dependency definitions for all modules:

```xml
<dependency>
  <groupId>de.digitalcollections</groupId>
  <artifactId>iiif-presentation-backend-api</artifactId>
  <version>${version.iiif-presentation}</version>
</dependency>

<dependency>
  <groupId>de.digitalcollections</groupId>
  <artifactId>iiif-presentation-backend-impl</artifactId>
  <version>${version.iiif-presentation}</version>
</dependency>

<dependency>
  <groupId>de.digitalcollections</groupId>
  <artifactId>iiif-presentation-business-api</artifactId>
  <version>${version.iiif-presentation}</version>
</dependency>

<dependency>
  <groupId>de.digitalcollections</groupId>
  <artifactId>iiif-presentation-business-impl</artifactId>
  <version>${version.iiif-presentation}</version>
</dependency>

<dependency>
  <groupId>de.digitalcollections</groupId>
  <artifactId>iiif-presentation-model-api</artifactId>
  <version>${version.iiif-presentation}</version>
</dependency>

<dependency>
  <groupId>de.digitalcollections</groupId>
  <artifactId>iiif-presentation-model-impl</artifactId>
  <version>${version.iiif-presentation}</version>
</dependency>

<dependency>
  <groupId>de.digitalcollections</groupId>
  <artifactId>iiif-presentation-frontend-impl-client-rest</artifactId>
  <version>${version.iiif-presentation}</version>
</dependency>

<dependency>
  <groupId>de.digitalcollections</groupId>
  <artifactId>iiif-presentation-frontend-impl-springmvc</artifactId>
  <version>${version.iiif-presentation}</version>
</dependency>

<dependency>
  <groupId>de.digitalcollections</groupId>
  <artifactId>iiif-presentation-frontend-impl-commandline</artifactId>
  <version>${version.iiif-presentation}</version>
</dependency>
```

### Use embedded in your Java code

#### Create a manifest

Create your IIIF-Manifest by using IIIF-Resources like Manifest, Sequence, Canvas, Image, ImageResource, etc.
(see classes in package de.digitalcollections.iiif.presentation.model.impl.v2).

```java
import de.digitalcollections.iiif.presentation.model.api.v2.Manifest;
import de.digitalcollections.iiif.presentation.model.impl.v2.ManifestImpl;

  Manifest myManifest = new ManifestImpl(myId, myLabel);
  ...
```

#### Generate JSON

Generate JSON-representation of your Manifest by calling

```java
import de.digitalcollections.iiif.presentation.frontend.impl.commandline.v2.ManifestGenerator;

  ManifestGenerator mg = new ManifestGenerator();
  String json = mg.generateJson(myManifest);
  ...
```

#### Automatic manifest generation

Additionally a command line tool (ManifestGenerator) is provided, which generates
a manifest by reading all images (e.g. of a book) in a directory.

#### Embed IIIF-Controller into your Spring MVC application

- For IIIF Presentation API support add Spring MVC-library as dependency to your pom.xml:

```xml
<dependency>
  <groupId>de.digitalcollections</groupId>
  <artifactId>iiif-presentation-frontend-impl-springmvc</artifactId>
  <version>2.0.0</version>
</dependency>
```

- Import library's root configuration class into the Spring configuration of your webapp. Example:

```java
@Configuration
@ComponentScan(basePackages = {
  "de.digitalcollections.iiif.presentation.config"
}) // scans all frontend, business and backend configs of Presentation API
...
public class SpringConfig implements EnvironmentAware {
  ...
}
```

- Start your Spring MVC webapp. You should see mappings for IIIF-Presentation-API-URLs in your log:

```
...
[2016-07-14 10:15:23,662 INFO ] [...] RequestMappingHandlerMapping (main    ) > Mapped "{[/presentation/v2/{identifier}/manifest],methods=[GET],produces=[application/json]}" onto public de.digitalcollections.iiif.presentation.model.api.v2.Manifest de.digitalcollections.iiif.presentation.frontend.impl.springmvc.controller.v2.IIIFPresentationApiController.getManifest(java.lang.String) throws de.digitalcollections.iiif.presentation.frontend.impl.springmvc.exception.NotFoundException
...
```

#### IIIF REST client in your Spring MVC application

In the configuration file `de.digitalcollections.iiif.presentation.config.SpringConfigClientRest-local.properties` (resp. `-DEV` or `-PROD`) set your IIIF server URL:

```
presentation.iiifRepositoryURL=https://localhost/presentation
```

After including the configuration bean `SpringConfigClientRest` in your java config component scan you can autowire the REST client:

```java
public class Test {

  @Autowired
  private IIIFRepository iiif;

  public void fetch(String id) {
    Manifest manifest = iiif.manifest(id);
    // ... do something with manifest
  }

}

```

### Local build

Clone project and build it:

```shell
$ mvn clean install
```

# FAQ
<b>Q</b>: The JSON output for IIIF Presentation API is not correct.<br/>
<b>A</b>: Be sure that Jackson object mapping is configured correctly. The SpringConfigFrontendPresentation overrides the method "configureMessageConverters(...)" and configures the MappingJackson2HttpMessageConverter's ObjectMapper properly. But if you override the method in your Spring MVC configuration class, the SpringConfigFrontendPresentation message converters configuration is ignored (the root configuration rules...).<br/>
Solution: Add proper ObjectMapper configuration to your config. For IIIF this is needed:

```java
import de.digitalcollections.iiif.presentation.model.impl.jackson.v2.IiifPresentationApiObjectMapper;

@Bean
public ObjectMapper objectMapper() {
  ObjectMapper objectMapper = new IiifPresentationApiObjectMapper();
  return objectMapper;
}
```
