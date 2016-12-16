package de.digitalcollections.iiif.presentation.frontend.impl.springmvc.controller.v2;

import de.digitalcollections.commons.server.HttpLoggingUtilities;
import de.digitalcollections.iiif.presentation.business.api.v2.PresentationService;
import de.digitalcollections.iiif.presentation.frontend.impl.springmvc.exception.NotFoundException;
import de.digitalcollections.iiif.presentation.model.api.v2.Manifest;
import javax.servlet.http.HttpServletRequest;
import net.logstash.logback.marker.LogstashMarker;
import net.logstash.logback.marker.Markers;
import static net.logstash.logback.marker.Markers.append;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * IIIF Presentation API implementation. Supported URLs (examples):
 * <ul>
 * <li>http://localhost:9898/presentation/v2/1234/manifest</li>
 * </ul>
 */
@Controller(value = "IIIFPresentationApiController-v2")
@RequestMapping("/presentation/v2")
public class IIIFPresentationApiController {

  private static final Logger LOGGER = LoggerFactory.getLogger(IIIFPresentationApiController.class);
  public static final String VERSION = "v2";

  @Autowired
  private PresentationService presentationService;

  /**
   * The manifest response contains sufficient information for the client to initialize itself and begin to display
   * something quickly to the user. The manifest resource represents a single object and any intellectual work or works
   * embodied within that object. In particular it includes the descriptive, rights and linking information for the
   * object. It then embeds the sequence(s) of canvases that should be rendered to the user.
   *
   * @param identifier unique id of object to be shown
   * @return the JSON-Manifest
   * @throws NotFoundException if manifest can not be delivered
   * @see <a href="http://iiif.io/api/presentation/2.0/#manifest">IIIF 2.0</a>
   */
  @CrossOrigin(allowedHeaders = {"*"}, origins = {"*"})
  @RequestMapping(value = {"{identifier}/manifest", "{identifier}"}, method = {RequestMethod.GET, RequestMethod.HEAD},
                  produces = "application/json")
  @ResponseBody
  public Manifest getManifest(@PathVariable String identifier, HttpServletRequest request) throws NotFoundException {
    LogstashMarker marker = HttpLoggingUtilities.makeRequestLoggingMarker(request)
        .and(append("manifestId", identifier));
    Manifest manifest;
    try {
      manifest = presentationService.getManifest(identifier);
      LOGGER.info(marker, "Serving manifest for {}", identifier);
    } catch (de.digitalcollections.iiif.presentation.business.api.exceptions.NotFoundException ex) {
      LOGGER.info(marker, "Did not find manifest for {}", identifier);
      throw new NotFoundException(ex.getMessage());
    }
    return manifest;
  }
}
