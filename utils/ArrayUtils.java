/* 
 This class "ArrayUtils" was created by Luke Mattfeld 
for CSCD210 at Eastern Washington University
 */
package utils;



public class ArrayUtils {

  // Insert:
  public static int[] insert(int[] arr, int item, int loc) throws Exception {
    if (loc > arr.length - 1) {
      throw new Exception("Location larger than array");
    } else if (loc < 0) {
      throw new Exception("Location must be larger than -1");
    }
    int[] temp = new int[arr.length + 1];
    for (int i = 0; i < loc; i++) {
      temp[i] = arr[i];
    }
    temp[loc] = item;
    for(int i = loc; i < arr.length; i++) {
      int j = i + 1;
      temp[j] = arr[i];
    }
    return temp;
  }

  public static double[] insert(double[] arr, double item, int loc) throws Exception {
    if (loc > arr.length - 1) {
      throw new Exception("Location larger than array");
    } else if (loc < 0) {
      throw new Exception("Location must be larger than -1");
    }
    double[] temp = new double[arr.length + 1];
    for (int i = 0; i < loc; i++) {
      temp[i] = arr[i];
    }
    temp[loc] = item;
    for(int i = loc; i < arr.length; i++) {
      int j = i + 1;
      temp[j] = arr[i];
    }
    return temp;
  }


  // linear search.
  public static int linearSearch(int[] arr, int num) {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == num) {
        return i;
      }
    }
    
    return -1;  // if it returns -1, "num" is not in the array.
  } 

  public static int linearSearch(double[] arr, double num) {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == num) {
        return i;
      }
    }
    
    return -1;
  }

  public static int linearSearch(String[] arr, String str) {
	for(int i = 0; i < arr.length; i++) {
	  if(arr[i].equals(str)) {
		 return i;
	  }
	}
	
	return -1;
 }


  // Pop
  public static int[] pop(int[] arr) {
    int[] temp = new int[arr.length - 1];
    
    for(int i = 0; i < arr.length - 1; i++) {
      temp[i] = arr[i];
    }
    return temp;
  }
  
  public static double[] pop(double[] arr) {
    double[] temp = new double[arr.length - 1];
    
    for(int i = 0; i < arr.length - 1; i++) {
       temp[i] = arr[i];
    }
    return temp;
  }
  
  public static String[] pop(String[] arr) {
	String[] temp = new String[arr.length - 1];
	
	for(int i = 0; i < arr.length - 1; i++) {
		temp[i] = arr[i];
	}
	return temp;
 }
  
  // Push
  public static int[] push(int[] arr, int item) {
    int[] temp = new int[arr.length + 1];
    
    for(int i = 0; i < arr.length; i++) {
      temp[i] = arr[i];
    }
    temp[temp.length - 1] = item;
    return temp;
  }
  
  public static double[] push(double[] arr, double item) {
    double[] temp = new double[arr.length + 1];
    
    for(int i = 0; i < arr.length; i++) {
      temp[i] = arr[i];
    }
    temp[temp.length - 1] = item;
    return temp;
  }

  public static String[] push(String[] arr, String item) {
	String[] temp = new String[arr.length + 1];
	
	for(int i = 0; i < arr.length; i++) {
	  temp[i] = arr[i];
	}
	temp[temp.length - 1] = item;
	return temp;
 }
  
  
  // Remove: removes item at index (loc) of given array (arr), then returns new array
  public static int[] remove(int[] arr, int loc) throws Exception {
    if (loc > arr.length - 1) {
      throw new Exception("Location larger than array");
    } else if (loc < 0) {
      throw new Exception("Location must be larger than -1");
    }
    int[] temp = new int[arr.length - 1];
    for (int i = 0; i < loc; i++) {
      temp[i] = arr[i];
    }
    for(int i = loc + 1; i < arr.length; i++) {
      int j = i - 1;
      temp[j] = arr[i];
    }
    return temp;
  }
  
  public static double[] remove(double[] arr, int loc) throws Exception {
    if (loc > arr.length - 1) {
      throw new Exception("Location larger than array");
    } else if (loc < 0) {
      throw new Exception("Location must be larger than -1");
    }
    double[] temp = new double[arr.length - 1];
    for (int i = 0; i < loc; i++) {
      temp[i] = arr[i];
    }
    for(int i = loc + 1; i < arr.length; i++) {
      int j = i - 1;
      temp[j] = arr[i];
    }
    return temp;
  }

  public static String[] remove(String[] arr, int loc) throws Exception {
	if (loc > arr.length - 1) {
	  throw new Exception("Location larger than array");
	} else if (loc < 0) {
	  throw new Exception("Location must be larger than -1");
	}
	String[] temp = new String[arr.length - 1];
	for (int i = 0; i < loc; i++) {
	  temp[i] = arr[i];
	}
	for(int i = loc + 1; i < arr.length; i++) {
	  int j = i - 1;
	  temp[j] = arr[i];
	}
	return temp;
 }


  // remove by value.
  public static int[] removeByValue(int[] arr, int item) throws Exception {
    int removeIndex = linearSearch(arr, item);
    if (removeIndex < 0) {
      throw new Exception("Value not in array");
    }
    arr = remove(arr, removeIndex);
    return arr;
  }
  
  public static double[] removeByValue(double[] arr, double item) throws Exception {
    int removeIndex = linearSearch(arr, item);
    if (removeIndex < 0) {
      throw new Exception("Value not in array");
    }
    arr = remove(arr, removeIndex);
    return arr;
  }

  public static String[] removeByValue(String[] arr, String item) throws Exception {
	int removeIndex = linearSearch(arr, item);
	if (removeIndex < 0) {
	  throw new Exception("Value not in array");
	}
	arr = remove(arr, removeIndex);
	return arr;
 }
  
  
  // Selection Sort
  public static void selectionSort(int[] arr) {
    for (int j = 0; j < arr.length; j++) {
      int indSmall = j;
      for (int i = j; i < arr.length; i++) {
        if (arr[i] < arr[indSmall]) {
          indSmall = i;
        }
      }
      if (indSmall != j) {
        swap(arr, indSmall, j);
      } 
    }
  }
  
  public static void selectionSort(double[] arr) {
    for (int j = 0; j < arr.length; j++) {
      int indSmall = j;
      for (int i = j; i < arr.length; i++) {
        if (arr[i] < arr[indSmall]) {
          indSmall = i;
        }
      }
      if (indSmall != j) {
        swap(arr, indSmall, j);
      }
    }
  }
  

  // Local swapping of two values for sorting (not in API)
  private static void swap(int[] arr, int loc1, int loc2) {
    int cache = arr[loc1];
    arr[loc1] = arr[loc2];
    arr[loc2] = cache;
  }
  
  private static void swap(double[] arr, int loc1, int loc2) {
    double cache = arr[loc1];
    arr[loc1] = arr[loc2];
    arr[loc2] = cache;
  }

  private static void swap(String[] arr, int loc1, int loc2) {
	String cache = arr[loc1];
	arr[loc1] = arr[loc2];
	arr[loc2] = cache;
 }
}