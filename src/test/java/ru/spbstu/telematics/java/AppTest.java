package ru.spbstu.telematics.java;


import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class AppTest
{
	@Test
	public void rndNotNull(){
		normalRandomer rndGen=new normalRandomer();
		Assert.assertNotNull(rndGen.getRandom(new Random().nextDouble(),new Random().nextDouble()));
	}
	@Test
	public void rndIfinityNaN(){
		normalRandomer rndGen=new normalRandomer();
		Assert.assertEquals(Double.NaN, rndGen.getRandom(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY),0);
	}
	@Test
	public void rndNaNNaN(){
		normalRandomer rndGen=new normalRandomer();
		Assert.assertEquals(Double.NaN, rndGen.getRandom(Double.NaN,Double.NaN),0);
	}
}
