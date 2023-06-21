public class PivotIndex {
    public static int findPivotIndex(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;

        // Calculate the sum of all elements in the array
        for (int num : arr) {
            rightSum += num;
        }

        for (int i = 0; i < arr.length; i++) {
            // Subtract the current element from rightSum
            rightSum -= arr[i];

            // Check if the left and right sums are equal
            if (leftSum == rightSum) {
                return i; // Return the index as the pivot index
            }

            // Add the current element to leftSum
            leftSum += arr[i];
        }

        // No pivot index found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int pivotIndex = findPivotIndex(arr);

        if (pivotIndex != -1) {
            System.out.println("Pivot Index: " + pivotIndex);
        } else {
            System.out.println("No pivot index found.");
        }
    }
}
