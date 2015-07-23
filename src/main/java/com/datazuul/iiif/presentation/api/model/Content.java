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

import com.datazuul.iiif.presentation.api.model.other.Metadata;
import java.util.List;

/**
 * <p>
 * Content resources such as images or texts that are associated with a canvas.</p>
 *
 * <ul>
 * <li>A canvas or content resource must not have a viewing direction.</li>
 * </ul>
 *
 * @author Ralf Eichinger
 */
public class Content extends AbstractIiifResource {

    protected String id; // required
    protected List<Metadata> metadata; // optional
    protected String description; // optional
    protected String thumbnail; // optional
    protected String format; // optional
    protected int height; // optional
    protected int width; // optional

    /**
     * @param id A content resource must have an id unless it is embedded in the response, and it must be the http(s)
     * URI at which the resource is published.
     */
    public Content(String id) {
        assert id != null;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Metadata> getMetadata() {
        return metadata;
    }

    /**
     * @param metadata A content resource may have metadata pairs associated with it.
     */
    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @param description A content resource may have a description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail A content resource may have a thumbnail and should have a thumbnail if it is an option in a
     * choice of resources.
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getFormat() {
        return format;
    }

    /**
     * @param format The specific media type (often called a MIME type) of a content resource, for example “image/jpeg”.
     * This is important for distinguishing text in XML from plain text, for example. A content resource may have a
     * format, and if so, it must be the value of the Content-Type header returned when the resource is dereferenced.
     * N.B. This is different to the formats property in the Image API, which gives the extension to use within that
     * API. It would be inappropriate to use in this case, as format can be used with any content resource, not just
     * images.
     */
    public void setFormat(String format) {
        this.format = format;
    }

    public int getHeight() {
        return height;
    }

    /**
     * @param height The height of a canvas or image resource. For images, this is in pixels. No particular units are
     * required for canvases, as the dimensions provide an aspect ratio for the resources to be located within rather
     * than measuring any physical property of the object. Content resources may have a height, given in pixels, if
     * appropriate.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    /**
     * @param width The width of a canvas or image resource. For images, this is in pixels. No particular units are
     * required for canvases. Content resources may have a height, given in pixels, if appropriate.
     */
    public void setWidth(int width) {
        this.width = width;
    }
}
