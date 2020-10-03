package Week2.Day5;

public class LC_739_DailyTemp {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for(int i=0;i<T.length;i++){
            if(i==T.length-1) result[i] =0;
            for(int j=i+1;j<T.length;j++){
                if(T[j]>T[i]){
                    result[i]=j-i;
                    break;
                }else result[i]=Integer.MIN_VALUE;
            }
            if(result[i]==Integer.MIN_VALUE) result[i]=0;
        }
        return result;
    }
}
