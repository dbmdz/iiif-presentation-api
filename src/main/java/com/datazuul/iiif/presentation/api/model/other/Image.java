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
package com.datazuul.iiif.presentation.api.model.other;

import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Ralf Eichinger
 */
public class Image {

    private URI id;
    private final String motivation = "sc:painting";
    private final String type = "oa:Annotation";
    private URI on;

    private ImageResource resource;

    public Image() {
    }

    public Image(URI id) {
        this.id = id;
    }

    public Image(String id) throws URISyntaxException {
        this.id = new URI(id);
    }

    public URI getId() {
        return id;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(ImageResource resource) {
        this.resource = resource;
    }

    public String getMotivation() {
        return motivation;
    }

    public String getType() {
        return type;
    }

    public URI getOn() {
        return on;
    }

    public void setOn(URI on) {
        this.on = on;
    }

}
