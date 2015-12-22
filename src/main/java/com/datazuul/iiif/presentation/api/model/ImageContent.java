/*
 * Copyright 2015 Ralf Eichinger
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
package com.datazuul.iiif.presentation.api.model;

import java.net.URI;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/annotation/{name}
 * </p>
 *
 * @author Ralf Eichinger
 */
public class ImageContent extends Content {

    private String label; // optional

    public ImageContent(URI id) {
        super(id);
        this.type = "oa:Annotation"; // required
    }

    public String getLabel() {
        return label;
    }

    /**
     * @param label A content resource may have a label, and if there is a choice of content resource for the same
     * canvas, then they must have labels. The label should be a brief description of the resource, such as “black and
     * white” versus “color photograph”.
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
