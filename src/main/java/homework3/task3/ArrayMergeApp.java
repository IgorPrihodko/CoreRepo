package homework3.task3;
import java.util.Arrays;

public class ArrayMergeApp {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 2, 3, 11};
        int[] arr2 = new int[] {1, 2, 4, 6, 7, 7};
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] resArr = new int[arr1.length + arr2.length];

        while ((i < arr1.length) && (j < arr2.length)) {
            if (arr1[i] <= arr2[j]) {
                resArr[k] = arr1[i];
                i++;
            } else {
                resArr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            resArr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            resArr[k] = arr2[j];
            j++;
            k++;
        }
        return resArr;
    }
}
