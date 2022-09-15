package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BowlingApplicationTests {

	@Test
	void contextLoads() {
		int[] rolls = {1,4,4,5,6,4,5,5,0,10,0,1,7,3,6,4,0,10,2,8,6};
		int[] expectedResult = {5,14,29,49,60,61,77,97,117,133};
		Assert.assertArrayEquals(expectedResult, BowlingGame.getResult(rolls));

	}

}
