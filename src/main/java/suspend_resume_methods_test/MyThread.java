package suspend_resume_methods_test;

/**
 * @Program: Multi-Thread-Programing-Test
 * @Description:
 * @Author: Marty
 * @Created: 2019-06-02 08:38
 **/
public class MyThread extends Thread {

    private long i = 0;

    public long getI() {
        return i;
    }
    public void setI(long i) {
        this.i = i;
    }
    @Override
    public void run(){
        while (true){
            i++;
        }
    }
}
