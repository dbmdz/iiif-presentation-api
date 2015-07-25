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

/**
 *
 * @author Ralf Eichinger
 */
public abstract class AbstractIiifResource {

    protected String attribution; // optional
    protected String license; // optional
    protected String logo; // optional
    protected String type; // required
    protected String related; // optional
    protected Service service; // optional
    protected String seeAlso; // optional
    protected String within; // optional
    protected String id; // optional

    public String getAttribution() {
        return attribution;
    }

    public String getLicense() {
        return license;
    }

    public String getLogo() {
        return logo;
    }

    /**
     * @param attribution A human readable label that must be displayed when the resource it is associated with is
     * displayed or used. For example, this could be used to present copyright or ownership statements, or simply an
     * acknowledgement of the owning and/or publishing institutions. Any resource may have an attribution label.
     */
    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    /**
     * @param license A link to an external resource that describes the license or rights statement under which the
     * resource is being used. The rationale for this being a URI and not a human readable label is that typically there
     * is one license for many resources, and the text is too long to be displayed to the user along with the object. If
     * displaying the text is a requirement, then it is recommended to include the information using the attribution
     * property instead. Any resource may have a license associated with it.
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * @param logo A small image that represents an individual or organization associated with the resource it is
     * attached to. This could be the logo of the owning or hosting institution. It is recommended that a IIIF Image API
     * service be available for this image for manipulations such as resizing. Any resource may have a logo associated
     * with it.
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return The type of the resource. For the resource types defined by this specification, the value of @type will
     * be described in the sections below. For content resources, the type may be drawn from other vocabularies.
     * Recommendations for basic types such as image, text or audio are also given in the sections below.
     */
    public String getType() {
        return type;
    }

    public String getRelated() {
        return related;
    }

    /**
     * @param related A link to an external resource intended to be displayed directly to the user, and is related to
     * the resource that has the related property. Examples might include a video or academic paper about the resource,
     * a website, an HTML description, and so forth. A label and the format of the related resource should be given to
     * assist clients in rendering the resource to the user. Any resource may have an external resource related to it.
     */
    public void setRelated(String related) {
        this.related = related;
    }

    public Service getService() {
        return service;
    }

    /**
     * @param service A link to a service that makes more functionality available for the resource, such as from an
     * image to the base URI of an associated IIIF Image API service. The service resource should have additional
     * information associated with it in order to allow the client to determine how to make appropriate use of it, such
     * as a profile link to a service description. It may also have relevant information copied from the service itself.
     * This duplication is permitted in order to increase the performance of rendering the object without necessitating
     * additional HTTP requests. Any resource may have a link to an external service.
     */
    public void setService(Service service) {
        this.service = service;
    }

    public String getSeeAlso() {
        return seeAlso;
    }

    /**
     * @param seeAlso A link to a machine readable document that semantically describes the resource with the seeAlso
     * property, such as an XML or RDF description. This document could be used for search and discovery or inferencing
     * purposes, or just to provide a longer description of the resource. The profile and format properties of the
     * document should be given to help the client to make appropriate use of the document. Any resource may have an
     * external description related to it.
     */
    public void setSeeAlso(String seeAlso) {
        this.seeAlso = seeAlso;
    }

    public String getWithin() {
        return within;
    }

    /**
     * @param within A link to a resource that contains the current resource, such as annotation lists within a layer.
     * This also allows linking upwards to collections that allow browsing of the digitized objects available. Any
     * resource may be within a containing resource.
     */
    public void setWithin(String within) {
        this.within = within;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
