package com.callor.iolist.models;

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
public class IolistVO {

	private String io_seq;
	private String io_date;
	private String io_time;
	private String io_input;
	private String io_pname;
	private String io_price;
	private String io_quan;
	private String io_total;
	

	public int getIprice() {
		int iprice = 0;

		if ("1".equals(io_input)) {
			iprice = Integer.valueOf(io_price);
			return iprice;
		} else {
			return 0;
		}
	}

	public int getOprice() {
		int oprice = 0;

		if ("2".equals(io_input)) {
			oprice = Integer.valueOf(io_price);
			return oprice;
		} else {
			return 0;
		}
	}

	public int getQuan() {
		int quan = 0;
		quan = Integer.valueOf(io_quan);
		return quan;
	}

}
