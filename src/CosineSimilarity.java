public class CosineSimilarity {
    public static double similarity(double[] vector1,double[] vector2){
        //a=xi*y*, b=x^2,c=y^2
        double a=0d,b=0d,c=0d;

        for(int i=0;i<300;i++){
            a+=vector1[i]*vector2[i];
            b+=vector1[i]*vector1[i];
            //c+=Math.pow((Double.parseDouble(word[j])),2);
            c+=vector2[i]*vector2[i];
        }
        b=Math.sqrt(b);
        c=Math.sqrt(c);

        return (a/(b*c));
    }
}
