package Project;

public class Rank {
	
	public static void sort(int[] array, int thnumber, int[] output) {
		
	
		if(thnumber == 0) { //if thread number is 0, it executes with single thread.
			rankSort(array, 1, 0, output);
		} 
		if(thnumber == 1) { // if thread number is 1, it executes with 2 threads
			multithread(array, output, 2);
		} else if(thnumber == 2) {
			multithread(array, output, 4); // if thread number is 2, it execute with four threads
		}
	}
	
	
	public static void rankSort(int array[], int s, int first, int[] output) {
		
		for(int i = first; i < array.length; i+=s) {
			int index = 0;
			for(int j = 0; j < array.length; j++) {
				if(array[i] > array[j] || (array[i] == array[j] && (j < i))) {
					index++;
				}
			}	
			output[index] = array[i];
		}
	}
	private static void multithread(int[] array, int[] output, int thnumber) {
		if(thnumber == 2) {
			Thread lT = new Thread(new SorterforRank(array, 2, 0, output));
			Thread rT = new Thread(new SorterforRank(array, 2, 1, output));
			
			lT.start();
			rT.start();
			try {
				lT.join();
				rT.join();
			} catch (InterruptedException ie) {}
		} else if(thnumber == 4) { 
			Thread lT = new Thread(new SorterforRank(array, 4, 0, output));
			Thread rT = new Thread(new SorterforRank(array, 4, 1, output));
			Thread l2T = new Thread(new SorterforRank(array, 4, 2, output));
			Thread r2T = new Thread(new SorterforRank(array, 4, 3, output));

			lT.start();
			rT.start();
			l2T.start();
			r2T.start();
			
			try {
				lT.join();
				rT.join();
				l2T.join();
				r2T.join();

			} catch (InterruptedException ie) {}
		}
	}
	

}