package com.douzone.container.config.videosystem.mixing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.douzone.container.videosystem.DVDPlayer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {DVDPlayerConfig.class})
public class DVDPlayerMixingConfigTest01 {
	@Autowired
	private DVDPlayer dvdPlayer;
	
	@Test
	public void testDVDPlay() {
		System.out.println( dvdPlayer.play());
		assertEquals("Playing Movie MARVEL's Infinity War", dvdPlayer.play());
	
	}
}
