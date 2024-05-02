
package com.callor.gallery.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {

	private String	username	;
	private String	password	;
	private String	email	;
	private String	tel	;

	
	
}
