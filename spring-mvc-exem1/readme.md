#### 使用spring基于java的配置创建一个spring webmvc工程，spring版本5.2.2.RELEASE。
#### 工程创建过程 
1. 创建maven web工程（maven-archetype-webapp）
2. 修改pom文件，增加spring mvc依赖，具体见pom.xml文件。
3. 创建MyWebApplicationInitializer类，该类相当于声明一个Servlet。
4. 创建一个AppConfig类，在该类里配置ViewResolver和静态资源处理器。
5. 创建Controller，并根据AppConfig配置在相应的位置创建相应的jsp文件。
6. 发布配置到tomcat，以idea为例：
    
    6.1 首先在idea中创建一个tomcat容器，菜单Run->Edit Configurations-> 点+号-> Tomcat Servers,然后配置相应的tomcat homet和相应的端口。
    
    6.2 把项目发现到tomcat中，tomcat->Deployment-> + -> Artifact，完成。
7. 访问http://localhost:port/spring-mvc-exam1/hello
#### 需要注意的问题
1. 在AppConfig配置类中，不能使用@EnableWebMvc类，否则会报错，no ServletContext set。

#### webmvc中的一些特殊Bean
1. ViewResolver：解析从Controller中返回的字符串与view页面的对应关系，srping包含一些实现(例些主要的)：
    
    1.1 XmlViewResolver：使用一个xml配置文件定义，默认位置为/WEB-INF/views.xml
    
    1.2 InternalResourceViewResolver：UrlBasedViewResolver的子类，它将InternalResourceView作为缺省的View类，如果当前classpath中有jstl的jar包时则使用JstlView作为缺省的view来渲染结果
    
    1.3 UrlBasedViewResolver：
        
        ```
        <bean id="viewResolver"
               class="org.springframework.web.servlet.view.UrlBasedViewResolver">
               <property name="viewClass"
                   value="org.springframework.web.servlet.view.JstlView" />
               <property name="prefix" value="/WEB-INF/jsp/" />
               <property name="suffix" value=".jsp" />
         </bean>
        ```
    
    1.4 FreeMarkerViewResolver：UrlBasedViewResolver的子类，使用Freemarker做为模板
    
    1.5 ContentNegotiatingViewResolver：本身不解析对应的视图，把相应的工作交给下层的viewresolver，可以组合多个viewresolver，
        可以根据accepte header或者查询参数返回不同的视图，比如/path?format=json返回json格式，/path?format=xml返回xml格式。
2. HandlerMapping：主要是把请求映射到相应的controller，spring中包含两个实现：
    2.1 RequestMappingHandlerMapping：可以根据@RequestMapping来实现映射。
    
    2.2 SimpleUrlHandlerMapping：需要包含明确的映射规则，较少使用
    
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
3. HandlerAdapter：帮助DispatcherServlet去调用相应的Handler，忽略调用的细节
4. HandlerExceptionResolver：