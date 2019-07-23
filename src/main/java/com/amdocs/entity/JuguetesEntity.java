/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 16, 2019
 */
package com.amdocs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 16, 2019
 */

@Entity
@Table(name = "Juguetes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JuguetesEntity {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;
}
