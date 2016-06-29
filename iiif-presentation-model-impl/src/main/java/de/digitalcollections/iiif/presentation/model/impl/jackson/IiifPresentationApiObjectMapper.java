package de.digitalcollections.iiif.presentation.model.impl.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.digitalcollections.iiif.presentation.model.api.Annotation;
import de.digitalcollections.iiif.presentation.model.api.AnnotationList;
import de.digitalcollections.iiif.presentation.model.api.Canvas;
import de.digitalcollections.iiif.presentation.model.api.Collection;
import de.digitalcollections.iiif.presentation.model.api.Content;
import de.digitalcollections.iiif.presentation.model.api.IiifResource;
import de.digitalcollections.iiif.presentation.model.api.Image;
import de.digitalcollections.iiif.presentation.model.api.ImageContent;
import de.digitalcollections.iiif.presentation.model.api.ImageResource;
import de.digitalcollections.iiif.presentation.model.api.ImageService;
import de.digitalcollections.iiif.presentation.model.api.Layer;
import de.digitalcollections.iiif.presentation.model.api.Manifest;
import de.digitalcollections.iiif.presentation.model.api.Metadata;
import de.digitalcollections.iiif.presentation.model.api.OtherContent;
import de.digitalcollections.iiif.presentation.model.api.Range;
import de.digitalcollections.iiif.presentation.model.api.Resource;
import de.digitalcollections.iiif.presentation.model.api.Sequence;
import de.digitalcollections.iiif.presentation.model.api.Service;
import de.digitalcollections.iiif.presentation.model.api.Thumbnail;
import de.digitalcollections.iiif.presentation.model.impl.AbstractIiifResourceImpl;
import de.digitalcollections.iiif.presentation.model.impl.MetadataLocalizedValueImpl;
import de.digitalcollections.iiif.presentation.model.impl.MetadataMultilanguageImpl;
import de.digitalcollections.iiif.presentation.model.impl.MetadataSimpleImpl;
import de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.MetadataDeserializer;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.AbstractIiifResourceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.AnnotationListMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.AnnotationMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.CanvasMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.CollectionMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.ContentMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.ImageContentMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.ImageMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.ImageResourceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.ImageServiceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.LayerMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.ManifestMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.MetadataLocalizedValueMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.MetadataMultilanguageMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.MetadataSimpleMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.OtherContentMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.RangeMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.ResourceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.SequenceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.ServiceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.ThumbnailMixIn;

/**
 * A Jackson object mapper preconfigured for IIIF Presentation API objects.
 */
public class IiifPresentationApiObjectMapper extends ObjectMapper {

  public IiifPresentationApiObjectMapper() {
    addMixIn(IiifResource.class, AbstractIiifResourceMixIn.class);
    addMixIn(AbstractIiifResourceImpl.class, AbstractIiifResourceMixIn.class);

    addMixIn(Annotation.class, AnnotationMixIn.class);
    addMixIn(AnnotationList.class, AnnotationListMixIn.class);
    addMixIn(Canvas.class, CanvasMixIn.class);
    addMixIn(Collection.class, CollectionMixIn.class);
    addMixIn(Content.class, ContentMixIn.class);
    addMixIn(ImageContent.class, ImageContentMixIn.class);
    addMixIn(Image.class, ImageMixIn.class);
    addMixIn(ImageResource.class, ImageResourceMixIn.class);
    addMixIn(ImageService.class, ImageServiceMixIn.class);
    addMixIn(Layer.class, LayerMixIn.class);
    addMixIn(Manifest.class, ManifestMixIn.class);
    addMixIn(MetadataLocalizedValueImpl.class, MetadataLocalizedValueMixIn.class);
    addMixIn(MetadataMultilanguageImpl.class, MetadataMultilanguageMixIn.class);
    addMixIn(MetadataSimpleImpl.class, MetadataSimpleMixIn.class);
    addMixIn(OtherContent.class, OtherContentMixIn.class);
    addMixIn(Range.class, RangeMixIn.class);
    addMixIn(Resource.class, ResourceMixIn.class);
    addMixIn(Sequence.class, SequenceMixIn.class);
    addMixIn(Service.class, ServiceMixIn.class);
    addMixIn(Thumbnail.class, ThumbnailMixIn.class);

    setSerializationInclusion(JsonInclude.Include.NON_NULL);
    enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    MetadataDeserializer metadataDeserializer = new MetadataDeserializer();
    SimpleModule module = new SimpleModule("PolymorphicMetadataDeserializerModule");
    module.addDeserializer(Metadata.class, metadataDeserializer);
    registerModule(module);
  }

}
