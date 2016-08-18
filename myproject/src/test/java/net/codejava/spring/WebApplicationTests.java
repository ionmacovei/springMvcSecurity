package net.codejava.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import net.codejava.spring.config.ApplicationContextConfig;
import net.codejava.spring.config.SpringWebAppInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
@ContextConfiguration(classes = SpringWebAppInitializer.class),
@ContextConfiguration(classes = ApplicationContextConfig.class)
})

public class WebApplicationTests {
	
	@Autowired
	private WebApplicationContext applicationContext;
	
	@Autowired
	private MockServletContext servletContext;
	
	@Autowired
	private MockHttpServletRequest httpServletRequest;
	
	@Autowired
	private MockHttpServletResponse httpServletResponse;
	
	@Test
	public void testWebApp() {
		Assert.assertNotNull(applicationContext);
		Assert.assertNotNull(servletContext);
		
		Assert.assertNotNull(httpServletRequest);
		Assert.assertNotNull(httpServletResponse);
		
	}
	
}
