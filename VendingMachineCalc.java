package hiponia_dcit23_prac5;
import java.util.Scanner;
import java.text.NumberFormat;

public class Hiponia_DCIT23_Prac5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println("========== VENDING MACHINE CALCULATOR ==========");
        System.out.println("\n\n================= HOW IT WORKS =================");
        System.out.println("1. Enter the price of the item (in cents).");
        System.out.println("2. Enter the amount of money inserted (in cents).");
        System.out.println("3. The program will calculate your total change.");
        System.out.println("4. It will then dispense the exact number of Quarters,");
        System.out.println("   Dimes, Nickels, and Pennies required.");
        System.out.println("===============================================\n");  
        
        boolean isCorrectPriceInput = false;
        boolean isCorrectAmountPaidInput = false;

        do{
            System.out.print("Enter the price of the item (in cents): ₱");
            int itemPrice = sc.nextInt();
            if (itemPrice < 0){
                System.out.println("\nInvalid input, try again.\n");
                isCorrectPriceInput = false;
            }else{
                do{
                    System.out.print("Enter the amount of money inserted (in cents): ₱");
                    int amountPaid = sc.nextInt();
                    if (amountPaid < 1){
                        System.out.println("\nInvalid input, try again.\n");
                        isCorrectAmountPaidInput = false;
                    }else if(itemPrice > amountPaid){
                            System.out.println("\nThe price of the item should not be larger than the amount you paid, try again.");
                    }else{
                        if (itemPrice < amountPaid || itemPrice == amountPaid){
                            int amountChange = amountPaid - itemPrice;

                            int piecesThousands = amountChange / 1000;
                            int remThousands = amountChange % 1000;
                            int amountThousands = piecesThousands * 1000;
                            String formattedAmountThousands = nf.format(amountThousands);

                            int piecesFiveHundreds = remThousands / 500;
                            int remFiveHundreds = remThousands % 500;
                            int amountFiveHundreds = piecesFiveHundreds * 500;
                            String formattedAmountFiveHundreds = nf.format(amountFiveHundreds);
                            
                            int piecesTwoHundreds = remFiveHundreds / 200;
                            int remTwoHundreds = remFiveHundreds % 200;
                            int amountTwoHundreds = piecesTwoHundreds * 200;
                            String formattedAmountTwoHundreds = nf.format(amountTwoHundreds);

                            int piecesHundreds = remTwoHundreds / 100;
                            int remHundreds = remTwoHundreds % 100;
                            int amountHundreds = piecesHundreds * 100;
                            String formattedAmountHundreds = nf.format(amountHundreds);

                            int piecesFiveTens = remHundreds / 50;
                            int remFiveTens = remHundreds % 50;
                            int amountFiveTens = piecesFiveTens * 50;
                            String formattedAmountFiveTens = nf.format(amountFiveTens);
                            
                            int piecesTwoTens = remFiveTens / 20;
                            int remTwoTens = remFiveTens % 20;
                            int amountTwoTens = piecesTwoTens * 20;
                            String formattedAmountTwoTens = nf.format(amountTwoTens);
                            
                            int piecesTens = remTwoTens / 10;
                            int remTens = remTwoTens % 10;
                            int amountTens = piecesTens * 10;
                            String formattedAmountTens = nf.format(amountTens);
                            
                            int piecesFives = remTens / 5;
                            int remFives = remTens % 5;
                            int amountFives = piecesFives * 5;
                            String formattedAmountFives = nf.format(amountFives);
                            
                            int piecesOnes = remFives;
                            int amountOnes = piecesOnes;
                            String formattedAmountOnes = nf.format(amountOnes);
                            
                            int totalAmountChange = amountThousands + amountFiveHundreds + amountTwoHundreds + amountHundreds + amountFiveTens + amountTwoTens + amountTens + amountFives + amountOnes;
                            String formattedTotalAmountChange = nf.format(totalAmountChange);
                            

                            System.out.println("\n\n========== YOUR CHANGE ==========");
                            System.out.println("(" + piecesThousands + ")" + " One Thousand Pesos = ₱" + formattedAmountThousands);
                            System.out.println("(" + piecesFiveHundreds + ")" + " Five Hundred Pesos = ₱" + formattedAmountFiveHundreds);
                            System.out.println("(" + piecesTwoHundreds + ")" + " Two Hundred Pesos = ₱" + formattedAmountTwoHundreds);
                            System.out.println("(" + piecesHundreds + ")" + " One Hundred Pesos = ₱" + formattedAmountHundreds);
                            System.out.println("(" + piecesFiveTens + ")" + " Fifty Pesos = ₱" + formattedAmountFiveTens);
                            System.out.println("(" + piecesTwoTens + ")" + " Twenty Pesos = ₱" + formattedAmountTwoTens);
                            System.out.println("(" + piecesTens + ")" + "  Ten Pesos = ₱" + formattedAmountTens);
                            System.out.println("(" + piecesFives + ")" + " Five Pesos = ₱" + formattedAmountFives);
                            System.out.println("(" + piecesOnes + ")" + " One Pesos = ₱" + formattedAmountOnes);
                            System.out.println("\nTotal amount of change: ₱" + formattedTotalAmountChange + "\n\n");

                            isCorrectAmountPaidInput = true;
                            isCorrectPriceInput = true;
                        }
                    }
                }while (!isCorrectAmountPaidInput);
            }
        }while(!isCorrectPriceInput);
        sc.close();
    }
    
}
