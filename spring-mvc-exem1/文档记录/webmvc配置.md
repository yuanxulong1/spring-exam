1. Enable MVC Config

   1. java代码配置

      ```jav
      @Configuration
      @EnableWebMvc
      public class WebConfig {
      }
      ```

   2. xml配置：

      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:mvc="http://www.springframework.org/schema/mvc"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="
              http://www.springframework.org/schema/beans
              https://www.springframework.org/schema/beans/spring-beans.xsd
              http://www.springframework.org/schema/mvc
              https://www.springframework.org/schema/mvc/spring-mvc.xsd">
      
          <mvc:annotation-driven/>
      
      </beans>
      ```

      