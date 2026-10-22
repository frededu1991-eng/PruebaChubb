package com.chubb.test.respository;

import java.util.List;

import com.chubb.test.model.Client;

public interface IClientRepository {
	
  public List<Client> findAll(); 
  public int  save(Client client);

   public   boolean existsById(Long id);
   public  int deleteById(Long id);
  
}
