public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99, 100};
        int target = 33;

        System.out.println(bSearch(arr, target));
        System.out.println(bSearchRecursive(arr, target,0 , arr.length-1));
    }

    private static boolean bSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private static boolean bSearchRecursive(int[] arr, int target, int left, int right) {
        if(left > right)
            return false;

        int mid = (left + right) / 2;

        if (arr[mid] < target) {
            return bSearchRecursive(arr, target, mid+1, right);
        } else if (arr[mid] > target) {
            return bSearchRecursive(arr, target, left, mid - 1);
        } else return true;

    }
}
