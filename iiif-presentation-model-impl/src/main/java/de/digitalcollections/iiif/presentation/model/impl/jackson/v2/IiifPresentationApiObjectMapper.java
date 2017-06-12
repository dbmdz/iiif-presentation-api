package de.digitalcollections.iiif.presentation.model.impl.jackson.v2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.digitalcollections.iiif.presentation.model.api.v2.Annotation;
import de.digitalcollections.iiif.presentation.model.api.v2.AnnotationList;
import de.digitalcollections.iiif.presentation.model.api.v2.AnnotationResource;
import de.digitalcollections.iiif.presentation.model.api.v2.Canvas;
import de.digitalcollections.iiif.presentation.model.api.v2.Collection;
import de.digitalcollections.iiif.presentation.model.api.v2.Content;
import de.digitalcollections.iiif.presentation.model.api.v2.IiifResource;
import de.digitalcollections.iiif.presentation.model.api.v2.Image;
import de.digitalcollections.iiif.presentation.model.api.v2.ImageContent;
import de.digitalcollections.iiif.presentation.model.api.v2.ImageResource;
import de.digitalcollections.iiif.presentation.model.api.v2.ImageService;
import de.digitalcollections.iiif.presentation.model.api.v2.Layer;
import de.digitalcollections.iiif.presentation.model.api.v2.Manifest;
import de.digitalcollections.iiif.presentation.model.api.v2.Metadata;
import de.digitalcollections.iiif.presentation.model.api.v2.OtherContent;
import de.digitalcollections.iiif.presentation.model.api.v2.PhysicalDimensionsService;
import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2.Range;
import de.digitalcollections.iiif.presentation.model.api.v2.Rendering;
import de.digitalcollections.iiif.presentation.model.api.v2.Resource;
import de.digitalcollections.iiif.presentation.model.api.v2.SeeAlso;
import de.digitalcollections.iiif.presentation.model.api.v2.Sequence;
import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import de.digitalcollections.iiif.presentation.model.api.v2.Thumbnail;
import de.digitalcollections.iiif.presentation.model.api.v2.references.CollectionReference;
import de.digitalcollections.iiif.presentation.model.api.v2.references.IiifReference;
import de.digitalcollections.iiif.presentation.model.api.v2.references.ManifestReference;
import de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2.AnnotationResourceDeserializer;
import de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2.IiifReferenceDeserializer;
import de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2.PropertyValueDeserializer;
import de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2.SeeAlsoDeserializer;
import de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2.ServiceDeserializer;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.AbstractIiifResourceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.AnnotationListMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.AnnotationMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.CanvasMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.CollectionMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.ContentMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.ImageContentMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.ImageMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.ImageResourceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.ImageServiceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.LayerMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.ManifestMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.MetadataMixin;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.OtherContentMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.PhysicalDimensionsMixin;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.PropertyValueLocalizedMixin;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.RangeMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.RenderingMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.ResourceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.SeeAlsoMixin;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.SequenceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.ServiceMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.ThumbnailMixIn;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.references.CollectionReferenceMixin;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.references.IiifReferenceMixin;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.references.ManifestReferenceMixin;
import de.digitalcollections.iiif.presentation.model.impl.jackson.serializer.v2.PropertyValueSerializer;
import de.digitalcollections.iiif.presentation.model.impl.v2.AbstractIiifResourceImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2.PropertyValueLocalizedImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2.references.IiifReferenceImpl;

/**
 * A Jackson object mapper preconfigured for IIIF Presentation API objects.
 */
public class IiifPresentationApiObjectMapper extends ObjectMapper {

  public IiifPresentationApiObjectMapper() {
    // For correct serialization of Instant types (for navDate)
    this.findAndRegisterModules();
    this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    registerMixins();
    registerDeserializers();
    setSerializationInclusion(JsonInclude.Include.NON_NULL);
    enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    enable(SerializationFeature.INDENT_OUTPUT);
  }

  private void registerMixins() {
    addMixIn(IiifResource.class, AbstractIiifResourceMixIn.class);
    addMixIn(AbstractIiifResourceImpl.class, AbstractIiifResourceMixIn.class);
    addMixIn(IiifReferenceImpl.class, IiifReferenceMixin.class);

    addMixIn(Annotation.class, AnnotationMixIn.class);
    addMixIn(AnnotationList.class, AnnotationListMixIn.class);
    addMixIn(Canvas.class, CanvasMixIn.class);
    addMixIn(Collection.class, CollectionMixIn.class);
    addMixIn(CollectionReference.class, CollectionReferenceMixin.class);
    addMixIn(Content.class, ContentMixIn.class);
    addMixIn(ImageContent.class, ImageContentMixIn.class);
    addMixIn(Image.class, ImageMixIn.class);
    addMixIn(ImageResource.class, ImageResourceMixIn.class);
    addMixIn(ImageService.class, ImageServiceMixIn.class);
    addMixIn(Layer.class, LayerMixIn.class);
    addMixIn(Manifest.class, ManifestMixIn.class);
    addMixIn(ManifestReference.class, ManifestReferenceMixin.class);
    addMixIn(Metadata.class, MetadataMixin.class);
    addMixIn(PropertyValueLocalizedImpl.class, PropertyValueLocalizedMixin.class);
    addMixIn(PhysicalDimensionsService.class, PhysicalDimensionsMixin.class);
    addMixIn(OtherContent.class, OtherContentMixIn.class);
    addMixIn(Range.class, RangeMixIn.class);
    addMixIn(Resource.class, ResourceMixIn.class);
    addMixIn(Sequence.class, SequenceMixIn.class);
    addMixIn(Service.class, ServiceMixIn.class);
    addMixIn(Rendering.class, RenderingMixIn.class);
    addMixIn(Thumbnail.class, ThumbnailMixIn.class);
    addMixIn(SeeAlso.class, SeeAlsoMixin.class);
  }

  private void registerDeserializers() {
    SimpleModule module = new SimpleModule("PolymorphicTypes");
    PropertyValueSerializer propertyValueSerializer = new PropertyValueSerializer();
    PropertyValueDeserializer propertyValueDeserializer = new PropertyValueDeserializer();
    module.addSerializer(PropertyValue.class, propertyValueSerializer);
    module.addDeserializer(PropertyValue.class, propertyValueDeserializer);

    AnnotationResourceDeserializer annotationResourceDeserializer = new AnnotationResourceDeserializer();
    module.addDeserializer(AnnotationResource.class, annotationResourceDeserializer);

    IiifReferenceDeserializer iiifReferenceDeserializer = new IiifReferenceDeserializer();
    module.addDeserializer(IiifReference.class, iiifReferenceDeserializer);

    SeeAlsoDeserializer seeAlsoDeserializer = new SeeAlsoDeserializer();
    module.addDeserializer(SeeAlso.class, seeAlsoDeserializer);

    ServiceDeserializer serviceDeserializer = new ServiceDeserializer();
    module.addDeserializer(Service.class, serviceDeserializer);
    registerModule(module);
  }
}
