import java.util.Arrays;

public class RadixSortPhoneNumbers {
    public static void countingSort(long[], int exp) {
        int n = arr.length;
        long[] output = new long[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) { //подсчет цифр
            int digit = (int)((arr[i] / exp) % 10);
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) { //обновление  массива для хранения индексов
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) { //построение отсортированного массива
            int digit = (int)((arr[i] / exp) % 10);
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {   //копирование отсортированных элементов обратно в массив
            arr[i] = output[i];
        }
    }

    public static long[] sortPhoneNumbers(long[] arr) {
        long max = Arrays.stream(arr).max().orElse(0L);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }

        return arr;
    }

    public static void main(String[] args) {
        long[] phoneNumbers = {9876543210L, 1234567890L, 5555555555L, 1000000000L};
        System.out.println(Arrays.toString(sortPhoneNumbers(phoneNumbers)));
    }
}
