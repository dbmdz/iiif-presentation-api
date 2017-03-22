package de.digitalcollections.iiif.presentation.frontend.impl.springmvc.controller.v2;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestConfiguration.class)
public class IIIFPresentationApiControllerTest {

  @Autowired
  protected IIIFPresentationApiController iiifController;

  private MockMvc mockMvc;

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  protected WebApplicationContext wac;

  @BeforeClass
  public static void beforeClass() {
    System.setProperty("spring.profiles.active", "TEST");
  }

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  /**
   * Test of getManifest method, of class IIIFPresentationApiController.
   */
  @Test
  public void testGetManifest() throws Exception {
    mockMvc.perform(get("/presentation/" + IIIFPresentationApiController.VERSION + "/abcdef/manifest"))
            .andExpect(status().isOk());
  }

  @Test
  public void testCorsHeadersArePresent() throws Exception {
    ResultActions result = mockMvc.perform(get("/presentation/" + IIIFPresentationApiController.VERSION + "/abcdef/manifest")
        .header("Origin", "http://example.com"));
    result.andExpect(status().isOk());
    result.andExpect(header().string("Access-Control-Allow-Origin", "http://example.com"));
  }

  @Test
  public void testCheckManifestExistence() throws Exception {
    ResultActions result = mockMvc.perform(head("/presentation/" + IIIFPresentationApiController.VERSION + "/abcdef/manifest"));
    result.andExpect(status().isOk());
    result = mockMvc.perform(head("/presentation/" + IIIFPresentationApiController.VERSION + "/notfound/manifest"));
    result.andExpect(status().isNotFound());
  }
}
