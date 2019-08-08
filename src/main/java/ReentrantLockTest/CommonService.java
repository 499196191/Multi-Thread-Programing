package ReentrantLockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//实现轮询打印AB
public class CommonService {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean showA = true;

    public void printA() {
        try {
            lock.lock();
            while (true){
                if (showA) {
                    System.out.println("打印-- A --");
                    showA = false;
                    condition.signalAll();
                    condition.await();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();

        }
    }

    public void printB(){
        try {
            lock.lock();
            while (true){
                if (!showA) {
                    System.out.println("打印-- B --");
                    showA = true;
                    condition.signalAll();
                    condition.await();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
