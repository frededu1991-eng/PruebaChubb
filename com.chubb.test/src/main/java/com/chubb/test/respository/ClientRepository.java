package com.chubb.test.respository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chubb.test.model.Client;

@Repository
public class ClientRepository implements IClientRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Client> findAll() {
		return jdbcTemplate.query("select id,first_name,last_name,surname,phone from clients", BeanPropertyRowMapper.newInstance(Client.class));
	}

	@Override
	public int save(Client client) {		
		return jdbcTemplate.update("insert into clients values (?, ?, ?, ?)", new Object[] {client.getFirstName(), client.getLastName(), client.getSurname(), client.getPhone()});
	}
@Override
	public int deleteById(Long id) {
    return jdbcTemplate.update("DELETE FROM clients WHERE id = ?", new Object[] { id });
}

@Override
public boolean existsById(Long id) {
    Integer count = jdbcTemplate.queryForObject(
        "SELECT COUNT(*) FROM clients WHERE id = ?", 
        new Object[] { id }, 
        Integer.class
    );
    
    // Retorna true si el conteo es mayor a 0, de lo contrario false
    return count != null && count > 0;
}



	

}
