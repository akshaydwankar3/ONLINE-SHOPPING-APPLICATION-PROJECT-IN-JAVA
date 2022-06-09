package com.masai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	 @Column(name = "email")
	@Email(message = "Email is not valid")
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	
	@Column(name = "mobile")
	@Size(min=10, max=10,message="Mobile number shuld be 10 digit.. ")
	private String mobile;
	
	@Column(name = "username")
	@NotBlank(message="username is mandatory")
	private String username;
	
	@Column(name = "password")
	@NotBlank(message="password is mandatory")
	private String password;
	
//	@Transient
//	private String confirmPassword;
	
	//private boolean signup;
}
