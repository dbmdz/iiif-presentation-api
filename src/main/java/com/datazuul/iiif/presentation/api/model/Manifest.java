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
package com.datazuul.iiif.presentation.api.model;

import java.util.List;

/**
 * IIIF Presentation API Manifest.
 * Recommended URI pattern: {scheme}://{host}/{prefix}/{identifier}/manifest
 * @author Ralf Eichinger
 * @see http://iiif.io/api/presentation/2.0/#manifest
 */
public class Manifest {
    private String attribution;
    private final String context = "http://iiif.io/api/presentation/2/context.json";
    private String description;
    private String id; // required
    private String label;
    private String license;
    private final String type = "sc:Manifest"; // required
    private String within;
    private List<Sequence> sequences;

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getWithin() {
        return within;
    }

    public void setWithin(String within) {
        this.within = within;
    }

    public List<Sequence> getSequences() {
        return sequences;
    }

    public void setSequences(List<Sequence> sequences) {
        this.sequences = sequences;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public String getContext() {
        return context;
    }

    public String getType() {
        return type;
    }
}
