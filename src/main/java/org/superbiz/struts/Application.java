package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBeanForSMF (){
        SiteMeshFilter siteMeshFilter = new SiteMeshFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(siteMeshFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBeanForSPEF (){
        StrutsPrepareAndExecuteFilter strutsPrepareAndExecuteFilter = new StrutsPrepareAndExecuteFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(strutsPrepareAndExecuteFilter);
        Collection<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/");
        urlPatterns.add("/addUserForm.action");
        urlPatterns.add("/addUser.action");
        urlPatterns.add("/findUserForm.action");
        urlPatterns.add("/findUser.action");
        urlPatterns.add("/listAllUsers.action");

        filterRegistrationBean.setUrlPatterns(urlPatterns);
        return filterRegistrationBean;
    }
}
