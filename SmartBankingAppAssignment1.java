import java.util.Scanner;

public class SmartBankingAppAssignment1{
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "💰 Welcome to Smart Banking App";
        final String OPEN_ACCOUNT = "💵 Open New Account";   
        final String DEPOSIT = "Deposit Money";
        final String WITHDRAW = "Withdraw Money";
        final String TRANSFER = "💸 Transfer Money";
        final String ACCOUNT_BALANCE = "Check Acoount Balance";
        final String DROP_ACCOUNT = "Drop Existing Account";

        String[] accountNames = new String[0];
        String screen = DASHBOARD;

        do{
            final String APP_TITLE = String.format("%s%s%s",
                                COLOR_BLUE_BOLD, screen, RESET);
            
            System.out.println(CLEAR);
            System.out.println(APP_TITLE);

            switch(screen){
                case DASHBOARD:
                    System.out.println("\n[1]. Open New Account");
                    System.out.println("[2]. Deposit Money");
                    System.out.println("[3]. Withdraw Money");
                    System.out.println("[4]. Transfer Money");
                    System.out.println("[5]. Check Acoount Balance");
                    System.out.println("[6]. Drop Existing Account");
                    System.out.println("[7]. Exit\n");
                    System.out.print("Enter an option to continue > ");

                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch (option){
                        case 1: screen = OPEN_ACCOUNT; break;
                        case 2: screen = DEPOSIT; break;
                        case 3: screen = WITHDRAW; break;
                        case 4: screen = TRANSFER; break;
                        case 5: screen = ACCOUNT_BALANCE; break;
                        case 6: screen = DROP_ACCOUNT; break;
                        case 7: System.exit(0); break;
                        default: continue;
                    }
                    break;
                
                case OPEN_ACCOUNT:
                    
                    System.out.printf("ID: SDB-%05d\n", (accountNames.length+1));

                    boolean valid = true;
                    String name;
                    do{
                        System.out.print("Name: ");
                        name = SCANNER.nextLine().strip();
                        if(name.isBlank()){
                            System.out.printf("%sName can't be empty%s \n", COLOR_RED_BOLD, RESET);
                            valid = false;
                            continue;
                        }

                        for (int i = 0; i < name.length(); i++) {
                            if( !(Character.isLetter(name.charAt(i)) || Character.isSpaceChar(name.charAt(i)))){
                                System.out.printf("%sInvalid Name%s \n", COLOR_RED_BOLD, RESET);
                                valid = false;
                                break;
                            }
                        }
                       

                    }while(!valid);
                
                default:
                    System.exit(0);

                }
                
        }while(true);

    }
}