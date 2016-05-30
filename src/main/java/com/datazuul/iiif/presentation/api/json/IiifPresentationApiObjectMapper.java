package com.datazuul.iiif.presentation.api.json;

import com.datazuul.iiif.presentation.api.model.AbstractIiifResource;
import com.datazuul.iiif.presentation.api.model.Canvas;
import com.datazuul.iiif.presentation.api.model.Manifest;
import com.datazuul.iiif.presentation.api.model.other.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * A Jackson object mapper preconfigured for IIIF Presentation API objects.
 *
 * @author Ralf Eichinger (ralf.eichinger at bsb-muenchen.de)
 */
public class IiifPresentationApiObjectMapper extends ObjectMapper {

  public IiifPresentationApiObjectMapper() {
    addMixIn(AbstractIiifResource.class, AbstractIiifResourceMixIn.class);
    addMixIn(Canvas.class, CanvasMixIn.class);
    addMixIn(Image.class, AbstractIiifResourceMixIn.class);
    addMixIn(Manifest.class, ManifestMixIn.class);
    addMixIn(MetadataLocalizedValue.class, MetadataLocalizedValueMixIn.class);
    addMixIn(MetadataMultilanguage.class, MetadataMultilanguageMixIn.class);
    addMixIn(MetadataSimple.class, MetadataSimpleMixIn.class);
    addMixIn(Resource.class, AbstractIiifResourceMixIn.class);
    addMixIn(Service.class, ServiceMixIn.class);
    addMixIn(Thumbnail.class, AbstractIiifResourceMixIn.class);

    setSerializationInclusion(JsonInclude.Include.NON_NULL);
    enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    MetadataDeserializer metadataDeserializer = new MetadataDeserializer();
    SimpleModule module = new SimpleModule("PolymorphicMetadataDeserializerModule");
    module.addDeserializer(Metadata.class, metadataDeserializer);
    registerModule(module);
  }

}
