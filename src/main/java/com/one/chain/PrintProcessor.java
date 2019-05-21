package com.one.chain;

import java.util.concurrent.LinkedBlockingQueue;

public class PrintProcessor extends Thread implements RequestProcessor {
    private final RequestProcessor nextProcessor;

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();


    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        try {
            Request request = requests.take();
            System.out.println("print data:" + request.getName());
            nextProcessor.processRequest(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //处理请求
    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
}
