package MultiThread;
import java.util.List;

public class DBInterface extends Thread{
    List<ClientsTread> clientsTreads;
    int clientCount;

    public DBInterface(List<ClientsTread> p){
        clientsTreads = p;
    }

    @Override
    public void run() {
        while (true){
            for(ClientsTread pot : clientsTreads)
                pot.waitForFull();
            for(ClientsTread pot : clientsTreads)
                pot.DataBaseRecord();
            clientCount++;
            if(clientCount %2 != 0)
                System.out.println("Отладка1");
            else
                System.out.println("Отладка2");
        }

    }
}

