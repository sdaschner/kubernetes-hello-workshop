package com.sebastian_daschner.kubernetes.boundary;

import com.sebastian_daschner.kubernetes.boundary.HelloResource;
import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResourceTest {

    private final HelloResource helloResource = new HelloResource();

    @Test
    public void testHello() {
        String first = helloResource.hello();
        String second = helloResource.hello();
        String third = helloResource.hello();

        Stream.of(first, second, third).forEach(s -> assertThat(s).startsWith("Hello Kubernetes"));
    }

}
