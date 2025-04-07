package Actividad03;

public class BinarySearchIterativo {
    int binarySearch(int arr[], int x) {
        int lo = 0, hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (arr[mid] == x)
                return mid;
            
            if (arr[mid] < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchIterativo ob = new BinarySearchIterativo();
        int arr[] = { 1, 2, 3, 4, 5 };
        //int n = arr.length; no se usa en este caso
        int x = 3;
        int position = ob.binarySearch(arr, x);
        
        if (position == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index: " + position);
    }
}
