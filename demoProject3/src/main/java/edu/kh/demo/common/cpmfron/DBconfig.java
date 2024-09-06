package edu.kh.demo.common.cpmfron;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/* @configuratiom 어노테이션
 * - 서버 실행 시 자동으로 객체로 만들어져
 *   내부에 작성된 메서드를 실행 하게함
 * 
 * 
 * @Bean
 * - 메서드 수행 결과로 반환 객체들을 bean으로 등록함
 *  + 메서드 내부 코드 == bean 설정 코드
 */

@Configuration
@PropertySource("classpath:/config.properties")
public class DBconfig {

	@Autowired
	private ApplicationContext applicationContext;
	//@Bean
	// - 개발자가 수동으로 bean을 등록하는 어노테이션
	// - @Bean 어노테이션이 작성된 메서드에서 반환된 객체는
	// Spring Container가 관리함(IOC)
	
	
	@Bean
	// @ConfigurationProperties(prefix = "spring.datasource.hikari")
	// properties 파일의 내용을 이용해서 생성되는 bean을 설정하는 어노테이션
	// prefix를 지정하여 spring.datasource.hikari으로 시작하는 설정을 모두 적용
	
	
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
	return new HikariConfig();
	}
	
	
	@Bean
	public DataSource dataSource(HikariConfig config) {
	DataSource dataSource = new HikariDataSource(config);
	return dataSource;
	
	}

	
	////////////////////////////Mybatis 설정 추가 ////////////////////////////
		
	// sqlSession : DB연결 + SQL파일 위치 등록 + 마이바티스 설정 적용 + 클래스 별칭 등록
	
	// SqlSessionFactory : SqlSession을 만드는 객체 
	@Bean
	public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception {
	SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
	
	sessionFactoryBean.setDataSource(dataSource);
	
	// 매퍼 파일이 모여있는 경로 지정
	sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**.xml"));
	
	// 별칭을 지정해야하는 DTO가 모여있는 패키지 지정
	// -> 해당 패키지에 있는 모든 클래스가 클래스명으로 별칭이 지정됨
	sessionFactoryBean.setTypeAliasesPackage("edu.kh.demo");
	
	// 별칭 지정 전 -> edu.kh.demo.dto.User 라고 작성
	// 별칭 지정 후 -> User
	
	// 마이바티스 설정 파일 경로 지정
	sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
	
	// SqlSession 객체 반환
	return sessionFactoryBean.getObject();
	}
	
	// SqlSessionTemplate :  기본 SQL 실행 + 트랜잭션 처리
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sessionFactory) {
	return new SqlSessionTemplate(sessionFactory);
	}
	
	// DataSourceTransactionManager : 트랜잭션 매니저
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
	return new DataSourceTransactionManager(dataSource);
	}


/*  ** DB 연결 설정 순서
 * 
 * 1) config.properties 내용을 읽어와
 *   HikariConfig Bean 등록
 * 
 * 2) HikariConfig Bean을 이용해서
 *    DataSoruce(Java DBCP 사용을 위한 인터페이스) Bean 등록
 *    
 * 3) DataSoruce Bean을 이용해서
 *    DataSoruceTransactionManager Bean 등록
 *    (DBCP을 이용해서 SQL 수행 사 트랜잭션 처리를 관리)
 *    
 * 4) DataSoruce + mapper파일 + mybatis-config.xml 파일을 이용해
 *    SqlSessionFactory Bean 등록
 *    ( DB연결 + SQL파일 위치 등록 + 마이바티스 설정 적용 + 클래스 별칭 등록)
 *    
 * 5) SqlSessionFactory 이용해
 *    sqlSessionTemplate Bean 등록
 *    ( DB연결 + 마이바티스 기능 사용 
 *      + Spring 제공 트랜잭션 관련 어노테이션 사용 가능)
 */





}
