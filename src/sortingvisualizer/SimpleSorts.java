package sortingvisualizer;
import static sortingvisualizer.Utils.swap;

public class SimpleSorts {
  public static void shuffle(int[] array) {
    for (int i = 0; i < array.length; i++) {
      // random index past i
      int random = i + (int)(Math.random() * (array.length - i));
      // swap random with present element
      swap(array, i, random);
    }
  }

  public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
        swap(array, j, j-1);
      }
    }
  }

  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;

      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }

      if (minIndex != i) {
        swap(array, minIndex, i);
      }
    }
  }

  public static void bubbleSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = 1; j < array.length; j++) {
        if (array[j - 1] > array[j]) {
          swap(array, j, j-1);
        }
      }
    }
  }

  public static void cocktailSort(int[] array) {
    boolean swapped;

    do {
      swapped = false;

      for (int i = 0; i <= array.length - 2; i++) {
        if (array[i] > array[i + 1]) {
          swap(array, i, i+1);
          swapped = true;
        }
      }

      if (!swapped) {
        //we can exit the outer loop here if no swaps occurred.
        break;
      }

      swapped = false;

      for (int i = array.length - 2; i >= 0; i--) {
        if (array[i] > array[i + 1]) {
          swap(array, i, i+1);
          swapped = true;
        }
      }

      //if no elements have been swapped, then the list is sorted
    } while (swapped);
  }

  public static void bogoSort(int[] array) {
    while (!isSorted(array)) {
      int a = (int) (Math.random() * array.length);
      int b = (int) (Math.random() * array.length);
      swap(array, a, b);
    }
  }

  public static boolean isSorted(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int a = array[i];
      int b = array[i + 1];

      if (a > b) {
        return false;
      }
    }

    return true;
  }
}
