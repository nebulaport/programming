package questions;

/**
 * @ClassName MinGeneric
 * @Description 实现最小值函数
 * 自己设计一个泛型的获取数组最小值的函数.
 * 并且这个方法只能接受Number的子类并且实现了Comparable接口。
 * @Author NebulaPort
 * @Date 2019/7/29 16:02
 */
public class MinGeneric {
    public static void main(String[] args) {
        Integer[] intArray={0,1,2};
        Double[] doubleArray={1.1,2.3,-1d};
        System.out.println(min(intArray));
        System.out.println(min(doubleArray));

    }
    private static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) {
                min = values[i];
            }
        }
        return min;
    }
}
