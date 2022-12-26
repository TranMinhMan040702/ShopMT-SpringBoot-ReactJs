package com.mtshop.dto.output;

import com.mtshop.dto.AbstractDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserResp extends AbstractDto<UserResp>{
	
	private String firstname;
	private String lastname;
	private String idCard;
	private String email;
	private String phone;
	private String avatar;

}
