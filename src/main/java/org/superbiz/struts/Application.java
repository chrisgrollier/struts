package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Order(1)
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean<SiteMeshFilter> siteMeshFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        siteMeshFilterFilterRegistrationBean.setFilter(new SiteMeshFilter());
        siteMeshFilterFilterRegistrationBean.addUrlPatterns("/*");
        return siteMeshFilterFilterRegistrationBean;
    }

    @Bean
    @Order(2)
    public FilterRegistrationBean strutsPrepareAndExecuteFilter() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> strutsPrepareAndExecuteFilter = new FilterRegistrationBean<>();
        strutsPrepareAndExecuteFilter.setFilter(new StrutsPrepareAndExecuteFilter());
        strutsPrepareAndExecuteFilter.addUrlPatterns("/", "/addUserForm.action", "/addUser.action", "/findUserForm.action", "/findUser.action", "/listAllUsers.action");
        strutsPrepareAndExecuteFilter.addInitParameter("actionPackages", "com.lq");
        return strutsPrepareAndExecuteFilter;
    }
}
