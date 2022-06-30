package com.exam.exspring;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HelloController {
	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public String hello( MyValue  mv, Map map) {
		mv.setSum(mv.getX() + mv.getY());
		
		map.put("now", new Date());
		
		
		return "hw/hello";//hello.jsp경로 
		
	} 
	//http://localhost:8000/exspring/hello.do?x=3&y=4
	//로 요청을 보내면, 
	//화면에 
	//계산결과 : 3+4=7
	// 현재서버시간 : 2022년 6월 9일 16시 01분 (javascript가 아니라 Java로 현재서버시간 구현해야함.)
	//라고 출력되도록 구현 
	//파라미터 값은 MyValue 객체의 sum 변수에 저장
	// 출력은 hello.jsp 파일에서!

}
