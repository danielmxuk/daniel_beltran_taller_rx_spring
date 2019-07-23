/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 16, 2019
 */
package com.amdocs.services;

import java.util.List;

import com.amdocs.dto.requests.CreateJuguetesRequest;
import com.amdocs.entity.JuguetesEntity;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 16, 2019
 */
public interface JuguetesService {

	List<JuguetesEntity> getAllJuguetes();
	
	JuguetesEntity getJugueteById(String Id);
	
	String createJuguete(CreateJuguetesRequest createJuguetesRequest);
	
	boolean updateJuguete(CreateJuguetesRequest createJuguetesRequest);
	
	boolean deleteJuguete(String Id);
	
}
