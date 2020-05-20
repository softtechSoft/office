package softtech.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class comService {

	@Autowired
    public JdbcTemplate jdbcTemplate;
	
	// DBの他の処理等
}

