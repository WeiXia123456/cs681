package edu.umb.cs681.hw15;

public class ExitHandler implements Runnable{
    private volatile boolean done;
    private AdmissionControl admissionControl;

    public ExitHandler(AdmissionControl admissionControl) {
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

            admissionControl.exit();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                continue;
            }


        }
    }
}
