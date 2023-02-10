package com.douzone.container.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.douzone.container.config.videosystem.DVDPlayerConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {DVDPlayerConfig.class})
public class DVDPlayerJavaConfigTest {
	
	// 같은 타입의 빈이 2개 이상 있는 경우
	// 설정 클래스의 빈생성 메소드의 @Bean의 name(default)의 속성으로 Qualifier 하기 
	@Qualifier("dvdPlayer")
	@Autowired()
	private DVDPlayer dvdPlayer01;
	
	// 같은 타입의 빈이 2개 이상 있는 경우
	// 설정 클래스의 빈생성 메소드의 이름으로 Qualifier 하기 
	@Qualifier("dvdPlayer02")
	@Autowired()
	private DVDPlayer dvdPlayer02;

	@Qualifier("dvdPlayer03")
	@Autowired()
	private DVDPlayer dvdPlayer03;

	@Test
	public void testDVDPlayer01NotNull() {
		assertNotNull(dvdPlayer01);
	}
	
	@Test
	public void testDVDPlayer02NotNull() {
		assertNotNull(dvdPlayer02);
	}
	
	@Test
	public void testDVDPlayer03NotNull() {
		assertNotNull(dvdPlayer03);
	}
	
	@Test
	public void testPlay() {
		assertEquals("Playing Movie MARVEL's Avengers", dvdPlayer03.play()); 
	}
}
