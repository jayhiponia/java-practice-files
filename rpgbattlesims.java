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
        System.out.println(" [2] Pouch   --> Take only 1 item from your pouch that you can use.");
        System.out.println(" [3] Defend --> Brace yourself to take half damage this round.\n");

        System.out.println("Beware: The Boss is unpredictable and will attack randomly!");
        System.out.println("Defeat the Boss before your HP reaches 0.");
        System.out.println("===========================================================================\n");

        int bossHP = 200;
        int playerHP = 100;
        int numRounds = 0;

        String[] playerPouch = {"Minor Potion", "Throwing Axe", "Cursed Relic", "Mystic Scroll", "Iron Plating", "Vampire Vial"};
        boolean defenseState = false;
        boolean pouchOpen = false;
        boolean isEvading = false;

        mainBattleLoop:
        while (bossHP > 0 && playerHP > 0){ 
            numRounds++;
            isEvading = false;
            defenseState = false;
            System.out.println("\n\n\n\n\n\n=========================================");
            System.out.printf("PLAYER HP: %d   |   BOSS HP: %d%n", playerHP, bossHP);
            System.out.println("=========================================");
            System.out.println("\n\nRound " + numRounds + ", begin!");
            System.out.println("\n========= ACTIONS =========");
            System.out.println("[1] Attack");
            System.out.println("[2] Pouch");
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
                    pouchOpen = false;
                    while (!pouchOpen){
                        System.out.println("\n\n\n========= YOUR POUCH =========");
                        for (int i = 0; i < playerPouch.length; i++){
                            System.out.println("[" + (i + 1) + "] " + playerPouch[i]);
                        }
                        System.out.println("\n[" + (playerPouch.length + 1) + "] Cancel and Go Back");
                        System.out.print("Choose an item: ");
                        int itemChoice = sc.nextInt();

                        switch (itemChoice){
                            case 1:
                                if (playerPouch[0].equals("Empty")){
                                    System.out.println("\n\nYou reach into your pouch, but you have no Minor Potion left!");
                                    continue;
                                }else if(!playerPouch[0].equals("Empty")){
                                    System.out.println("\n\nYou took the " + playerPouch[0]);
                                    System.out.println("You uncap the vial and drink the glowing red liquid. You recover health!");
                                    playerHP = Math.min(playerHP + 40, 120);
                                    playerPouch[0] = "Empty";
                                    pouchOpen = true;
                                }
                                break;
                            case 2:
                                if (playerPouch[1].equals("Empty")){
                                    System.out.println("\n\nYou reach into your pouch, but you have no Throwing Axe left!");
                                    continue;
                                }else if(!playerPouch[1].equals("Empty")){
                                    System.out.println("\n\nYou took the " + playerPouch[1]);
                                    System.out.println("You hurl the heavy axe through the air! It strikes the Boss for 25 damage!");
                                    bossHP -= 25;
                                    playerPouch[1] = "Empty";
                                    pouchOpen = true;
                                }
                                break;
                            case 3:
                                if (playerPouch[2].equals("Empty")){
                                    System.out.println("\n\nYou reach into your pouch, but you have no Cursed Relic left!");
                                    continue;
                                }else if(!playerPouch[2].equals("Empty")){
                                    System.out.println("\n\nYou took the " + playerPouch[2]);
                                    System.out.println("The relic burns your hands as it unleashes dark magic! The Boss takes massive damage, but you are hurt in the process.");
                                    playerHP -= 15;
                                    bossHP -= 20;
                                    playerPouch[2] = "Empty";
                                    pouchOpen = true;
                                }
                                break;
                            case 4: 
                                if (playerPouch[3].equals("Empty")){
                                    System.out.println("\n\nYou reach into your pouch, but you have no Mystic Scroll left!");
                                    continue;
                                }else if (!playerPouch[3].equals("Empty")){
                                    System.out.println("\n\nYou took the " + playerPouch[3]);
                                    System.out.println("You read the glowing runes! A chaotic blast of energy hits the Boss for [X] damage!"); 
                                    int mysticScroll = rand.nextInt(4) * 10;
                                    bossHP -= mysticScroll;
                                    playerPouch[3] = "Empty";
                                    pouchOpen = true;
                                }
                                break;
                            case 5:
                                if (playerPouch[4].equals("Empty")){
                                    System.out.println("\n\nYou reach into your pouch, but you have no Iron Plating left!");
                                    continue;
                                }else if (!playerPouch[4].equals("Empty")){
                                    System.out.println("\n\nYou took the " + playerPouch[4]);
                                    System.out.println("You strap on temporary armor plates. You are braced for impact!"); 
                                    defenseState = true;
                                    playerPouch[4] = "Empty";
                                    pouchOpen = true;
                                }
                                break;
                            case 6:
                                if (playerPouch[5].equals("Empty")){
                                    System.out.println("\n\nYou reach into your pouch, but you have no Vampire Vial left!");
                                    continue;
                                }else if (!playerPouch[5].equals("Empty")){
                                    System.out.println("\n\nYou took the " + playerPouch[5]);
                                    System.out.println("You smash the vial! It drains the Boss's life force and heals you!"); 
                                    playerHP += 15;
                                    bossHP -= 15;
                                    playerPouch[5] = "Empty";
                                    pouchOpen = true;
                                }
                                break;
                            case 7:
                                System.out.println("\n\n\nYou closed your pouch.");
                                numRounds--;
                                continue mainBattleLoop;
                            default:
                                System.out.println("\n\nInvalid choice, please choose again.");
                                continue mainBattleLoop;
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n\nYou stay light on your feet, ready to dodge the next attack!");
                    isEvading = true;
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
                    if (isEvading){
                        boolean evadeSuccess = rand.nextBoolean();
                        if (evadeSuccess){
                            System.out.println("You swiftly sidestep the attack! You take 0 damage.");
                        }else{
                            System.out.println("You trip while trying to dodge! You take the full 15 damage.");
                            playerHP -= 15;
                        }
                    }else{
                        if (defenseState){
                            playerHP -= 7;
                        }else{
                            playerHP -= 15;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nThe Boss glows red and unleashes a Heavy Attack!");
                    if (isEvading){
                        boolean evadeSuccess = rand.nextBoolean();
                        if (evadeSuccess){
                            System.out.println("\n\nYou swiftly sidestep the attack! You take 0 damage.");
                        }else{
                            System.out.println("\n\nYou trip while trying to dodge! You take the full 15 damage.");
                            playerHP -= 15;
                        }
                    }else{
                        if (defenseState){
                            playerHP -= 12;
                        }else{
                            playerHP -= 25;
                        }
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

        System.out.println("\n================= FINAL STATS ==================");
        System.out.printf("PLAYER HP: %d   |   BOSS HP: %d%n", playerHP, bossHP);
        System.out.println("================================================\n\n\n\n\n");
        sc.close();
    }
}
