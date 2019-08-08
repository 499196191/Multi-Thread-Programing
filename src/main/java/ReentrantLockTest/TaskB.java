package ReentrantLockTest;

public class TaskB implements Runnable {

    private CommonService commonService;

    public TaskB(CommonService commonService){
        this.commonService = commonService;
    }

    public void run() {
        commonService.printB();
    }
}
