package utils;

import java.util.Random;
import java.io.PrintStream;
import utils.*;
import java.util.Scanner;

public class ArrayExtras {
  
   public static double[] cloneArray(double[] n) {   // Clones the input array, and returns a new array.
      double[] n2 = new double[n.length];
      
      for (int ix = 0; ix < n.length; ix++) {
         n2[ix] = n[ix];
      }
      
      return n2;
   }
   
   
   public static void populateNums(double[] n) {     // populate given array.
      Random rng = new Random(); // created a random number generator object.
      
      for (int ix=0; ix < n.length; ix++) {
         n[ix] = rng.nextDouble();  // Fills array n with random numbers from 0 to 1;
      }
   }
   

   // Randomly Populated list 
   public static void populateNums(double[] n, double max) {     // populate given array.   
      Random rng = new Random(); // created a random number generator object.
      
      for (int ix=0; ix < n.length; ix++) {
         n[ix] = rng.nextDouble() * (max-1);  // Fills array n with random numbers from 0 to 1;
      }
   }
   
   public static void populateNums(int[] n, int max) {     // populate given array.
      Random rng = new Random(); // created a random number generator object.

      for (int ix=0; ix < n.length; ix++) {
         int setInt = rng.nextInt(max);
         n[ix] = setInt;  // Fills array n with random numbers from 0 to 1;
      }
   }
   
   
   public static void printArray(int[] arr) {
      for(int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + ", ");
      }
      System.out.println("\n");
   }

  public static void printLnArray(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
       System.out.println(arr[i]);
    }
  }

  public static void printArray(double[] arr) {
    for(int i = 0; i < arr.length; i++) {
       System.out.print(arr[i] + ", ");
    }
    System.out.println("\n");
  }

  public static void printLnArray(double[] arr) {
    for(int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }


  public static void writeArray(int[] arr, PrintStream fout) {
    for(int i = 0; i < arr.length; i++) {
       fout.print(arr[i] + " ");
    }
  }

  public static void writeArray(double[] arr, PrintStream fout) {
    for(int i = 0; i < arr.length; i++) {
       fout.print(arr[i] + " ");
    }
  }
  public static void writeLnArray(int[] arr, PrintStream fout) {
    for(int i = 0; i < arr.length; i++) {
       fout.println(arr[i]);
    }
  }

  public static void writeLnArray(double[] arr, PrintStream fout) {
    for(int i = 0; i < arr.length; i++) {
       fout.println(arr[i]);
    }
  }

  public static void printArray(String[] arr) {
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println("\n");
  }

  public static void printLnArray(String[] arr) {
    for(int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
    System.out.println("\n");
  }

  public static int[] stringToArray(String str) {
	int[] nums = new int[0];
	Scanner ps = new Scanner(str).useDelimiter(",");
	while (ps.hasNextInt()) {
		nums = ArrayUtils.push(nums, ps.nextInt());
	}
	ps.close();


	return nums;
  }
  
  public static String arrayToString(int[] arr) {
	  String str = "";
	  for (int i = 0; i < arr.length; i++) {
		  str = str + arr[i] + ",";
	  }
	  return str;
  }
  


  // Quick Sort
  public static int[] quickSort(int[] n) {
    int[] cache = new int[n.length];
    if(n.length < 2) {
      cache = n;
    } else {
      int pivot = n[n.length - 1];
      int subLowLen = -1;
      for(int i = 0; i < n.length; i++) {
        if(n[i] <= pivot) {
          subLowLen++;
        }
      }
      int subHighLen = n.length - subLowLen - 1;
      int[] subLow = new int[subLowLen];
      int[] subHigh = new int[subHighLen];
      int popSL = 0;
      int popSH = 0;
      for(int i = 0; i < n.length - 1; i++) {
        if(n[i] <= pivot) {
          subLow[popSL] = n[i];
          popSL++;
        }
        if(n[i] > pivot) {
          subHigh[popSH] = n[i];
          popSH++;
        }
      }
      subLow = quickSort(subLow);
      subHigh = quickSort(subHigh);
      
      int cacheIndex = 0;
      for(int i = 0; i < subLow.length; i++) {
        cache[cacheIndex] = subLow[i];
        cacheIndex += 1;
      }
      cache[cacheIndex] = pivot;
      cacheIndex += 1;
      for(int i = 0; i < subHigh.length; i++) {
        cache[cacheIndex] = subHigh[i];
        cacheIndex += 1;
      }
    }
    return cache;
  }
  
  public static double[] quickSort(double[] n) {
    double[] cache = new double[n.length];
    if(n.length < 2) {
      cache = n;
    } else {
      double pivot = n[n.length - 1];
      int subLowLen = -1;
      for(int i = 0; i < n.length; i++) {
        if(n[i] <= pivot) {
          subLowLen++;
        }
      }
      int subHighLen = n.length - subLowLen - 1;
      double[] subLow = new double[subLowLen];
      double[] subHigh = new double[subHighLen];
      int popSL = 0;
      int popSH = 0;
      for(int i = 0; i < n.length - 1; i++) {
        if(n[i] <= pivot) {
          subLow[popSL] = n[i];
          popSL++;
        }
        if(n[i] > pivot) {
          subHigh[popSH] = n[i];
          popSH++;
        }
      }
      subLow = quickSort(subLow);
      subHigh = quickSort(subHigh);
      
      int cacheIndex = 0;
      for(int i = 0; i < subLow.length; i++) {
        cache[cacheIndex] = subLow[i];
        cacheIndex += 1;
      }
      cache[cacheIndex] = pivot;
      cacheIndex += 1;
      for(int i = 0; i < subHigh.length; i++) {
        cache[cacheIndex] = subHigh[i];
        cacheIndex += 1;
      }
    }
    return cache;
  }
  
  
  //Quick sort version 3 (v2 + avg pivot)
  public static int[] quickSort3(int[] n) throws Exception {
    int[] cache = new int[n.length];
    if(n.length < 2) {
      cache = n;
    } else {
      int pivot = n[n.length - 1];
      
      double avg = StatsUtils.mean(n);
      double newDiff = Math.abs(avg - pivot);
      for(int i = 1; i < n.length; i++) {
        if (n[i] != n[i - 1]) {
          double diff = Math.abs(avg - n[i]);
          if (diff < newDiff) {
            pivot = n[i];
            newDiff = diff;
          }
        }
      }
      
      int subLowLen = 0;
      int subSameLen = 0;
      int subHighLen = 0;
      for(int i = 0; i < n.length; i++) {
        if(n[i] < pivot) {
          subLowLen++;
        }
        if(n[i] == pivot) {
          subSameLen++;
        }
        if(n[i] > pivot) {
          subHighLen++;
        }
      }
      // System.out.println("total: " + n.length + " low: " + subLowLen + " mid: " + subSameLen + " high: " + subHighLen);
      int[] subLow = new int[subLowLen];
      int[] subHigh = new int[subHighLen];
      int[] subSame = new int[subSameLen];
      int popSL = 0;
      int popSH = 0;
      int popSS = 0;
      for(int i = 0; i < n.length; i++) {
        if(n[i] < pivot) {
          subLow[popSL] = n[i];
          popSL++;
        }
        if(n[i] == pivot) {
          subSame[popSS] = n[i];
          popSS++;
        }
        if(n[i] > pivot) {
          subHigh[popSH] = n[i];
          popSH++;
        }
      }
      
      subLow = quickSort3(subLow);
      subHigh = quickSort3(subHigh);
      
      int cacheIndex = 0;
      for(int i = 0; i < subLow.length; i++) {
        cache[cacheIndex] = subLow[i];
        cacheIndex += 1;
      }
      for(int i = 0; i < subSame.length; i++) {
        cache[cacheIndex] = subSame[i];
        cacheIndex += 1;
      }
      for(int i = 0; i < subHigh.length; i++) {
        cache[cacheIndex] = subHigh[i];
        cacheIndex += 1;
      }
    }
    return cache;
  }
  
  public static double[] quickSort3(double[] n) throws Exception {
    double[] cache = new double[n.length];
    if(n.length < 2) {
      cache = n;
    } else {
      double pivot = n[n.length - 1];
      
      double avg = StatsUtils.mean(n);
      double newDiff = Math.abs(avg - pivot);
      for(int i = 1; i < n.length; i++) {
        if (n[i] != n[i - 1]) {
          double diff = Math.abs(avg - n[i]);
          if (diff < newDiff) {
            pivot = n[i];
            newDiff = diff;
          }
        }
      }
      
      int subLowLen = 0;
      int subSameLen = 0;
      int subHighLen = 0;
      for(int i = 0; i < n.length; i++) {
        if(n[i] < pivot) {
          subLowLen++;
        }
        if(n[i] == pivot) {
          subSameLen++;
        }
        if(n[i] > pivot) {
          subHighLen++;
        }
      }
      // System.out.println("total: " + n.length + " low: " + subLowLen + " mid: " + subSameLen + " high: " + subHighLen);
      double[] subLow = new double[subLowLen];
      double[] subHigh = new double[subHighLen];
      double[] subSame = new double[subSameLen];
      int popSL = 0;
      int popSH = 0;
      int popSS = 0;
      for(int i = 0; i < n.length; i++) {
        if(n[i] < pivot) {
          subLow[popSL] = n[i];
          popSL++;
        }
        if(n[i] == pivot) {
          subSame[popSS] = n[i];
          popSS++;
        }
        if(n[i] > pivot) {
          subHigh[popSH] = n[i];
          popSH++;
        }
      }
      
      subLow = quickSort3(subLow);
      subHigh = quickSort3(subHigh);
      
      int cacheIndex = 0;
      for(int i = 0; i < subLow.length; i++) {
        cache[cacheIndex] = subLow[i];
        cacheIndex += 1;
      }
      for(int i = 0; i < subSame.length; i++) {
        cache[cacheIndex] = subSame[i];
        cacheIndex += 1;
      }
      for(int i = 0; i < subHigh.length; i++) {
        cache[cacheIndex] = subHigh[i];
        cacheIndex += 1;
      }
    }
    return cache;
  }
  
  
  //Quick Sort 2 (speeds up same numbers);
  public static int[] quickSort2(int[] n) {
    int[] cache = new int[n.length];
    if(n.length < 2) {
      cache = n;
    } else {
      int pivot = n[n.length - 1];
      int subLowLen = 0;
      int subSameLen = 0;
      int subHighLen = 0;
      for(int i = 0; i < n.length; i++) {
        if(n[i] < pivot) {
          subLowLen++;
        }
        if(n[i] == pivot) {
          subSameLen++;
        }
        if(n[i] > pivot) {
          subHighLen++;
        }
      }
      // System.out.println("total: " + n.length + " low: " + subLowLen + " mid: " + subSameLen + " high: " + subHighLen);
      int[] subLow = new int[subLowLen];
      int[] subHigh = new int[subHighLen];
      int[] subSame = new int[subSameLen];
      int popSL = 0;
      int popSH = 0;
      int popSS = 0;
      for(int i = 0; i < n.length; i++) {
        if(n[i] < pivot) {
          subLow[popSL] = n[i];
          popSL++;
        }
        if(n[i] == pivot) {
          subSame[popSS] = n[i];
          popSS++;
        }
        if(n[i] > pivot) {
          subHigh[popSH] = n[i];
          popSH++;
        }
      }
      
      subLow = quickSort2(subLow);
      subHigh = quickSort2(subHigh);
      
      int cacheIndex = 0;
      for(int i = 0; i < subLow.length; i++) {
        cache[cacheIndex] = subLow[i];
        cacheIndex += 1;
      }
      for(int i = 0; i < subSame.length; i++) {
        cache[cacheIndex] = subSame[i];
        cacheIndex += 1;
      }
      for(int i = 0; i < subHigh.length; i++) {
        cache[cacheIndex] = subHigh[i];
        cacheIndex += 1;
      }
    }
    return cache;
  }
  
  public static double[] quickSort2(double[] n) {
    double[] cache = new double[n.length];
    if(n.length < 2) {
      cache = n;
    } else {
      double pivot = n[n.length - 1];
      int subLowLen = 0;
      int subSameLen = 0;
      int subHighLen = 0;
      for(int i = 0; i < n.length; i++) {
        if(n[i] < pivot) {
          subLowLen++;
        }
        if(n[i] == pivot) {
          subSameLen++;
        }
        if(n[i] > pivot) {
          subHighLen++;
        }
      }
      // System.out.println("total: " + n.length + " low: " + subLowLen + " mid: " + subSameLen + " high: " + subHighLen);
      double[] subLow = new double[subLowLen];
      double[] subHigh = new double[subHighLen];
      double[] subSame = new double[subSameLen];
      int popSL = 0;
      int popSH = 0;
      int popSS = 0;
      for(int i = 0; i < n.length; i++) {
        if(n[i] < pivot) {
          subLow[popSL] = n[i];
          popSL++;
        }
        if(n[i] == pivot) {
          subSame[popSS] = n[i];
          popSS++;
        }
        if(n[i] > pivot) {
          subHigh[popSH] = n[i];
          popSH++;
        }
      }
      
      subLow = quickSort2(subLow);
      subHigh = quickSort2(subHigh);
      
      int cacheIndex = 0;
      for(int i = 0; i < subLow.length; i++) {
        cache[cacheIndex] = subLow[i];
        cacheIndex += 1;
      }
      for(int i = 0; i < subSame.length; i++) {
        cache[cacheIndex] = subSame[i];
        cacheIndex += 1;
      }
      for(int i = 0; i < subHigh.length; i++) {
        cache[cacheIndex] = subHigh[i];
        cacheIndex += 1;
      }
    }
    return cache;
  }
  
  public static int findSmallestIndex(int[] arr, int start) {
    int smallestInt = arr[0];
    int smallestIntIndex = 0;
    for (int i = start + 1; i < arr.length; i++) {
      if (arr[i] < smallestInt) {
        smallestInt = arr[i];
        smallestIntIndex = i;
      }
    
    }
    return smallestIntIndex;
  }

  public static int findSmallestIndex(double[] arr, int start) {
    double smallestInt = arr[0];
    int smallestIntIndex = 0;
    for (int i = start + 1; i < arr.length; i++) {
      if (arr[i] < smallestInt) {
        smallestInt = arr[i];
        smallestIntIndex = i;
      }
    
    }
    return smallestIntIndex;
  }
  
}