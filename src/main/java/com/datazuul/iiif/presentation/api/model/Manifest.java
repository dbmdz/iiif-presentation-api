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

import com.datazuul.iiif.presentation.api.model.other.Service;
import java.util.List;

/**
 * IIIF Presentation API Manifest.
 * Recommended URI pattern: {scheme}://{host}/{prefix}/{identifier}/manifest
 * @author Ralf Eichinger
 * @see http://iiif.io/api/presentation/2.0/#manifest
 */
public class Manifest {
    private String attribution; // optional
    private final String context = "http://iiif.io/api/presentation/2/context.json";
    private final String description; // recommended
    private final String id; // required
    private final String label; // required
    private String license; // optional
    private String logo; // optional
    private final String metadata; // recommended
    private String related; // optional
    private String seeAlso; // optional
    private List<Sequence> sequences;
    private Service service; // optional
    private final String thumbnail; // recommended
    private final String type = "sc:Manifest"; // required
    private String viewingDirection; // optional
    private String viewingHint; // optional
    private String within; // optional

    public Manifest(String id, String label, String description, String metadata, String thumbnail) {
        assert id != null;
        assert label != null;
        
        this.id = id;
        this.label = label;
        
        this.description = description;
        this.metadata = metadata;
        this.thumbnail = thumbnail;
    }
    
    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getContext() {
        return context;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMetadata() {
        return metadata;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getSeeAlso() {
        return seeAlso;
    }

    public void setSeeAlso(String seeAlso) {
        this.seeAlso = seeAlso;
    }

    public List<Sequence> getSequences() {
        return sequences;
    }

    public void setSequences(List<Sequence> sequences) {
        this.sequences = sequences;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getType() {
        return type;
    }

    public String getViewingDirection() {
        return viewingDirection;
    }

    public void setViewingDirection(String viewingDirection) {
        this.viewingDirection = viewingDirection;
    }

    public String getViewingHint() {
        return viewingHint;
    }

    public void setViewingHint(String viewingHint) {
        this.viewingHint = viewingHint;
    }

    public String getWithin() {
        return within;
    }

    public void setWithin(String within) {
        this.within = within;
    }
}
