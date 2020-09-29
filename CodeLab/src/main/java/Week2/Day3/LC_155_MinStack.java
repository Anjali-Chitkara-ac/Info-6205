package Week2.Day3;

import java.util.ArrayList;
import java.util.List;

public class LC_155_MinStack {

    List<Integer> list = new ArrayList<>();
    List<Integer> min = new ArrayList<>();

    public void push(int x){
        list.add(x);
        if(min.isEmpty()){
            min.add(x);
        }
        else {
            if (x < min.get(min.size() - 1)) {
                min.add(x);
            } else {
                min.add(min.get(min.size() - 1));
            }
        }
    }

    public int top(){
        return list.get(list.size()-1);
    }

    public void pop(){
        int a = list.size()-1;
        list.remove(a);
        min.remove(a);
    }

    public int getMin(){
        return min.get(min.size() - 1);
    }
}
