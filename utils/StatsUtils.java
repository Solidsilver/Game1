/* 
 This class "StatsUtils" was created by Luke Mattfeld 
for CSCD210 at Eastern Washington University

This library assumes that the ArrayUtils library is in the same folder.
 */

package utils;

public class StatsUtils {

    //Mean
    public static double mean(int[] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception("Array cannot be empty");
        }
        double total = 0.0;
        total = sumArray(arr);  // sumArray method is located at the end of this file

        return total/arr.length;
    }

    public static double mean(double[] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception("Array cannot be empty");
        }
        double total = 0.0;
        total = sumArray(arr);

        return total/arr.length;
    }


    //Median
    public static double median(int[] arr) throws Exception {
        if (arr.length < 2) {
            throw new Exception("Array must contain at least 2 items");
        }
        if (arr.length%2 == 0){
            return (arr[arr.length/2] + arr[arr.length/2-1])/2.0;
        } else {
            return arr[arr.length/2];
        }
    }

    public static double median(double[] arr) throws Exception {
        if (arr.length < 2) {
            throw new Exception("Array must contain at least 2 items");
        }
        if (arr.length%2 == 0){
            return (arr[arr.length/2] + arr[arr.length/2-1])/2.0;
        } else {
            return arr[arr.length/2];
        }
    }


    // Midpoint
    public static double midpoint(int[] arr) throws Exception {
        if (arr.length < 2) {
            throw new Exception("Array must contain at least 2 items");
        }
        int[] arrSort = arr;
        ArrayUtils.selectionSort(arrSort);
        return (arrSort[0] + arrSort[arrSort.length-1])/2.0;
    }

    public static double midpoint(double[] arr) throws Exception {
        if (arr.length < 2) {
            throw new Exception("Array must contain at least 2 items");
        }
        double[] arrSort = arr;
        ArrayUtils.selectionSort(arrSort);
        return (arrSort[0] + arrSort[arrSort.length-1])/2.0;
    }


    // Modes
    public static int[] modes(int[] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception("Array cannot be empty");
        }
        int[] arrSort = arr;
        int[] mode = new int[0];
        ArrayUtils.selectionSort(arrSort);
        int maxFreq = 0;
        for (int i = 0; i < arrSort.length; i++) {
            int currentFreq = 1;
            while (i != arrSort.length - 1 && arrSort[i] == arrSort[i+1]) {
                currentFreq++;
                i++;
            }
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                mode = new int[0];
                mode = ArrayUtils.push(mode, arrSort[i]);
            } else if (currentFreq == maxFreq) {
                mode = ArrayUtils.push(mode, arrSort[i]);
            }
        }
        return mode;
    }

    public static double[] modes(double[] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception("Array cannot be empty");
        }
        double[] arrSort = arr;
        double[] mode = new double[0];
        ArrayUtils.selectionSort(arrSort);
        int maxFreq = 0;
        for (int i = 0; i < arrSort.length; i++) {
            int currentFreq = 1;
            while (i != arrSort.length - 1 && arrSort[i] == arrSort[i+1]) {
                currentFreq++;
                i++;
            }
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                mode = new double[0];
                mode = ArrayUtils.push(mode, arrSort[i]);
            } else if (currentFreq == maxFreq) {
                mode = ArrayUtils.push(mode, arrSort[i]);
            }
        }
        return mode;
    }


    // stdDev
    public static double standardDeviation(int[] arr) throws Exception {
        if (arr.length < 2) {
            throw new Exception("Array must contain at least 2 items");
        }
        double mean = mean(arr);
        double[] temp = new double[arr.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i] - mean;
            temp[i] *= temp[i];
        }
        double stdDev = Math.sqrt(sumArray(temp)/(arr.length-1));

        return stdDev;
    }

    public static double standardDeviation(double[] arr) throws Exception {
        if (arr.length < 2) {
            throw new Exception("Array must contain at least 2 items");
        }
        double mean = mean(arr);
        double[] temp = new double[arr.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i] - mean;
            temp[i] *= temp[i];
        }
        double stdDev = Math.sqrt(sumArray(temp)/(arr.length-1));

        return stdDev;
    }
    

    // Private summation of an array
    private static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static double sumArray(double[] arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}