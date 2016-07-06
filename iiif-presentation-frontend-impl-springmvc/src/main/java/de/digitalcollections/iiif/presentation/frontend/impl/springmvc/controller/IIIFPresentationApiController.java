package de.digitalcollections.iiif.presentation.frontend.impl.springmvc.controller;

import de.digitalcollections.iiif.presentation.business.api.PresentationService;
import de.digitalcollections.iiif.presentation.frontend.impl.springmvc.exception.NotFoundException;
import de.digitalcollections.iiif.presentation.model.api.Manifest;
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
 * <li>http://localhost:9898/iiif/presentation/1234/manifest</li>
 * </ul>
 */
@Controller
@RequestMapping("/iiif/presentation")
public class IIIFPresentationApiController {

  private static final Logger LOGGER = LoggerFactory.getLogger(IIIFPresentationApiController.class);

  @Autowired
  private PresentationService presentationService;

  /**
   * see <a href="http://iiif.io/api/presentation/2.0/#manifest">IIIF 2.0</a><br/>
   * The manifest response contains sufficient information for the client to initialize itself and begin to display
   * something quickly to the user. The manifest resource represents a single object and any intellectual work or works
   * embodied within that object. In particular it includes the descriptive, rights and linking information for the
   * object. It then embeds the sequence(s) of canvases that should be rendered to the user.
   *
   * @param identifier unique id of object to be shown
   * @return the JSON-Manifest
   * @throws de.digitalcollections.iiif.presentation.frontend.impl.springmvc.exception.NotFoundException
   */
  @CrossOrigin(allowedHeaders = {"*"}, origins = {"*"})
  @RequestMapping(value = "{identifier}/manifest", method = RequestMethod.GET,
          produces = "application/json")
  @ResponseBody
  public Manifest getManifest(@PathVariable String identifier) throws NotFoundException {
    Manifest manifest;
    try {
      manifest = presentationService.getManifest(identifier);
    } catch (de.digitalcollections.iiif.presentation.business.api.exceptions.NotFoundException ex) {
      throw new NotFoundException(ex.getMessage());
    }
    return manifest;
  }
}
