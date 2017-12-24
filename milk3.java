
/*
ID: angusjy1
LANG: JAVA
TASK: milk3
*/
import java.io.*;
import java.util.*;

class milk3 {
	
	public static int ASize;
	public static int BSize;
	public static int CSize;
	public static ArrayList<Integer> answers = new ArrayList<Integer>();
	public static boolean[][][] doneCombos;
	
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader reader = new BufferedReader(new FileReader("milk3.in"));
                                                  // input file name goes above
    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
    StringTokenizer st = new StringTokenizer(reader.readLine());
    ASize = Integer.parseInt(st.nextToken());
    BSize = Integer.parseInt(st.nextToken());
    CSize = Integer.parseInt(st.nextToken());
    doneCombos = new boolean[ASize+1][BSize+1][CSize+1];
    pour(0,0,CSize);
    Collections.sort(answers);
    for(int ind = 0; ind < answers.size(); ind++){
    	if(ind!=0){
    		writer.print(" ");
    	}
    	writer.print(answers.get(ind));
    }
    writer.println();
    writer.close();
  }
  
  public static void pour(int A, int B, int C){
	  if(doneCombos[A][B][C]){
		  return;
	  }
	  doneCombos[A][B][C] = true;
	  if(A==0){
		  answers.add(C);
	  }
	  
	  //c to a
	  pour(A+Math.min(C,ASize-A),B,C-Math.min(C,ASize-A));
		//a to c
	  pour(A-Math.min(CSize-C,A),B,C+Math.min(CSize-C,A));
		
		//b to a
	  pour(A+Math.min(B,ASize-A),B-Math.min(B,ASize-A),C);
		//a to b
	  pour(A-Math.min(BSize-B,A),B+Math.min(BSize-B,A),C);
		
		//c to b
	  pour(A,B+Math.min(C,BSize-B),C-Math.min(C,BSize-B));
		//b to c
	  pour(A,B-Math.min(CSize-C,B),C+Math.min(CSize-C,B));
  }
  
  public static void printArrayI(int[] arr){
	  for(int i = 0; i < arr.length; i++){
		  System.out.println(arr[i]);
	  }
  }
  
  public static void printArrayB(boolean[] arr){
	  for(int i = 0; i < arr.length; i++){
		  System.out.println(arr[i]);
	  }
  }
  
  public static void printArrayD(double[] arr){
	  for(int i = 0; i < arr.length; i++){
		  System.out.println(arr[i]);
	  }
  }
  
  public static void printArrayC(char[] arr){
	  for(int i = 0; i < arr.length; i++){
		  System.out.println(arr[i]);
	  }
  }
  
  public static void printArrayS(String[] arr){
	  for(int i = 0; i < arr.length; i++){
		  System.out.println(arr[i]);
	  }
  }

  public static void printListI(ArrayList<Integer> arr){
	  for(int i = 0; i < arr.size(); i++){
		  System.out.println(arr.get(i));
	  }
  }
  
  public static void printListD(ArrayList<Double> arr){
	  for(int i = 0; i < arr.size(); i++){
		  System.out.println(arr.get(i));
	  }
  }
  
  public static void printListS(ArrayList<String> arr){
	  for(int i = 0; i < arr.size(); i++){
		  System.out.println(arr.get(i));
	  }
  }
  
  private int array[];
  private int length;
  
  public void sort(int[] inputArr) {
      
      if (inputArr == null || inputArr.length == 0) {
          return;
      }
      this.array = inputArr;
      length = inputArr.length;
      quickSort(0, length - 1);
  }

  private void quickSort(int lowerIndex, int higherIndex) {
       
      int i = lowerIndex;
      int j = higherIndex;
      // calculate pivot number, I am taking pivot as middle index number
      int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
      // Divide into two arrays
      while (i <= j) {
          /**
           * In each iteration, we will identify a number from left side which 
           * is greater then the pivot value, and also we will identify a number 
           * from right side which is less then the pivot value. Once the search 
           * is done, then we exchange both numbers.
           */
          while (array[i] < pivot) {
              i++;
          }
          while (array[j] > pivot) {
              j--;
          }
          if (i <= j) {
              exchangeNumbers(i, j);
              //move index to next position on both sides
              i++;
              j--;
          }
      }
      // call quickSort() method recursively
      if (lowerIndex < j)
          quickSort(lowerIndex, j);
      if (i < higherIndex)
          quickSort(i, higherIndex);
  }

  private void exchangeNumbers(int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
  }
  
}