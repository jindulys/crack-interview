import java.util.Stack;
import java.util.ArrayList;

public class SetOfStacks {
    int capacity;
    ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(int value) {
        Stack<Integer> stack = getLastStack();
        if (stack != null && !isFull(stack)) {
            stack.push(value);
        } else {
            stack = new Stack<Integer>();
            stack.push(value);
            stacks.add(stack);
        }
    }

    //Why java could return null instead of a Stack<Integer>
    private Stack<Integer> getLastStack() {
        int size = stacks.size();
        if (size == 0) {
            return null;
        } else {
            return stacks.get(size-1);
        }
    }

    private boolean isFull(Stack<Integer> stack) {
        if (stack == null) return true;
        if (stack.size() < capacity) return false;
        return true;
    }



    public int pop() throws Exception{
        Stack<Integer> stack = getLastStack();
        if (stack == null) throw new Exception("Empty Stack");
        Integer result = stack.pop();
        if (stack.size() == 0) stacks.remove(stacks.size()-1);
        return result;
    }


    public static void main(String[] args) throws Exception{
        SetOfStacks stacks = new SetOfStacks(2);
        stacks.push(5);
        stacks.push(6);
        stacks.push(9);
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
    }
}
