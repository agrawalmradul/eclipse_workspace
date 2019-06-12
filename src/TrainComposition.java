
import java.util.*;

public class TrainComposition {
    public LinkedList<Integer> list;
    
    public TrainComposition(){
        list = new LinkedList<Integer>();
    }
    
    public void attachWagonFromLeft(int wagonId) {
        list.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        list.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        return list.removeFirst();
    }

    public int detachWagonFromRight() {
        return list.removeLast();
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7 
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}