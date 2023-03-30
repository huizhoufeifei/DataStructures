package com.yyf.queue;

/**
 * @author yyf
 * @date 2023/3/29 16:11
 * @Description
 */
public class CircleQueueDemo {
    public static void main(String[] args) {

    }
}
class CircleQueue{
    private int maxSize;//队列最大容量
    private int front;//队列头下标，指向第一个数据
    private int rear;//队列为下标，指向最后一个数据的下一个位置
    private int[] arr;//定义一个数组

    public CircleQueue (int arrayMaxSize){
        maxSize = arrayMaxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    //判断数组是否为空
    public boolean isNull(){
        return rear == front;
    }

    //判断数组是否已满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //存储数据
    public void addQueue(int n){
        //先判断数组是否已满
        if (isFull()){
            System.out.println("数组满，无法继续添加~");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //取数据
    public int getQueueData(){
        //判断数组是否为空
        if (isNull()){
            throw new RuntimeException("数组空，无法取数据~");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //获取所有数据
    public void getAllData(){
        //判断数组是否为空
        if (isNull()){
            throw new RuntimeException("数组空，无法取数据~");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
}
