/*
 * Copyright 2015 Ralf Eichinger.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datazuul.iiif.presentation.api;

import com.datazuul.iiif.presentation.api.model.Canvas;
import com.datazuul.iiif.presentation.api.model.Manifest;
import com.datazuul.iiif.presentation.api.model.Sequence;
import com.datazuul.iiif.presentation.api.model.other.Image;
import com.datazuul.iiif.presentation.api.model.other.ImageResource;
import com.datazuul.iiif.presentation.api.model.other.Service;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Ralf Eichinger
 */
public class ManifestGeneratorTest {

    public ManifestGeneratorTest() {
    }

    @Test
    public void testGenerateJson() throws JsonProcessingException, URISyntaxException {
        String urlPrefix = "http://localhost:10000/de.alexandria.webapp";
        Manifest manifest = new Manifest(new URI(urlPrefix + "/demo/bookreader/manifest.json"), "Walters MS 168");

        List<Sequence> sequences = new ArrayList<>();
        manifest.setSequences(sequences);

        Sequence seq1 = new Sequence("Current page order");
        seq1.setId(urlPrefix + "/demo/bookreader/normal");
        sequences.add(seq1);

        List<Canvas> canvases = new ArrayList<>();
        seq1.setCanvases(canvases);

        addPage(urlPrefix, canvases);

        ManifestGenerator mg = new ManifestGenerator();
        String json = mg.generateJson(manifest);
        System.out.println(json);
        Assert.assertTrue(json.contains("{"));
    }

    private void addPage(String urlPrefix, List<Canvas> canvases) throws URISyntaxException {
        // add a new page
        Canvas canvas1 = new Canvas(new URI(urlPrefix + "/demo/bookreader/canvas/canvas-1"), "Upper board outside", 2236, 1732);
        canvases.add(canvas1);
        
        List<Image> images = new ArrayList<>();
        canvas1.setImages(images);
        
        Image image1 = new Image("http://dms-data.stanford.edu/data/manifests/Walters/qm670kv1873/imageanno/anno-1");
        image1.setOn(canvas1.getId());
        images.add(image1);
        
        ImageResource imageResource1 = new ImageResource(new URI("http://stacks.stanford.edu/image/qm670kv1873/W168_000001_300"));
        imageResource1.setHeight(2236);
        imageResource1.setWidth(1732);
        image1.setResource(imageResource1);
        
        Service service1 = new Service(urlPrefix + "/demo/bookreader/mechanik1/1.jpg?");
        service1.setContext("http://iiif.io/api/image/2/context.json");
        service1.setProfile("http://iiif.io/api/image/2/level1.json");
        imageResource1.setService(service1);
    }

}
