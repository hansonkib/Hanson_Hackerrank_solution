package Algorithm.CompareTriplets;

public class CompareTriplets {
    public String compare(int[] a, int[] b){
        int bobPoints =0,alicePoints=0;
        int[] result = new int[2];
        if (a.length == b.length){
            for (int i = 0; i < a.length; i++) {
               if (a[i]>b[i]){
//                   award points to allice
                   alicePoints++;
               }
               else if (a[i] == b[i]){
//                   nobody is awarded points
                   alicePoints=alicePoints+0;
                   bobPoints = bobPoints+0;
               }
               else {
//                   bob is awarded points
                   bobPoints++;
               }
            }
        }
       result[0]=alicePoints;
        result[1]=bobPoints;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]+" ");
        }
        System.out.print(sb);
        return sb.toString();
    }

}
