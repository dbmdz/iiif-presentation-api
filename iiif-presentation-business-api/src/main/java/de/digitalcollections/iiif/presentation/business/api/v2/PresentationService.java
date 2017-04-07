package de.digitalcollections.iiif.presentation.business.api.v2;

import de.digitalcollections.iiif.presentation.model.api.exceptions.InvalidDataException;
import de.digitalcollections.iiif.presentation.model.api.exceptions.NotFoundException;
import de.digitalcollections.iiif.presentation.model.api.v2.Canvas;
import de.digitalcollections.iiif.presentation.model.api.v2.Collection;
import de.digitalcollections.iiif.presentation.model.api.v2.Manifest;
import de.digitalcollections.iiif.presentation.model.api.v2.Range;
import de.digitalcollections.iiif.presentation.model.api.v2.Sequence;
import java.net.URI;

/**
 * Service for IIIF Presentation API functionality.
 */
public interface PresentationService {

  /**
   * @param name unique name of collection
   * @return Collection specified by name
   * @throws NotFoundException if no collection found or access disallowed
   */
  Collection getCollection(String name) throws NotFoundException, InvalidDataException;

  /**
   * @param identifier unique id for IIIF resource
   * @return Manifest specifying presentation for IIIF resource
   * @throws de.digitalcollections.iiif.presentation.model.api.exceptions.NotFoundException if no manifest found or
   * access disallowed
   */
  Manifest getManifest(String identifier) throws NotFoundException, InvalidDataException;

  default Canvas getCanvas(String manifestId, String canvasUri) throws NotFoundException, InvalidDataException {
    return getCanvas(manifestId, URI.create(canvasUri));
  }

  Canvas getCanvas(String manifestId, URI canvasUri) throws NotFoundException, InvalidDataException;

  default Range getRange(String manifestId, String rangeUri) throws NotFoundException, InvalidDataException {
    return getRange(manifestId, URI.create(rangeUri));
  }

  Range getRange(String manifestId, URI rangeUri) throws NotFoundException, InvalidDataException;

  default Sequence getSequence(String manifestId, String sequenceUri) throws NotFoundException, InvalidDataException {
    return getSequence(manifestId, URI.create(sequenceUri));
  }

  Sequence getSequence(String manifestId, URI sequenceUri) throws NotFoundException, InvalidDataException;
}
