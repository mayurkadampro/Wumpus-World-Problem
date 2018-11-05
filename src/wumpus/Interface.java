package wumpus;

public interface Interface {
    
    void MovementOfUser();
    void AssignAllObjects();
    void AssignUSER(int x);
    void AssignWumpus(int x);
    void AssignPITS(int x);
    void AssignGold(int x);
    void PostionOfAllObject();
    void printArray();
    void printArrayPlay();
    void playAlertSoundNearWUMPUS();
    void playAlertSoundNearPIT();
    void playAlertSoundNearGOLD();
    void playAlertForWumPus();
    void playAlertForPIt();
    void playAlertForGold();
    void WumpusEat();
    void PITMan();
    void GrabGold();
}
