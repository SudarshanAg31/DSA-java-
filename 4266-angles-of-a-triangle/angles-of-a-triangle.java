class Solution {
    public double[] internalAngles(int[] sides) {
     int a=sides[0];
     int b=sides[1];   
     int c=sides[2];   
        if(a+b<=c||b+c<=a||c+a<=b){
            return new double[0];
        }
        double[] ans=new double [3];
        double A= Math.acos((b*b+c*c-a*a)/(2.0*b*c));
        double B= Math.acos((a*a+c*c-b*b)/(2.0*a*c));
        double C= Math.acos((a*a+b*b-c*c)/(2.0*a*b));
        A=Math.toDegrees(A);
        B=Math.toDegrees(B);
        C=Math.toDegrees(C);
        ans[0]=A;
        ans[1]=B;
        ans[2]=C;
        Arrays.sort(ans);
        return ans;
    }
}