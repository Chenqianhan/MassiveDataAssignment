import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ReadVectorRep {
    private double[] vector;

    public ReadVectorRep(String path, String sentence){
        try{
            String[] sen=sentence.split("\\s+");
            String[] strs;
            int len=sen.length;
            Scanner scan=new Scanner(new File(path));
            vector=new double[300];
            Arrays.fill(vector,0d);

            HashMap<String,Integer> map=new HashMap<>();
            for(String s:sen){
                if(map.containsKey(s)) len--;

                map.put(s,0);
            }

            System.out.println("Calculating representations.....");
            while(scan.hasNext()){
                strs=scan.nextLine().split("\\s+");
                if(map.containsKey(strs[0])){
                    System.out.println("Found "+strs[0]);
                    for(int i=1;i<strs.length;i++){
                        vector[i-1]+=Double.parseDouble(strs[i]);
                    }
                }
            }

            for(int i=0;i<vector.length;i++){
                vector[i]/=len;
            }
            System.out.println("Calculated successfully!");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public double[] getVector() {
        return vector;
    }
}
