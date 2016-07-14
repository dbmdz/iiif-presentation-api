package de.digitalcollections.iiif.presentation.model.api.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.enums.ViewingDirection;
import de.digitalcollections.iiif.presentation.model.api.enums.ViewingHint;
import java.util.List;

/**
 * IIIF Presentation API Manifest.
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/manifest
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
 * used for extensions if at all possible.
 *
 * <p>
 * A complete example response, e.g. at URL http://www.example.org/iiif/book1/manifest:
 *
 * <pre>
 * {
 *   "@context":"http://iiif.io/api/presentation/2/context.json",
 *   "@type":"sc:Manifest",
 *   "@id":"http://www.example.org/iiif/book1/manifest",
 *
 *   "label":"Book 1",
 *   "metadata": [
 *     {"label":"Author", "value":"Anne Author"},
 *     {"label":"Published", "value": [
 *       {"@value": "Paris, circa 1400", "@language":"en"},
 *       {"@value": "Paris, environ 14eme siecle", "@language":"fr"}
 *     ]
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
 *   {
 *     "@id":"http://www.example.org/iiif/book1/sequence/normal",
 *     "@type":"sc:Sequence",
 *     "label":"Current Page Order",
 *     "viewingDirection":"left-to-right",
 *     "viewingHint":"paged",
 *     "canvases": [
 *     {
 *       "@id":"http://www.example.org/iiif/book1/canvas/p1",
 *       "@type":"sc:Canvas",
 *       "label":"p. 1",
 *       "height":1000,
 *       "width":750,
 *       "images": [
 *       {
 *         "@type":"oa:Annotation",
 *         "motivation":"sc:painting",
 *         "resource":{
 *           "@id":"http://www.example.org/iiif/book1/res/page1.jpg",
 *           "@type":"dctypes:Image",
 *           "format":"image/jpeg",
 *           "service": {
 *             "@context": "http://iiif.io/api/image/2/context.json",
 *             "@id": "http://www.example.org/images/book1-page1",
 *             "profile":"http://iiif.io/api/image/2/level1.json"
 *           },
 *           "height":2000,
 *           "width":1500
 *         },
 *         "on":"http://www.example.org/iiif/book1/canvas/p1"
 *       }
 *       ],
 *       "otherContent": [
 *       {
 *         "@id":"http://www.example.org/iiif/book1/list/p1",
 *         "@type":"sc:AnnotationList"
 *       }
 *       ]
 *     },
 *     {
 *       "@id":"http://www.example.org/iiif/book1/canvas/p2",
 *       "@type":"sc:Canvas",
 *       "label":"p. 2",
 *       "height":1000,
 *       "width":750,
 *       "images": [
 *       {
 *         "@type":"oa:Annotation",
 *         "motivation":"sc:painting",
 *         "resource":{
 *           "@id":"http://www.example.org/images/book1-page2/full/1500,2000/0/default.jpg",
 *           "@type":"dctypes:Image",
 *           "format":"image/jpeg",
 *           "height":2000,
 *           "width":1500,
 *           "service": {
 *             "@context": "http://iiif.io/api/image/2/context.json",
 *             "@id": "http://www.example.org/images/book1-page2",
 *             "profile":"http://iiif.io/api/image/2/level1.json",
 *             "height":8000,
 *             "width":6000,
 *             "tiles" : [{"width": 512, "scaleFactors": [1,2,4,8,16]}]
 *           }
 *         },
 *         "on":"http://www.example.org/iiif/book1/canvas/p2"
 *       }
 *       ],
 *       "otherContent": [
 *       {
 *         "@id":"http://www.example.org/iiif/book1/list/p2",
 *         "@type":"sc:AnnotationList"
 *       }
 *       ]
 *     },
 *     {
 *       "@id":"http://www.example.org/iiif/book1/canvas/p3",
 *       "@type":"sc:Canvas",
 *       "label":"p. 3",
 *       "height":1000,
 *       "width":750,
 *       "images": [
 *       {
 *         "@type":"oa:Annotation",
 *         "motivation":"sc:painting",
 *         "resource":{
 *           "@id":"http://www.example.org/iiif/book1/res/page3.jpg",
 *           "@type":"dctypes:Image",
 *           "format":"image/jpeg",
 *           "service": {
 *             "@context": "http://iiif.io/api/image/2/context.json",
 *             "@id": "http://www.example.org/images/book1-page3",
 *             "profile":"http://iiif.io/api/image/2/level1.json"
 *           },
 *           "height":2000,
 *           "width":1500
 *         },
 *         "on":"http://www.example.org/iiif/book1/canvas/p3"
 *       }
 *       ],
 *       "otherContent": [
 *       {
 *         "@id":"http://www.example.org/iiif/book1/list/p3",
 *         "@type":"sc:AnnotationList"
 *       }
 *       ]
 *     }
 *     ]
 *   }
 *   ],
 *   "structures": [
 *   {
 *     "@id": "http://www.example.org/iiif/book1/range/r1",
 *     "@type":"sc:Range",
 *     "label":"Introduction",
 *     "canvases": [
 *       "http://www.example.org/iiif/book1/canvas/p1",
 *       "http://www.example.org/iiif/book1/canvas/p2",
 *       "http://www.example.org/iiif/book1/canvas/p3#xywh=0,0,750,300"
 *     ]
 *   }
 *   ]
 * }
 * </pre>
 *
 * @see <a href="http://iiif.io/api/presentation/2.0/#manifest">http://iiif.io/api/presentation/2.0/#manifest</a>
 */
public interface Manifest extends IiifResource {

  String getContext();

  String getDescription();

  void setDescription(String description);

  String getLabel();

  void setLabel(String label);

  List<Metadata> getMetadata();

  void setMetadata(List<Metadata> metadata);

  void setRanges(List<Range> structures);

  List<Sequence> getSequences();

  void setSequences(List<Sequence> sequences);

  List<Range> getStructures();

  void setStructures(List<Range> structures);

  Thumbnail getThumbnail();

  void setThumbnail(Thumbnail thumbnail);

  String getViewingDirection();

  /**
   * @param viewingDirection The direction that canvases of the resource should be presented when rendered for the user
   * to navigate and/or read. A manifest may have a viewing direction, and if so, it applies to all of its sequences
   * unless the sequence specifies its own viewing direction.
   * @see ViewingDirection
   */
  void setViewingDirection(String viewingDirection);

  String getViewingHint();

  /**
   * @param viewingHint A hint to the client as to the most appropriate method of displaying the resource. A manifest,
   * sequence or range may have a viewing hint, with scope as per viewingDirection.
   * @see ViewingHint
   */
  void setViewingHint(String viewingHint);

}
