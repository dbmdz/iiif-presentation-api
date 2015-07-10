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

import com.datazuul.iiif.presentation.api.model.other.Image;
import com.datazuul.iiif.presentation.api.model.other.Metadata;
import com.datazuul.iiif.presentation.api.model.other.Service;
import java.util.List;

/**
 * <p>
 * The canvas represents an individual page or view and acts as a central point for laying out the different content
 * resources that make up the display. As with sequences, the name should not begin with a number. Suggested patterns
 * are “f1r” or “p1”.</p>
 *
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/canvas/{name}</p>
 *
 * <ul>
 * <li>Each canvas should have one or more content resources associated with it. Zero is possible but unlikely; it
 * represents the case where the page exists (or existed) but has not been digitized.</li>
 * </ul>
 *
 * @author Ralf Eichinger
 */
public class Canvas {

    private String attribution; // optional
    private String description; // optional
    private final int height; // required
    private final String id; // required
    private List<Image> images;
    private final String label; // required
    private String license; // optional
    private String logo; // optional
    private List<Metadata> metadata; // optional
    private String related; // optional
    private String seeAlso; // optional
    private Service service; // optional
    private final String thumbnail; // recommended
    private final String type = "sc:Canvas"; // required
    private String viewingHint; // optional
    private final int width; // required
    private String within; // optional

    /**
     *
     * @param id
     * @param label A canvas must have a label, and it should be the page or view label such as “p. 1”, “front”, or
     * “north view”.
     * @param height
     * @param width
     * @param thumbnail
     */
    public Canvas(String id, String label, int height, int width, String thumbnail) {
        assert id != null;
        assert label != null;
        assert height > -1;
        assert width > -1;

        this.id = id;
        this.height = height;
        this.label = label;
        this.width = width;

        this.thumbnail = thumbnail;
    }

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

    public int getHeight() {
        return height;
    }

    public String getId() {
        return id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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

    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
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

    public String getViewingHint() {
        return viewingHint;
    }

    public void setViewingHint(String viewingHint) {
        this.viewingHint = viewingHint;
    }

    public int getWidth() {
        return width;
    }

    public String getWithin() {
        return within;
    }

    public void setWithin(String within) {
        this.within = within;
    }

}
