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
import com.datazuul.iiif.presentation.api.model.other.Service;
import com.datazuul.iiif.presentation.api.model.other.ViewingDirections;
import java.util.List;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/sequence/{name}</p>
 *
 * <ul>
 * <li>Each sequence must have at least one canvas and is likely to have more than one.</li>
 * <li>A manifest, sequence or canvas must not have a format.</li>
 * <li>A manifest or sequence must not have a height.</li>
 * <li>A manifest or sequence must not have a width.</li>
 * </ul>
 *
 * @author Ralf Eichinger
 */
public class Sequence extends AbstractIiifResource {

    private List<Canvas> canvases;
    private String description; // optional
    private String id; // optional
    private String label; // optional
    private List<Metadata> metadata; // optional
    private String related; // optional
    private String seeAlso; // optional
    private Service service; // optional
    private String startCanvas; // optional
    private String thumbnail; // optional
    private String viewingDirection = ViewingDirections.LTR; // optional
    private String viewingHint = "paged"; // optional
    private String within; // optional

    public Sequence() {
        type = "sc:Sequence";
    }

    /**
     * @param label A sequence may have a label, and if there are multiple sequences in a single manifest then they must
     * have labels. The label should briefly convey the nature of sequence, such as “Current Page Order”.
     */
    public Sequence(String label) {
        this();
        assert label != null;
        this.label = label;
    }

    public List<Canvas> getCanvases() {
        return canvases;
    }

    public void setCanvases(List<Canvas> canvases) {
        this.canvases = canvases;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @param description A sequence may have a description to further explain how it differs from other sequences.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    /**
     * @param id A sequence may have an id.
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Metadata> getMetadata() {
        return metadata;
    }

    /**
     * @param metadata A sequence may have metadata pairs associated with it to describe the difference between it and
     * other sequences.
     */
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

    public String getStartCanvas() {
        return startCanvas;
    }

    public void setStartCanvas(String startCanvas) {
        this.startCanvas = startCanvas;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail A sequence may have a thumbnail and should have a thumbnail if there are multiple sequences in a
     * single manifest. Each of the thumbnails should be different.
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getViewingDirection() {
        return viewingDirection;
    }

    /**
     * @see ViewingDirections
     * @param viewingDirection The direction that canvases of the resource should be presented when rendered for the
     * user to navigate and/or read. A sequence may have a viewing direction, and it MAY be different to that of the
     * manifest.
     */
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
