package ru.spbstu.telematics.java.lab1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	lsPrinter lser = new lsPrinter();
        lser.printLs("/");
        normalRandomer rnd = new normalRandomer();
        System.out.println(rnd.getRandom(Double.NaN, Double.NaN));
    }
}
