IIIF Presentation API Library
=============================
[![Build Status](https://travis-ci.org/dbmdz/iiif-presentation-api.svg?branch=next)](https://travis-ci.org/dbmdz/iiif-presentation-api)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![GitHub release](https://img.shields.io/github/release/dbmdz/iiif-presentation-api.svg?maxAge=2592000)](https://github.com/dbmdz/iiif-presentation-api/releases)


Java library implementing the IIIF Presentation API 2.0 and providing Manifest generation (see <a href="http://iiif.io/api/presentation/2.0/">http://iiif.io/api/presentation/2.0/</a>):

"The IIIF Presentation API specifies a web service that returns JSON-LD structured documents that together describe the structure and layout of a digitized object or other collection of images and related content. Many different styles of viewer can be implemented that consume the information to enable a rich and dynamic user experience, consuming content from across collections and hosting institutions."

Usage
-----

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
