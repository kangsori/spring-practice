package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Configuragion (Annotation Scan)
		testBeanFactory01();

	}

	private static void testBeanFactory01() {
		//내가 빈팩토리를 만들겠다 저기에 있는 파일로 
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext.xml"));
		
		//유저라는 타입의 빈을 줘
		User user = bf.getBean(User.class);
	    System.out.println(user.getName());
		
	}

}
