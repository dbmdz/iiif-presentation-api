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
 * IIIF Presentation API Manifest.
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/manifest</p>
 *
 * <ul>
 * <li>Each manifest must, and is very likely to, have one sequence, but may have more than one.</li>
 * <li>A manifest, sequence or canvas must not have a format.</li>
 * <li>A manifest or sequence must not have a height.</li>
 * <li>A manifest or sequence must not have a width.</li>
 * <li>Other resources must not have a startCanvas relationship.</li>
 * </ul>
 *
 * <p>
 * Other properties are possible, either via custom extensions or endorsed by the IIIF. If a client discovers properties
 * that it does not understand, then it must ignore them. Other properties should consist of a prefix and a name in the
 * form “prefix:name” to ensure it does not collide with a property defined by IIIF specifications. Services should be
 * used for extensions if at all possible.</p>
 *
 * <p>
 * A complete example rsponse, e.g. at URL http://www.example.org/iiif/book1/manifest:
 *
 * <pre>
 *
 *
 * {
 *   "@context":"http://iiif.io/api/presentation/2/context.json",
 *   "@type":"sc:Manifest",
 *   "@id":"http://www.example.org/iiif/book1/manifest",
 *
 *   "label":"Book 1",
 *   "metadata": [
 *     {"label":"Author", "value":"Anne Author"},
 *     {"label":"Published", "value": [
 *         {"@value": "Paris, circa 1400", "@language":"en"},
 *         {"@value": "Paris, environ 14eme siecle", "@language":"fr"}
 *       ]
 *     }
 *   ],
 *   "description":"A longer description of this example book. It should give some real information.",
 *   "license":"http://www.example.org/license.html",
 *   "attribution":"Provided by Example Organization",
 *   "service": {
 *     "@context": "http://example.org/ns/jsonld/context.json",
 *     "@id": "http://example.org/service/example",
 *     "profile": "http://example.org/docs/example-service.html"
 *   },
 *   "seeAlso": {
 *     "@id": "http://www.example.org/library/catalog/book1.marc",
 *     "format": "application/marc"
 *   },
 *   "within":"http://www.example.org/collections/books/",
 *
 *   "sequences" : [
 *     {
 *       "@id":"http://www.example.org/iiif/book1/sequence/normal",
 *       "@type":"sc:Sequence",
 *       "label":"Current Page Order",
 *       "viewingDirection":"left-to-right",
 *       "viewingHint":"paged",
 *       "canvases": [
 *         {
 *           "@id":"http://www.example.org/iiif/book1/canvas/p1",
 *           "@type":"sc:Canvas",
 *           "label":"p. 1",
 *           "height":1000,
 *           "width":750,
 *           "images": [
 *             {
 *               "@type":"oa:Annotation",
 *               "motivation":"sc:painting",
 *               "resource":{
 *                 "@id":"http://www.example.org/iiif/book1/res/page1.jpg",
 *                 "@type":"dctypes:Image",
 *                 "format":"image/jpeg",
 *                 "service": {
 *                   "@context": "http://iiif.io/api/image/2/context.json",
 *                   "@id": "http://www.example.org/images/book1-page1",
 *                   "profile":"http://iiif.io/api/image/2/level1.json"
 *                 },
 *                 "height":2000,
 *                 "width":1500
 *               },
 *               "on":"http://www.example.org/iiif/book1/canvas/p1"
 *             }
 *           ],
 *           "otherContent": [
 *             {
 *               "@id":"http://www.example.org/iiif/book1/list/p1",
 *               "@type":"sc:AnnotationList"
 *             }
 *           ]
 *         },
 *         {
 *           "@id":"http://www.example.org/iiif/book1/canvas/p2",
 *           "@type":"sc:Canvas",
 *           "label":"p. 2",
 *           "height":1000,
 *           "width":750,
 *           "images": [
 *             {
 *               "@type":"oa:Annotation",
 *               "motivation":"sc:painting",
 *               "resource":{
 *                 "@id":"http://www.example.org/images/book1-page2/full/1500,2000/0/default.jpg",
 *                 "@type":"dctypes:Image",
 *                 "format":"image/jpeg",
 *                 "height":2000,
 *                 "width":1500,
 *                 "service": {
 *                   "@context": "http://iiif.io/api/image/2/context.json",
 *                   "@id": "http://www.example.org/images/book1-page2",
 *                   "profile":"http://iiif.io/api/image/2/level1.json",
 *                   "height":8000,
 *                   "width":6000,
 *                   "tiles" : [{"width": 512, "scaleFactors": [1,2,4,8,16]}]
 *                 }
 *               },
 *               "on":"http://www.example.org/iiif/book1/canvas/p2"
 *             }
 *           ],
 *           "otherContent": [
 *             {
 *               "@id":"http://www.example.org/iiif/book1/list/p2",
 *               "@type":"sc:AnnotationList"
 *             }
 *           ]
 *         },
 *         {
 *           "@id":"http://www.example.org/iiif/book1/canvas/p3",
 *           "@type":"sc:Canvas",
 *           "label":"p. 3",
 *           "height":1000,
 *           "width":750,
 *           "images": [
 *             {
 *               "@type":"oa:Annotation",
 *               "motivation":"sc:painting",
 *               "resource":{
 *                 "@id":"http://www.example.org/iiif/book1/res/page3.jpg",
 *                 "@type":"dctypes:Image",
 *                 "format":"image/jpeg",
 *                 "service": {
 *                   "@context": "http://iiif.io/api/image/2/context.json",
 *                   "@id": "http://www.example.org/images/book1-page3",
 *                   "profile":"http://iiif.io/api/image/2/level1.json"
 *                 },
 *                 "height":2000,
 *                 "width":1500
 *               },
 *               "on":"http://www.example.org/iiif/book1/canvas/p3"
 *             }
 *           ],
 *           "otherContent": [
 *             {
 *               "@id":"http://www.example.org/iiif/book1/list/p3",
 *               "@type":"sc:AnnotationList"
 *             }
 *           ]
 *         }
 *       ]
 *     }
 *   ],
 *   "structures": [
 *     {
 *       "@id": "http://www.example.org/iiif/book1/range/r1",
 *       "@type":"sc:Range",
 *       "label":"Introduction",
 *       "canvases": [
 *         "http://www.example.org/iiif/book1/canvas/p1",
 *         "http://www.example.org/iiif/book1/canvas/p2",
 *         "http://www.example.org/iiif/book1/canvas/p3#xywh=0,0,750,300"
 *       ]
 *     }
 *   ]
 * }
 * </pre>
 * </p>
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
    private List<Sequence> sequences;
    private String thumbnail; // recommended
    private String viewingDirection; // optional
    private String viewingHint; // optional

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

    public List<Sequence> getSequences() {
        return sequences;
    }

    public void setSequences(List<Sequence> sequences) {
        this.sequences = sequences;
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

    /**
     * @see ViewingHint
     * @param viewingHint A hint to the client as to the most appropriate method of displaying the resource. A manifest,
     * sequence or range may have a viewing hint, with scope as per viewingDirection.
     */
    public void setViewingHint(String viewingHint) {
        this.viewingHint = viewingHint;
    }
}
