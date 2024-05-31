package com.callor.book.models.naver;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class NBooks {

	public String lastBuildDate;
	public String total;
	public List<NBookVO> items;
}
