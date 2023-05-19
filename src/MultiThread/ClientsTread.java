package MultiThread;
import DataBase.PackageDB;

public class ClientsTread {
    String threadName;
    public int count;//сколько сейчас мёда
    public static final int maxCount = 10;//сколько всего мёда влезает в горшок
    public int countOField;
    public PackageDB packageDB;
    public ClientsTread(String potName, PackageDB packageDB, int countOField){
        this.threadName = potName;
        this.packageDB = packageDB;
        this.countOField = countOField;
    }

    //synchronized() не пустит больше 1
    synchronized public void put(){

        while(isFull())
            try{
                System.out.println(threadName +" Завершена обработка 10 клиетов");

                notify();
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        count ++;
        if(count % 10==0) {
            System.out.println("Пакет еды для данного пользователя: ");
            packageDB.getEatListFromPackage(count%countOField);
        }
    }

    synchronized public void DataBaseRecord(){

        while(!isFull())
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        System.out.println("Производится запись в ДБ");
        count = 0;
        notifyAll();
    }

    synchronized public void waitForFull(){
        while(!isFull())
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
    }

    public boolean isFull(){
        return count == maxCount;
    }
}
