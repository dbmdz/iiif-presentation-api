package de.digitalcollections.iiif.presentation.model.impl.jackson.v2_0_0;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Annotation;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.AnnotationList;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Canvas;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Collection;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Content;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.IiifResource;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Image;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.ImageContent;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.ImageResource;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.ImageService;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Layer;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Manifest;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Metadata;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.OtherContent;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Range;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Resource;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Sequence;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Service;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Thumbnail;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.AbstractIiifResourceImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.MetadataLocalizedValueImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.MetadataMultilanguageImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.MetadataSimpleImpl;
import de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2_0_0.MetadataDeserializer;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.AbstractIiifResourceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.AnnotationListMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.AnnotationMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.CanvasMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.CollectionMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ContentMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ImageContentMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ImageMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ImageResourceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ImageServiceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.LayerMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ManifestMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.MetadataLocalizedValueMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.MetadataMultilanguageMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.MetadataSimpleMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.OtherContentMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.RangeMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ResourceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.SequenceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ServiceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ThumbnailMixIn;

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
