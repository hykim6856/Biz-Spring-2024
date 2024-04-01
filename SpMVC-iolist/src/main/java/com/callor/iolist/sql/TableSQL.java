package com.callor.iolist.sql;

public class TableSQL {

	public final static String ORDER_CUSTOM = " select * " 
			+ " from tbl_orders O " 
			+ " Join tbl_customer C "
			+ " ON O.o_ccode = c.c_code " 
			+ " ORDER BY O.o_num ";

}
