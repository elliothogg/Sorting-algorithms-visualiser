import java.util.*;

public class MergeSort {
    
    public double[] merge(double[] A, int firstI, int midI, int lastI)
    {
        int n1 = midI - firstI + 1;
        int n2 = lastI - midI;
        double[] l = new double[n1 + 1];
        double[] r = new double[n2 + 1];
        for (int i = 0; i < n1; i++)
        {
            l[i] = A[firstI + i];
        }
        for (int j = 0; j < n2; j++)
        {
            r[j] = A[midI + 1 + j];
        }
        l[n1] = Double.POSITIVE_INFINITY;
        r[n2] = Double.POSITIVE_INFINITY;
        int i = 0;
        int j = 0;
        for (int k = firstI; k <= lastI; k ++)
        {
            if (l[i] <= r[j])
            {
                A[k] = l[i];
                i ++;
            }
            else
            {
                A[k] = r[j];
                j++;
            }
        }
        return A;
    }

    public double[] mergeSort(double[] A, int firstI, int lastI)
    {
        if (firstI < lastI)
        {
            int midI = (int) java.lang.Math.floor((firstI + lastI)/2);
            mergeSort(A, firstI, midI);
            mergeSort(A, midI + 1, lastI);
            merge(A, firstI, midI, lastI);
        }
        return A;
    }

    double[][] allArrays = new double[7][8];
    int i = 0;

    public void mergeSortVisualise(double[] A, int firstI, int lastI)
    {
        if (firstI < lastI)
        {
            int midI = (int) java.lang.Math.floor((firstI + lastI)/2);
            mergeSortVisualise(A, firstI, midI);
            mergeSortVisualise(A, midI + 1, lastI);
            merge(A, firstI, midI, lastI);
            allArrays[i] = A;
            i = i + 1;
        } 
    }

    public double[] mergeSortListener(double numberIn)
    {
        double[] list = new double[4];
        int i = 0;
        list[i] = numberIn;
        i ++;
        return list;
    }

    public void test(){
        for(int i = 0; i < 4; i++)
        {
            mergeSortListener(i);
        }
    }
    public static void main(String[] args)
    {   
        MergeSort harness = new MergeSort();

        double[] unsortedArray = {6,1,9,4,8,7,2,3};
        
        System.out.print("unsorted: ");
        System.out.println(Arrays.toString(unsortedArray));
        
        harness.mergeSortVisualise(unsortedArray, 0, unsortedArray.length - 1);

        System.out.println(Arrays.deepToString(harness.allArrays));
        
    }
}