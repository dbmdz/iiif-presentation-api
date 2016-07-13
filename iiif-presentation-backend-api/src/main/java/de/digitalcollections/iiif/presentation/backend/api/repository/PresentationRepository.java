package de.digitalcollections.iiif.presentation.backend.api.repository;

import de.digitalcollections.iiif.presentation.backend.api.exceptions.NotFoundException;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Manifest;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Interface to be implemented by project/user of this library.
 */
public interface PresentationRepository {

  /**
   * @param identifier unique id for IIIF resource
   * @return Manifest specifying presentation for IIIF resource
   * @throws de.digitalcollections.iiif.presentation.backend.api.exceptions.NotFoundException in case Manifest does not
   * exist or can not be delivered
   */
  Manifest getManifest(String identifier) throws NotFoundException;

  public Manifest getManifest(URI manifestUri) throws NotFoundException;

  public String getManifestJson(URI manifestUri) throws NotFoundException;

  public JSONObject getManifestAsJsonObject(URI manifestUri) throws NotFoundException, ParseException;

  public JSONObject getManifestAsJsonObject(String manifestUri) throws URISyntaxException, NotFoundException, ParseException;
}
