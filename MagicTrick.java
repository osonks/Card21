import java.util.Scanner;

public class MagicTrick {
    private Magician mrMorse;
    private Logger log;
    private String fullMsg;
    private Scanner sc;

    public MagicTrick(){
        mrMorse = new Magician();
        log = new Logger();
        fullMsg = "";
        sc = new Scanner(System.in);
    }

    public void start(){

        int temp;
        log.startLogger();
        mrMorse.pick21cards();
        print("Carefully look at the following cards then choose one card to memorize it !\n\n");
        print(mrMorse.show21Cards());
        print("press enter when you are ready..");
        fullMsg+=sc.nextLine();

        for(int i=0;i<3;i++) {
            mrMorse.distributeCards();
            print(mrMorse.showColumns());
            print("where is your card (1, 2, 3)? ");
            temp= sc.nextInt();
            fullMsg+= temp + "\n";
            mrMorse.collectCards(temp);
        }

        print(mrMorse.revealChosenCard());
        log.logMessage(fullMsg);
        log.endLogger();
    }

    public void print(String txt){
        System.out.print(txt);
        fullMsg+=txt;
    }
}
