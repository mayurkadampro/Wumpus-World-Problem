package wumpus;

public class Wumpus {

    public static void main(String[] args) {

        Imaplement imp = new Imaplement();
        imp.AssignAllObjects();
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t------ALL OBJECTS ARE ASSIGN------");
        imp.clearScreenFromSpacess();
        System.out.println("\t\t\t\t\t\t\t------Start The Game------");
        imp.PostionOfAllObject();
        imp.printArrayPlay();
        imp.MovementOfUser();

    }

}
