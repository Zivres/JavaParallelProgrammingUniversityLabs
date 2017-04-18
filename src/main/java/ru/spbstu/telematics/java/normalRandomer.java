package ru.spbstu.telematics.java;

import java.util.Random;

public class normalRandomer {
	double getRandom(double mean, double stdDev){
		return new Random().nextGaussian()*stdDev+mean;
	}
}
