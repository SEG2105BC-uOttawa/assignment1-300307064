package code_part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class ComparingArrays {
    final static int DEFAULT_SIZE = 99_000_000;
    final static Random rd = new Random();

    public static void main(String[] args) {
        arrayExecutionTime();
        arrayListExecutionTime();
        vectorExecutionTime();
    }

    public static void arrayExecutionTime() {
        int[] array = new int[DEFAULT_SIZE];

        long start, end1, end2, elapsed1, elapsed2;

        start = System.currentTimeMillis();

        for (int i = 0; i < DEFAULT_SIZE; i++) {
            int num = rd.nextInt(100);
            array[i] = num;
        }

        end1 = System.currentTimeMillis();

        int sum = 0;
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            sum += array[i];
        }

        end2 = System.currentTimeMillis();
        
        elapsed1 = end1 - start;
        elapsed2 = end2 - end1;

        System.out.println("\nSum: " + sum);
        System.out.println("Populating numbers into array took " + elapsed1 + " ms");
        System.out.println("Calculating the sum of all elements in the array took " + elapsed2 + " ms");
    }

    public static void arrayListExecutionTime() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        long start, end1, end2, elapsed1, elapsed2;

        start = System.currentTimeMillis();

        for (int i = 0; i < DEFAULT_SIZE; i++) {
            int num = rd.nextInt(100);
            arrayList.add(num);
        }

        end1 = System.currentTimeMillis();

        Iterator<Integer> iterator = arrayList.iterator();

        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        end2 = System.currentTimeMillis();
        
        elapsed1 = end1 - start;
        elapsed2 = end2 - end1;

        System.out.println("Sum: " + sum);
        System.out.println("Populating numbers into array took " + elapsed1 + " ms");
        System.out.println("Calculating the sum of all elements in the array took " + elapsed2 + " ms");
    }

    public static void vectorExecutionTime() {
        Vector<Integer> vector = new Vector<>();

        long start, end1, end2, elapsed1, elapsed2;

        start = System.currentTimeMillis();

        for (int i = 0; i < DEFAULT_SIZE; i++) {
            int num = rd.nextInt(100);
            vector.add(num);
        }

        end1 = System.currentTimeMillis();

        Iterator<Integer> iterator = vector.iterator();

        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        end2 = System.currentTimeMillis();
        
        elapsed1 = end1 - start;
        elapsed2 = end2 - end1;

        System.out.println("Sum: " + sum);
        System.out.println("Populating numbers into array took " + elapsed1 + " ms");
        System.out.println("Calculating the sum of all elements in the array took " + elapsed2 + " ms");
    }
}
