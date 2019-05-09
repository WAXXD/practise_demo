package com.waxxd.topN_minHeap;

/**
 * description:
 *          最小堆
 * @author waxxd
 * @date 2019-05-09 14:30
 **/
public class MinHeap {

    private int[] data; // 存储结构

    public MinHeap(int[] data){
        this.data = data;
        buildHeap();
    }

    /**
     * 构建最小堆
     * @return
     * @author waxxd
     **/
    private void buildHeap(){
        for(int i = data.length / 2 - 1;i >= 0;i--){
            heapify(i);
        }
    }

    /**
     * 将节点，左子节点和右子节点中较小的节点作为父节点
     * @param i
     * @return
     * @author waxxd
     **/
    private void heapify(int i){
        int l = left(i);
        int r = right(i);

        int min = i;

        // 左节点存在且左节点小于父节点
        if(l < data.length && data[l] < data[i]){
            min = l;
        }

        // 存在右节点且右节点小于min节点
        if(r < data.length && data[r] < data[min]){
            min = r;
        }

        if(i == min) return;

        swap(i,min); // 交换

        heapify(min);
    }

    /**
     * 获取左子节点的数组下标
     * @param i
     * @return
     * @author waxxd
     **/
    private int left(int i){
        return ((i + 1) << 1) - 1;
    }

    /**
     * 获取右子节点的数组下标
     * @param i
     * @return
     * @author waxxd
     **/
    private int right(int i){
        return ((i + 1) << 1);
    }

    /**
     * 交换数组中的位置
     * @param i
     * @param min
     * @return
     * @author waxxd
     **/
    private void swap(int i ,int min){
        int temp = data[i];
        data[i] = data[min];
        data[min] = temp;
    }

    /**
     * 获取根节点，也就是最小的值
     * @return
     * @author waxxd
     **/
    public int getRoot(){
        return data[0];
    }

    /**
     * 改变根节点
     * @param root
     * @return
     * @author waxxd
     **/
    public void setRoot(int root){
        data[0] = root;
        heapify(0);
    }

}
