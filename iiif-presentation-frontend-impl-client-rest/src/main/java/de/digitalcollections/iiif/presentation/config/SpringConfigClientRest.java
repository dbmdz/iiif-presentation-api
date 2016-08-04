package de.digitalcollections.iiif.presentation.config;

import de.digitalcollections.iiif.presentation.frontend.impl.client.rest.IIIFRepository;
import de.digitalcollections.iiif.presentation.model.impl.jackson.v2_0_0.IiifPresentationApiObjectMapper;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = {
    "classpath:de/digitalcollections/iiif/presentation/config/SpringConfigFrontend-${spring.profiles.active:PROD}.properties"
})
public class SpringConfigClientRest {

  @Value("${presentation.iiifRepositoryURL}")
  private String iifRepositoryURL;

  @Bean
  public IIIFRepository iiifRepository() {
    IIIFRepository iiif = Feign.builder()
        .decoder(new JacksonDecoder(new IiifPresentationApiObjectMapper()))
        .target(IIIFRepository.class, iifRepositoryURL);
    return iiif;
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}
