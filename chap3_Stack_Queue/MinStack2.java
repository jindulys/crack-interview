import java.util.Stack;
public class MinStack2 extends Stack<Integer> {
    private Stack<Integer> s2;
    public MinStack2() {
        s2 = new Stack<Integer>();
    }

    public void push(int value) {
        if (value < min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }
        return value;
    }

    public int min() {
        if (s2.empty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }
}
