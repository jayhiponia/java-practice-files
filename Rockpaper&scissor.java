package hiponia_dcit23_prac4;
import java.util.Scanner;
import java.util.Random;

public class Hiponia_DCIT23_Prac4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("\n\n\n========== ROCK, PAPER AND SCISSORS! ==========");
        System.out.println("\n\n=============== GAME MECHANICS =================");
        System.out.println("1. Choose your weapon: [1] Rock, [2] Paper, [3] Scissors.");
        System.out.println("2. The computer will randomly choose its weapon.");
        System.out.println("3. Rock crushes Scissors, Scissors cut Paper, Paper covers Rock.");
        System.out.println("4. First player to score 5 points wins the match!");

        int userWins = 0;
        int compWins = 0;
        int numRounds = 0;
        
        do{
            numRounds++;
            System.out.println("\n\n\n\n\nRound " + numRounds + ", begin!");
            System.out.println("\n\n=============== ARSENAL ===============");
            System.out.println("[1] Rock");
            System.out.println("[2] Paper");
            System.out.println("[3] Scissors");
            System.out.print("Choose your weapon: ");
            int userChoice = sc.nextInt();
            
            if (userChoice > 3 || userChoice < 1){
                System.out.println("\n\n\n\nInvalid choice, try again.");
                numRounds--;
            }else {
                int compChoice = rand.nextInt(3) + 1;
                if (compChoice == 1){
                    System.out.println("The COMPUTER chose Rock.");
                }else if(compChoice == 2){
                    System.out.println("The COMPUTER chose Paper.");
                }else if(compChoice == 3){
                    System.out.println("The COMPUTER chose Scissors.");
                }
                
                if((userChoice == 1 && compChoice == 3) || (userChoice == 3 && compChoice == 2) || (userChoice == 2 && compChoice == 1)){
                    userWins++;
                    System.out.println("\n\n\n\nUSER wins this round.");
                }else if((compChoice == 1 && userChoice == 3) || (compChoice == 3 && userChoice == 2) || (compChoice == 2 && userChoice == 1)){
                    compWins++;
                    System.out.println("\n\n\n\nCOMPUTER wins this round.");
                }else if (userChoice == compChoice){
                    System.out.println("\n\n\n\nIt's a TIE.");
                }
                
                System.out.println("\nSCORES:");
                System.out.println("USER: " + userWins + " points");
                System.out.println("COMPUTER: " + compWins + " points");
            }  
        } while (userWins < 5 && compWins < 5);
        
        System.out.println("\n\n\n\n=============== GAME OVER ================");
        if (userWins < compWins){
            System.out.println("\nCOMPUTER wins this game.");
        }else if (userWins > compWins){
            System.out.println("\nUSER wins this game.");
        }else{
            System.out.println("\nNOBODY won the game.");
        }
        System.out.println("\nThank you for playing this game. Goodbye!\n");
       sc.close();
    }   
    
}
