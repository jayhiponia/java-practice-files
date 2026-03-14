import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class cinemabookingsystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd");
        
        String user = "Jay"; 
        String pass = "060108";

        
        String[] movieTitle = {"Project Hail Mary", "The Odyssey", "Spider-Man: Brand New Day", "Dune: Messiah", "Avengers: Doomsday", "Supergirl"};
        String[] movieDesc = {
            "An astronaut awakens on a spaceship with no memory and must use science to save humanity.",
            "Christopher Nolan’s epic retelling of Odysseus’s 10-year journey home after the Trojan War.",
            "Peter Parker balances life as an anonymous hero while a new street-level threat rises in NYC.",
            "Paul Atreides, now Emperor, struggles to control the religious war he unleashed across the stars.",
            "The Avengers must unite once again to stop the multiversal threat of the mysterious Doctor Doom.",
            "A jaded Kara Zor-El travels the galaxy on a gritty quest for revenge alongside a young alien girl."
        };
        String[] movieCast = {
            "Ryan Gosling, Sandra Hüller, Lionel Boyce",
            "Matt Damon, Anne Hathaway, Tom Holland",
            "Tom Holland, Mark Ruffalo, Jon Bernthal",
            "Timothée Chalamet, Zendaya, Florence Pugh",
            "Robert Downey Jr., Chris Evans, Chris Hemsworth",
            "Milly Alcock, Jason Momoa, Eve Ridley"
        };
        String[] movieGenre = {
            "Sci-Fi, Adventure, Comedy",
            "Epic, Action, Fantasy",
            "Action, Adventure, Sci-Fi",
            "Sci-Fi, Drama, Epic",
            "Action, Adventure, Sci-Fi",
            "Sci-Fi, Action, Adventure"
        }; 

        String[] timeList = {"8:00 AM", "10:30 AM", "1:00 PM", "3:30 PM", "6:00 PM", "8:30 PM"};


        char[] seatRow = {'A', 'B', 'C', 'D', 'E'};
        boolean [][] bookedSeats = new boolean [5][5];


        String[] screenName = {"Standard", "Director's Club", "IMAX", "Event Cinema"};
        String[] screenDesc = {
            "The classic experience.",
            "w/ reclining seats and bigger screen.",
            "IMAX Screen w/ Surround Sound.",
            "Includes a full meal and butler service."
        };
        double[] screenPrice = {400, 600, 900, 1200};


        String[] snackPopcorn = {"Small Popcorn", "Medium Popcorn", "Large Popcorn"};
        double[] snackPopcornPrice = {140, 190, 240};

        String[] snackDrinks = {"Medium Soda", "Large Soda", "Bottled Water", "Iced Tea"};
        double[] snackDrinksPrice = {95, 115, 55, 105};

        String[] snackFingers = {"Hotdog Sandwich", "Nachos w/ Cheese & Salsa", "Medium Fries", "Large Fries", "Chicken Poppers"};
        double[] snackFingersPrice = {120, 165, 95, 130, 185};


        String finalTicketMovie = "";
        String finalTicketDate = "";
        String finalTicketTime = "";
        String finalTicketScreen = "";
        char [] finalTicketRowSeat = new char[20];
        int [] finalTicketColSeat = new int [20];
        String finalTicketSnacks = new String();
        float totalPrice = 0;

        
        System.out.println("\n\n\nPlease enter your credentials before we proceed.");
        mainLoop:
        do { 
            System.out.print("Username: ");
            String inputUser = sc.nextLine();
            System.out.print("Password: ");
            String inputPass = sc.nextLine();

            if (inputUser.equals(user) && inputPass.equals(pass)) {

                System.out.printf("\n\n\nWelcome to Filmory, %s", user);
                System.out.println("\n\n\n================= NOW SHOWING ================== \n");
                for (int d = 1; d <= movieTitle.length; d++){
                    System.out.printf("[%d] %s%n", d, movieTitle[d - 1]);
                }
                System.out.print("\n\nWhat would you like to watch? (1-6): ");
                int userMovieChoice = sc.nextInt();
                sc.nextLine();
                finalTicketMovie = movieTitle[userMovieChoice - 1];

                
                System.out.println("\n\n\n\n\n================= MOVIE DETAILS =================="); 
                System.out.printf("%n%n%s (2026) PG-13%n", movieTitle[userMovieChoice - 1]);
                System.out.printf("%nDescription: %s%n", movieDesc[userMovieChoice - 1]);
                System.out.printf("%nCast: %s%n", movieCast[userMovieChoice - 1]);
                System.out.printf("%nGenres: %s%n", movieGenre[userMovieChoice - 1]);
                
                
                System.out.println("\n\n\n\n\n================= CHOOSE DATE & TIME ==================");

                dateLoop:
                while(true){
                    System.out.println("\n\n= = = = Date = = = =");
                    LocalDate dateCounter = LocalDate.now();
                    for (int d = 1; d <= 5; d++){
                        LocalDate nextDate = dateCounter.plusDays(d);
                        System.out.printf("[%d] %s%n", d, nextDate.format(formatter));
                    }
                    System.out.print("\n\nWhen do you want to watch? (1-5): ");
                    int userDateChoice = sc.nextInt();
                    sc.nextLine();
                    LocalDate selectedDate = LocalDate.now().plusDays(userDateChoice);
                    finalTicketDate = selectedDate.format(formatter);
                    if (userDateChoice < 1 || userDateChoice > 5){
                        System.out.println("\nInvalid input, try again.");
                        continue dateLoop;
                    }else{
                        break dateLoop;
                    }
                }
                
                timeLoop:
                while (true) { 
                    System.out.println("\n\n\n= = = = Time = = = =");
                    for (int h = 1; h <= timeList.length; h++){
                        System.out.printf("[%d] %s%n", h, timeList[h - 1]);
                    }
                    System.out.print("\n\nWhat time do you want to watch? (1-6): ");
                    int userTimeChoice = sc.nextInt();
                    sc.nextLine();
                    finalTicketTime = timeList[userTimeChoice - 1];
                    if (userTimeChoice < 1 || userTimeChoice > 6){
                        System.out.println("\nInvalid input, try again.");
                        continue timeLoop;
                    }else{
                        break timeLoop;
                    }
                }


                System.out.println("\n\n\n\n\n================= CHOOSE YOUR SCREEN ==================\n");
                screenLoop:
                while (true) { 
                    for (int e = 1; e <= screenName.length; e++){
                        if (e == 1){
                            System.out.printf("[%d] %s (₱%.2f): %s%n", e , screenName[e - 1], screenPrice[e - 1], screenDesc[e - 1]);
                        }else{
                            System.out.printf("[%d] %s (+₱%.2f): %s%n", e , screenName[e - 1], screenPrice[e - 1], screenDesc[e - 1]);
                        }
                    }
                    System.out.print("\n\nWhat is your preferred screen? (1-4): ");
                    int userScreenChoice = sc.nextInt();
                    System.out.println("\n\n");
                    sc.nextLine();
                    finalTicketScreen = screenName[userScreenChoice - 1];

                    if (userScreenChoice < 1 || userScreenChoice > 4){
                        System.out.println("\nInvalid input, try again.");
                        System.out.println("\n\n");
                        continue screenLoop;
                    }else{
                        switch (userScreenChoice) {
                            case 1:
                                break;
                            case 2:
                                totalPrice += 600;
                                break;
                            case 3:
                                totalPrice += 900;
                                break;
                            case 4:
                                totalPrice += 1200;
                                break;
                        }
                        break;
                    }
                }


                System.out.println("\n\n\n================= CHOOSE YOUR SEAT ==================\n");
                seatLoop:
                while (true) { 
                    for (int c = 0; c < 6; c++){
                        System.out.print(c + "\t");
                    }
                    System.out.println("\n");
                    for (int a = 0; a < 5; a++){
                        System.out.print(seatRow[a] + "\t");
                        for (int b = 0; b < 5; b++){
                            System.out.print("🪑\t");
                        }
                        System.out.println("\n");
                    }

                    System.out.print("\n\n\nHow many seats do you want to buy? (Pick a number): ");
                    int seatCountInput = sc.nextInt();
                    for (int s = 0; s < seatCountInput; s++){
                        totalPrice += 400;
                        seatSelectLoop:
                        while(true){
                            System.out.print("\n\nWhat is your seat row? (A-E): ");
                            char rowChar = Character.toUpperCase(sc.next().charAt(0));
                            sc.nextLine();
                            finalTicketRowSeat[s] = rowChar;

                            System.out.print("What is your seat number? (1-5) ");
                            int colNum = sc.nextInt();
                            sc.nextLine();
                            finalTicketColSeat[s] = colNum;
                            System.out.println("\n\n");

                            if (rowChar < 'A' || rowChar > 'E' || colNum < 1 || colNum > 5){
                                    System.out.println("\nInvalid input, try again.");
                                    System.out.println("\n\n");
                                    continue seatLoop;
                            }else{
                                int rIndex = rowChar - 'A';
                                int cIndex = colNum - 1;

                                if (bookedSeats[rIndex][cIndex] == true){
                                    System.out.println("\n\nYou already chose that seat, try again.");
                                    continue seatSelectLoop;
                                }else{
                                    bookedSeats[rIndex][cIndex] = true;
                                    for (int c = 0; c < 6; c++){
                                        System.out.print(c + "\t");
                                    }
                                    System.out.println("\n");

                                    for (int a = 0; a < 5; a++){
                                        System.out.print(seatRow[a] + "\t");
                                        for (int b = 0; b < 5; b++){
                                            if(bookedSeats[a][b] == true){
                                                System.out.print("✅\t");
                                            }else{
                                                System.out.print("🪑\t");
                                            }
                                        }
                                        System.out.println("\n");
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    break seatLoop;
                }


                snackLoop:
                while (true){
                    System.out.print("\n\nDo you want to buy some snacks? (Yes/no): ");
                    String buySnacks = sc.nextLine();
                    snackDecision:
                    if(buySnacks.equalsIgnoreCase("yes")){
                        System.out.println("\n\n\n\n\n================= SNACK BAR ==================");
                        shelfLoop:
                        while (true) { 
                            System.out.println("\n\n\n\n========== Shelf ==========");
                            System.out.printf("[1] Popcorn %n[2] Finger Foods %n[3] Drinks %n%n[4] Go to Confirmation Tab");
                            System.out.print("\n\nChoose a shelf (1-3): ");
                            int userShelfChoice = sc.nextInt();

                            switch (userShelfChoice) {
                                case 1:
                                    popcornLoop:
                                    while(true){
                                        System.out.println("\n\n\n= = = Popcorns = = =");
                                        for (int f = 1; f <= snackPopcorn.length; f++){
                                            System.out.printf("[%d] %s: ₱%.2f%n", f, snackPopcorn[f - 1], snackPopcornPrice[f - 1]);
                                        }
                                        System.out.printf("%n[4] Back to Shelf Selection %n[5] Go to Confirmation Tab");
                                        System.out.print("\n\nWhat do you want to eat?: ");
                                        int userSnackPopcornChoice = sc.nextInt();
                                        sc.nextLine();
                                        if (userSnackPopcornChoice <= 3){
                                            switch (userSnackPopcornChoice){
                                                case 1: 
                                                    finalTicketSnacks += "\tSmall Popcorn\n";
                                                    totalPrice += 140;
                                                    break;
                                                case 2:
                                                    finalTicketSnacks += "\tMedium Popcorn\n";
                                                    totalPrice += 190;
                                                    break;
                                                case 3:
                                                    finalTicketSnacks += "\tLarge Popcorn\n";
                                                    totalPrice += 240;
                                                    break;
                                            }
                                            continue popcornLoop;
                                        }else if (userSnackPopcornChoice == 4){
                                            continue shelfLoop;
                                        }else if (userSnackPopcornChoice == 5){
                                            break snackDecision;
                                        }else{
                                            System.out.println("Invalid input, try again.");
                                            continue popcornLoop;
                                        }
                                    }
                                case 2:
                                    fingersLoop:
                                    while(true){
                                        System.out.println("\n\n\n= = = Finger Foods = = =");
                                        for (int f = 1; f <= snackFingers.length; f++){
                                            System.out.printf("[%d] %s: ₱%.2f%n", f, snackFingers[f - 1], snackFingersPrice[f - 1]);
                                        }   
                                        System.out.printf("%n[6] Back to Shelf Selection %n[7] Go to Confirmation Tab");
                                        System.out.print("\n\nWhat do you want to eat?: ");
                                        int userSnackFingersChoice = sc.nextInt();
                                        sc.nextLine();

                                        if (userSnackFingersChoice <= 5){
                                            switch (userSnackFingersChoice){
                                                case 1: 
                                                    finalTicketSnacks += "\tHotdog Sandwich\n";
                                                    totalPrice += 120;
                                                    break;
                                                case 2:
                                                    finalTicketSnacks += "\tNachos w/ Cheese & Salsa\n";
                                                    totalPrice += 165;
                                                    break;
                                                case 3:
                                                    finalTicketSnacks += "\tMedium Fries\n";
                                                    totalPrice += 95;
                                                    break;
                                                case 4:
                                                    finalTicketSnacks += "\tLarge Fries\n";
                                                    totalPrice += 130;
                                                    break;
                                                case 5:
                                                    finalTicketSnacks += "\tChicken Poppers\n";
                                                    totalPrice += 185;
                                                    break;
                                            }
                                            continue fingersLoop;
                                        }else if (userSnackFingersChoice == 6){
                                            continue shelfLoop;
                                        }else if (userSnackFingersChoice == 7){
                                            break snackDecision;
                                        }else{
                                            System.out.println("Invalid input, try again.");
                                            continue fingersLoop;
                                        }
                                    }
                                case 3:
                                    drinksLoop:
                                    while(true){
                                        System.out.println("\n\n\n= = = Drinks = = =");
                                        for (int f = 1; f <= snackDrinks.length; f++){
                                            System.out.printf("[%d] %s: ₱%.2f%n", f, snackDrinks[f - 1], snackDrinksPrice[f - 1]);
                                        }   
                                        System.out.printf("%n[5] Back to Shelf Selection %n[6] Go to Confirmation Tab");
                                        System.out.print("\n\nWhat do you want to eat?: ");
                                        int userSnackDrinksChoice = sc.nextInt();
                                        sc.nextLine();
                                        
                                        if (userSnackDrinksChoice <= 4){
                                            switch (userSnackDrinksChoice){
                                                case 1: 
                                                    finalTicketSnacks += "\tMedium Soda\n";
                                                    totalPrice += 95;
                                                    break;
                                                case 2:
                                                    finalTicketSnacks += "\tLarge Soda\n";
                                                    totalPrice += 115;
                                                    break;
                                                case 3:
                                                    finalTicketSnacks += "\tBottled Water\n";
                                                    totalPrice += 55;
                                                    break;
                                                case 4:
                                                    finalTicketSnacks += "\tIced Tea\n";
                                                    totalPrice += 105;
                                                    break;
                                            }
                                            continue drinksLoop;
                                        }else if (userSnackDrinksChoice == 5){
                                            continue shelfLoop;
                                        }else if (userSnackDrinksChoice == 6){
                                            break snackDecision;
                                        }else{
                                            System.out.println("Invalid input, try again.");
                                            continue drinksLoop;
                                        }
                                    }
                                case 4:
                                    break snackDecision;
                            }
                        }
                    }else if (!buySnacks.equalsIgnoreCase("no") && !buySnacks.equalsIgnoreCase("yes") ){
                        System.out.println("\nInvalid input, try again.");
                        System.out.println("\n\n");
                        continue snackLoop;
                    }else if(buySnacks.equalsIgnoreCase("no")){
                        break snackDecision;
                    }
                    break;
                }
            
            
            System.out.println("\n\n\n\n================= CONFIRM YOUR BOOKING ==================");
            System.out.println("\n\n==========================================");
            System.out.println("\t     CINEMA TICKET\t");
            System.out.println("==========================================");
            System.out.printf("Name: %s%n", user);
            System.out.printf("Movie: %s%n", finalTicketMovie);
            System.out.printf("Date: %s%n", finalTicketDate);
            System.out.printf("Time: %s%n", finalTicketTime);
            System.out.printf("Screen: %s%n", finalTicketScreen);
            System.out.printf("Seat: ");
            for (int t = 0; t < finalTicketRowSeat.length; t++){
                if (finalTicketRowSeat[t] != 0 || finalTicketColSeat[t] != 0){
                    System.out.printf("%s%d | ",finalTicketRowSeat[t], finalTicketColSeat[t]);
                }
            }
            System.out.printf("%nSnacks: %n");
            System.out.printf("%s", finalTicketSnacks);
            System.out.println("==========================================");
            System.out.printf("\tTotal Price: ₱%.2f%n", totalPrice);
            System.out.println("==========================================");
            break mainLoop;

            }else if (inputUser.isEmpty() || inputPass.isEmpty()){
            System.out.println("Username & Password can't be empty, try again.");
            }else if (!inputUser.equals(user) && !inputPass.equals(pass)){
            System.out.println("Invalid credentials, try again.");
            }else if (!inputPass.equals(pass)){
            System.out.println("Invalid password, try again.");
            }else if (!inputUser.equals(user)){
            System.out.println("Invalid username, try again.");
            }else if (inputUser.equals(user)){
            System.out.println("Invalid password, try again.");
            }
        } while (true);
    }
}
