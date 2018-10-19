package com.hrsys.common.util;

import java.util.Random;

public class RandomNum {
	public int getRandomNum(int max,int min){
		Random random = new Random();//获取随机数[0,max]
		int randomNum = random.nextInt(max)%(max-min+1) + min;
		
		return randomNum;
	}
	
}
