import java.util.Scanner;

public class SecondLargestNumberFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[15];

        System.out.println("Enter 15 integers from 0 to 100:");

        for (int i = 0; i < 15; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            int num = input.nextInt();

            while (num < 0 || num > 100) {
                System.out.println("Invalid! Enter a number from 0 to 100.");
                System.out.print("Enter number " + (i + 1) + ": ");
                num = input.nextInt();
            }

            numbers[i] = num;
        }

        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14 - i; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        System.out.println("\nNumbers in descending order:");

        for (int i = 0; i < 15; i++) {
            System.out.print(numbers[i] + " ");
        }

        int largest = numbers[0];
        int secondLargest = -1;

        for (int i = 1; i < 15; i++) {
            if (numbers[i] < largest) {
                secondLargest = numbers[i];
                break;
            }
        }

        System.out.println("\nLargest number: " + largest);

        if (secondLargest == -1) {
            System.out.println("No second-largest distinct number exists.");
        } else {
            System.out.println("Second largest distinct number: " + secondLargest);
        }

        input.close();
    }
}
