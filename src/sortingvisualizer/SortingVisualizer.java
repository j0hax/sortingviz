package sortingvisualizer;

import javax.swing.*;
import java.util.Arrays;

public class SortingVisualizer {

  public static void main(String[] args) throws InterruptedException {
    SortingVisualizer sortviz = new SortingVisualizer();
    JFrame mainWindow = new JFrame("Sorting Visualizer");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ArrayPanel panel = new ArrayPanel();
    mainWindow.add(panel);
    mainWindow.pack();
    mainWindow.setLocationRelativeTo(null);
    mainWindow.setVisible(true);
    Thread.sleep(3000);
    new Thread(new Runnable() {
      @Override
      public void run() {
        // only repaint if bits[] changes
        int[] lastBits = new int[panel.bits.length];

        while (true) {
          if (!Arrays.equals(lastBits, panel.bits)) {
            panel.repaint();
            lastBits = panel.bits.clone();
          }

          try {
            Thread.sleep(5);

          } catch (InterruptedException e) {
            System.err.println("Interrupted during redraw!");
          }
        }
      }
    }).start();

    while (true) {
      reset(panel);
      panel.setCurrentOperation("Merge Sort");
      panel.setOperationDescription("O(n log n)");
      MergeSort.mergeSort(panel.bits, 0, panel.bits.length - 1);
      Thread.sleep(1000);

      reset(panel);
      panel.setCurrentOperation("Heap Sort");
      panel.setOperationDescription("O(n log n)");
      HeapSort.sort(panel.bits);
      Thread.sleep(1000);

      reset(panel);
      panel.setCurrentOperation("Insertion Sort");
      panel.setOperationDescription("O(n^2)");
      SimpleSorts.insertionSort(panel.bits);
      Thread.sleep(1000);

      /* TODO: something wrong with this one
      reset(panel);
      panel.setCurrentOperation("Selection Sort");
      panel.setOperationDescription("O(n^2)");
      SimpleSorts.selectionSort(panel.bits);
      Thread.sleep(1000);
      */

      reset(panel);
      panel.setCurrentOperation("Bubble Sort");
      panel.setOperationDescription("O(n^2)");
      SimpleSorts.bubbleSort(panel.bits);
      Thread.sleep(1000);

      reset(panel);
      panel.setCurrentOperation("Cocktailshaker Sort");
      panel.setOperationDescription("O(n^2)");
      SimpleSorts.cocktailSort(panel.bits);
      Thread.sleep(1000);

      /* NOT THE AUTISTIC ONE PLEASE
      reset(panel);
      panel.setCurrentOperation("Bogosort");
      panel.setOperationDescription("O((n+1)!)");
      SimpleSorts.bogoSort(panel.bits);
      Thread.sleep(1000);
      */
    }
  }

  private static void reset(ArrayPanel panel) {
    panel.resetStatistics();
    panel.setCurrentOperation("Fisher-Yates Shuffle");
    panel.setOperationDescription("O(n)");
    SimpleSorts.shuffle(panel.bits);
    panel.resetStatistics();
  }
}
