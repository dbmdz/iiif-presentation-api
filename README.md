# IIIF Presentation API Java Libraries

[![Build Status](https://travis-ci.org/dbmdz/iiif-presentation-api.svg?branch=next)](https://travis-ci.org/dbmdz/iiif-presentation-api)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![GitHub release](https://img.shields.io/github/release/dbmdz/iiif-presentation-api.svg?maxAge=2592000)](https://github.com/dbmdz/iiif-presentation-api/releases)


These Java libraries implement the IIIF Presentation API 2.0.0 and provide Manifest generation (see <a href="http://iiif.io/api/presentation/2.0/">http://iiif.io/api/presentation/2.0/</a>):

"The IIIF Presentation API specifies a web service that returns JSON-LD structured documents that together describe the structure and layout of a digitized object or other collection of images and related content. Many different styles of viewer can be implemented that consume the information to enable a rich and dynamic user experience, consuming content from across collections and hosting institutions."

## Usage

### Use embedded in your Java code

1. Create your IIIF-Manifest by using IIIF-Resources like Manifest, Sequence, Canvas, Image, ImageResource, etc.
(see classes in package com.datazuul.iiif.presentation.api.model).

        Manifest myManifest = new Manifest(myId, myLabel);
        ...

2. Generate JSON-representation of your Manifest by calling

        ManifestGenerator mg = new ManifestGenerator();
        String json = mg.generateJson(myManifest);

Additionally a command line tool (ManifestGenerator) is provided, which generates
a manifest by reading all images (of a book) in a directory.

Contributions are welcome!

### Use as Maven dependency

Checkout and build it (mvn clean install)

or

Deploy to your local Maven repository server

    $ cd target
    $ mvn deploy:deploy-file -DgroupId=de.digitalcollections -DartifactId=iiif-presentation-model-api -Dversion=2.0.0-SNAPSHOT -Dpackaging=jar -Dfile=./iiif-presentation-model-api-2.0.0-SNAPSHOT.jar -DrepositoryId=mdzrepo-snapshot -Durl=[url to your local snapshot repository]

# FAQ
<b>Q</b>: The JSON output for IIIF Presentation API is not correct.<br/>
<b>A</b>: Be sure that Jackson object mapping is configured correctly. The SpringConfigIIIF overrides the method "configureMessageConverters(...)" and configures the MappingJackson2HttpMessageConverter's ObjectMapper properly. But if you override the method in your Spring MVC configuration class, the SpringConfigIIIF message converters configuration is ignored (the root beans rules...).<br/>
Solution: Add proper ObjectMapper configuration to your config. For IIIF this is needed:

        @Bean
        public ObjectMapper objectMapper() {
          ObjectMapper objectMapper = new ObjectMapper();
          // do not serialize null values/objects
          objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

          // IIIF Presentation API objects:
          objectMapper.addMixIn(AbstractIiifResource.class, AbstractIiifResourceMixIn.class);
          objectMapper.addMixIn(Image.class, AbstractIiifResourceMixIn.class);
          objectMapper.addMixIn(Manifest.class, ManifestMixIn.class);
          objectMapper.addMixIn(MetadataLocalizedValue.class, MetadataLocalizedValueMixIn.class);
          objectMapper.addMixIn(Resource.class, AbstractIiifResourceMixIn.class);
          objectMapper.addMixIn(Service.class, ServiceMixIn.class);

          return objectMapper;
        }
