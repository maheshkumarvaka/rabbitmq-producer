package com.maheshkumarvaka.rabbitmqconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Programmer {
	private String name;
	private String skill;
	private Integer yearsOfExperience;
	
}
