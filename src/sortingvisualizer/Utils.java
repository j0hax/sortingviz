package sortingvisualizer;

public class Utils {
    public static void delay() {
        delay(5);
    }

    public static void delay(long millis) {
        try {
            Thread.sleep(millis);

        } catch (InterruptedException e) {
            System.err.println("Interrupted during algorithm delay!");
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        delay();
    }
}
