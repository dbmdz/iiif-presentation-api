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
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Range;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Resource;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Sequence;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Service;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Thumbnail;
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
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.MetadataMixin;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.OtherContentMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.PropertyValueLocalizedMixin;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.RangeMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ResourceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.SequenceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ServiceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.ThumbnailMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.serializer.v2_0_0.PropertyValueSerializer;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.AbstractIiifResourceImpl;
import de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2_0_0.PropertyValueDeserializer;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.MetadataImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.PropertyValueLocalizedImpl;

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
    addMixIn(Metadata.class, MetadataMixin.class);
    addMixIn(PropertyValueLocalizedImpl.class, PropertyValueLocalizedMixin.class);
    addMixIn(OtherContent.class, OtherContentMixIn.class);
    addMixIn(Range.class, RangeMixIn.class);
    addMixIn(Resource.class, ResourceMixIn.class);
    addMixIn(Sequence.class, SequenceMixIn.class);
    addMixIn(Service.class, ServiceMixIn.class);
    addMixIn(Thumbnail.class, ThumbnailMixIn.class);

    setSerializationInclusion(JsonInclude.Include.NON_NULL);
    //enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    SimpleModule module = new SimpleModule("PolymorphicPropertyValueModule");
    PropertyValueSerializer propertyValueSerializer = new PropertyValueSerializer();
    PropertyValueDeserializer propertyValueDeserializer = new PropertyValueDeserializer();
    module.addSerializer(PropertyValue.class, propertyValueSerializer);
    module.addDeserializer(PropertyValue.class, propertyValueDeserializer);
    registerModule(module);
  }

}
