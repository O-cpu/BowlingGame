package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BowlingApplicationTests {

	@Test
	void fierstExample() {
		int[] rolls = {1,4,4,5,6,4,5,5,10,0,0,1,7,3,6,4,10,0,2,8,6};
		int[] expectedResult = {5,14,29,49,60,61,77,97,117,133};
		Assert.assertArrayEquals(expectedResult, BowlingGame.getResult(rolls));
	}

	@Test
	void maximim() {
		int[] rolls = {10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,10,10};
		int[] expectedResult = {30,60,90,120,150,180,210,240,270,300};
		Assert.assertArrayEquals(expectedResult, BowlingGame.getResult(rolls));
	}

	@Test
	void zero() {
		int[] rolls = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] expectedResult = {0,0,0,0,0,0,0,0,0,0};
		Assert.assertArrayEquals(expectedResult, BowlingGame.getResult(rolls));
	}

}
