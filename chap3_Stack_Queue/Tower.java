import java.util.*;

public class Tower {
    // The index of tower;
    int index;

    // Store the disks
    Stack<Integer> disks;

    public Tower(int i) {
        index = i;
        disks = new Stack<Integer>();
    }

    public void addTop(int i) throws Exception {
        if (!disks.empty() && disks.peek() < i) throw new Exception("Add Top Not allowed");
        disks.push(i);
    }

    public void moveTop(Tower des) throws Exception {
        try {
            int top = disks.pop();
            des.addTop(top);
            System.out.println("Moving" + top + "From Tower -" + this.index + "To Tower -" + des.index);
        } catch (EmptyStackException e) {
            throw new Exception("Move empty tower");
        }
    }

    public void moveDisks(int n,Tower des, Tower buf) throws Exception{
        if (n == 0) return;
        moveDisks(n-1, buf, des);
        moveTop(des);
        buf.moveDisks(n-1,des,this);
    }

    public static void main(String[] args) throws Exception {
        Tower[] towers = new Tower[3];
        for(int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for(int i = 6; i>0; i--) {
            towers[0].addTop(i);
        }

        towers[0].moveDisks(6, towers[2], towers[1]);
    }
}
