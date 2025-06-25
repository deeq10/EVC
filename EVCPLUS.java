import java.util.Date;
import java.util.Scanner;

public class EVCPLUS {
    static Scanner input = new Scanner(System.in);
    static Date currenDateAndTime = new Date();
    static double haraa = 300.0;
    static final int MAX_TRANSACTIONS = 50;
    static String[] history = new String[MAX_TRANSACTIONS];
    static int historyCount = 0;

    public static void main(String[] args) {
        int opp, phone;
        double money;

        System.out.println("welcome garac (*770#)");
        String n = input.nextLine();

        if (n.startsWith("*") && n.endsWith("#")) {
            System.out.println("Fadlan gali pinkaaga:");
            int password = input.nextInt();
            input.nextLine();
            if (password == 2222) {
                boolean running = true;
                while (running) {
                    displayMenu();
                    int option = input.nextInt();
                    input.nextLine();
                    switch (option) {
                        case 0:
                            System.out.println("Waxaad dooratay inaad ka baxdo .");
                            running = false;
                            break;
                        case 1:
                            checkBalance();
                            break;
                        case 2:
                            airtimeMenu(input,haraa);
                            break;
                        case 3:
                            billMenu(input,haraa);

                            break;
                        case 4:
                            transferMoney();
                            break;
                        case 5:
                            printHistory();
                            break;
                        case 6:
                            salaamBankMenu(input,haraa);
                            break;
                        case 7:
                            manageAccount(input,currentPin);
                            break;
                        case 8:
                            taajService(input, haraa);
                            break;
                        case 9:
                            payBills(input, haraa);
                            break;
                        default:
                            System.out.println("Fadlan dooro number sax ah.");
                    }
                }
                System.out.println("\nMahadsanid macmiil, soo laabo mar kale!");
            } else {
                System.out.println("Password khaldan!");
            }
        } else {
            System.out.println("Fadlan geli code-ka sax ah sida tusaalaha.");
        }
        input.close();
    }

    static void displayMenu() {
        System.out.println("\nEVPLus Menu:");
        System.out.println("1. Itus Haraagaga");
        System.out.println("2. Karka ku hadalka");
        System.out.println("3. Bixi bill");
        System.out.println("4. U wareeji EVCplus");
        System.out.println("5. Warbixin kooban");
        System.out.println("6. Salam bank");
        System.out.println("7. Maareynta");
        System.out.println("8. TAAJ");
        System.out.println("9. Bill payment");
        System.out.println("0. Ka bax (Exit)");
        System.out.print("Fadlan dooro option: ");
    }

    static void checkBalance() {
        System.out.println("Haraagaga waa $" + haraa);
    }

    static double airtimeMenu(Scanner input, double haraa) {
        System.out.println("Karka ku hadalka:");
        System.out.println("1. Ku shub Airtime");
        System.out.println("2. Ugu shub qof kale");
        System.out.print("Dooro: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Geli lacagta: ");
                double amount = input.nextDouble();
                input.nextLine();
                if (amount <= 0 || amount > haraa) {
                    System.out.println("Lacag khaldan ama haraagaaga kuma filna.");
                } else {
                    haraa -= amount;
                    System.out.println("Waxaad ku shubtay $" + amount + " airtime. Haraaga cusub: $" + haraa);
                }
                break;
            case 2:
                System.out.print("Geli numberka qofka: ");
                String number = input.nextLine();
                System.out.print("Geli lacagta: ");
                amount = input.nextDouble();
                input.nextLine();
                if (amount <= 0 || amount > haraa) {
                    System.out.println("Lacag khaldan ama haraagaaga kuma filna.");
                } else {
                    haraa -= amount;
                    System.out.println("Waxaad $" + amount + " ugu shubtay lambar: " + number + ". Haraaga cusub: $" + haraa);
                }
                break;
            default:
                System.out.println("Doorasho aan sax ahayn.");
        }
        return haraa;
    }
    static double billMenu(Scanner input, double haraa) {
        System.out.println("Bixi bill:");
        System.out.print("Geli magaca shirkadda: ");
        String company = input.nextLine();
        System.out.print("Geli lacagta billka: ");
        double amount = input.nextDouble();
        input.nextLine();

        if (amount <= 0 || amount > haraa) {
            System.out.println("Lacag khaldan ama haraagaaga kuma filna.");
        } else {
            haraa -= amount;
            System.out.println("Waxaad bixisay $" + amount + " shirkadda " + company + ". Haraaga cusub: $" + haraa);
        }
        return haraa;
    }


    static void transferMoney() {
        System.out.print("Fadlan geli numberka: ");
        int phone = input.nextInt();
        input.nextLine();
        if (phone == 619862296) {
            System.out.println("Lambarka aad dooratay waa la xanibay.");
            return;
        }
        System.out.print("Fadlan geli lacagta: ");
        double money = input.nextDouble();
        input.nextLine();
        System.out.println("Ma hubtaa inaad $" + money + " u wareejisay " + phone + "?\n1.haa\n2.maya");
        int confirm = input.nextInt();
        input.nextLine();
        if (confirm == 1) {
            if (money > haraa) {
                System.out.println("Haraaga xisaabtaada kugu ma filna.");
            } else {
                haraa -= money;
                String tx = "[-EVC PLUS-] $" + money + " ayaad u wareejisay " + phone + " Taariikh: " + currenDateAndTime + " Haraagaagu waa $" + haraa;
                System.out.println(tx);
                record(tx);
            }
        } else {
            System.out.println("Mahadsanid.");
        }
    }

    static void record(String tx) {
        if (historyCount < MAX_TRANSACTIONS) {
            history[historyCount++] = tx;
        } else {
            for (int i = 1; i < MAX_TRANSACTIONS; i++) {
                history[i - 1] = history[i];
            }
            history[MAX_TRANSACTIONS - 1] = tx;
        }
    }

    static void printHistory() {
        if (historyCount == 0) {
            System.out.println("Wax warbixin ah lama helin.");
        } else {
            System.out.println("\nWarbixin Kooban:");
            for (int i = 0; i < historyCount; i++) {
                System.out.println((i + 1) + ". " + history[i]);
            }
        }
    }

    static double salaamBankMenu(Scanner input, double haraa) {
        boolean back = false;
        while (!back) {
            System.out.println("\nSalaam Bank:");
            System.out.println("1. Itus Haraagaaga");
            System.out.println("2. Lacag dhigasho");
            System.out.println("3. Lacag qaadasho");
            System.out.println("4. Ka Wareeji EVCPLUS");
            System.out.println("5. Ka Wareeji Account-kaaga");
            System.out.println("6. Hubi wareejin account");
            System.out.println("7. Maareynta bankiga");
            System.out.println("8. Ka Bax");
            System.out.print("Dooro: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Haraagaaga Salaam Bank waa: $" + haraa);
                    break;
                case 2:
                    System.out.print("Geli lacagta aad dhigeyso: ");
                    double deposit = input.nextDouble();
                    input.nextLine();
                    if (deposit > 0) {
                        haraa += deposit;
                        System.out.println("Waad dhigatay $" + deposit + ". Haraaga cusub: $" + haraa);
                    } else {
                        System.out.println("Fadlan geli lacag sax ah.");
                    }
                    break;
                case 3:
                    System.out.print("Geli lacagta aad qaadaneyso: ");
                    double withdraw = input.nextDouble();
                    input.nextLine();
                    if (withdraw > 0 && withdraw <= haraa) {
                        haraa -= withdraw;
                        System.out.println("Waad qaadatay $" + withdraw + ". Haraaga cusub: $" + haraa);
                    } else {
                        System.out.println("Lacag khaldan ama haraaga kuma filna.");
                    }
                    break;
                case 4:
                    // Ka Wareeji EVCPLUS
                    System.out.print("Fadlan geli lacagta aad u wareejinayso EVCPLUS: ");
                    double amount = input.nextDouble();
                    input.nextLine();
                    if(amount > 0 && amount <= haraa) {
                        if (amount <= haraa) {
                            haraa -= amount;
                            haraa += amount;
                            System.out.println("Waad u wareejisay $" + amount + " EVCPLUS.");
                        } else {
                            System.out.println("Haraaga EVCPLUS kuma filna in lacag lagu helo.");
                        }
                    } else {
                        System.out.println("Lacagta ma aha mid sax ah ama kama bixin kartid Salaam Bank.");
                    }
                    break;

                case 5:
                    // Ka Wareeji Account-kaaga (Tusaale fudud)
                    System.out.print("Fadlan geli lacagta aad u wareejinayso account-kaaga: ");
                    double accAmount = input.nextDouble();
                    input.nextLine();
                    if(accAmount > 0 && accAmount <= haraa) {
                        haraa -= accAmount;
                        haraa += accAmount;
                        System.out.println("Waad u wareejisay $" + accAmount + " account-ka Salaam Bank.");
                    } else {
                        System.out.println("Lacagta ma aha mid sax ah ama kama bixin kartid EVCPLUS.");
                    }
                    break;

                case 6:
                    // Hubinta wareejinta (muujin taariikhaha Salaam Bank)
                    System.out.println("Taariikhda wareejinta Salaam Bank:");
                    boolean found = false;
                    for (String rec : history) {
                        if (rec.startsWith("Salaam Bank:")) {
                            System.out.println(rec);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Ma jiraan wareejinno la diiwaangeliyay.");
                    }
                    break;
            }
        }
        return haraa;
    }
    static int currentPin = 4286; // PIN default ah
    static String blockedNumber = ""; // Lambar la xannibay

    static int manageAccount(Scanner input, int currentPin) {
        boolean back = false;
        while (!back) {
            System.out.println("\nMaareynta:");
            System.out.println("1. Badal PIN");
            System.out.println("2. Xannib Lambar");
            System.out.println("3. Dib ugu noqo");
            System.out.print("Dooro: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Geli PIN cusub: ");
                    int newPin = input.nextInt();
                    input.nextLine();
                    if (newPin > 999 && newPin <= 9999) {
                        currentPin = newPin;
                        System.out.println("PIN-ka waa la bedelay si guul leh.");
                    } else {
                        System.out.println("PIN-ka cusub waa inuu noqdaa 4-lambar.");
                    }
                    break;

                case 2:
                    System.out.print("Geli lambar aad rabto inaad xannibto: ");
                    blockedNumber = input.nextLine();
                    System.out.println("Lambarka " + blockedNumber + " waa la xannibay.");
                    break;

                case 3:
                    System.out.println("Waxaad dib ugu laabatay menu-ga weyn.");
                    back = true;
                    break;

                default:
                    System.out.println("Fadlan dooro doorasho sax ah.");
            }
        }
        return currentPin;
    }

    static double taajService(Scanner input, double haraa) {
        System.out.println("\nTAAJ:");
        System.out.println("1. Dir Lacag");
        System.out.println("2. Ka Qaado Lacag");
        System.out.print("Dooro: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Geli magaca qofka aad u dirayso: ");
                String name = input.nextLine();
                System.out.print("Geli lacagta aad dirayso: ");
                double sendAmount = input.nextDouble();
                input.nextLine();

                if (sendAmount <= 0 || sendAmount > haraa) {
                    System.out.println("Lacag khaldan ama haraagaaga kuma filna.");
                } else {
                    haraa -= sendAmount;
                    System.out.println("Waxaad u dirtay $" + sendAmount + " qofka " + name +
                            ". Haraaga cusub: $" + haraa);
                }
                break;

            case 2:
                System.out.print("Geli lacagta aad qaadaneyso: ");
                double receiveAmount = input.nextDouble();
                input.nextLine();

                if (receiveAmount <= 0) {
                    System.out.println("Fadlan geli lacag sax ah.");
                } else {
                    haraa += receiveAmount;
                    System.out.println("Waxaad ka qaadatay $" + receiveAmount +
                            " TAAJ. Haraaga cusub: $" + haraa);
                }
                break;

            default:
                System.out.println("Doorasho aan sax ahayn.");
        }

        return haraa;
    }

    static double payBills(Scanner input, double haraa) {
        System.out.println("\nBill Payment:");
        System.out.println("1. Bixi koronto");
        System.out.println("2. Bixi biyaha");
        System.out.println("3. Bixi internet");
        System.out.print("Dooro: ");
        int choice = input.nextInt();
        input.nextLine();

        System.out.print("Geli lacagta: ");
        double amount = input.nextDouble();
        input.nextLine();

        if (amount <= 0 || amount > haraa) {
            System.out.println("Lacag khaldan ama haraagaaga kuma filna.");
        } else {
            haraa -= amount;
            String service = "";
            switch (choice) {
                case 1:
                    service = "koronto";
                    break;
                case 2:
                    service = "biyaha";
                    break;
                case 3:
                    service = "internet";
                    break;
                default:
                    System.out.println("Doorasho aan sax ahayn.");
                    return haraa;
            }
            System.out.println("Waxaad bixisay $" + amount + " adeegga " + service +
                    ". Haraaga cusub: $" + haraa);
        }

        return haraa;
    }

}