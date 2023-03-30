package com.yyf.queue;

/**
 * @author yyf
 * @date 2023/3/29 16:11
 * @Description
 */
public class QueueArrayDemo {
    public static void main(String[] args) {

    }
}
class QueueArray{
    private int maxSize;//队列最大容量
    private int front;//队列头下标，指向头数据前一个下标
    private int rear;//队列为下标
    private int[] arr;//定义一个数组

    public QueueArray (int arrayMaxSize){
        maxSize = arrayMaxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    //判断数组是否为空
    public boolean isNull(){
        return front == rear;
    }

    //判断数组是否已满
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //存储数据
    public void addQueue(int n){
        //先判断数组是否已满
        if (isFull()){
            System.out.println("数组满，无法继续添加~");
            return;
        }
        ++rear;
        arr[rear] = n;
    }

    //取数据
    public int getQueueData(){
        //判断数组是否为空
        if (isNull()){
            throw new RuntimeException("数组空，无法取数据~");
        }
        ++front;
        return arr[front];
    }

    //获取所有数据
    public void getAllData(){
        //判断数组是否为空
        if (isNull()){
            throw new RuntimeException("数组空，无法取数据~");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //获取头数据
    public int getHeadData(){
        if (isNull()){
            throw new RuntimeException("数组空，无法取数据~");
        }
        return arr[front + 1];
    }
}
