package MultiThread;

public class Client extends Thread{
    private ClientsTread pot;
    private int timeSleep;


    public Client(ClientsTread p, int timeSleep){
        pot = p;
        this.timeSleep = timeSleep;
    }

    Client(ClientsTread p){
        this(p,50);
    }

    @Override
    //постоянно трудиться и носит мёд в горшок
    public void run() {
        while(true){
            pot.put();
            try {
                //после того как отнесла мёд отдыхает 50 мс
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) { }
        }
    }
}
