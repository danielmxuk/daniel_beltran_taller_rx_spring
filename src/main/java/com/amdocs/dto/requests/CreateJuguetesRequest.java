/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 16, 2019
 */
package com.amdocs.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 16, 2019
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateJuguetesRequest {

	private String id;
	private String name;
	
}
