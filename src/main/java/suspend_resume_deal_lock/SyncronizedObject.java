package suspend_resume_deal_lock;

/**
 * @Program: Multi-Thread-Programing-Test
 * @Description:
 * @Author: Marty
 * @Created: 2019-06-02 09:49
 **/
public class SyncronizedObject {
    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远suspend了");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
