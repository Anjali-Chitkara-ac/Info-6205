package Sep14;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {
    public boolean isUnique(String str){
        str = str.toLowerCase();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            if(!set.add(str.charAt(i)))
                //set.add returns a boolean
                // if it is unable to add -> that item already exists in the set
                return false;
        }
        return true;
    }

    public static void demo(){
        IsUnique obj = new IsUnique();
        boolean b1 = obj.isUnique("Anjali");
        System.out.println(b1);
    }
}
