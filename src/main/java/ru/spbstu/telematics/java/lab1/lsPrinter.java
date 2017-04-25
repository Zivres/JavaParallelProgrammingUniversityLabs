package ru.spbstu.telematics.java.lab1;

import java.io.File;

public class lsPrinter {
	void printLs(String path){
		try{
			File[] folderEntries = new File(path).listFiles();
			for (File f : folderEntries)
				System.out.println(f);
		}
		catch(NullPointerException e){
			System.err.println(e+": invalid path.");
		}
	}
}
