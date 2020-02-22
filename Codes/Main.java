package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;


public class Main {

	
	
	public static void main(String[] args) {		
		int demo []=new int[16];
		String doutput="16.txt";
		takeinput(demo, doutput);
		System.out.println("Array before sort");
		for (int i = 0; i < demo.length; i++) {
	
			System.out.printf(" %d ",demo[i]);
		}
		
		int t []=new int[16];
		Radix.sort(demo, t, 3, 0, 10, 10);
		System.out.println();
		System.out.println("Array after sort");
		for (int i = 0; i < demo.length; i++) {
			
			System.out.printf(" %d ",demo[i]);
		}
		System.out.println();
		System.out.println();
		for(int i =16; i<=16777216; i=i*16) {
			int size=i;
		
			int p5=10;
			String file = i+".txt";
			int array[] = new int[size];
			int temp[]=new int[size];
			takeinput(array, file);
			if(i==1048576) {
				
				p5=11;
			}
			if(i==16777216) {
				
				p5=17;
			}
			long start = System.nanoTime();
			Radix.sort(array,temp,3,0,p5,10);
			long end = System.nanoTime();
			long elapsed = end-start;
			System.out.println("It takes "+ elapsed+" nanoseconds to sort "+size+" elements with single threading with using Radix sort" );
			
			takeinput(array, file);
			

			long start1 = System.nanoTime();
			Radix.sort(array,temp,3,1,p5,10);
			long end1 = System.nanoTime();
			long elapsed1 = end1-start1;
			System.out.println("It takes "+ elapsed1+" nanoseconds to sort "+size+" elements with 2 threads with using Radix sort" );
			
			takeinput(array, file);
			

			long start2 = System.nanoTime();
			Radix.sort(array,temp,3,2,p5,10);
			long end2 = System.nanoTime();
			long elapsed2 = end2-start2;
			System.out.println("It takes "+ elapsed2+" nanoseconds to sort "+size+" elements with 4 threads with using Radix sort" );
			
			System.out.println();
			
			takeinput(array, file);
			
		}

	}
	public static int[] takeinput(int[] data, String path){
		Scanner scanner;
		try {
			scanner = new Scanner(new File(path));
			int read = 0;
			while(scanner.hasNextInt()){
			   data[read++] = scanner.nextInt();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}




}