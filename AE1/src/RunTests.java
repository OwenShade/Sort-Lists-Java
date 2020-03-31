import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class RunTests {
	
	static String path = "C:\\Users\\owens\\OneDrive\\Documents\\second year\\ADS2\\AE1\\IntBig.txt";
	
	public static Integer[] OpenFile() throws IOException{
		
		FileReader fr = new FileReader(path);
		BufferedReader intReader = new BufferedReader(fr);
		
		int lines = 1000000;
		Integer[] data = new Integer[1000000];
		int i;
		
		for (i=0; i<lines; i++) {
			String temp = intReader.readLine();
			data[i] = Integer.parseInt(temp);
		}
		
		intReader.close();
		return data;
	}

	public static boolean isSorted(Integer a[]){
		int n = a.length;
		for (int i = 0; i < n-1; i++){
			if (a[i] > a[i+1]){
				return false;
			}
		}
     	return true;
	} 
	
	public static long start() throws IOException {
		Question1 a = new Question1();
		Integer[] array = OpenFile();
		a.InsertionSort(array);
		boolean result = isSorted(array);
		//System.out.println(Arrays.toString(array));
		if(result) {
			System.out.println("True");
			long time = System.nanoTime();
			return time;
		}else {
			System.out.println("False");
			long time = System.nanoTime();
			return time;
		}
	}
	
	public static void main(String args[]) throws IOException {
		long time1 = System.nanoTime();
		long time2 = start();
		long timeTaken = time2-time1;
		System.out.println(timeTaken + " nanoseconds\n");
	}
}
