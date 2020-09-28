import java.util.*;

class InsertionSort{

    public double[] InsertionSortAlgorithm(double[] arrayIn)
    {
        for (int j = 1; j < arrayIn.length; j++)
        {
            int i = j - 1;
            double KeytobeSorted = arrayIn[j];
            while (i >= 0 && KeytobeSorted < arrayIn[i])
            {
                arrayIn[i + 1] = arrayIn[i];
                i --;
            }
            arrayIn[1 + i] = KeytobeSorted;
        }
        return arrayIn;
    }

    public double[] InsertionSortAlgorithmVisualised(double[] arrayIn)
    {
        for (int j = 1; j < arrayIn.length; j++)
        {
            int i = j - 1;
            double KeytobeSorted = arrayIn[j];
            while (i >= 0 && KeytobeSorted < arrayIn[i])
            {
                arrayIn[i + 1] = arrayIn[i];
                i --;
            }
            arrayIn[1 + i] = KeytobeSorted;
            
            if (j < 10)
            {
            System.out.println("   Iteration " + j + ": " + (Arrays.toString(arrayIn)));
            }
            else System.out.println("  Iteration " + j + ": " + (Arrays.toString(arrayIn)));
            System.out.println();
        }
        return arrayIn;
    }

    public void printDoubleArray(double[] arrayIn)
    {
        for (double values : arrayIn)
        {
            System.out.print(values + ", ");
        }
        System.out.println();
    }
}