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
 * </ul>
 *
 * @author Ralf Eichinger
 * @see http://iiif.io/api/presentation/2.0/#manifest
 */
public class Manifest {

    /**
     * A human readable label that must be displayed when the resource it is associated with is displayed or used. For
     * example, this could be used to present copyright or ownership statements, or simply an acknowledgement of the
     * owning and/or publishing institutions.
     */
    private String attribution; // optional
    private final String context = "http://iiif.io/api/presentation/2/context.json";
    private String description; // recommended
    private final String id; // required
    private final String label; // required
    /**
     * A link to an external resource that describes the license or rights statement under which the resource is being
     * used. The rationale for this being a URI and not a human readable label is that typically there is one license
     * for many resources, and the text is too long to be displayed to the user along with the object. If displaying the
     * text is a requirement, then it is recommended to include the information using the attribution property instead.
     */
    private String license; // optional
    /**
     * A small image that represents an individual or organization associated with the resource it is attached to. This
     * could be the logo of the owning or hosting institution. It is recommended that a IIIF Image API service be
     * available for this image for manipulations such as resizing.
     */
    private String logo; // optional
    private List<Metadata> metadata; // recommended
    private String related; // optional
    private String seeAlso; // optional
    private List<Sequence> sequences;
    private Service service; // optional
    private String thumbnail; // recommended
    private final String type = "sc:Manifest"; // required
    private String viewingDirection; // optional
    private String viewingHint; // optional
    private String within; // optional

    public Manifest(String id, String label) {
        assert id != null;
        assert label != null;

        this.id = id;
        this.label = label;
    }

    /**
     *
     * @param id
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
