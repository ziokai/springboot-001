package com.zou.system;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author 你好
 */
@Configuration
@MapperScan(basePackages = DataSourceConfiguration.PACKAGE, sqlSessionFactoryRef = DataSourceConfiguration.NAME + "SqlSessionFactory")
public class DataSourceConfiguration {

    static final String NAME = "zou";
    private static final String PREFIX = "druid." + NAME;
    static final String MAPPER_LOCATION = "classpath:mybatis/" + NAME + "/*.xml";
    static final String PACKAGE = "com.zou.dao." + NAME;
    static final String ENTITY = "com.zou.bean." + NAME;

    /**
     * druid 数据源 (加载 application.yml druid.example 配置)
     *
     * @return DataSource 数据源
     * @title druidDataSource
     * @date 2018年8月14日 下午5:05:47
     */
    @Bean(name = NAME + "DataSource")
    @ConfigurationProperties(prefix = PREFIX)
    @Primary
    public DataSource druidDataSource() {
        DruidDataSource temp  = new DruidDataSource();
        System.out.println(temp.getUsername());
        System.out.println("===========");
        return temp;
    }

    @Bean(name = NAME + "SqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier(NAME + "DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));
        bean.setTypeAliasesPackage(ENTITY);
        return bean.getObject();
    }

    @Bean(name = NAME + "TransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier(NAME + "DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = NAME + "SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(NAME + "SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
