package br.com.upf.vini.connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class PoolDBConfig {
	@Bean(name = "ifood")
	@ConfigurationProperties(prefix = "pool-connection.ifood.datasource")
	public DataSource ifoodDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "ifood_template")
	public JdbcTemplate ifoodjdbcTemplate(@Qualifier("ifood") DataSource ds) {
		return new JdbcTemplate(ds);
	}

}
