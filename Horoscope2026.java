package com.mycompany.hiponia_dcit23_act4;
import java.util.Scanner;


public class Hiponia_DCIT23_Act4 {

    public static void main(String[] args) {
        Scanner horoscope = new Scanner(System.in);
        String user = "Jay";
        String pass = "060108";
        
        System.out.println("Please enter your credentials before we proceed");
        
        boolean isAuthenticated = false;
        
        do{
            System.out.print("Username: ");
            String inputUser = horoscope.nextLine().trim();
            System.out.print("Password: ");
            String inputPass = horoscope.nextLine().trim();
            
                if (inputUser.equals(user) && inputPass.equals(pass)){
                    isAuthenticated = true;
                    
                    System.out.println();
                    for (int i = 1; i <= 20; i++){
                        System.out.print(" * ");
                    }
                    System.out.println("\n");
                    System.out.println("Welcome to Horoscope 2026, " + user + "!");
                    System.out.println("Let's see your fortune for today.");
                    
                    boolean isCorrectLetter = false;
                    
                    do {
                        System.out.println("\nChoose your Zodiac Sign. Are you a/an:");
                        System.out.println("[a] Aries ");
                        System.out.println("[b] Taurus");
                        System.out.println("[c] Gemini");
                        System.out.println("[d] Cancer");
                        System.out.println("[e] Leo");
                        System.out.println("[f] Virgo");
                        System.out.println("[g] Libra");
                        System.out.println("[h] Scorpio");
                        System.out.println("[i] Sagittarius");
                        System.out.println("[j] Capricorn");
                        System.out.println("[k] Aquarius");
                        System.out.println("[l] Pisces");
                        System.out.print("Enter your choice (a-l): ");
                        String zodiacSign = horoscope.nextLine().toLowerCase().trim();
    
                        isCorrectLetter = true;
                        
                        switch (zodiacSign){
                            case "a":
                                System.out.println("\n\nYou chose Aries, " + user + "!");
                                System.out.println("A bold opportunity awaits - take the lead!");
                                break;
                            case "b":
                                System.out.println("\n\nYou chose Taurus, " + user + "!");
                                System.out.println("Patience will bring reward today. "); 
                                break;
                            case "c":
                                System.out.println("\n\nYou chose Gemini, " + user + "!");
                                System.out.println("A lively conversation sparks new ideas."); 
                                break;
                            case "d":
                                System.out.println("\n\nYou chose Cancer, " + user + "!");
                                System.out.println("Trust your intuition - it guides you well!"); 
                                break;
                            case "e":
                                System.out.println("\n\nYou chose Leo, " + user + "!");
                                System.out.println("Your confidence shines and attracts success."); 
                                break;
                            case "f":
                                System.out.println("\n\nYou chose Virgo, " + user + "!");
                                System.out.println("Focus on details - they will open big doors."); 
                                break;
                            case "g":
                                System.out.println("\n\nYou chose Libra, " + user + "!");
                                System.out.println("Balance brings harmony in relationships.");
                                break;
                            case "h":
                                System.out.println("\n\nYou chose Scorpio, " + user + "!");
                                System.out.println("A secret may reveal: a powerful truth."); 
                                break;
                            case "i":
                                System.out.println("\n\nYou chose Sagittarius, " + user + "!");
                                System.out.println("Adventure calls - embrace the unknown. "); 
                                break;
                            case "j":
                                System.out.println("\n\nYou chose Capricorn, " + user + "!");
                                System. out.println("Hard word today sets up new success. ");
                                break;
                            case "k":
                                System.out.println("\n\nYou chose Aquarius, " + user + "! ");
                                System.out.println("Innovation sparks - share your unique vision. ");
                                break;
                            case "l":
                                System.out.println("\n\nYou chose Pisces, " + user + "!");
                                System.out.println("Dreams inspire creativity - let them flow.");
                                break;
                            default:
                                System.out.println("\nInvalid choice. Try Again.");
                                isCorrectLetter = false;
                        } 
                        
                        if(isCorrectLetter){
                            boolean chooseAgainFlag = false;
                            
                            do {
                                System.out.print("\n\nDo you want to choose again?(Yes or No): ");
                                String chooseAgain = horoscope.nextLine().trim();

                                if (chooseAgain.equalsIgnoreCase("Yes")){
                                    isCorrectLetter = false;
                                    chooseAgainFlag = true;
                                }else if (chooseAgain.equalsIgnoreCase("No")){
                                    System.out.println();
                                    for (int i = 1; i <= 20; i++){
                                        System.out.print(" * ");
                                    }
                                    System.out.println("\n");
                                    System.out.print("Thank you for using Horoscope 2026, " + user + "! Goodbye.");
                                    isCorrectLetter = true;
                                    chooseAgainFlag = true;
                                }else{
                                    System.out.println("Invalid input! Try again.");
                                }
                            } while (!chooseAgainFlag);
                        } 
                    } while (!isCorrectLetter);
                    
            }else if (inputUser.isEmpty() && inputPass.isEmpty()) {
                    System.out.println("Username and Password cannot be empty! Try again.");
                    System.out.println();
            }else if (inputUser.isEmpty() && !inputPass.equals(pass)){
                    System.out.println("Username cannot be empty and your Password is invalid! Try again.");
                    System.out.println();
            }else if (inputPass.isEmpty() && !inputUser.equals(user)){
                    System.out.println("Username cannot be empty and your Password is invalid! Try again.");
                    System.out.println();
            }else if (inputUser.isEmpty()){
                    System.out.println("Username cannot be empty! Try again.");
                    System.out.println();
            }else if (inputPass.isEmpty()){
                    System.out.println("Password cannot be empty! Try again.");
                    System.out.println();
            }else if (inputUser.equals(user)) {
                    System.out.println("Invalid password! Try again.");
                    System.out.println();
            }else if (inputPass.equals(pass)) {
                    System.out.println("Invalid username! Try again.");
                    System.out.println();
            }else {
                    System.out.println("Invalid credentials! Try again.");
                    System.out.println();
            }
        }while (!isAuthenticated);
        horoscope.close();
    }
}
