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
public class OrdersVO {

	private String o_num; // varchar(6) NO PRI
	private String o_date; // varchar(10) NO
	private String o_ccode; // varchar(5) YES MUL
}
