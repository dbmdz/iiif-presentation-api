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

import com.datazuul.iiif.presentation.api.model.other.Metadata;
import com.datazuul.iiif.presentation.api.model.other.Thumbnail;

import java.net.URI;
import java.util.List;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/range/{name}</p>
 *
 * @author Ralf Eichinger
 */
public class Range extends AbstractIiifResource {

    private String description; // optional
    private final String label; // required
    private List<Metadata> metadata; // optional
    private String startCanvas; // optional
    private Thumbnail thumbnail; // optional
    private String viewingDirection; // optional
    private String viewingHint; // optional

    public Range(URI id, String label) {
        assert id != null;
        assert label != null;

        this.id = id;
        this.label = label;

        type = "sc:Range";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public List<Metadata> getMetadata() {
        return metadata;
    }

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

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getViewingDirection() {
        return viewingDirection;
    }

    /**
     * @see ViewingDirections
     * @param viewingDirection The direction that canvases of the resource should be presented when rendered for the
     * user to navigate and/or read. A range or layer may have a viewing direction.
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
}
