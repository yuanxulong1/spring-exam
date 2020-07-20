- java代码配置：

  - 需要环境：Servlet3.0+

  - 实现方式：

    - 通过xml文件来配置，注意context是XmlWebApplicationContext：

      ```java
      
      public class MyWebApplicationInitializer implements WebApplicationInitializer {
      
          @Override
          public void onStartup(ServletContext container) {
              XmlWebApplicationContext appContext = new XmlWebApplicationContext();
              appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
      
              ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(appContext));
              registration.setLoadOnStartup(1);
              registration.addMapping("/");
          }
      }
      ```

    - 通过java类配置(AppConfig类是配置类)，注意context类是AnnotationConfigWebApplicationContext：

      ```java
      public class MyWebApplicationInitializer implements WebApplicationInitializer {
          public void onStartup(ServletContext servletCxt) {
                  AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
                  ac.register(AppConfig.class);
                  ac.refresh();
      
                  DispatcherServlet servlet = new DispatcherServlet(ac);
                  ServletRegistration.Dynamic registration = servletCxt.addServlet("/", servlet);
                  registration.setLoadOnStartup(1);
                  registration.addMapping("/");
          }	
      }
      
      AppConfig.java
      @Configuration
      @EnableWebMvc
      @ComponentScan(basePackages = {"p.yxl"})
      public class AppConfig implements WebMvcConfigurer {
          @Bean
          public ViewResolver viewResolver() {
              InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
              internalResourceViewResolver.setPrefix("/WEB-INF/views/jsp/");
              internalResourceViewResolver.setSuffix(".jsp");
              internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
              return internalResourceViewResolver;
          }
      
          /**
           * 配置静态资源处理器
           */
          public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
              configurer.enable();
          }
      
          @Bean
          public HandlerMapping handlerMapping() {
              return new RequestMappingHandlerMapping();
          }
      }
      ```

      

    - 继承AbstractAnnotationConfigDispatcherServletInitializer（使用java配置类配置）：

      ```java
      public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
      
          @Override
          protected Class<?>[] getRootConfigClasses() {
              return null;
          }
      
          @Override
          protected Class<?>[] getServletConfigClasses() {
              return new Class<?>[] { AppConfig.class };
          }
      
          @Override
          protected String[] getServletMappings() {
              return new String[] { "/" };
          }
      }
      ```

    - 使用xml文件配置：

      ```jav
      public class MyWebAppInitializer extends AbstractDispatcherServletInitializer {
      
          @Override
          protected WebApplicationContext createRootApplicationContext() {
              return null;
          }
      
          @Override
          protected WebApplicationContext createServletApplicationContext() {
              XmlWebApplicationContext cxt = new XmlWebApplicationContext();
              cxt.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
              return cxt;
          }
      
          @Override
          protected String[] getServletMappings() {
              return new String[] { "/" };
          }
      }
      ```

      