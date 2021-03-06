package de.digitalcollections.iiif.presentation.frontend.impl.springmvc.controller.v2;

import de.digitalcollections.iiif.presentation.business.api.v2.PresentationService;
import de.digitalcollections.iiif.presentation.model.api.exceptions.InvalidDataException;
import de.digitalcollections.iiif.presentation.model.api.exceptions.NotFoundException;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
  "de.digitalcollections.core.config",
  "de.digitalcollections.iiif.presentation.config"}
)
//@PropertySource(value = {
//  "classpath:de/digitalcollections/iiif/image/config/SpringConfigBackend-${spring.profiles.active:PROD}.properties"
//})
public class TestConfiguration extends WebMvcConfigurerAdapter {

//  @Bean
//  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//    return new PropertySourcesPlaceholderConfigurer();
//  }
  @Bean
  public PresentationService presentationService() throws NotFoundException, InvalidDataException {
    PresentationService mock = Mockito.mock(PresentationService.class);
    when(mock.getManifest("notfound")).thenThrow(new NotFoundException());
    return mock;
  }
}
