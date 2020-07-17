- ViewResolver：解析从Controller中返回的字符串与view页面的对应关系

  - XmlViewResolver：使用一个xml配置文件定义，默认位置为/WEB-INF/views.xml

  - UrlBasedViewResolver：基于前缀和后缀来匹配视图，配置如下：

    ```xml
    <bean id="viewResolver"
           class="org.springframework.web.servlet.view.UrlBasedViewResolver">
           <property name="viewClass"
               value="org.springframework.web.servlet.view.JstlView" />
           <property name="prefix" value="/WEB-INF/jsp/" />
           <property name="suffix" value=".jsp" />
     </bean>
    ```

  - InternalResourceViewResolver：UrlBasedViewResolver的子类，它将InternalResourceView作为缺省的View类，如果当前classpath中有jstl的jar包时则使用JstlView作为缺省的view来渲染结果

  - FreeMarkerViewResolver：前端支持Freemarker模板。

  - ContentNegotiatingViewResolver：本身不解析对应的视图，把相应的工作交给下层的viewresolver，可以组合多个viewresolver，可以根据accepte header或者查询参数返回不同的视图，比如/path?format=json返回json格式，/path?format=xml返回xml格式。

- HandlerMapping：主要是把请求映射到相应的controller，spring中包含两个实现

  - RequestMappingHandlerMapping：可以根据@RequestMapping来实现映射

  - SimpleUrlHandlerMapping：需要包含明确的映射规则，较少使用，例：

    ```xml
    <bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
    	   <property name="mappings">
    		<props>
    		   <prop key="/welcome.htm">welcomeController</prop>
    		   <prop key="/*/welcome.htm">welcomeController</prop>
    		   <prop key="/helloGuest.htm">helloGuestController</prop>
    		 </props>
    	   </property>
    </bean>
    ```

- HandlerAdapter：帮助DispatcherServlet去调用相应的Handler，忽略调用的细节

- HandlerExceptionResolver：

- LocaleResolver：

- ThemeResolver：

- MultipartResolver：

- FlashMapManager：

