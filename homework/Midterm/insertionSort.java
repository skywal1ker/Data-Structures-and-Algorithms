import java.util.Arrays;

public class insertionSort {

	public static void insertionSort(char[ ] data) {
		for (int k = 1; k < data.length; k++) {    // begin with second element
		    char cur = data[k];          // save data[k] in cur
		    int j = k;                   
		    while (j > 0 && data[j-1] > cur) {  // find correct index j for cur
		        data[j] = data[j-1];            
		        j--;                            
		    } // while
		    data[j] = cur;     // this is the proper place for cur
		    
		 } // for
		 return;
	}

	public static void main(String[] args) {
		
		char[] charArray = {'B', 'C', 'D', 'A', 'E', 'H', 'G', 'F'};
		
		insertionSort(charArray);
	}
}



