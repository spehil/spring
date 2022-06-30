package com.exam.core;

import org.springframework.stereotype.Component;

//@Component("mse")
public class MyServiceEn implements MyService {

	@Override
	public String getHelloMsg() {
		// TODO Auto-generated method stub
		return "Hello";
	}

	@Override
	public String getByeMsg() {
		// TODO Auto-generated method stub
		return "Bye";
	}

}
