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
import com.datazuul.iiif.presentation.api.model.other.Thumbnail;
import com.datazuul.iiif.presentation.api.model.other.ViewingDirection;
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
    private String label; // optional
    private List<Metadata> metadata; // optional
    private String startCanvas; // optional
    private Thumbnail thumbnail; // optional
    private String viewingDirection; // optional
    private String viewingHint; // optional

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

    /**
     * Convenience constructor (as id is optional)
     * @param id unique id of resource
     * @param label The label should briefly convey the nature of sequence, such as “Current Page Order”.
     */
    public Sequence(String id, String label) {
        this(label);
        this.id = id;
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

    /**
     * @param id A sequence may have an id.
     */
    @Override
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

    public String getStartCanvas() {
        return startCanvas;
    }

    /**
     * @param startCanvas A link from a sequence or range to a canvas that is contained within the sequence. On seeing
     * this relationship, a client should advance to the specified canvas when beginning navigation through the
     * sequence/range. This allows the client to begin with the first canvas that contains interesting content rather
     * than requiring the user to skip past blank or empty canvases manually. A sequence or a range may have this
     * relationship, and the target must be a canvas.
     */
    public void setStartCanvas(String startCanvas) {
        this.startCanvas = startCanvas;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail A sequence may have a thumbnail and should have a thumbnail if there are multiple sequences in a
     * single manifest. Each of the thumbnails should be different.
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getViewingDirection() {
        return viewingDirection;
    }

    /**
     * @see ViewingDirection
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

    /**
     * @param viewingHint A manifest, sequence or range may have a viewing hint, with scope as per viewingDirection.
     */
    public void setViewingHint(String viewingHint) {
        this.viewingHint = viewingHint;
    }
}
