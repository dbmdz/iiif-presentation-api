package de.digitalcollections.iiif.presentation.backend.api.repository.v2;

import de.digitalcollections.iiif.presentation.model.api.exceptions.InvalidDataException;
import de.digitalcollections.iiif.presentation.model.api.exceptions.NotFoundException;
import de.digitalcollections.iiif.presentation.model.api.v2.Collection;
import de.digitalcollections.iiif.presentation.model.api.v2.Manifest;
import java.net.URI;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Interface to be implemented by project/user of this library.
 */
public interface PresentationRepository {

  /**
   * @param name unique name of collection
   * @return Collection specified by name
   * @throws NotFoundException in case Collection does
   * not exist or can not be delivered
   */
  public Collection getCollection(String name) throws NotFoundException, InvalidDataException;

  public Collection getCollection(URI collectionUri) throws NotFoundException, InvalidDataException;

  /**
   * @param identifier unique id for IIIF resource
   * @return Manifest specifying presentation for IIIF resource
   * @throws NotFoundException in case Manifest does not
   * exist or can not be delivered
   */
  Manifest getManifest(String identifier) throws NotFoundException, InvalidDataException;

  public Manifest getManifest(URI manifestUri) throws NotFoundException, InvalidDataException;

  public String getResourceJson(URI resourceUri) throws NotFoundException;

  public JSONObject getResourceAsJsonObject(URI resourceUri) throws NotFoundException, ParseException;

  public JSONObject getResourceAsJsonObject(String resourceUri) throws NotFoundException, ParseException;
}
