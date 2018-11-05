package wumpus;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Imaplement implements Interface {

    private static int score = 100;
    private static final String arr[][] = {{"0", "1", "2", "3"}, {"4", "5", "6", "7"}, {"8", "9", "10", "11"}, {"12", "13", "14", "15"}};
    private static final String arrr[][] = {{"0", "1", "2", "3"}, {"4", "5", "6", "7"}, {"8", "9", "10", "11"}, {"12", "13", "14", "15"}};
    private static boolean CurrentVal = true;
    private static int x;
    private static int x1;
    private static int x2;
    private static int positionxGOLD;
    private static int positionyGOLD;
    private static int positionxWUMPUS;
    private static int positionyWUMPUS;
    private static int positionxPIT;
    private static int positionyPIT;
    private static final Scanner sc = new Scanner(System.in);

    public void PostionOfAllObject() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == "GOLD") {
                    //System.out.println("GOLD At " + i + " " + j);
                    positionxGOLD = i;
                    positionyGOLD = j;
                }
                if (arr[i][j] == "PIT") {
                    //System.out.println("PIT At " + i + " " + j);
                    positionxPIT = i;
                    positionyPIT = j;
                }
                if (arr[i][j] == "WUMPUS") {
                    //System.out.println("WUMPUS At " + i + " " + j);
                    positionxWUMPUS = i;
                    positionyWUMPUS = j;
                }

            }
        }
    }

    @Override
    public void MovementOfUser() {

        while (true) {
            
            checkScrore();
            if (arr[0][0].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[0][0]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[0][0]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[0][0]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 2 To Move Downward Or 6 To Move Right");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 2:
                        arr[0][0] = "0";
                        arr[0 + 1][0] = "USER";
                        arrr[0][0] = "0";
                        arrr[0 + 1][0] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[0][0] = "0";
                        arr[0][0 + 1] = "USER";
                        arrr[0][0] = "0";
                        arrr[0][0 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }

            }

            checkScrore();
            if (arr[1][0].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[1][0]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[1][0]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[1][0]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                System.out.println("Enter 8 To Move Upward Or 2 To Move Downward Or 6 To Move Right");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[1][0] = "4";
                        arr[1 - 1][0] = "USER";
                        arrr[1][0] = "4";
                        arrr[1 - 1][0] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[1][0] = "4";
                        arr[1][0 + 1] = "USER";
                        arrr[1][0] = "4";
                        arrr[1][0 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 2:
                        arr[1][0] = "4";
                        arr[1 + 1][0] = "USER";
                        arrr[1][0] = "4";
                        arrr[1 + 1][0] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }

            }

            checkScrore();
            if (arr[0][1].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[0][1]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[0][1]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[0][1]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                System.out.println("Enter 2 To Move Downward Or 4 To Move Left Or 6 To Right");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 4:
                        arr[0][1] = "1";
                        arr[0][1 - 1] = "USER";
                        arrr[0][1] = "1";
                        arrr[0][1 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 2:
                        arr[0][1] = "1";
                        arr[0 + 1][1] = "USER";
                        arrr[0][1] = "1";
                        arrr[0 + 1][1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[0][1] = "1";
                        arr[0][1 + 1] = "USER";
                        arrr[0][1] = "1";
                        arrr[0][1 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }

            }

            checkScrore();
            if (arr[1][1].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[1][1]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[1][1]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[1][1]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or 2 To Move Downward Or 6 To Move Right Or 4 To Move Left");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[1][1] = "5";
                        arr[1 - 1][1] = "USER";
                        arrr[1][1] = "5";
                        arrr[1 - 1][1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 4:
                        arr[1][1] = "5";
                        arr[1][1 - 1] = "USER";
                        arrr[1][1] = "5";
                        arrr[1][1 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[1][1] = "5";
                        arr[1][1 + 1] = "USER";
                        arrr[1][1] = "5";
                        arrr[1][1 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 2:
                        arr[1][1] = "5";
                        arr[1 + 1][1] = "USER";
                        arrr[1][1] = "5";
                        arrr[1 + 1][1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }
            }

            checkScrore();
            if (arr[2][1].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[2][1]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[2][1]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[2][1]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or 2 To Move Downward Or 6 To Move Right Or 4 To Move Left");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[2][1] = "9";
                        arr[2 - 1][1] = "USER";
                        arrr[2][1] = "9";
                        arrr[2 - 1][1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 4:
                        arr[2][1] = "9";
                        arr[2][1 - 1] = "USER";
                        arrr[2][1] = "9";
                        arrr[2][1 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[2][1] = "9";
                        arr[2][1 + 1] = "USER";
                        arrr[2][1] = "9";
                        arrr[2][1 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 2:
                        arr[2][1] = "9";
                        arr[2 + 1][1] = "USER";
                        arrr[2][1] = "9";
                        arrr[2 + 1][1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }
            }
            
            checkScrore();
            if (arr[3][1].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[3][1]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[3][1]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[3][1]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or 6 To Move Right Or 4 To Move Left");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[3][1] = "13";
                        arr[3 - 1][1] = "USER";
                        arrr[3][1] = "13";
                        arrr[3 - 1][1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 4:
                        arr[3][1] = "13";
                        arr[3][1 - 1] = "USER";
                        arrr[3][1] = "13";
                        arrr[3][1 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[3][1] = "13";
                        arr[3][1 + 1] = "USER";
                        arrr[3][1] = "13";
                        arrr[3][1 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }
            }

            checkScrore();
            if (arr[0][2].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[0][2]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[0][2]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[0][2]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 2 To Move Downward Or 4 To Move Left Or 6 To Move Right");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 4:
                        arr[0][2] = "2";
                        arr[0][2 - 1] = "USER";
                        arrr[0][2] = "2";
                        arrr[0][2 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 2:
                        arr[0][2] = "2";
                        arr[0 + 1][2] = "USER";
                        arrr[0][2] = "2";
                        arrr[0 + 1][2] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[0][2] = "2";
                        arr[0][2 + 1] = "USER";
                        arrr[0][2] = "2";
                        arrr[0][2 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }
            }

            checkScrore();
            if (arr[1][2].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[1][2]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[1][2]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[1][2]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or 2 To Move Downward Or 6 To Move Right Or 4 To Move Left");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[1][2] = "6";
                        arr[1 - 1][2] = "USER";
                        arrr[1][2] = "6";
                        arrr[1 - 1][2] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 4:
                        arr[1][2] = "6";
                        arr[1][2 - 1] = "USER";
                        arrr[1][2] = "6";
                        arrr[1][2 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[1][2] = "6";
                        arr[1][2 + 1] = "USER";
                        arrr[1][2] = "6";
                        arrr[1][2 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 2:
                        arr[1][2] = "6";
                        arr[1 + 1][2] = "USER";
                        arrr[1][2] = "6";
                        arrr[1 + 1][2] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }

            }

            checkScrore();
            if (arr[2][2].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[2][2]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[2][2]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[2][2]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or 2 To Move Downward Or 6 To Move Right Or 4 To Move Left");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[2][2] = "10";
                        arr[2 - 1][2] = "USER";
                        arrr[2][2] = "10";
                        arrr[2 - 1][2] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 4:
                        arr[2][2] = "10";
                        arr[2][2 - 1] = "USER";
                        arrr[2][2] = "10";
                        arrr[2][2 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[2][2] = "10";
                        arr[2][2 + 1] = "USER";
                        arrr[2][2] = "10";
                        arrr[2][2 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 2:
                        arr[2][2] = "10";
                        arr[2 + 1][2] = "USER";
                        arrr[2][2] = "10";
                        arrr[2 + 1][2] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }

            }

            checkScrore();
            if (arr[3][2].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[3][2]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[3][2]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[3][2]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or 6 To Move Right Or 4 To Move Left");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[3][2] = "14";
                        arr[3 - 1][2] = "USER";
                        arrr[3][2] = "14";
                        arrr[3 - 1][2] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 4:
                        arr[3][2] = "14";
                        arr[3][2 - 1] = "USER";
                        arrr[3][2] = "14";
                        arrr[3][2 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[3][2] = "14";
                        arr[3][2 + 1] = "USER";
                        arrr[3][2] = "14";
                        arrr[3][2 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }
            }

            checkScrore();
            if (arr[0][3].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[0][3]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[0][3]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[0][3]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 2 To Move Downward Or 4 To Move Left");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 4:
                        arr[0][3] = "3";
                        arr[0][3 - 1] = "USER";
                        arrr[0][3] = "3";
                        arrr[0][3 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 2:
                        arr[0][3] = "3";
                        arr[0 + 1][3] = "USER";
                        arrr[0][3] = "3";
                        arrr[0 + 1][3] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }
            }

            checkScrore();
            if (arr[1][3].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[1][3]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[1][3]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[1][3]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or 2 To Move Downward Or 4 To Move Left");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[1][3] = "7";
                        arr[1 - 1][3] = "USER";
                        arrr[1][3] = "7";
                        arrr[1 - 1][3] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 4:
                        arr[1][3] = "7";
                        arr[1][3 - 1] = "USER";
                        arrr[1][3] = "7";
                        arrr[1][3 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 2:
                        arr[1][3] = "7";
                        arr[1 + 1][3] = "USER";
                        arrr[1][3] = "7";
                        arrr[1 + 1][3] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }
            }

            checkScrore();
            if (arr[2][3].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[2][3]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[2][3]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[2][3]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or 2 To Move Downward Or 4 To Move Left");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[2][3] = "11";
                        arr[2 - 1][3] = "USER";
                        arrr[2][3] = "11";
                        arrr[2 - 1][3] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 4:
                        arr[2][3] = "11";
                        arr[2][3 - 1] = "USER";
                        arrr[2][3] = "11";
                        arrr[2][3 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 2:
                        arr[2][3] = "11";
                        arr[2 + 1][3] = "USER";
                        arrr[2][3] = "11";
                        arrr[2 + 1][3] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }

            }

            checkScrore();
            if (arr[3][3].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[3][3]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[3][3]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[3][3]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or Enter 4 To Move Left");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[3][3] = "15";
                        arr[3 - 1][3] = "USER";
                        arrr[3][3] = "15";
                        arrr[3 - 1][3] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 4:
                        arr[3][3] = "15";
                        arr[3][3 - 1] = "USER";
                        arrr[3][3] = "15";
                        arrr[3][3 - 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }

            }

            checkScrore();
            if (arr[2][0].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[2][0]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[2][0]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[2][0]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or 6 To Move Right Or 2 To Move Downward");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 2:
                        arr[2][0] = "8";
                        arr[2 + 1][0] = "USER";
                        arrr[2][0] = "8";
                        arrr[2 + 1][0] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[2][0] = "8";
                        arr[2][0 + 1] = "USER";
                        arrr[2][0] = "8";
                        arrr[2][0 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 8:
                        arr[2][0] = "8";
                        arr[2 - 1][0] = "USER";
                        arrr[2][0] = "8";
                        arrr[2 - 1][0] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                }
            }

            checkScrore();
            if (arr[3][0].equals("USER")) {
                playAlertForWumPus();
                playAlertForPIt();
                playAlertForGold();
                if (arr[positionxGOLD][positionyGOLD] == arr[3][0]) {
                    try {
                        GrabGold();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Got The GOLD");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxWUMPUS][positionyWUMPUS] == arr[3][0]) {
                    try {
                        WumpusEat();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("You Lose The Match");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (arr[positionxPIT][positionyPIT] == arr[3][0]) {
                    try {
                        PITMan();
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You Fall Into PIT");
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Enter 8 To Move Upward Or 6 To Move Right");
                System.out.print("Enter Your Choice : ");
                x = sc.nextInt();
                switch (x) {
                    case 8:
                        arr[3][0] = "12";
                        arr[3 - 1][0] = "USER";
                        arrr[3][0] = "12";
                        arrr[3 - 1][0] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;
                    case 6:
                        arr[3][0] = "12";
                        arr[3][0 + 1] = "USER";
                        arrr[3][0] = "12";
                        arrr[3][0 + 1] = "USER";
                        score -= 10;
                        clearScreenFromSpacess();
                        printArrayPlay();
                        break;

                }
            }
        }

    }

    @Override
    public void AssignAllObjects() {
        clearScreenFromSpacess();
        printArray();
        System.out.print("Enter A Position Of USER : ");
        x = sc.nextInt();
        AssignUSER(x);
        clearScreenFromSpacess();
        printArray();
        System.out.print("Enter A Position Of WUMPUS : ");
        x = sc.nextInt();
        AssignWumpus(x);
        if (CurrentVal == false) {
            System.exit(0);
        }
        clearScreenFromSpacess();
        printArray();
        System.out.print("Enter A Position Of PIT :");
        x = sc.nextInt();
        AssignPITS(x);
        if (CurrentVal == false) {
            System.exit(0);
        }
        clearScreenFromSpacess();
        printArray();
        System.out.print("Enter A Position Of GOLD :");
        x = sc.nextInt();
        AssignGold(x);
        if (CurrentVal == false) {
            System.exit(0);
        }
        printArray();

    }

    @Override
    public void AssignUSER(int x) {

        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (x == i) {
                arr[0][i] = "USER";
                arrr[0][i] = "USER";
                break;
            }
        }

        for (int i = 4; i < 8; i++) {
            if (x == i) {
                arr[1][count] = "USER";
                arrr[1][count] = "USER";
                break;
            }
            count++;

        }

        count = 0;
        for (int i = 8; i < 12; i++) {
            if (x == i) {
                arr[2][count] = "USER";
                arrr[2][count] = "USER";
                break;
            }
            count++;
        }

        count = 0;
        for (int i = 12; i < 16; i++) {
            if (x == i) {
                arr[3][count] = "USER";
                arrr[3][count] = "USER";
                break;
            }
            count++;

        }

    }

    @Override
    public void AssignWumpus(int x) {

        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (x == i) {
                if (arr[0][i] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                arr[0][i] = "WUMPUS";
                break;
            }
        }

        for (int i = 4; i < 8; i++) {
            if (x == i) {
                if (arr[1][count] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                arr[1][count] = "WUMPUS";
                break;
            }
            count++;

        }

        count = 0;
        for (int i = 8; i < 12; i++) {
            if (x == i) {
                if (arr[2][count] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                arr[2][count] = "WUMPUS";
                break;
            }
            count++;
        }

        count = 0;
        for (int i = 12; i < 16; i++) {
            if (x == i) {
                if (arr[3][count] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                arr[3][count] = "WUMPUS";
                break;
            }
            count++;

        }

    }

    @Override
    public void AssignPITS(int x) {

        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (x == i) {
                if (arr[0][i] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                if (arr[0][i] == "WUMPUS") {
                    System.out.println("The Current Value Is Given To WUMPUS");
                    CurrentVal = false;
                    break;
                }
                arr[0][i] = "PIT";
                break;
            }
        }

        for (int i = 4; i < 8; i++) {
            if (x == i) {
                if (arr[1][count] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                if (arr[1][count] == "WUMPUS") {
                    System.out.println("The Current Value Is Given To WUMPUS");
                    CurrentVal = false;
                    break;
                }
                arr[1][count] = "PIT";
                break;
            }
            count++;

        }

        count = 0;
        for (int i = 8; i < 12; i++) {
            if (x == i) {
                if (arr[2][count] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                if (arr[2][count] == "WUMPUS") {
                    System.out.println("The Current Value Is Given To WUMPUS");
                    CurrentVal = false;
                    break;
                }
                arr[2][count] = "PIT";
                break;
            }
            count++;
        }

        count = 0;
        for (int i = 12; i < 16; i++) {
            if (x == i) {
                if (arr[3][count] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                if (arr[3][count] == "WUMPUS") {
                    System.out.println("The Current Value Is Given To WUMPUS");
                    CurrentVal = false;
                    break;
                }

                arr[3][count] = "PIT";
                break;
            }
            count++;

        }

    }

    @Override
    public void AssignGold(int x) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (x == i) {
                if (arr[0][i] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                if (arr[0][i] == "WUMPUS") {
                    System.out.println("The Current Value Is Given To WUMPUS");
                    CurrentVal = false;
                    break;
                }
                if (arr[0][i] == "PIT") {
                    System.out.println("The Current Value Is Given To PIT");
                    CurrentVal = false;
                    break;
                }
                arr[0][i] = "GOLD";
                //arrr[0][i] = "GOLD";
                break;
            }
        }

        for (int i = 4; i < 8; i++) {
            if (x == i) {
                if (arr[1][count] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                if (arr[1][count] == "WUMPUS") {
                    System.out.println("The Current Value Is Given To WUMPUS");
                    CurrentVal = false;
                    break;
                }
                if (arr[1][count] == "PIT") {
                    System.out.println("The Current Value Is Given To PIT");
                    CurrentVal = false;
                    break;
                }
                arr[1][count] = "GOLD";
                //arrr[1][count] = "GOLD";
                break;
            }
            count++;

        }

        count = 0;
        for (int i = 8; i < 12; i++) {
            if (x == i) {
                if (arr[2][count] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                if (arr[2][count] == "WUMPUS") {
                    System.out.println("The Current Value Is Given To WUMPUS");
                    CurrentVal = false;
                    break;
                }
                if (arr[2][count] == "PIT") {
                    System.out.println("The Current Value Is Given To PIT");
                    CurrentVal = false;
                    break;
                }
                arr[2][count] = "GOLD";
                //arrr[2][count] = "GOLD";
                break;
            }
            count++;
        }

        count = 0;
        for (int i = 12; i < 16; i++) {
            if (x == i) {
                if (arr[3][count] == "USER") {
                    System.out.println("The Current Value Is Given To USER");
                    CurrentVal = false;
                    break;
                }
                if (arr[3][count] == "WUMPUS") {
                    System.out.println("The Current Value Is Given To WUMPUS");
                    CurrentVal = false;
                    break;
                }
                if (arr[3][count] == "PIT") {
                    System.out.println("The Current Value Is Given To PIT");
                    CurrentVal = false;
                    break;
                }

                arr[3][count] = "GOLD";
                //arrr[3][count] = "GOLD";
                break;
            }
            count++;

        }

    }

    @Override
    public void printArray() {

        System.out.println();
        System.out.println("\t\t\t\t -------------------------------------------------------------------------");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t\t" + arr[0][0] + "\t | \t" + arr[0][1] + "\t | \t" + arr[0][2] + "\t | \t" + arr[0][3] + "\t | \t");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t -------------------------------------------------------------------------");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t\t" + arr[1][0] + "\t | \t" + arr[1][1] + "\t | \t" + arr[1][2] + "\t | \t" + arr[1][3] + "\t | \t");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t -------------------------------------------------------------------------");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t\t" + arr[2][0] + "\t | \t" + arr[2][1] + "\t | \t" + arr[2][2] + "\t | \t" + arr[2][3] + "\t | \t");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t --------------------------------------------------------------------------");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t\t" + arr[3][0] + "\t | \t" + arr[3][1] + "\t | \t" + arr[3][2] + "\t | \t" + arr[3][3] + "\t | \t");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t -------------------------------------------------------------------------");

    }

    @Override
    public void printArrayPlay() {

        System.out.println();
        System.out.println("Player Score : " + score);
        System.out.println("\t\t\t\t -------------------------------------------------------------------------");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t\t" + arrr[0][0] + "\t | \t" + arrr[0][1] + "\t | \t" + arrr[0][2] + "\t | \t" + arrr[0][3] + "\t | \t");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t -------------------------------------------------------------------------");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t\t" + arrr[1][0] + "\t | \t" + arrr[1][1] + "\t | \t" + arrr[1][2] + "\t | \t" + arrr[1][3] + "\t | \t");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t -------------------------------------------------------------------------");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t\t" + arrr[2][0] + "\t | \t" + arrr[2][1] + "\t | \t" + arrr[2][2] + "\t | \t" + arrr[2][3] + "\t | \t");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t --------------------------------------------------------------------------");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t\t" + arrr[3][0] + "\t | \t" + arrr[3][1] + "\t | \t" + arrr[3][2] + "\t | \t" + arrr[3][3] + "\t | \t");
        System.out.println(" \t\t\t\t\t\t | \t\t | \t\t | \t\t |");
        System.out.println("\t\t\t\t -------------------------------------------------------------------------");

    }

    @Override
    public void playAlertSoundNearWUMPUS() {
        try {
            File sound = new File("C:\\Users\\Mayur\\Documents\\NetBeansProjects\\Wumpus\\src\\Sound\\beep-07.wav");
            AudioInputStream audio = null;
            audio = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void playAlertForWumPus() {

        if (arr[0][0].equals("WUMPUS")) {
            if (arrr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arrr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[0][1].equals("WUMPUS")) {
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[0][2].equals("WUMPUS")) {
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[0][3].equals("WUMPUS")) {
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[1][0].equals("WUMPUS")) {
            if (arrr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arrr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arrr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }

        }

        if (arr[1][1].equals("WUMPUS")) {
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[1][2].equals("WUMPUS")) {
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[1][3].equals("WUMPUS")) {
            if (arr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
        }

        if (arr[2][0].equals("WUMPUS")) {
            if (arrr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arrr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arrr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }

        }

        if (arr[2][1].equals("WUMPUS")) {
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[2][2].equals("WUMPUS")) {
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[2][3].equals("WUMPUS")) {
            if (arr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS + 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
        }

        /**
         * ******************************************
         */
        if (arr[3][0].equals("WUMPUS")) {
            if (arrr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arrr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[3][1].equals("WUMPUS")) {
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[3][2].equals("WUMPUS")) {
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS][positionyWUMPUS + 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
            if (arr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

        if (arr[3][3].equals("WUMPUS")) {
            if (arr[positionxWUMPUS][positionyWUMPUS - 1].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();

            }
            if (arr[positionxWUMPUS - 1][positionyWUMPUS].equals("USER")) {
                System.out.println("WUMPUS IS NEAR");
                playAlertSoundNearWUMPUS();
            }
        }

    }

    @Override
    public void WumpusEat() {
        try {
            File sound = new File("C:\\Users\\Mayur\\Documents\\NetBeansProjects\\Wumpus\\src\\Sound\\evil_laugh.wav");
            AudioInputStream audio = null;
            audio = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void PITMan() {
        try {
            File sound = new File("C:\\Users\\Mayur\\Documents\\NetBeansProjects\\Wumpus\\src\\Sound\\fall.wav");
            AudioInputStream audio = null;
            audio = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void GrabGold() {
        try {
            File sound = new File("C:\\Users\\Mayur\\Documents\\NetBeansProjects\\Wumpus\\src\\Sound\\coin.wav");
            AudioInputStream audio = null;
            audio = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void playAlertForPIt() {

        if (arr[0][0].equals("PIT")) {
            if (arrr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arrr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[0][1].equals("PIT")) {
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[0][2].equals("PIT")) {
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[0][3].equals("PIT")) {
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[1][0].equals("PIT")) {
            if (arrr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arrr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arrr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }

        }

        if (arr[1][1].equals("PIT")) {
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[1][2].equals("PIT")) {
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[1][3].equals("PIT")) {
            if (arr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
        }

        if (arr[2][0].equals("PIT")) {
            if (arrr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arrr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arrr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }

        }

        if (arr[2][1].equals("PIT")) {
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[2][2].equals("PIT")) {
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[2][3].equals("PIT")) {
            if (arr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT + 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
        }

        /**
         * ******************************************
         */
        if (arr[3][0].equals("PIT")) {
            if (arrr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arrr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[3][1].equals("PIT")) {
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[3][2].equals("PIT")) {
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT][positionyPIT + 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
            if (arr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

        if (arr[3][3].equals("PIT")) {
            if (arr[positionxPIT][positionyPIT - 1].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();

            }
            if (arr[positionxPIT - 1][positionyPIT].equals("USER")) {
                System.out.println("PIT IS NEAR");
                playAlertSoundNearPIT();
            }
        }

    }

    @Override
    public void playAlertForGold() {

        if (arr[0][0].equals("GOLD")) {
            if (arrr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arrr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[0][1].equals("GOLD")) {
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[0][2].equals("GOLD")) {
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[0][3].equals("GOLD")) {
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[1][0].equals("GOLD")) {
            if (arrr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arrr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arrr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }

        }

        if (arr[1][1].equals("GOLD")) {
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[1][2].equals("GOLD")) {
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[1][3].equals("GOLD")) {
            if (arr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
        }

        if (arr[2][0].equals("GOLD")) {
            if (arrr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arrr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arrr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }

        }

        if (arr[2][1].equals("GOLD")) {
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[2][2].equals("GOLD")) {
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[2][3].equals("GOLD")) {
            if (arr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD + 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
        }

        /**
         * ******************************************
         */
        if (arr[3][0].equals("GOLD")) {
            if (arrr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arrr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[3][1].equals("GOLD")) {
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[3][2].equals("GOLD")) {
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD][positionyGOLD + 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
            if (arr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

        if (arr[3][3].equals("GOLD")) {
            if (arr[positionxGOLD][positionyGOLD - 1].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();

            }
            if (arr[positionxGOLD - 1][positionyGOLD].equals("USER")) {
                System.out.println("GOLD IS NEAR");
                playAlertSoundNearGOLD();
            }
        }

    }

    @Override
    public void playAlertSoundNearPIT() {
        try {
            File sound = new File("C:\\Users\\Mayur\\Documents\\NetBeansProjects\\Wumpus\\src\\Sound\\pit.wav");
            AudioInputStream audio = null;
            audio = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void playAlertSoundNearGOLD() {
        try {
            File sound = new File("C:\\Users\\Mayur\\Documents\\NetBeansProjects\\Wumpus\\src\\Sound\\gold.wav");
            AudioInputStream audio = null;
            audio = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Imaplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearScreenFromSpacess() {
        for (int i = 0; i <= 35; i++) {
            System.out.println();
        }
    }

    public void checkScrore() {
        if (score <= 0) {
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t You Lost Your Moves");
            System.exit(0);
        }
    }

}
