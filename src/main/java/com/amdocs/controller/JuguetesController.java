/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 22, 2019
 */
package com.amdocs.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.dto.requests.CreateJuguetesRequest;
import com.amdocs.dto.responses.BaseWebResponse;
import com.amdocs.entity.JuguetesEntity;
import com.amdocs.services.JuguetesService;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 22, 2019
 */

@RestController
@RequestMapping( value = "/api/juguetes" )
public class JuguetesController {
	
	@Autowired
	private JuguetesService juguetesService;
	
	
	@GetMapping( value="/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getTest() {
        return "Hola hola!!!";
    }
	
	
	@GetMapping( value="/getAllJuguetes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseWebResponse<List<JuguetesEntity>>> getAllJuguetes() {
        return ResponseEntity.ok( BaseWebResponse.successWithData( juguetesService.getAllJuguetes() ) );
    }
	
	
	@GetMapping( value="/getJuguete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseWebResponse<JuguetesEntity>> getJugueteById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok( BaseWebResponse.successWithData( juguetesService.getJugueteById(id) ) );
    }

	
	@PostMapping( value="/creaJuguete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseWebResponse<String>> creaJuguete(@RequestBody CreateJuguetesRequest createJuguetesRequest){
		
		String jugueteEntryId = juguetesService.createJuguete(createJuguetesRequest);
		
		return ResponseEntity.created( URI.create("/api/juguetes/" + jugueteEntryId) )
				.body( BaseWebResponse.successWithData(jugueteEntryId) );
	}
	
	
	@PatchMapping( value="/updateJuguete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseWebResponse> updateJugueteById(@PathVariable(value = "id") String id, @RequestBody CreateJuguetesRequest createJuguetesRequest) {
		createJuguetesRequest.setId(id);
		juguetesService.updateJuguete(createJuguetesRequest);
		
		return ResponseEntity.ok( BaseWebResponse.successWithoutData() );
    }
	
	
	@DeleteMapping( value="/deleteJuguete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseWebResponse> deleteJugueteById(@PathVariable(value = "id") String id) {
        
		juguetesService.deleteJuguete(id);
		
		return ResponseEntity.ok( BaseWebResponse.successWithoutData() );
    }
	
}
