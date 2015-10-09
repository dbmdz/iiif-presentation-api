# iiif-presentation-api
Java library implementing the IIIF Presentation API and providing Manifest generation.

## Usage

### Use embedded in your Java code
1. Create your IIIF-Manifest by using IIF-Resources like Manifest, Sequence, Canvas, Image, ImageResource, etc.
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
    $ mvn deploy:deploy-file -DgroupId=com.datazuul -DartifactId=iiif-presentation-api -Dversion=2.0.0-SNAPSHOT -Dpackaging=jar -Dfile=./iiif-presentation-api-2.0.0-SNAPSHOT.jar -DrepositoryId=mdzrepo-snapshot -Durl=[url to your local snapshot repository]