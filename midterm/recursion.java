public class recursion {

    public static void reverseArray(int[] a, int low, int high) {
        if (low < high) {
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            reverseArray(a, low + 1, high - 1 );
        }

    }


    public static boolean binarySearch(int[] a, int target, int low, int high) {
        if (low > high) {return false;}
        else {
            int mid = (low + high) /2;
            if (target == a[mid]) {return true;}
            else if(target < a[mid]) { return binarySearch(a, target, low, mid - 1);}
            else {return binarySearch(a, target, low, mid + 1);}
        }
    }


    public static void insertionsort(char[] data) {
        for (int k = 1; k<data.length; k++) {
            int j = k;
            while (j>0 && data[j-1]> data[k]) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = data[k];
        } 
    }


    public static void insertionsort(char[] data) {
        for (int k = 1; k<data.length; k++) {
            while (k>0 && data[k-1]> data[k]) {
                data[k] = data[k-1];
                k--;
            }

        } 
    }
        

    public static boolean factorial(int n) {

        if (n < 0) {return false;}
        else{
            if (n == 0) {return 1;}

            else {n * factorial(n - 1);} 
        }
        
    }
    


    public static void main(){

    }
} 