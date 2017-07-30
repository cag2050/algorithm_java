public class BinarySearchDemo {
    /**
     * 非递归方法，利用while循环
     *
     * @param arr
     * @param des
     * @return
     */
    public static int binarySearch(int[] arr, int des) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
//            使用 (low + high) / 2，如果low和high的和大于Integer.MAX_VALUE(在java中是2 23 -1)，计算就会发生溢出，使(low + high)成为一个负数，然后被2除，结果当然仍是负数。
//            int middle = (low + high) / 2;
            int middle = low + (high - low) / 2;
            if (arr[middle] == des) {
                return middle;
            } else if (arr[middle] < des) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 递归查找
     *
     * @param arr
     * @param des
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int[] arr, int des, int low, int high) {
//        int middle = (low + high) / 2;
        int middle = low + (high - low) / 2;
        if (des < arr[low] || des > arr[high] || low > high) {
            return -1;
        }
        if (arr[middle] < des) {
            return binarySearch(arr, des, middle + 1, high);
        } else if (arr[middle] > des) {
            return binarySearch(arr, des, low, middle - 1);
        } else {
            return middle;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 11, 15, 17};
        int des = 15;
        System.out.println("所查找元素在数组中的下标为：" + binarySearch(arr, des));
        System.out.println("所查找元素在数组中的下标为：" + binarySearch(arr, des, 0, 10));
    }
}
