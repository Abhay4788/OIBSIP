import java.util.Scanner;
public class GuessThenumber{
    public static void main(String[] args){
        int random=(int)(Math.random()*100);

        System.out.print("Guess the number:");
        Scanner sc=new Scanner(System.in);
        int guess=sc.nextInt();

        boolean flag=true;
        while(flag){
            if(guess == random){
                flag=false;
            System.out.println("Congratulation! Your guess was correct");
        }
        else if(guess > random){
           System.out.println("The number is lower than this");
           System.out.print("Guess the number again:");
           guess=sc.nextInt();
        }
        else{
            System.out.println("The number is higer than this");
            System.out.print("Guess the number:");
            guess=sc.nextInt();
            
        }
    
    }

    }
}
