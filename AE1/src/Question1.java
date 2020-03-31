
public class Question1 {

	//Start Part A
	public void QuickSort(Integer A[], int p, int r) {
		if(p<r) {
			int q = Partition(A,p,r);
			QuickSort(A,p,q-1);
			QuickSort(A,q+1,r);
		}
	}
	
	public int Partition(Integer A[], int p, int r) {
		int x = A[r];
		int i = p-1;
		for(int j=p;j<r; j++) {
			if(A[j]<=x) {
				i++;
				int hold = A[i];
				A[i] = A[j];
				A[j] = hold;
			}
		}
		int temp = A[i+1];
		A[i+1] = A[r];
		A[r] = temp;
		return i+1;
	}
	//End Part A
	
	//Start Part B
	public void QuickSortB(Integer A[], int p, int r, int k) {
		int size = A.length;
		if (size < k) {
			InsertionSortHelper(A,p);
		}
		else {
			int q = Partition(A,p,r);
			QuickSort(A,p,q-1);
			QuickSort(A,q+1,r);
		}
		
	}
	
	public void InsertionSort(Integer a[]){
			   int n = a.length;
			   for (int j = 1; j < n; j++){
				   int key = a[j];
				   int i = j-1;
				   while ((i >= 0) && (a[i] > key)){
					   a[i+1] = a[i];
					   i--;
				   }
				   a[i+1] = key;
			   }
	}
	
	public void InsertionSortHelper(Integer[] A, int p){
	    for (int i = 1; i < p; i++ ){
	        int key = A[i];
	        int j = i - 1;
	        while (j >= 0 && A[j] > key){
	            A[j+1] = A[j];
	            j = j - 1;
	        }
	    A[j + 1] = key;
	    }
	}
	//End Part B
	
	//Start Part C
	public void QuickSortMedian(Integer A[], int p, int r, int k) {
		if(p<r) {
			int q = medianPartition(A,p,r,k);
			QuickSortMedian(A,p,q-1, k);
			QuickSortMedian(A,q+1,r, k);
		}
	}
	
	public int medianPartition(Integer[] A, int p, int r, int k) {
	
		int x = pivot(A,p,r);
		int i = p-1;
		
		for(int j = p; j < r; j++) {
			if(A[j] <= x) {
				i++;
				int hold4 = A[j];
				A[j] = A[i];
				A[i] = hold4;
			}
		}
		int hold5 = A[i + 1];
		A[i +1] = A[r];
		A[r] = hold5;
		
		return i+1;
	}
	
	public int pivot(Integer[] A, int p, int r) {
		int mid = (p+r)/2;
		
		if(A[mid]<A[p]) {
			int hold = A[p];
			A[p] = A[mid];
			A[mid] = hold;
		}
		if(A[r]<A[p]) {
			int hold2 = A[p];
			A[p] = A[r];
			A[r] = hold2;
		}
		if(A[mid]<A[r]) {
			int hold = A[mid];
			A[mid] = A[r];
			A[r] = hold;
		}
		int pivot = A[r];
		return pivot;
	}
	
	//End Part C
	
	//Start Part D
	
	public void ThreeWayQuickSort(Integer[] A, int p, int r){
		if(p<r) {
			int[] returned;
			returned = PartitionThree(A,p,r);
			ThreeWayQuickSort(A, p, returned[0] - 1);
			ThreeWayQuickSort(A, returned[1] + 1,r);
		}
	}
	
	public int[] PartitionThree(Integer[] A, int p, int r) {
		int i = p;
		int pivot = A[p];
		int lessthan = p;
		int greaterthan = r;
		
		while(i<=greaterthan) {
			if (A[i] < pivot) {
				int temp = A[lessthan];
				A[lessthan] = A[i];
				A[i] = temp;
				lessthan++;
				i++;
			}
			else if(A[i]>pivot) {
				int temp2 = A[greaterthan];
				A[greaterthan] = A[i];
				A[i] = temp2;
				greaterthan--;
			}
			else {
				i++;
			}
		}
		int[] toReturn;
		toReturn = new int[2];
		toReturn[0] = lessthan;
		toReturn[1] = greaterthan;
		return toReturn;
	}
	//End Part D
	
	//Start Merge Sort
	  public void merge(Integer a[], int p, int q, int r){
		  int n1 = q - p + 1;
		  int n2 = r - q;
		  int[] L = new int[n1 + 1];
		  int[] R = new int[n2 + 1];
		  for (int i=0; i<n1; i++) {
			  L[i] = a[p + i];
		  }
		  for (int j=0; j<n2; j++) {
			  R[j] = a[q + 1+ j];
		  }
		  L[n1] = Integer.MAX_VALUE;
		  R[n2] = Integer.MAX_VALUE;
		  int i = 0;
		  int j = 0;
		  for (int k=p; k<= r; k++){
			  if(L[i] <= R[j]){
				  a[k] = L[i];
				  i++;
			  }
			  else{
				  a[k] = R[j];
				  j++;
			  }
		  }
	  }
	  
	  public void MergeSort(Integer a[], int p, int r){
		  if (p < r){
			  int q = (p+r)/2;
			  MergeSort(a, p, q);
			  MergeSort(a , q+1, r);
			  merge(a, p, q, r);
		  }
	  }  
}
