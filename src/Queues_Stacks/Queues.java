package Queues_Stacks;

public class Queues {
    public static void main(String[] args) {
        // Test case
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4


        MyCircularQueue myCircularQueue2 = new MyCircularQueue(1);
        myCircularQueue2.enQueue(1);
        myCircularQueue2.enQueue(2); // return True
        myCircularQueue2.enQueue(3); // return True
        myCircularQueue2.enQueue(4); // return False
        myCircularQueue2.Rear();     // return 3
        myCircularQueue2.isFull();   // return True
        myCircularQueue2.deQueue();  // return True
        myCircularQueue2.enQueue(4); // return True
        myCircularQueue2.Rear();     // return 4
    }
}

// MyCircularQueue(k) Initializes the object with the size of the queue to be k.
// int Front() Gets the front item from the queue. If the queue is empty, return -1.
// int Rear() Gets the last item from the queue. If the queue is empty, return -1.
// boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
// boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
// boolean isEmpty() Checks whether the circular queue is empty or not.
// boolean isFull() Checks whether the circular queue is full or not.


class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    private int size;
    public MyCircularQueue(int k) {
        this.size = k+1;
        data = new int[k+1];
        // 'Head' refers to an empty position
        // Loop array needs to take up one more place
        head = 0;
        tail = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        else{
            tail = (tail + 1)%size;
            data[tail] = value;
            return true;
        }
        //
        
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head + 1)%size;

        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[(head+1)%size];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[tail];
    }
    
    public boolean isEmpty() {
        if(head==tail){
            return true;
        }else return false;
    }
    
    public boolean isFull() {
        // The tail is always 'size' units longer than the head
        if((head + size - 1)% size == tail){
            return true;
        }else return false;
    }
}

