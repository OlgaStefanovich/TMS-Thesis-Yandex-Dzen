package by.dzen;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "by.dzen")
public class WebConfiguration implements ApplicationContextAware, WebMvcConfigurer {

    private ApplicationContext applicationContext;
    private  HikariDataSource ds;

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/pages/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


//    @Bean
//    public HikariCPDataSource hikariCPDataSource() {
//        HikariCPDataSource hikariCPDataSource = new HikariCPDataSource();
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
//        config.setUsername("postgres");
//        config.setPassword("Vorobei55");
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//        HikariDataSource ds = new HikariDataSource(config);
//        return hikariCPDataSource;
//    }

//    @Bean
//    @Scope(value = "prototype")
//    public Connection getConnection(HikariCPDataSource hikariCPDataSource) throws SQLException {
//        return ds.getConnection();
//    }

//    @Bean
//    public ComboPooledDataSource dataSource() {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        try {
//            dataSource.setDriverClass("org.postgresql.Driver");
//            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
//            dataSource.setUser("postgres");
//            dataSource.setPassword("Vorobei55");
//
//            Properties properties = new Properties();
//            properties.setProperty("user", "postgres");
//            properties.setProperty("password", "Vorobei55");
//            properties.setProperty("useUnicode", "true");
//            properties.setProperty("characterEncoding", "UTF8");
//            dataSource.setProperties(properties);
//
//            // set options:
//            dataSource.setMaxStatements(180);
//            dataSource.setMaxStatementsPerConnection(180);
//            dataSource.setMinPoolSize(50);
//            dataSource.setAcquireIncrement(10);
//            dataSource.setMaxPoolSize(60);
//            dataSource.setMaxIdleTime(30);
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }
//
//    @Scope(value = "prototype")
//    @Bean
//    public Connection connection(ComboPooledDataSource dataSource) {
//        try {
//             return dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
