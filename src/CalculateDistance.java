import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CalculateDistance {
    private PriorityQueue<String[]> queue;

    public CalculateDistance(double[] myVector, String path){
        try{
            String[] strs;
            String[] temp;
            double distance;
            Scanner scan=new Scanner(new File(path));

            //Initialize priorityQueue
            queue=new PriorityQueue<>(new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    //this is ascending order
                    //if(Double.parseDouble(o1[1])>Double.parseDouble(o2[1])) return 1;
                    //if(Double.parseDouble(o1[1])<Double.parseDouble(o2[1])) return -1;

                    //this is descending order
                    if(Double.parseDouble(o1[1])>Double.parseDouble(o2[1])) return -1;
                    if(Double.parseDouble(o1[1])<Double.parseDouble(o2[1])) return 1;
                    return 0;
                }
            });

            System.out.println("Comparing similarity......");
            while(scan.hasNext()){
                strs=scan.nextLine().split("\\s+");
                distance=CosineSimilarity(strs,myVector);
                //System.out.println(strs[0]+": "+distance+",int:"+new Double(distance*).intValue());
                temp=new String[2];
                temp[0]=strs[0];
                temp[1]=String.valueOf(distance);
                queue.add(temp);
            }

            System.out.println("completed!");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private double CosineSimilarity(String[] word, double[] myVector){

        //a=xi*y*, b=x^2,c=y^2
        double a=0d,b=0d,c=0d;
        for(int i=0,j=1;i<300;i++,j++){
            a+=myVector[i]*(Double.parseDouble(word[j]));
            //b+=Math.pow(myVector[i],2);
            b+=myVector[i]*myVector[i];
            //c+=Math.pow((Double.parseDouble(word[j])),2);
            c+=Double.parseDouble(word[j])*Double.parseDouble(word[j]);
        }
        b=Math.sqrt(b);
        c=Math.sqrt(c);

        return (a/(b*c));
    }

    public PriorityQueue<String[]> getQueue(){
        return queue;
    }
}
