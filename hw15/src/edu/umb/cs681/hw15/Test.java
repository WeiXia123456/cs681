package edu.umb.cs681.hw15;

public class Test {
    public static void main(String[] args) {
        AdmissionControl admissionControl = new AdmissionControl();

        EntranceHandler entranceHandler1 = new EntranceHandler(admissionControl);
        EntranceHandler entranceHandler2 = new EntranceHandler(admissionControl);
        EntranceHandler entranceHandler3 = new EntranceHandler(admissionControl);
        ExitHandler exitHandler1 = new ExitHandler(admissionControl);
        ExitHandler exitHandler2 = new ExitHandler(admissionControl);
        ExitHandler exitHandler3 = new ExitHandler(admissionControl);
        MonitorHandler monitorHandler = new MonitorHandler(admissionControl);


        Thread t1 = new Thread(entranceHandler1);
        Thread t2 = new Thread(entranceHandler2);
        Thread t3 = new Thread(entranceHandler3);
        Thread t4 = new Thread(exitHandler1);
        Thread t5 = new Thread(exitHandler2);
        Thread t6 = new Thread(exitHandler3);
        Thread t7 = new Thread(monitorHandler);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        entranceHandler1.setDone();
        entranceHandler2.setDone();
        entranceHandler3.setDone();
        exitHandler1.setDone();
        exitHandler2.setDone();
        exitHandler3.setDone();
        monitorHandler.setDone();

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();
        t5.interrupt();
        t6.interrupt();
        t7.interrupt();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
