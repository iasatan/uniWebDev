package hu.me.lev.web;

import hu.me.lev.persist.EmployeeDAO;
import hu.me.lev.persist.inmemory.EmployeeDAOImpl;
import hu.me.lev.service.EmployeeService;
import hu.me.lev.service.impl.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "hu.me.lev.controller")
public class EmployeeApplicationContext extends WebMvcConfigurerAdapter {
    @Bean
    public EmployeeService employeeService() {
        return new EmployeeServiceImpl(employeeDAO());
    }

    @Bean(name = "EmployeeDAO")
    public EmployeeDAO employeeDAO() {
        return new EmployeeDAOImpl();
    }
}
