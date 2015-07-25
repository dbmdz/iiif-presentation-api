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
 * <li>A manifest, sequence or canvas must not have a format.</li>
 * <li>A canvas or content resource must not have a viewing direction.</li>
 * </ul>
 *
 * @author Ralf Eichinger
 */
public class Canvas extends AbstractIiifResource {

    private String description; // optional
    private final int height; // required
    private List<Image> images;
    private final String label; // required
    private List<Metadata> metadata; // optional
    private String thumbnail; // recommended
    private String viewingHint; // optional
    private final int width; // required

    public Canvas(String id, String label, int height, int width) {
        assert id != null;
        assert label != null;
        assert height > -1;
        assert width > -1;

        this.id = id;
        this.height = height;
        this.label = label;
        this.width = width;

        type = "sc:Canvas";
    }

    /**
     * @param id A canvas must have an id, and it must be an http(s) URI. The canvas’s JSON representation should be
     * published at that URI.
     * @param label A canvas must have a label, and it should be the page or view label such as “p. 1”, “front”, or
     * “north view”.
     * @param height The height of a canvas or image resource. For images, this is in pixels. No particular units are
     * required for canvases, as the dimensions provide an aspect ratio for the resources to be located within rather
     * than measuring any physical property of the object. A canvas must have a height, which does not have a unit type.
     * It merely conveys, along with width, an aspect ratio.
     * @param width The width of a canvas or image resource. For images, this is in pixels. No particular units are
     * required for canvases. A canvas must have a height, which does not have a unit type. It merely conveys, along
     * with width, an aspect ratio.
     * @param thumbnail A canvas may have a thumbnail and should have a thumbnail if there are multiple images or
     * resources that make up the representation.
     */
    public Canvas(String id, String label, int height, int width, String thumbnail) {
        this(id, label, height, width);
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @param description A canvas may have a description to describe particular features of the view.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public int getHeight() {
        return height;
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

    public List<Metadata> getMetadata() {
        return metadata;
    }

    /**
     * @param metadata A canvas may have metadata pairs associated with it to describe its particular features.
     */
    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail A canvas may have a thumbnail and should have a thumbnail if there are multiple images or
     * resources that make up the representation.
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getViewingHint() {
        return viewingHint;
    }

    /**
     * @param viewingHint A manifest, sequence or range may have a viewing hint, with scope as per viewingDirection. A
     * canvas may have a viewing hint, and the only hint defined by this specification for canvases is “non-paged”.
     * “non-paged” is only valid if the canvas is within a manifest, sequence or range that is “paged”, and the
     * particular canvas must not be displayed in a page-turning viewer.
     */
    public void setViewingHint(String viewingHint) {
        this.viewingHint = viewingHint;
    }

    public int getWidth() {
        return width;
    }
}
