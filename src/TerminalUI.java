import java.util.*;

public class TerminalUI {

    Scanner s = new Scanner(System.in);

    double[] getInputtedArray()
    {
        
        int length = returnValidArrayLength();
        double[] A = new double[length];
        System.out.println("\n" + "Enter the elements of the array:");
    
        for(int i=0; i<length; i++ ) {
            System.out.print("["+i+"]: ");
            A[i] = returnValidArrayKey(i);
        }
        return A;
    }

    //method for validating integers as Scanner input
    public int returnValidArrayLength()
    {
        System.out.print("Enter the length of the array (Max 15): ");
        while (!s.hasNextInt())
                {
                    System.out.print("Invalid input! Enter the length of the array (Max 15): ");
                    s.next();
                }
        int arrLength = s.nextInt();
        if (arrLength > 15 || arrLength < 1)
        {
            //error message and recursive call to revalidate input
            System.out.print("Invalid input! ");
            return returnValidArrayLength();
        }
        else return arrLength;
        }

    //method for validating doubles as Scanner input
    public double returnValidArrayKey(int index)
    {
        while (!s.hasNextDouble())
            {
                System.out.print("Invalid input! [" + index + "]: ");
                s.next();
            }
        return s.nextDouble();
    }

    //recursive method that validates user menu choices
    public int returnValidMenuChoice()
    {
        System.out.print("Please choose an option (enter 1 - 4): ");
 
        //while loop that continually prompts for input until an integer is recieved
        while (!s.hasNextInt())
            {
                System.out.print("Invalid input! Please choose an option (enter 1 - 4): ");
                s.next();
            }
 
        //variable to store integer for further validation
        int menuInput = s.nextInt();
        if (menuInput > 4 || menuInput < 1)
        {
            //error message and recursive call to revalidate input
            System.out.print("Invalid input! ");
            return returnValidMenuChoice();
        }
        else return menuInput;
    }

    public void printMenuChoices()
    {
        System.out.println("\n" + "Choose a sorting algorithm:" + "\n" + 
        "1 - Insertion Sort" + "\n" +
        "2 - Heap Sort" + "\n" +
        "3 - Merge Sort" + "\n" +
        "4 - Quick Sort");
    }

    public void printDoubleArray(double[] arrayIn)
    {
        for (double values : arrayIn)
        {
            System.out.print(values + ", ");
        }
        System.out.println();
    }
 
    public void menuLoop()
    {
        System.out.print("Would you like to sort again? (Please enter Y/N):  ");
        String answer = s.next();
        if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"))
        {
            System.out.print("Invalid input! ");
            menuLoop();
        }
        else if (answer.equalsIgnoreCase("y"))
        {
            System.out.println();
            menu();
        }
        else System.out.println("Thanks for using!");
    }

    void menu(double... arrayIn)
    {
        InsertionSort iSort = new InsertionSort();
        HeapSort hSort = new HeapSort();
        MergeSort mSort = new MergeSort();
        QuickSort qSort = new QuickSort();

        double[] A = getInputtedArray();
        printMenuChoices();
        int menuChoice = returnValidMenuChoice();
        System.out.println("\n" + "Unsorted Array: " + Arrays.toString(A) + "\n");
        if (menuChoice == 1)
        {
            iSort.InsertionSortAlgorithmVisualised(A);
            System.out.println("  Sorted Array: " + Arrays.toString(A) + "\n");
        }
        if (menuChoice == 2)
        {
            hSort.heapSortVisualised(A);
            System.out.println("\n" + "Sorted Array: " + Arrays.toString(A) + "\n");
        }
        if (menuChoice == 3)
        {
            System.out.println("Merge sort visualisation is still under construction :(" + "\n");
            //mSort.mergeSort(A, 0, (A.length - 1));
        }
        else if (menuChoice == 4)
        {
            System.out.println("Quick sort visualisation is still under construction :(" + "\n");
            //qSort.quickSort(A, 0, (A.length - 1));
        }
        menuLoop();
    }
    public static void main (String[] args)
    {
        TerminalUI harness = new TerminalUI();

        harness.menu();
    }
}