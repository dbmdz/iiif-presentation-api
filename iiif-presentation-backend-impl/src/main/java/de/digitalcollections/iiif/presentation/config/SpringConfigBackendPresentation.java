package de.digitalcollections.iiif.presentation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Backend configuration.
 */
@Configuration
@ComponentScan(basePackages = {
  "de.digitalcollections.core.config",
  "de.digitalcollections.iiif.presentation.backend.impl.repository"
})
//@PropertySource(value = {
//  "classpath:de/digitalcollections/iiif/presentation/config/SpringConfigBackend-${spring.profiles.active:PROD}.properties"
//})
public class SpringConfigBackendPresentation {

//  private static final Logger LOGGER = LoggerFactory.getLogger(SpringConfigBackendPresentation.class);
//
//  @Bean
//  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//    return new PropertySourcesPlaceholderConfigurer();
//  }
}
