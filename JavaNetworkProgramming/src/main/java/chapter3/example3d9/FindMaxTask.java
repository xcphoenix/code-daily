package chapter3.example3d9;


import java.util.concurrent.Callable;

/**
 * @author      xuanc
 * @date        2019/12/7 下午4:15
 * @version     1.0
 */ 
public class FindMaxTask implements Callable<Integer> {

    private int[] data;
    private int start;
    private int end;

    public FindMaxTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

}
