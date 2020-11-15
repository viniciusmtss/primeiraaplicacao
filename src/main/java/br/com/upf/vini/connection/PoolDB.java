package br.com.upf.vini.connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class PoolDB {
	@Autowired
	@Qualifier("ifood_template")
	private JdbcTemplate ifood;

	public JdbcTemplate jdbcIfood() {
		return ifood;
	}

}
