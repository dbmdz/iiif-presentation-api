package de.digitalcollections.iiif.presentation.config.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.iiif.presentation.model.impl.jackson.v2.IiifPresentationApiObjectMapper;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * IIIF presentation API specific configuration.
 */
@Configuration(value = "SpringConfigFrontendPresentation-v2")
@ComponentScan(basePackages = {
  "de.digitalcollections.iiif.presentation.frontend.impl.springmvc.controller"
})
@EnableWebMvc
public class SpringConfigFrontendPresentation extends WebMvcConfigurerAdapter {

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    // support for @ResponseBody of type String
    final StringHttpMessageConverter stringHMC = new StringHttpMessageConverter(StandardCharsets.UTF_8);
    // supported MediaTypes for stringHMC are by default set to: "text/plain" and MediaType.ALL
    converters.add(stringHMC);

    // support for @ResponseBody of type Object: convert object to JSON
    // used in ApiController
    converters.add(mappingJackson2HttpMessageConverter());
  }

  @Bean
  public HttpMessageConverter<?> mappingJackson2HttpMessageConverter() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(objectMapper());
    return converter;
  }

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new IiifPresentationApiObjectMapper();
    // define which fields schould be ignored with Filter-classes:
//        objectMapper.addMixIn(User.class, UserJsonFilter.class);
//        objectMapper.addMixIn(GrantedAuthority.class, GrantedAuthorityJsonFilter.class);
    return objectMapper;
  }
}
