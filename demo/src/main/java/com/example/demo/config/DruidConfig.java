//package com.example.demo.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.Properties;
//
//
//@Configuration
//public class DruidConfig {
//
//    private Logger logger = LoggerFactory.getLogger(DruidConfig.class);
//    @Value("${spring.druid.datasource.type}")
//    private String type;
//    @Value("${spring.druid.datasource.driverClassName}")
//    private String driverClassName;
//    @Value("${spring.druid.datasource.url}")
//    private String url;
//    @Value("${spring.druid.datasource.username}")
//    private String username;
//    @Value("${spring.druid.datasource.password}")
//    private String password;
//    @Value("${spring.druid.datasource.initialSize}")
//    private Integer initialSize;
//    @Value("${spring.druid.datasource.minIdle}")
//    private Integer minIdle;
//    @Value("${spring.druid.datasource.maxActive}")
//    private Integer maxActive;
//    @Value("${spring.druid.datasource.maxWait}")
//    private Long maxWait;
//    @Value("${spring.druid.datasource.timeBetweenEvictionRunsMillis}")
//    private Long timeBetweenEvictionRunsMillis;
//    @Value("${spring.druid.datasource.minEvictableIdleTimeMillis}")
//    private Long minEvictableIdleTimeMillis;
//    @Value("${spring.druid.datasource.validationQuery}")
//    private String validationQuery;
//    @Value("${spring.druid.datasource.testWhileIdle}")
//    private boolean testWhileIdle;
//    @Value("${spring.druid.datasource.testOnBorrow}")
//    private boolean testOnBorrow;
//    @Value("${spring.druid.datasource.testOnReturn}")
//    private boolean testOnReturn;
//
//    @Value("${spring.druid.datasource.poolPreparedStatements}")
//    private boolean poolPreparedStatements;
//    @Value("${spring.druid.datasource.maxPoolPreparedStatementPerConnectionSize}")
//    private Integer maxPoolPreparedStatementPerConnectionSize;
//
//    @Value("${spring.druid.datasource.filters}")
//    private String filters;
//    @Value("${spring.druid.datasource.connectionProperties}")
//    private String connectionProperties;
//    @Value("${spring.druid.datasource.useGlobalDataSourceStat}")
//    private boolean useGlobalDataSourceStat;
//
//
//
//
//
//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        ServletRegistrationBean reg = new ServletRegistrationBean();
//        reg.setServlet(new StatViewServlet());
//        reg.addUrlMappings("/druid/*");
//        reg.addInitParameter("loginUsername", "admin");
//        reg.addInitParameter("loginPassword", "123");
//        reg.addInitParameter("logSlowSql", "True");
//        return reg;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        filterRegistrationBean.addInitParameter("profileEnable", "true");
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    @ConfigurationProperties
//    public DruidDataSource dataSource() throws Exception{
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setMaxActive(maxActive);
//        dataSource.setMaxWait(maxWait);
//        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//
//        if (validationQuery != null && !"".equals(validationQuery)) {
//            dataSource.setValidationQuery(validationQuery);
//        }
//        dataSource.setTestWhileIdle(testWhileIdle);
//        dataSource.setTestOnBorrow(testOnBorrow);
//        dataSource.setTestOnReturn(testOnReturn);
//        if(poolPreparedStatements){
//            dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        }
//        dataSource.setFilters(filters);//这是最关键的,否则SQL监控无法生效
//        String connectionPropertiesStr = connectionProperties;
//        if(connectionPropertiesStr != null && !"".equals(connectionPropertiesStr)){
//            Properties connectProperties = new Properties();
//            String[] propertiesList = connectionPropertiesStr.split(";");
//            for(String propertiesTmp:propertiesList){
//                String[] obj = propertiesTmp.split("=");
//                String key = obj[0];
//                String value = obj[1];
//                connectProperties.put(key,value);
//            }
//            dataSource.setConnectProperties(connectProperties);
//        }
//        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
//
//        return dataSource;
//    }
//
//
//}