
public class ThreeStack {
    private static int stackSize = 100;
    private static int[] buffer = new int[stackSize * 3];

    private static int[] stackPointer = {-1, -1, -1};

    public static void main(String[] args) {
        System.out.println("Queue and Stack");
    }

    static void push(int stackNum, int value) throws Exception {
        // Check wheter that stack has been full
        if (stackPointer[stackNum]+1 >= stackSize) {
            throw new Exception();
        }

        stackPointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = value;
    }

    static int pop(int stackNum) throws Exception {
        if (stackPointer[stackNum] == -1) {
            throw new Exception();
        }
        int result = buffer[absTopOfStack(stackNum)];
        buffer[absTopOfStack(stackNum)] = 0;
        stackPointer[stackNum]--;
        return result;
    }

    static int peek(int stackNum) throws Exception {
        if (stackPointer[stackNum] == -1) {
            throw new Exception();
        }
        return buffer[absTopOfStack(stackNum)];
    }

    private static int absTopOfStack(int stackNum) {
        return stackSize * stackNum + stackPointer[stackNum];
    }
}
