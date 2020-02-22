package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;


public class Main2 {

	
	
	public static void main(String[] args) {		
		int demo []=new int[16];
		String path="16.txt";
		takeinput(demo, path);
		System.out.println("Array before sort:");
		for (int i = 0; i < demo.length; i++) {
			
			System.out.printf(" %d ",demo[i]);
		}
		
		int doutput []=new int[16];
		Rank.sort(demo, 0, doutput);
		System.out.println();
		System.out.println("Array after sort:");

		for (int i = 0; i < demo.length; i++) {

			System.out.printf(" %d ",doutput[i]);
		}
		System.out.println();
		System.out.println();
		for(int i =16; i<=65536; i=i*16) {
			int size=i;
			String file = i+".txt";
			int array[] = new int[size];
			int output[]=new int[size];
			takeinput(array, file);
		
			long start = System.nanoTime();
			Rank.sort(array,0,output);
			long end = System.nanoTime();
			long elapsed = end-start;
			System.out.println("It takes "+ elapsed+" nanoseconds to sort "+size+" elements with single threading with using Rank sort" );
			
			takeinput(array, file);
			

			long start1 = System.nanoTime();
			Rank.sort(array,1,output);
			long end1 = System.nanoTime();
			long elapsed1 = end1-start1;
			System.out.println("It takes "+ elapsed1+" nanoseconds to sort "+size+" elements with 2 threads with using Rank sort" );
			
			takeinput(array, file);
			

			long start2 = System.nanoTime();
			Rank.sort(array,2,output);
			long end2 = System.nanoTime();
			long elapsed2 = end2-start2;
			System.out.println("It takes "+ elapsed2+" nanoseconds to sort "+size+" elements with 4 threads with using Rank sort" );
			
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