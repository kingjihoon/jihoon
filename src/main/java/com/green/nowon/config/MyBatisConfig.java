package com.green.nowon.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@MapperScan("com.green.nowon.mapper") //패키지하위의 인터페이스를 매퍼로 적용
@Configuration
public class MyBatisConfig {
	@Autowired
	private ApplicationContext application;

	@Bean
	 DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	@Bean
	 HikariConfig hikariConfig() {
		return new HikariConfig();

	}

	@Bean
	 SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		// In MyBatis-Spring, an SqlSessionFactoryBean is used to create an
		// SqlSessionFactory
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());//dataSource Bean 세팅
		factoryBean.setConfiguration(mybatisConfiguration());//mybatis추가설정정보세팅
		
		String locationPattern="classpath:/static/mapper/**/*-mapper.xml";
		Resource[] mapperLocations=application.getResources(locationPattern);
		factoryBean.setMapperLocations(mapperLocations);
		factoryBean.setConfiguration(mybatisConfiguration()); //추가
		return factoryBean.getObject();
	}
	//현재파일에 Configuration 클래스가 2개 사용하므로 패키지경로부터 org.apache.ibatis.session.Configuration 사용
	@Bean
	@ConfigurationProperties(prefix="mybatis.configuration")
	 org.apache.ibatis.session.Configuration mybatisConfiguration() {
		return new org.apache.ibatis.session.Configuration();
	}

	//http://mybatis.org/spring/sqlsession.html#SqlSessionTemplate : SqlSession 사용 가이드 참조
	@Bean
	  public SqlSessionTemplate sqlSession(DataSource dataSource) throws Exception {
	    return new SqlSessionTemplate(sqlSessionFactory(dataSource));
	  }
}