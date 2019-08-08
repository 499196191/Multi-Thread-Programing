package ReentrantLockTest;

public class Test {
    public static void main(String[] args){
        CommonService commonService = new CommonService();
        Thread taskA = new Thread(new TaskA(commonService));
        Thread taskB = new Thread(new TaskB(commonService));
        taskA.start();
        taskB.start();
    }
}
