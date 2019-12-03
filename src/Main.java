import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        /*
        //Task1
        String name="quain";
        String path = System.getProperty("user.dir") + "/src/glove6B300d.txt";
        Reader r = new Reader(path,name);
        double[] myVector=r.getMyVector();
        CalculateDistance c=new CalculateDistance(myVector,path);
        PriorityQueue<String[]> queue=c.getQueue();

        int count=6;
        while(count>0){
            String[] temp=queue.poll();
            System.out.println(temp[0]+": "+temp[1]);
            count--;
        }
        //System.out.println(myVector.length);
*/

        /*
        //Task 2
        String sentence="practice makes perfect";
        String path = System.getProperty("user.dir") + "/src/glove6B300d.txt";
        ReadVectorRep r=new ReadVectorRep(path,sentence);
        double[] myVector=r.getVector();
        CalculateDistance c=new CalculateDistance(myVector,path);
        PriorityQueue<String[]> queue=c.getQueue();

        int count=10;
        while(count>0){
            String[] temp=queue.poll();
            System.out.println(temp[0]+": "+temp[1]);
            count--;
        }
        */

        //Task 3
        String sentence="practice makes perfect";
        String sentenceA="working hard is very important";
        String sentenceB="practice is in vain";
        String path = System.getProperty("user.dir") + "/src/glove6B300d.txt";

        ReadVectorRep v=new ReadVectorRep(path,sentence);
        double[] vector=v.getVector();

        ReadVectorRep a=new ReadVectorRep(path,sentenceA);
        double[] vectorA=a.getVector();

        ReadVectorRep b=new ReadVectorRep(path,sentenceB);
        double[] vectorB=b.getVector();

        double distance1=CosineSimilarity.similarity(vector,vectorA);
        double distance2=CosineSimilarity.similarity(vector,vectorB);

        System.out.print(distance1);
        System.out.print(distance2);
    }
}
