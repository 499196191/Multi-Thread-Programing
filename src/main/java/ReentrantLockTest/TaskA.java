package ReentrantLockTest;

public class TaskA implements Runnable {

    private CommonService commonService;

    public TaskA(CommonService commonService){
        this.commonService = commonService;
    }

    public void run() {
        commonService.printA();
    }
}
