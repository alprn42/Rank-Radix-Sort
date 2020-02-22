package Project;

public class SorterforRank implements Runnable {
	private int[] array;
	private int[] output;
	private int s;
	private int first;
	
	public SorterforRank(int[] array, int s, int first, int[] output) {
		this.array = array;
		this.s = s;
		this.first = first;
		this.output = output;
	}
	
	public void run() {
		Rank.rankSort(array, s, first, output);
	}
}