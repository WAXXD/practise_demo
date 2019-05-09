package com.waxxd.topN_minHeap;

import java.util.Arrays;

/**
 * description:
 *          获取数据中前N个元素
 * @author waxxd
 * @date 2019-05-09 15:06
 **/
public class TopN {


    /**
     * 获取给定数组中的前n个最大的
     * @param n  前n个最大的元素
     * @param data 给定数组
     * @return
     * @author waxxd
     **/
    public static int[] getTopN(int n,int[] data){
        int[] topN = Arrays.copyOf(data, n);

        MinHeap minHeap = new MinHeap(topN);
        for(int i = n;i < data.length;i++){
            if(data[n] > minHeap.getRoot()){
                minHeap.setRoot(data[n]);
            }
        }
        return topN;
    }

    public static void main(String[] args) {
        int[] data = new int[100000000];
        int i = 0;


        while(i < data.length){
            double v1 = Math.random() * 100000;
            data[i] = (int)v1;
            i++;
        }
        long l = System.currentTimeMillis();
        int[] topN = getTopN(1000, data);
        long l1 = System.currentTimeMillis() - l;
        for (int n : topN){
            System.out.println(n);
        }
        System.out.println("----" + l1);
    }
}
