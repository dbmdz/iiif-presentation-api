package de.digitalcollections.iiif.presentation.config.v2;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(2)
public class WebappInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebappInitializer.class);

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[]{SpringConfigFrontendPresentation.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return null;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/*"};
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);
    servletContext.addListener(new LogbackConfigListener());

    String contextPath = servletContext.getContextPath();
    LOGGER.info("*** Deployed under context path '{}'", contextPath);
  }
}
