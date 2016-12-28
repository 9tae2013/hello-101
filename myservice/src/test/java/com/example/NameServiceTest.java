package com.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NameServiceTest {

    @Test
    public void should_return_upercase() {
        // given
        String name = "abc";
        NameService service = new NameService(name);

        // when
        String result = service.getName();

        // then
        assertThat(result, equalTo("ABC"));

    }
}
