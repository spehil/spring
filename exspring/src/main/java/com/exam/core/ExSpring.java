package com.exam.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExSpring {

	public static void main(String[] args) {
//	   MyApp ma = new MyApp();
//	   ma.setMyService( new MyServiceKo());
//	   ma.say();
		
//		스프링컨데이터(스프링의 본체라고 생각하면됨. 객체를 만들어서가지고있음(객체목록)) : 객체를 생성하여 저장 
//		com/exam/core/context.xml 설정파일의 내용대로 스프링컨테이너를 생성
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/exam/core/context.xml");
//      MyConfig.class 설정파일의 내용대로  스프링컨테이너 
//		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        MyApp app= (MyApp) context.getBean("ma"); //ma라는 이름으로 등록된 객체를 가져오기
        app.say();
        
        for (String bn : context.getBeanDefinitionNames()) {
        	System.out.println(bn+ " : "+ context.getBean(bn).getClass().getName());
        }
	}

}
