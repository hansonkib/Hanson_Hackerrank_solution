package Algorithm.NumberJump;

public class Result {
    public static String kangaroo(int x1, int v1, int x2, int v2){
        String result = "";
        int x = 0;
        int y =0;
        x = x1 + v1;
        y = x2 + v2;
        if(x==y){
            result = "YES";
        }
        else{
            result = "NO";
        }

    return result;
    }
}
