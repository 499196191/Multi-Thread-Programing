package suspend_resume_deal_lock;

/**
 * @Program: Multi-Thread-Programing-Test
 * @Description:
 * @Author: Marty
 * @Created: 2019-06-02 09:52
 **/
public class Run {
    public static void main(String[] args){
        try {
            final SyncronizedObject object = new SyncronizedObject();
            Thread thread1 = new Thread(()->{
                object.printString();
            });
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2 = new Thread(()->{
                System.out.println("thread2启动了，但进入不了printString（）方法！只打印了1个begin");
                System.out.println("因为printString（）方法被a线程锁定并且永远suspend暂停了！");
                object.printString();
            });
            thread2.start();
        }catch (Exception e){

        }
    }
}
