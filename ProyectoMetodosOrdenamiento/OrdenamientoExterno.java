public class OrdenamientoExterno {

  /*
   * MergeSort
   */
  public static void mergeSort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  static void merge(int arr[], int l, int m, int r) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];

    /* Copy data to temp arrays */
    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  // Main function that sorts arr[l..r] using
  // merge()
  static void sort(int arr[], int l, int r) {
    if (l < r) {
      // Find the middle point
      int m = l + (r - l) / 2;

      // Sort first and second halves
      sort(arr, l, m);
      sort(arr, m + 1, r);

      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }

  /* A utility function to print array of size n */
  static void printArray(int arr[]) {
    int n = arr.length;
    System.out.print("[");
    for (int i = 0; i < n; ++i) {
      System.out.print(arr[i]);
      if (i < n - 1) {
        System.out.print(", ");
      } else {
        System.out.print(" ");
      }
    }
    System.out.println("]");
  }

  /*
   * Natural Merge Sort
   */

  private static void merge(int[] source, int[] target, int startLeft, int startRight, int endRight) {
    int leftPos = startLeft;
    int rightPos = startRight;
    int targetPos = startLeft;

    // As long as both arrays contain elements...
    while (leftPos < startRight && rightPos < endRight) {
      // Which one is smaller?
      int leftValue = source[leftPos];
      int rightValue = source[rightPos];
      if (leftValue <= rightValue) {
        target[targetPos++] = leftValue;
        leftPos++;
      } else {
        target[targetPos++] = rightValue;
        rightPos++;
      }
    }
    // Copy the rest
    while (leftPos < startRight) {
      target[targetPos++] = source[leftPos++];
    }
    while (rightPos < endRight) {
      target[targetPos++] = source[rightPos++];
    }
  }

  public static void Naturalsort(int[] elements) {
    int numElements = elements.length;

    int[] tmp = new int[numElements];
    int[] starts = new int[numElements + 1];

    // Step 1: identify runs
    int runCount = 0;
    starts[0] = 0;
    for (int i = 1; i <= numElements; i++) {
      if (i == numElements || elements[i] < elements[i - 1]) {
        starts[++runCount] = i;
      }
    }

    // Step 2: merge runs, until only 1 run is left
    int[] from = elements;
    int[] to = tmp;

    while (runCount > 1) {
      int newRunCount = 0;

      // Merge two runs each
      for (int i = 0; i < runCount - 1; i += 2) {
        merge(from, to, starts[i], starts[i + 1], starts[i + 2]);
        starts[newRunCount++] = starts[i];
      }

      // Odd number of runs? Copy the last one
      if (runCount % 2 == 1) {
        int lastStart = starts[runCount - 1];
        System.arraycopy(from, lastStart, to, lastStart,
            numElements - lastStart);
        starts[newRunCount++] = lastStart;
      }

      // Prepare for next round...
      starts[newRunCount] = numElements;
      runCount = newRunCount;

      // Swap "from" and "to" arrays
      int[] help = from;
      from = to;
      to = help;
    }
    printArray(elements);
    // If final run is not in "elements", copy it there
    if (from != elements) {
      System.arraycopy(from, 0, elements, 0, numElements);
    }
  }

  /*
   * In place sort
   */

  static void Imerge(int arr[], int start, int mid, int end) {
    int start2 = mid + 1;

    // If the direct merge is already sorted
    if (arr[mid] <= arr[start2]) {
      return;
    }

    // Two pointers to maintain start
    // of both arrays to merge
    while (start <= mid && start2 <= end) {

      // If element 1 is in right place
      if (arr[start] <= arr[start2]) {
        start++;
      } else {
        int value = arr[start2];
        int index = start2;

        // Shift all the elements between element 1
        // element 2, right by 1.
        while (index != start) {
          arr[index] = arr[index - 1];
          index--;
        }
        arr[start] = value;

        // Update all the pointers
        start++;
        mid++;
        start2++;
      }
    }
  }

  /*
   * l is for left index and r is right index of the
   * sub-array of arr to be sorted
   */
  static void mergeSort(int arr[], int l, int r) {
    if (l < r) {

      // Same as (l + r) / 2, but avoids overflow
      // for large l and r
      int m = l + (r - l) / 2;

      // Sort first and second halves
      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      Imerge(arr, l, m, r);
    }
  }

  public static void inplaceSort(int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
    printArray(arr);
  }
}
