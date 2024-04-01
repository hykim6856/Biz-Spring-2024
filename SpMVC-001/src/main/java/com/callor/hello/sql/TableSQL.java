package com.callor.hello.sql;

public class TableSQL {

	public final static String IO_LIST = 
			"SELECT io_seq, io_date, io_time, io_pname, "
			+ " CASE WHEN io_input = '1' THEN io_price  END AS io_iprice, "
			+ " CASE WHEN io_input = '2' THEN io_price END AS io_oprice, " 
			+ " io_quan" + "FROM tbl_iolist ";

}
