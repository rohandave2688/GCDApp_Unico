package org.unico.gcd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Object Argument persistence class
 */

@Entity
public class Arguments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int argument1;
	
	private int argument2;

	public Arguments(){
		
	}
	
	public Arguments(int argument1, int argument2){
		this.argument1 = argument1;
		this.argument2 = argument2;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArgument1() {
		return argument1;
	}

	public void setArgument1(int argument1) {
		this.argument1 = argument1;
	}

	public int getArgument2() {
		return argument2;
	}

	public void setArgument2(int argument2) {
		this.argument2 = argument2;
	}

	
	
	
}