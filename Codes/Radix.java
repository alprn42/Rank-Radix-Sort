package Project;

import java.util.Arrays;

public class Radix {

	private static void msdRadix(int r, int[] array, int[] array2, int first, int last, int size, int m) {
		
		int[] cnt = new int[size];
		int[] temp = new int[array.length];
		
		for (int i = first; i < last; i++) {
        	int test = (int) (array[i]/ Math.pow(10, r)) % m; 
        	cnt[test]++;
        	array2[test]++;
        }
        
        for (int k = 1; k < size; k++) {
        	cnt[k] += cnt[k-1];
        	array2[k] += array2[k-1];
        }
        
        for(int i = last-1; i >= first; i--) {
        	int test = (int) (array[i]/ Math.pow(10, r)) % m;
        	temp[--cnt[test]] = array[i];
        }
        
        for(int i = first; i < last; i++) {
        	array[i] = temp[i];
        }
	}
	
	public static void lsdRadix(int r, int[] array, int[] array2, int start, int end) {
		if(end <= (start+1)) {
			return;
		}
		
		int[] count = new int[10];
		
		for (int i = start; i < end; i++) {
        	int test = (int) (array[i]/ Math.pow(10, r)) % 10; 
        	count[test]++;
        }
        
        for (int k = 1; k < 10; k++) {
        	count[k] += count[k-1];
        }
        
        for(int i = end-1; i >= start; i--) {
        	int test = (int) (array[i]/ Math.pow(10, r)) % 10; 
        	array2[--count[test]+start] = array[i];
        }
        
        for(int i = start; i < end; i++) {
        	array[i] = array2[i];
        }
	}
	
	public static void multiThread(int threadNumber, int[] array, int[] array2, int[] c, int r, int length) {
		if(threadNumber == 0) { // if thread number is 0, it execute with single thread
			for(int i = 0; i < r; i++) {
	        	lsdRadix(i, array, array2, 0, array.length);
	        }
		} else if(threadNumber == 1) { // if thread number is 1, it execute with two threads
			Thread lT = new Thread(new SorterforRadix(array, array2, c, r, 0, c.length/2));
			Thread rT = new Thread(new SorterforRadix(array, array2, c, r, c.length/2, c.length));
			
			lT.start();
			rT.start();
			try {
				lT.join();
				rT.join();
			} catch (InterruptedException ie) {}
		} else { // if thread number is something else, it execute with 4 threads
			Thread lT = new Thread(new SorterforRadix(array, array2, c, r, 0, c.length/4));
			Thread rT = new Thread(new SorterforRadix(array, array2, c, r, c.length/4, c.length/2));
			Thread lT2 = new Thread(new SorterforRadix(array, array2, c, r, c.length/2, (c.length/2 + c.length/4)));
			Thread rT2 = new Thread(new SorterforRadix(array, array2, c, r, (c.length/2 + c.length/4), c.length));
			
			lT.start();
			rT.start();
			lT2.start();
			rT2.start();
			try {
				lT.join();
				rT.join();
				lT2.join();
				rT2.join();
			} catch (InterruptedException ie) {}
		}
		
	}
	
	
	public static void sort(int[] array, int[] array2, int maxValue, int threadNumber, int length, int m) {	
		int[] temp = new int[length];
		
		if(threadNumber != 0) {
			if(m == 100) {
				msdRadix(maxValue-2, array, temp, 0, array.length, length, m);
			} else {
				msdRadix(maxValue-1, array, temp, 0, array.length, length, m);
			}
		}
		
		multiThread(threadNumber, array, array2, temp, maxValue, length);
	}
}