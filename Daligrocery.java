import java.util.Scanner;

public class dali {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] itemsList = {"Apple", "Banana", "Orange", "Milk", "Bread"};
        double[] itemsPrice = {20, 10, 15, 50, 30};
        double totalPrice = 0;

        String[] itemsCart = new String[100];
        int itemCounter = 0;
        int[] finalQuantityChoice = new int[100];
        double[] finalItemsPrice = new double[100];

        System.out.println("\n\n\n\tWelcome to Dali Grocery!");
        
        mainLoop:
        do { 
            System.out.println("\n========== Point of Sale Menu ==========");
            for (int i = 0; i < itemsList.length; i++){
                System.out.printf("[%d]. %s \t-\t\t ₱%.2f%n", i + 1, itemsList[i], itemsPrice[i]);
            }
            System.out.println("\n[6]. Go to Checkout Tab");

            innerLoop:
            do { 
                System.out.printf("\nEnter your choice (1-5): ");
                int userItemChoice = sc.nextInt();

                if (userItemChoice < 1 || userItemChoice > 6){
                    System.out.println("\n\nInvalid choice, please try again.\n\n");
                    continue innerLoop;
                }else if (userItemChoice == 6){
                    break mainLoop;
                }else if (userItemChoice > 1 || userItemChoice < 6) {
                    System.out.print("Enter quantity: ");
                    int userQuantityChoice = sc.nextInt();

                    finalQuantityChoice[itemCounter] = userQuantityChoice;
                    itemsCart[itemCounter] = itemsList[userItemChoice - 1];

                    if (userQuantityChoice < 1){
                        System.out.println("\n\nInvalid choice, please try again.\n\n");
                        continue innerLoop;
                    }else{
                        double basePrice = itemsPrice[userItemChoice - 1] * userQuantityChoice;

                        if (basePrice >= 100){
                            if (basePrice < 200){
                                double discountedPrice = basePrice - (basePrice * .05);
                                finalItemsPrice[itemCounter] = discountedPrice;
                                totalPrice += discountedPrice;

                                System.out.println("\n\n\n\nYou have a 5% discount!");
                                System.out.printf("Subtotal: %.2f%n", discountedPrice);
                            }else if (basePrice >= 200){
                                double discountedPrice = basePrice - (basePrice * .1);
                                finalItemsPrice[itemCounter] = discountedPrice;
                                totalPrice += discountedPrice;

                                System.out.println("\n\n\n\nYou have a 10% discount!");
                                System.out.printf("Subtotal: %.2f%n", discountedPrice);
                            }
                        }else{
                            totalPrice += basePrice; 
                            finalItemsPrice[itemCounter] = basePrice;

                            System.out.println("\n\n\n\nYou are not eligible for a discount.");
                            System.out.printf("Subtotal: %.2f%n", basePrice);
                        }
                        itemCounter++;

                        System.out.printf("Added to Cart: %s x%d%n%n%n%n%n", itemsList[userItemChoice - 1], userQuantityChoice);
                        continue mainLoop;
                    }
                }
            } while (true);
        } while (true);

        System.out.println("\n\n\n\n\n\n============== Checkout Tab ==============");
        System.out.println("\nYour Cart");
        for (int c = 0; c < itemCounter; c++){
            System.out.printf("%n%s x%d: \t\t\t ₱%.2f", itemsCart[c], finalQuantityChoice[c], finalItemsPrice[c]);
        }
        System.out.printf("%n%nTotal Price: \t\t\t₱%.2f%n", totalPrice);
        System.out.println("\n\nThank you for shopping with Dali Grocery!");
        System.out.println("\n==========================================");
    }
}
