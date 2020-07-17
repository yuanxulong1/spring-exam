#### 使用spring基于java的配置创建一个spring webmvc工程，spring版本5.2.7.RELEASE。
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