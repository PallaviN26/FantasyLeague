package fantasy;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@Configuration
@EntityScan(basePackages = {"fantasy.model"})
public class FantasyApplication {
	public static void main(String[] args) {
		SpringApplication.run(FantasyApplication.class, args);

	}
	
	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUsername("npallavi");
	    dataSource.setPassword("Pallavi26");
	    dataSource.setUrl(
	      "jdbc:oracle:thin:@localhost:1521:xe"); 
	    
	    return dataSource;
	}
	
}
