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
import java.util.List;

/**
 * IIIF Presentation API Manifest.
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/manifest</p>
 *
 * <ul>
 * <li>Each manifest must, and is very likely to, have one sequence, but may have more than one.</li>
 * <li>A manifest, sequence or canvas must not have a format.</li>
 * <li>A manifest or sequence must not have a height.</li>
 * <li>A manifest or sequence must not have a width.</li>
 * </ul>
 *
 * @author Ralf Eichinger
 * @see http://iiif.io/api/presentation/2.0/#manifest
 */
public class Manifest extends AbstractIiifResource {

    private final String context = "http://iiif.io/api/presentation/2/context.json";
    private String description; // recommended
    private final String id; // required
    private final String label; // required
    private List<Metadata> metadata; // recommended
    private String related; // optional
    private String seeAlso; // optional
    private List<Sequence> sequences;
    private Service service; // optional
    private String thumbnail; // recommended
    private String viewingDirection; // optional
    private String viewingHint; // optional
    private String within; // optional

    public Manifest(String id, String label) {
        assert id != null;
        assert label != null;

        this.id = id;
        this.label = label;
        
        this.type = "sc:Manifest";
    }

    /**
     *
     * @param id The URI that identifies the resource. It is recommended that an HTTP URI be used for all resources.
     * Recommended HTTP URI patterns for the different classes of resource are given below. URIs from any registered
     * scheme may be used, and implementers may find it convenient to use a UUID URN of the form:
     * "urn:uuid:uuid-goes-here-1234". Resources that do not require URIs may be assigned blank node identifiers; this
     * is the same as omitting @id. A manifest must have an id, and it must be the http(s) URI at which the manifest is
     * published.
     * @param label A human readable label, name or title for the resource. This property is intended to be displayed as
     * a short, textual surrogate for the resource if a human needs to make a distinction between it and similar
     * resources, for example between pages or between a choice of images to display. A manifest must have a label, and
     * it should be the name of the object or title of the intellectual work that it embodies.
     * @param description A longer-form prose description of the object or resource that the property is attached to,
     * intended to be conveyed to the user as a full text description, rather than a simple label and value. It may be
     * in simple HTML or plain text. It can duplicate any of the information from the metadata fields, along with
     * additional information required to understand what is being displayed. Clients should have a way to display the
     * descriptions of manifests and canvases, and may have a way to view the information about other resources. A
     * manifest should have a description that describes the object or work.
     * @param metadata A list of short descriptive entries, given as pairs of human readable label and value to be
     * displayed to the user. The value should be either simple HTML, including links and text markup, or plain text,
     * and the label should be plain text. There are no semantics conveyed by this information, and clients should not
     * use it for discovery or other purposes. This list of descriptive pairs should be able to be displayed in a
     * tabular form in the user interface. Clients should have a way to display the information about manifests and
     * canvases, and may have a way to view the information about other resources. The client should display the pairs
     * in the order provided by the description. A pair might be used to convey the author of the work, information
     * about its creation, a brief physical description, or ownership information, amongst other use cases. The client
     * is not expected to take any action on this information beyond displaying the label and value. An example pair of
     * label and value might be a label of “Author” and a value of "Jehan Froissart". A manifest should have metadata
     * pairs associated with it describing the object or work.
     * @param thumbnail A small image that depicts or pictorially represents the resource that the property is attached
     * to, such as the title page, a significant image or rendering of a canvas with multiple content resources
     * associated with it. It is recommended that a IIIF Image API service be available for this image for manipulations
     * such as resizing. A manifest should have a thumbnail image that represents the entire object or work.
     */
    public Manifest(String id, String label, String description, List<Metadata> metadata, String thumbnail) {
        this(id, label);

        this.description = description;
        this.metadata = metadata;
        this.thumbnail = thumbnail;
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

    public List<Metadata> getMetadata() {
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

    public String getViewingDirection() {
        return viewingDirection;
    }

    /**
     * @see ViewingDirections
     * @param viewingDirection The direction that canvases of the resource should be presented when rendered for the
     * user to navigate and/or read. A manifest may have a viewing direction, and if so, it applies to all of its
     * sequences unless the sequence specifies its own viewing direction.
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
