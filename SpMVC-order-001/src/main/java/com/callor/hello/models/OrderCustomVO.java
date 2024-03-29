package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCustomVO {
/*
 *  주문과 고객 정보를 join 하여 리스트를 확인 하기 위한 data class
 */
	

		private String o_num; // varchar(6) NO PRI
		private String o_date; // varchar(10) NO
		private String o_ccode; // varchar(5) YES MUL
		
		private String c_code;//	varchar(5)	NO	PRI		
		private String c_name;//	varchar(25)	NO	MUL		
		private String c_tel;//	varchar(15)	NO	MUL		

	
}
