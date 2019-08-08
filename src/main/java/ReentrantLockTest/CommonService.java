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
            while (true) {
                if (!showA) {
                    //执行await()方法后会自动释放锁
                    condition.await();
                }
                System.out.println("打印-- A --");
                showA = false;
                condition.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public void printB() {
        try {
            lock.lock();
            while (true) {
                if (showA) {
                    condition.await();
                }
                System.out.println("打印-- B --");
                showA = true;
                condition.signalAll();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
