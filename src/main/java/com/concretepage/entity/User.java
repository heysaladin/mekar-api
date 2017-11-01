package com.concretepage.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
    private int userId;
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="sex")
	private String sex;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {return sex;}
	public void setSex(String sex) {
		this.sex = sex;
	}
} 