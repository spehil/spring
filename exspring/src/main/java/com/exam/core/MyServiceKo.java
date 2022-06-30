package com.exam.core;

import org.springframework.stereotype.Component;

@Component("msk")
public class MyServiceKo implements MyService {

	@Override
	public String getHelloMsg() {
		// TODO Auto-generated method stub
		return "안녕하세요";
	}

	@Override
	public String getByeMsg() {
		// TODO Auto-generated method stub
		return "안녕히가세요";
	}

}
