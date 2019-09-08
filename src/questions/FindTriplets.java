package questions;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName FindTriplets
 * @Description Find all triplets with zero sum
 * Given an array of distinct elements.
 * The task is to find triplets in array whose sum is zero.
 * @Author NebulaPort
 * @Date 2019/7/30 11:02
 */
public class FindTriplets {
    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        int n =arr.length;
        findTripletsSimple(arr, n);
        findTripletsHashing(arr, n);
        findTripletsSorting(arr, n);
    }

    /**
     * Method 1 (Simple : O(n3))
     * The naive approach is that run three loops
     * and check one by one that sum of three elements is zero or not
     * if sum of three elements is zero then print elements other wise print not found.
     * */
    public static void findTripletsSimple(int[] arr,int n){
        boolean found = true;
        for (int i=0; i<n-2; i++)
        {
            for (int j=i+1; j<n-1; j++)
            {
                for (int k=j+1; k<n; k++)
                {
                    if (arr[i]+arr[j]+arr[k] == 0)
                    {
                        System.out.print(arr[i]);
                        System.out.print(" ");
                        System.out.print(arr[j]);
                        System.out.print(" ");
                        System.out.print(arr[k]);
                        System.out.print("\n");
                        found = true;
                    }
                }
            }
        }

        // If no triplet with 0 sum found in array
        if (found == false) {
            System.out.println(" not exist ");
        }
    }

    /**
     * Method 2 (Hashing : O(n2))
     * We iterate through every element. For every element arr[i],
     * we find a pair with sum “-arr[i]”.
     * This problem reduces to pairs sum and can be solved in O(n) time using hashing.
     * */
    public static void findTripletsHashing(int arr[], int n){
        boolean found = false;

        for (int i = 0; i < n - 1; i++)
        {
            // Find all pairs with sum equals to
            // "-arr[i]"
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++)
            {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x))
                {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                }
                else
                {
                    s.add(arr[j]);
                }
            }
        }

        if (found == false)
        {
            System.out.printf(" No Triplet Found\n");
        }
    }
    /**
     * Method 3 (Sorting : O(n2))
     * The above method requires extra space.
     * We can solve in O(1) extra space.
     * The idea is based on method 2 of this post.
     * */
    public static void findTripletsSorting(int arr[], int n){
        boolean found = false;

        // sort array elements
        Arrays.sort(arr);

        for (int i=0; i<n-1; i++)
        {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r)
            {
                if (x + arr[l] + arr[r] == 0)
                {
                    // print elements if it's sum is zero
                    System.out.print(x + " ");
                    System.out.print(arr[l]+ " ");
                    System.out.println(arr[r]+ " ");

                    l++;
                    r--;
                    found = true;
                }
                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0) {
                    l++;
                }
                    // if sum is greater than zero than
                    // decrement in right side
                else {
                    r--;
                }
            }
        }

        if (found == false) {
            System.out.println(" No Triplet Found");
        }

    }
}
