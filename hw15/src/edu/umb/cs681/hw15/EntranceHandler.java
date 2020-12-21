package edu.umb.cs681.hw15;

public class EntranceHandler implements Runnable{
    private AdmissionControl admissionControl;
    private volatile boolean done;

    public EntranceHandler(AdmissionControl admissionControl) {
        this.admissionControl = admissionControl;
    }

    public void setDone(){
        done = true;
    }

    @Override
    public void run() {
        while (true) {
            if (done) {
                break;
            }

            admissionControl.enter();

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                continue;
            }


        }
    }
}
