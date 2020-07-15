import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();
        System.out.print("Enter the number of chairs:");
        int chairs=sc.nextInt();

        Queue<String> standing=new LinkedList<String>();
        Queue<String> sitting=new LinkedList<String>();

        System.out.print("Enter the number of players:");
        int players=sc.nextInt();

        for(int i=0;i<chairs;i++){
            System.out.print("Enter the name of players:");
            String player=sc.next();
            sitting.add(player);
        }
        for(int i=chairs;i<players;i++){
            System.out.print("Enter the name of players:");
            String player=sc.next();
            standing.add(player);
        }

        while(chairs>0){
            int rotation=rand.nextInt(chairs*players);
            for(int i=0;i<rotation;i++){
                standing.add(sitting.poll());
                sitting.add(standing.poll());
            }
            // System.out.println(Arrays.toString(sitting.toArray(new String[sitting.size()])));
            // System.out.println(Arrays.toString(standing.toArray(new String[standing.size()])));
            System.out.print("Do you want to continue(y/n):");
            String check=sc.next();
            if(check.equals("y")){
                System.out.println("People Still in chair are:");
                System.out.println(Arrays.toString(sitting.toArray(new String[sitting.size()])));
            }
            else{
                System.out.println("Bye");
                System.out.println("People Still in chair are:");
                break;
            }
            players=chairs;
            chairs--;
            standing.clear();
            if(sitting.size()>1){
                standing.add(sitting.poll());
            }
            else{
                break;
            }
        
        }
        System.out.println(Arrays.toString(sitting.toArray(new String[sitting.size()])));

    }
}
