package Project;

public class SorterforRadix implements Runnable{
	private int[] array;
	private int[] array2;
	private int[] array3;
	private int radix;
	private int first;
	private int last;
	
	public SorterforRadix(int[] array, int[] array2, int[] array3, int r, int first, int last) {
		this.array = array;
		this.array2 = array2;
		this.array3 = array3;
		this.radix = r;
		this.first = first;
		this.last = last;
	}
	
	public void run() {
		for(int i = 0; i < radix-1; i++) {
			for(int j = first; j < last; j++) {
				if(j == 0) {
					Radix.lsdRadix(i, array, array2, 0, array3[j]);
				} else {
					Radix.lsdRadix(i, array, array2, array3[j-1], array3[j]);
				}
			}
		}
	}
}
