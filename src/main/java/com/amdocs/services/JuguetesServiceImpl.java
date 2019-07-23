/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 16, 2019
 */
package com.amdocs.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.dto.requests.CreateJuguetesRequest;
import com.amdocs.entity.JuguetesEntity;
import com.amdocs.repository.JuguetesRepository;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 16, 2019
 */

@Service
public class JuguetesServiceImpl implements JuguetesService {

	@Autowired
	private JuguetesRepository juguetesRepository;
	
	@Override
	public List<JuguetesEntity> getAllJuguetes(){
		
		return juguetesRepository.findAll();
	}
	
	@Override
	public JuguetesEntity getJugueteById(String id){
		
		Optional<JuguetesEntity> optionalJuguete = juguetesRepository.findById( id );
		
		if(optionalJuguete.isPresent()) {
		
			return optionalJuguete.get();
			
		}else {
			return null;
		}
	}
	
	@Override
	public String createJuguete(CreateJuguetesRequest createJuguetesRequest) {
		
		return juguetesRepository.save( convertToJuguetesEntity(createJuguetesRequest) ).getId();
	}
	
	@Override
	public boolean updateJuguete(CreateJuguetesRequest createJuguetesRequest) {
		
		Optional<JuguetesEntity> optionalJuguete = juguetesRepository.findById( createJuguetesRequest.getId() );
		
		if(optionalJuguete.isPresent()) {
			
			JuguetesEntity juguete = optionalJuguete.get();
			juguete.setName( createJuguetesRequest.getName() );
			
			juguetesRepository.save(juguete);
			
			return true;
			
		}else {
			return false;
		}
	}
	
	@Override
	public boolean deleteJuguete(String id) {
		
		Optional<JuguetesEntity> optionalJuguete = juguetesRepository.findById( id );
		
		if(optionalJuguete.isPresent()) {
			
			juguetesRepository.delete( optionalJuguete.get() );
			
			return true;
			
		}else {
			return false;
		}
	}

	private JuguetesEntity convertToJuguetesEntity(CreateJuguetesRequest createJuguetesRequest) {
		JuguetesEntity juguete = new JuguetesEntity();
		
		BeanUtils.copyProperties(createJuguetesRequest, juguete);
		
		juguete.setId( UUID.randomUUID().toString() );
		
		return juguete;
	}
}
