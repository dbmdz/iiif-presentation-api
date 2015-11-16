package com.datazuul.iiif.presentation.api.json;

import com.datazuul.iiif.presentation.api.model.AbstractIiifResource;
import com.datazuul.iiif.presentation.api.model.Canvas;
import com.datazuul.iiif.presentation.api.model.Manifest;
import com.datazuul.iiif.presentation.api.model.other.Image;
import com.datazuul.iiif.presentation.api.model.other.Metadata;
import com.datazuul.iiif.presentation.api.model.other.MetadataLocalizedValue;
import com.datazuul.iiif.presentation.api.model.other.MetadataMultilanguage;
import com.datazuul.iiif.presentation.api.model.other.MetadataSimple;
import com.datazuul.iiif.presentation.api.model.other.Resource;
import com.datazuul.iiif.presentation.api.model.other.Service;
import com.fasterxml.jackson.annotation.JsonInclude;
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

    setSerializationInclusion(JsonInclude.Include.NON_NULL);

    MetadataDeserializer metadataDeserializer = new MetadataDeserializer();
    SimpleModule module = new SimpleModule("PolymorphicMetadataDeserializerModule");
    module.addDeserializer(Metadata.class, metadataDeserializer);
    registerModule(module);
  }

}
