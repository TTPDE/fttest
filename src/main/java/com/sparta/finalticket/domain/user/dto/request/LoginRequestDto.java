package com.sparta.finalticket.domain.user.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {

	private String username;
	private String password;
}