import java.util.Arrays;

public class Hw1 {

  public static void statistics(float[] a) {

    float smallest = 0;
    float largest = 0;
    float summ = 0;
    float median = 0;

    for (float i : a) {
      // This is for to pick minimum number of the array
      if (smallest == 0 || smallest > i) {
        smallest = i;
      }

      // This is for to pick maximum number of the array
      if (i > largest) {
        largest = i;
      }


      // This is for to sum all numbers of the array
      summ += i;

      // This is for to calculate median of the array
      if (a.length % 2 == 0) {
        median = ((float) a[a.length / 2] + (float) a[a.length / 2 - 1]) / 2;
      }
      else {
        median = (float) a[a.length / 2];
      }


    }
    System.out.println();
    System.out.println("Minimum: " + smallest);
    System.out.println("Maximum: " + largest);
    System.out.println("Average: " + summ / a.length);
    System.out.println("Median: " + median);
    System.out.println("Sum: " + summ);


  }

  public static int[] oddBeforeEven(int[] a) {

    // Initialise two index variable , left=0 and right=a.length-1
    int left=0;
    int right=a.length-1;
    for (int i = 0; i < a.length; i++) {


      // Increment left variable until you get odd number
      while(a[left]%2==1)
      {
        left++;
      }


      // Decrement right variable until you get even number.
      while(a[right]%2==0)
      {
        right--;
      }

      // If left < right, swap a[left] and a[right]
      if(left<right)
      {
        int temp=a[left];
        a[left]=a[right];
        a[right]=temp;
      }
    }

    //In the end, you will see that you have odd numbers on left side and even numbers on right side.
    return a;
  }

  public static void main(String[] args) {

    float[] a = {1, 4, 8, 9, 24};
    float[] b = {1, 4, 8, 9, 24, 27};

    statistics(a);
    statistics(b);

    int[] c = {23, 14, 6, 32, 11, 56, 82, 19};
    int[] d = new int[c.length];
    d = oddBeforeEven(c);

    System.out.println();
    System.out.println("New array: " + Arrays.toString(d));
  }

}
