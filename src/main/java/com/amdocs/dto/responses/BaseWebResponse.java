/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 16, 2019
 */
package com.amdocs.dto.responses;

import lombok.Builder;
import lombok.Getter;

/**
 * @Description: 
 * @Author: Daniel Beltran (db077a)
 * @Date: Jul 16, 2019
 */

@Getter
@Builder
public class BaseWebResponse<T> {

	private T data;
	
	public static BaseWebResponse successWithoutData() {
		return BaseWebResponse.builder()
				.build();
	}
	
	public static <T> BaseWebResponse<T> successWithData(T data) {
		return BaseWebResponse.<T>builder()
				.data(data)
				.build();
	}
}
