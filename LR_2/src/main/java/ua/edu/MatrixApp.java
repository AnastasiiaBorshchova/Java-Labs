package ua.edu;

import java.util.Random;
import java.util.Scanner;

public class MatrixApp {
    /** Максимально допустимий розмір матриці по кожній стороні. */
    private static final int MAX_SIZE = 20;
    /** Діапазон випадкових чисел (включно). */
    private static final int RANDOM_MIN = -100;
    private static final int RANDOM_MAX = 100;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int height = readInt("Введіть висоту матриці (1.." + MAX_SIZE + "): ", 1, MAX_SIZE);
        int width = readInt("Введіть ширину матриці (1.." + MAX_SIZE + "): ", 1, MAX_SIZE);
        int mode = readInt("Спосіб створення: 1 - з клавіатури, 2 - випадково: ", 1, 2);

        int[][] matrix = (mode == 1) ? createManually(height, width) : createRandom(height, width);

        printMatrix(matrix);
        System.out.println("Мінімальний елемент: " + findMin(matrix));
        System.out.println("Максимальний елемент: " + findMax(matrix));
        System.out.printf("Середнє арифметичне: %.4f%n", arithmeticMean(matrix));
        System.out.printf("Середнє геометричне (за модулями): %.4f%n", geometricMean(matrix));
    }

    /** Зчитує ціле число з клавіатури в межах [min, max], повторюючи запит при помилці. */
    static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Число має бути в межах від " + min + " до " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Це не ціле число, спробуйте ще раз.");
            }
        }
    }

    static int[][] createManually(int height, int width) {
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = readInt("Елемент [" + i + "][" + j + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    static int[][] createRandom(int height, int width) {
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = RANDOM_MIN + RANDOM.nextInt(RANDOM_MAX - RANDOM_MIN + 1);
            }
        }
        return matrix;
    }

    static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%6d", value);
            }
            System.out.println();
        }
    }

    static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }

    static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    static double arithmeticMean(int[][] matrix) {
        long sum = 0;
        long count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }

    /**
     * Середнє геометричне за модулями елементів: exp(середнє від ln|x|).
     * Якщо хоча б один елемент дорівнює 0, результат 0.
     */
    static double geometricMean(int[][] matrix) {
        double logSum = 0;
        long count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value == 0) {
                    return 0;
                }
                logSum += Math.log(Math.abs((double) value));
                count++;
            }
        }
        return Math.exp(logSum / count);
    }
}
