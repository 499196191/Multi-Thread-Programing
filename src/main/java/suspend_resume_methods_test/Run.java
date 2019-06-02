package suspend_resume_methods_test;

/**
 * @Program: Multi-Thread-Programing-Test
 * @Description:
 * @Author: Marty
 * @Created: 2019-06-02 08:41
 **/
public class Run {

    public static void main(String[] args){
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(5000);
            //a段
            myThread.suspend();
            System.out.println(String.format("A= %d i= %d", System.currentTimeMillis(), myThread.getI()));
            Thread.sleep(5000);
            System.out.println(String.format("A= %d i= %d", System.currentTimeMillis(), myThread.getI()));
            //b段
            myThread.resume();
            Thread.sleep(5000);
            myThread.suspend();
            System.out.println(String.format("B= %d i= %d", System.currentTimeMillis(), myThread.getI()));
            Thread.sleep(5000);
            System.out.println(String.format("B= %d i= %d", System.currentTimeMillis(), myThread.getI()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
