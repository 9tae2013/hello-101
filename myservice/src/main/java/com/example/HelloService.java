package com.example;

/**
 * Created by realize on 28/12/2559.
 */

public class HelloService {

    private NameService nameService;
    private DosomethingService dosomethingService;

    public HelloService(NameService nameService, DosomethingService dosomethingService) {
        this.nameService = nameService;
        this.dosomethingService = dosomethingService;
    }

    public SayHelloResult sayHello(String name) {
        dosomethingService.dosomething();
        return new SayHelloResult("Hello " + name);
    }

    public class SayHelloResult {
        private String result;

        public SayHelloResult(String result) {
            this.result = result;
        }

        public String getResult() {
            return result;
        }
    }
}

