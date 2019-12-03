import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Scanner;

public class Reader {
    private double[] myVector;

    public Reader(String path,String name){
        try{
            Scanner scan=new Scanner(new File(path));
            String[] strs;
            myVector=new double[300];

            System.out.println("Searching my name.....");
            while(scan.hasNext()){
                strs=scan.nextLine().split("\\s+");
                if(strs[0].equals(name)){
                    for(int i=1;i<strs.length;i++){
                        myVector[i-1]=Double.parseDouble(strs[i]);
                        //System.out.println(strs[i-1]);
                    }
                    break;
                }
            }
             System.out.println("Got your name word successfully!");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public double[] getMyVector(){
        return myVector;
    }
}
