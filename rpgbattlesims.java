import java.util.Random;
import java.util.Scanner;

public class rpgbattlesims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("\n\n===================== WELCOME TO THE COLOSSEUM ============================\n");
        System.out.println("========================= GAME MECHANICS ===========================");
        System.out.println("On your turn, enter a number to choose your action.");
        System.out.println(" [1] Attack --> Deal 20 damage to the Boss.");
        System.out.println(" [2] Heal   --> Consume 1 potion to restore 30 HP.");
        System.out.println(" [3] Defend --> Brace yourself to take half damage this round.\n");

        System.out.println("Beware: The Boss is unpredictable and will attack randomly!");
        System.out.println("Defeat the Boss before your HP reaches 0.");
        System.out.println("===========================================================================\n");

        int bossHP = 150;
        int playerHP = 100;
        int potions = 3;
        int numRounds = 0;

        boolean defenseState = false;

        while (bossHP > 0 && playerHP > 0){ 
            numRounds++;
            defenseState = false;
            System.out.println("\n\n\n\n\n\n=========================================");
            System.out.printf("PLAYER HP: %d   |   POTIONS: %d%n", playerHP, potions);
            System.out.printf("BOSS HP: %d%n", bossHP);
            System.out.println("=========================================");
            System.out.println("\n\nRound " + numRounds + " , begin!");
            System.out.println("\n ========= ACTIONS =========");
            System.out.println("[1] Attack");
            System.out.println("[2] Heal");
            System.out.println("[3] Defend");
            System.out.print("Enter your action: ");
            int playerAction = sc.nextInt();
            int bossAction = rand.nextInt(3) + 1;

            switch (playerAction) {
                case 1:
                    System.out.println("\n\nYou swing your sword with all your might!");
                    bossHP -= 20;
                    break;
                case 2:
                    if (potions >= 1){
                        System.out.println("\n\nYou drink a potion and feel your wounds close.");
                        potions--;
                        playerHP += 30;
                    }else {
                        System.out.println("\n\nYou have no potions left! Pick another action.");
                        numRounds--;
                        continue;
                    }
                    break;
                case 3:
                    System.out.println("\n\nYou raise your shield, bracing for impact!");
                    defenseState = true;
                    break;
                default:
                    System.out.println("\n\nInvalid input, try again.");
                    numRounds--;
                    continue;
            }

            if (bossHP < 0){
                System.out.println("\nThe BOSS collapsed to the ground!");
                break;
            }

            switch (bossAction) {
                case 1:
                    System.out.println("\nThe Boss lunges forward with a standard strike!");
                    if (defenseState){
                        playerHP -= 7;
                    }else{
                        playerHP -= 15;
                    }
                    break;
                case 2:
                    System.out.println("\nThe Boss glows red and unleashes a Heavy Attack!");
                    if (defenseState){
                        playerHP -= 12;
                    }else{
                        playerHP -= 25;
                    }
                    break;
                case 3:
                    System.out.println("\nThe Boss laughs maniacally, completely missing you.");
                    break;
                default:
                    break;
            }
        }

        if (bossHP <= 0){
            System.out.println("\n\n\n\n\nVictory! The village will celebrate your heroism and your bravery will be!\n");
        }else if (playerHP <= 0){
            System.out.println("\n\n\n\n\nGame Over, you have died! The village has been annihilated and reduced to atoms.\n");
        }

        System.out.println("================= FINAL STATS ==================");
        System.out.printf("PLAYER HP: %d   |   POTIONS: %d%n", playerHP, potions);
        System.out.printf("BOSS HP: %d%n", bossHP);
        System.out.println("================================================\n\n\n\n\n");
        sc.close();
    }
}
