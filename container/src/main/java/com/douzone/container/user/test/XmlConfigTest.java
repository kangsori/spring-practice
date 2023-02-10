package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Configuragion (Annotation Scanning)
		//testBeanFactory01();
		
		// XML Bean Configuragion (Explicit Configuration)
		//testBeanFactory02();
		
		// XML Auto Configuragion (Annotation Scanning)
		//testApplicationContext01();
		
		// XML Bean Configuragion (Explicit Configuration)
		testApplicationContext02();

	}
	
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext02.xml");
		
		User user = null;
		
		//id로 빈 가져오기 (명시적 빈 생성은 아이디를 부여해주어야 한다 )
		user = (User)ac.getBean("user");
		System.out.println(user.getName());
		
		//name으로 빈 가져오기 
		user = (User)ac.getBean("usr");
		System.out.println(user.getName());
		
		//type으로 빈 가져오기 (캐스팅 안해줘도됨)
		//같은 타입의 빈이 2개이상 있으면 타입으로 가져오기 실패 
		//1.id + type
		//2.name + type
		user = ac.getBean("user2",User.class);
		System.out.println(user);
		
		//파라미터 두개인 생성자로 생성된 빈1 가져오기 
		user = ac.getBean("user3",User.class);
		System.out.println(user);
		
		//파라미터 두개인 생성자로 생성된 빈2 가져오기 
		user = ac.getBean("user4",User.class);
		System.out.println(user);
		
		//setter를 사용한 빈 가져오기 
		user = ac.getBean("user5",User.class);
		System.out.println(user);
		
		//setter를 사용한 빈 가져오기2 (DI)
		user = ac.getBean("user6",User.class);
		System.out.println(user);
		
		//setter를 사용한 빈 가져오기3 (Collection Property) 
		user = ac.getBean("user7",User.class);
		System.out.println(user);
		
	}
	
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext01.xml");
		
		User user = null;
		
		// 타입으로 들고오기 
		user = ac.getBean(User.class);
	    System.out.println(user.getName());
	    
	    // Annotation Scan 설정에서는 Bean ID가 자동으로 부여됨 
	    user = (User)ac.getBean("user");
	    System.out.println(user.getName());
	}
	

	private static void testBeanFactory01() {
		//내가 빈팩토리를 만들겠다 저기에 있는 파일로 
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));
		
		//유저라는 타입의 빈을 줘
		User user = bf.getBean(User.class);
	    System.out.println(user.getName());
	}
	
	private static void testBeanFactory02() {
		//내가 빈팩토리를 만들겠다 저기에 있는 파일로 
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));
		
		//유저라는 타입의 빈을 줘
		User user = bf.getBean(User.class);
	    System.out.println(user.getName());
	}

}
