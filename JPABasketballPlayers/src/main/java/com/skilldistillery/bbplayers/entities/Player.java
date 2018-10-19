package com.skilldistillery.bbplayers.entities;

import javax.persistence.*;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	
	private String position;
	
	private int age;
	
	private String team;
	
	private String nationality;
	
	
	
}
