public class QuickSort {
    
    public int partition(double[] A, int firstI, int lastI)
    {   
        double pivot = A[lastI];
        int i = firstI -1;
        for (int j = firstI; j < lastI; j++)
        {
            if (A[j] <= pivot)
            {
                i++;
                double iClone = A[i];
                A[i] = A[j];
                A[j] = iClone;
            }
        }
        A[lastI] = A[i + 1];
        A[i + 1] = pivot;
        return i + 1;
    }

    public double[] quickSort(double[] A, int firstI, int lastI)
    {
        if (firstI < lastI)
        {
            int midI = partition(A, firstI, lastI);
            quickSort(A, firstI, midI - 1);
            quickSort(A, midI + 1, lastI); 
        }
        return A;
    }

    public void printDoubleArray(double[] arrayIn)
    {
        for (double values : arrayIn)
        {
            System.out.print(values + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {   
        QuickSort harness = new QuickSort();

        double[] unsortedArray = {6,5,3,9,8,1,2,7,10,11,4,78.9,1,-123,-3,1234};
        
        System.out.print("Unsorted array: ");
        harness.printDoubleArray(unsortedArray);
        
        harness.quickSort(unsortedArray, 0, unsortedArray.length - 1);
        
        System.out.print("Sorted array: ");
        harness.printDoubleArray(unsortedArray);
    }
}