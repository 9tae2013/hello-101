package com.example;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HelloServiceTest {

    @Test
    public void testSayHello() {
        // given
        NameService nameService = mock(NameService.class);
        DosomethingService dosomethingService = mock(DosomethingService.class);
        HelloService helloService = new HelloService(nameService, dosomethingService);

        // when
        HelloService.SayHelloResult result = helloService.sayHello("test");

        // then
        assertThat(result.getResult(), startsWith("Hello "));
        verify(dosomethingService).dosomething();


    }
}
