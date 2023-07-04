import java.util.*;

public class Unitbit {

    //time complexity of O(n^2)
    public static List<List<Integer>> findCombinations(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> seen = new HashMap<>(); // to store seen numbers and their indices

        for (int i = 0; i < arr.length; i++) {
            int num1 = arr[i];
            int num2 = target - num1;

            if (seen.containsKey(num2)) {
                result.add(Arrays.asList(num1, num2));
            }

            seen.put(num1, i);
        }

        return result;
    }

    // Merge and sort the array
    // The mergeAndSort function uses the Arrays.sort method, which typically has a time complexity of O(n log n)
    public static int[] mergeAndSort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    // Find combinations of numbers that sum up to double the target value
    public static List<List<Integer>> findDoubleCombinations(int[] arr, int target) {
        int doubleTarget = target * 2;
        List<List<Integer>> combinations = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int num1 = arr[i];
            int remaining = doubleTarget - num1;

            if (remaining >= arr[i]) {
                List<Integer> combination = new ArrayList<>();
                combination.add(num1);
                List<List<Integer>> targetCombinations = findCombinations(arr, remaining);
                if (!targetCombinations.isEmpty()) {
                    combination.addAll(targetCombinations.get(0));
                    combinations.add(combination);
                }
            }
        }

        return combinations;
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 3, 2, 2, -4, -6, -2, 8};
        int targetValue = 4;

        // Find first combinations
        List<List<Integer>> firstCombinations = findCombinations(inputArray, targetValue);
        System.out.println("First Combination For " + targetValue + " : " + firstCombinations);

        // Merge and sort the array
        int[] mergedArray = mergeAndSort(inputArray);
        System.out.println("Merge Into a single Array : " + Arrays.toString(mergedArray));

        // Find second combinations
        List<List<Integer>> doubleCombinations = findDoubleCombinations(mergedArray, targetValue);
        System.out.println("Second Combination For " + targetValue * 2 + " : " + doubleCombinations);
    }
}
