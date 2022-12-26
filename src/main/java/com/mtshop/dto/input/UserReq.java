package com.mtshop.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.mtshop.dto.AbstractDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserReq extends AbstractDto<UserReq>{
	
	@NotNull(message = "firstname shouldn't be null")
	private String firstname;
	@NotNull(message = "lastname shouldn't be null")
	private String lastname;
	@Email(message = "Email invalid")
	private String email;
	@Pattern(regexp = "^\\d{10}$", message = "invalid phone number")
	private String phone;
	private String password;
	private String avatar;
}
