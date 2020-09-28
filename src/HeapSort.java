import java.util.*;

public class HeapSort {

    public int left(int index)
    {   
        return (index * 2) + 1;
    }
    
    public int right(int index)
    {
        return (index * 2) + 2;
    }
    
    public double[] maxHeapify(double[] A, int HLength, int index)
    {
        int l = left(index);
        int r = right(index);
        int largest;
        
        if (l <= HLength && A[l] > A[index])
        {
            largest = l;
        }
        else largest = index;
        if (r <= HLength && A[r] > A[largest])
        {
            largest = r;
        }
        if (largest!= index)
        {
            double indexCopy = A[index];
            A[index] = A[largest];
            A[largest] = indexCopy;
            maxHeapify(A, HLength, largest);
        }
        return A;
    }

    public double[] buildMaxHeap(double[] A)
    {
        int j = (int) java.lang.Math.floor((A.length/2) - 1);
        for(int i = j; i >= 0; i--)
        {
            maxHeapify(A, A.length -1, i);
        }
        return A;
    }

    public double[] heapSort(double[] A)
    {
        buildMaxHeap(A);
        for(int i = A.length - 1; i > 0; i --)
        {
            double largest = A[0];
            A[0] = A[i];
            A[i] = largest;
            maxHeapify(A, i - 1, 0);
        }
        return A;
    }
    
    public double[] heapSortVisualised(double[] A)
    {
        System.out.println("Initial binary tree:" + "\n");
        drawTree(A);
        buildMaxHeap(A);
        System.out.println("\n\n" + "After the call to \"build max heap\": " + "\n");
        drawTree(A);
        System.out.println();
        int j = 1;
        for(int i = A.length - 1; i > 0; i --)
        {
            double largest = A[0];
            A[0] = A[i];
            A[i] = largest;
            maxHeapify(A, i - 1, 0);
            System.out.println("\n" + "After recursive call " + j + " to \"heap sort\": " + "\n");
            drawTree(A);
            j++;
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

    public void drawTree(double... arrayIn)
    {
        String[] keys = new String[15];
        String tripleSpace = "   ";
        Arrays.fill(keys, tripleSpace);
        
        for (int j = 0; j < arrayIn.length; j++)
        {
            keys[j] = Double.toString(arrayIn[j]);
        }

        System.out.println(createSpace(keys[1],keys[3],keys[4],keys[7],keys[8],keys[9],keys[10]) + keys[0]);
        System.out.println(createSpace(keys[7],keys[3],keys[8]) + keys[1] + createSpace(keys[9],keys[4],keys[10],keys[0],keys[11],keys[5],keys[12]) + keys[2]);
        System.out.println(createSpace(keys[7]) + keys[3] + createSpace(keys[8],keys[1],keys[9]) + keys[4] + createSpace(keys[10],keys[0],keys[11]) + keys[5] + createSpace(keys[12],keys[2],keys[13]) + keys[6]); 
        System.out.println(keys[7] + createSpace(keys[3]) + keys[8] + createSpace(keys[1]) + keys[9] + createSpace(keys[4]) + keys[10] + createSpace(keys[0]) + keys[11] + createSpace(keys[5]) + keys[12] + createSpace(keys[2]) + keys[13] + createSpace(keys[6]) + keys[14]);
        if (arrayIn.length > 15)
        {
            System.out.println("I can only draw a tree of max 15 keys");
        }
    }

    public String createSpace(String... in)
    {
        String space = " ";
        String totalSpace = "";
        for (int i = 0; i< in.length; i++)
        {
            totalSpace = totalSpace.concat(space.repeat(in[i].length()));
        }
        return totalSpace;
    } 
}
