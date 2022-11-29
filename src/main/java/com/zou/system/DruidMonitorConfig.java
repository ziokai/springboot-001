
package com.zou.system;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 你好
 */
@Configuration
public class DruidMonitorConfig {
    @Value("${druid.loginUsername}")
    private String loginUsername;
    @Value("${druid.loginPassword}")
    private String loginPassword;

    @Bean

    public ServletRegistrationBean<StatViewServlet> druidServlet() {
        ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<>();
        reg.setServlet(new StatViewServlet());
        // 登录URL
        reg.addUrlMappings("/druid/*");
        // 设置白名单
        reg.addInitParameter("allow", "");
        // 设置黑名单
        reg.addInitParameter("deny", "");
        // 设置登录查看信息的账号密码.
        reg.addInitParameter("loginUsername", loginUsername);
        reg.addInitParameter("loginPassword", loginPassword);
        return reg;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
