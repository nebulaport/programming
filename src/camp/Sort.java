package camp;



/**
 * @ClassName Sort
 * @Description 各种排序
 * @Author NebulaPort
 * @Date 2019/8/26 15:11
 */
public class Sort {
    public static void main(String[] args) {
        int[] a={5,3,1,6,8};
        int[] b={5,3,1,6,8,8,123,4,23,551,551};
        int[] c={5,3,1,6,8,0};
        int[] d={1,4,6,3,2,0,0};
//        printArray(naiveGnomeSort(a));
//        printArray(improvedGnomeSort(a));
//        printArray(bubbleSort(a));
//        printArray(selectSort(a));
//        printArray(insertSort(a));
        printArray(quickSort(a));
        printArray(quickSort(b));
        printArray(quickSort(c));
        printArray(quickSort(d));





    }
    /**
     * 贪心排序
     * */
    private static int[] naiveGnomeSort(int[] s){
        for (int i = 1; i < s.length; ) {
            if (i<1||s[i-1]<=s[i]){
                i++;
            }else{
                int temp=s[i-1];
                s[i-1]=s[i];
                s[i]=temp;
                i--;
            }
        }
        return s;
    }
    /**
     * 改进版贪心排序
     * */
    private static int[] improvedGnomeSort(int[] s){
        //s[0,k)已经排好序了，我们可以直接回到k重新扫描
        for (int k = 1; k <s.length ; k++) {

            for (int i = k; 0<i&&s[i-1]>s[i] ; i--) {
                int temp=s[i-1];
                s[i-1]=s[i];
                s[i]=temp;
            }

        }
        return s;
    }
    /**
     * 冒泡排序
     * */
    private static int[] bubbleSort(int[] s){
        for (int i = 0; i < s.length; i++) {
            for (int j = 1;j < s.length-i; j++) {
                if (s[j-1]>s[j]){
                    int temp=s[j-1];
                    s[j-1]=s[j];
                    s[j]=temp;
                }
            }
        }
        return s;
    }
    /**
     * 选择排序
     * */
    private static int[] selectSort(int[] s){

        for (int i = 0; i <s.length-1 ; i++) {
            int min=i;
            for (int j = i; j < s.length; j++) {
                if (s[j]<s[min]){
                    min=j;
                }
            }
            int temp=s[i];
            s[i]=s[min];
            s[min]=temp;
        }

        return s;

    }

    /**
     * 插入排序
     * */
    private static int[] insertSort(int[] s){
        for (int i = 1; i <s.length ; i++) {
            for (int j = i; j >0 ; j--) {
                if (s[j]<s[j-1]){
                    int temp=s[j-1];
                    s[j-1]=s[j];
                    s[j]=temp;
                }else{
                    break;
                }
            }
        }

        return s;

    }
    /**
     * 归并排序
     * */
    private static void mergeSort(int[]a,int left,int right){
        if (left==right){
            return;
        }
        int mid=left+(left+right)/2;
        mergeSort(a,left,mid);
        mergeSort(a,mid+1,right);
        merge(a,left,mid,right);

    }
    private static void merge(int[] data, int left, int center, int right) {
// 临时数组
        int[] tmpArr = new int[data.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }


    }



    private static int[] mergeSort(int[] a){
        return a;
    }

    /**
     * 快速排序
     * 三值取中作为pivot
     */
    private static void quickSort(int[] a, int left, int right) {

        if (right - left < 2) {
            if (a[right] < a[left]) {
                swap(a, left, right);
            }
            return;
        }
        int pivot = Median3(a, left, right);
        int i = left + 1;
        int j = right - 2;
        while (i < j) {

            while (a[i] < pivot) {
                i++;
            }
            while (pivot < a[j]) {
                j--;
            }

            if (i < j) {
                swap(a, i, j);
            }

        }

        //如果把小规模的排序换成更简单的排序，就不用判断了
        if (a[i]>=pivot){
            swap(a, i, right - 1);
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }else {
            quickSort(a, left, right - 2);

        }




    }

    private static int Median3(int[]a, int left, int right)
    {
        //取数据的头、尾和中间三个数，并对他们进行排序
        //排序结果直接保存在数组中
        int centre = (left + right)/2;
        if(a[left] > a[centre]) {
            swap(a,left,centre);
        }
        if(a[left] > a[right]) {
            swap(a,left,right);
        }
        if(a[centre] > a[right]) {
            swap(a,centre,right);
        }
        //把中值，即pivot与数组倒数第二个元素交换
        swap(a,centre, right - 1);
        return a[right - 1];
        //返回pivot
    }
    private static int[] quickSort(int a[]){
        quickSort(a,0,a.length-1);
        return a;
    }


    /**
     * 交换
     * */
    private static void swap(int[] nums, int i, int j) {
        int temp;

        if (nums != null) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }


    /**
     * 打印数组
     * */
    private static void printArray(int[] a){
        for (int anA : a) {
            System.out.print(anA + " ");
        }
        System.out.println();
    }
}
