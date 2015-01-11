public class MinStack {
    private int[] buffer;
    private int stackSize;
    private int stackTop = -1;

    public MinStack(int size) {
        stackSize = size;
        buffer = new int[stackSize];
    }

    public void push(int value) throws Exception {
        if (stackTop+1 >= stackSize) {
            throw new Exception("Stack Overflow");
        }
        stackTop++;
        buffer[stackTop] = value;
    }

    public int pop() throws Exception {
        if (stackTop == -1) {
            throw new Exception("Pop Empty stack");
        }

        int result = buffer[stackTop];
        buffer[stackTop] = 0;
        stackTop--;
        return result;
    }

    /*
    *  My Solution : For Min Stack, I don't know how to do that because if I record the Min
    *   when I pop I don't know where is the second less element, and fail to get the next Min.
    *   If I iterate throught the stack, I will cause the runtime O(n) not O(1)
    */

    /*  Answer's solution:
    *   The key Observation is that every time we update the min value, the previous one will be the
    *   second less value automaticlly. so what we need is an extra stack to keep minvalue.
    */

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack(1);
        stack.push(100);
        System.out.println(stack.pop());
    }
}
