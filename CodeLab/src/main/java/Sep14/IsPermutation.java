package Sep14;

import java.util.*;

public class IsPermutation {

    public boolean isPermutation(String strA, String strB){
        if(strA.length()!=strB.length()){
            return false;
        }
        strA = strA.toLowerCase();
        strB = strB.toLowerCase();
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<strA.length();i++){
            if(!map.containsKey(strA.charAt(i))){
                map.put(strA.charAt(i), 1);
            }
            else{
                map.put(strA.charAt(i),map.get(strA.charAt(i))+1);
            }
        }
        for(int j=0;j<strB.length();j++){
            if(!map.containsKey(strB.charAt(j))){
                return false;
            }
            else{
                map.put(strB.charAt(j),map.get(strB.charAt(j))-1);
            }
        }
        //if any value in the map>0
        //return false
        for(int i : map.values()){
            if (i>0){
                return false;
            }
        }
        return true;
    }

    public static void demo(){
        IsPermutation obj = new IsPermutation();

        boolean b1 = obj.isPermutation("aghdff","Ffgadh");
        System.out.println(b1);
    }
}
