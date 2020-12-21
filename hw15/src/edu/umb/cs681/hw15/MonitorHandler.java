package edu.umb.cs681.hw15;

public class MonitorHandler implements Runnable{
    private volatile boolean done;
    private AdmissionControl admissionControl;

    public MonitorHandler(AdmissionControl admissionControl) {
        this.admissionControl = admissionControl;
    }

    public void setDone() {
        done = true;
    }

    @Override
    public void run() {
        while (true) {
            if (done) {
                break;
            }
            System.out.println("current visitor is " + admissionControl.countCurrentVisitors());

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                continue;
            }
        }
    }
}
