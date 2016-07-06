package de.digitalcollections.iiif.presentation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Business context.
 */
@Configuration
@ComponentScan(basePackages = {
  "de.digitalcollections.iiif.presentation.business.impl.service"
})
public class SpringConfigBusinessPresentation {
}
