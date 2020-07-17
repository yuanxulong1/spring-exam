package p.yxl;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * 使用java配置DispatcherServlet有两种方式，
 * 1. 一种是直接implements WebApplicationInitializer，并实现onStartup方法
 * 2. 继承WebApplicationInitializer的抽像类AbstractAnnotationConfigDispatcherServletInitializer，复写其中的方法
 *
 */
//public class MyWebApplicationInitializer implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletCxt) {
//        System.out.println("*************************");
//        // Load Spring web application configuration
//        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
//        ac.register(AppConfig.class);
//        ac.refresh();
//
//        // Create and register the DispatcherServlet
//        DispatcherServlet servlet = new DispatcherServlet(ac);
//        ServletRegistration.Dynamic registration = servletCxt.addServlet("/", servlet);
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//    }
//}

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

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
