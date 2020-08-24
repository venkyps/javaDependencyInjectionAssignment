package com;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotEquals;

public class MessageServiceTest {

    @Test
    public void testDependencyInjection() throws CloneNotSupportedException {
        MessageService messageService1=MessagePrinter.getBean(MessagePrinter.class,"Singleton");
        assertNotNull(messageService1);
    }

    @Test
    public void testSingletonBean() throws CloneNotSupportedException {
        MessageService messageService1=MessagePrinter.getBean(MessagePrinter.class,"Singleton");
        MessageService messageService2=MessagePrinter.getBean(MessagePrinter.class,"Singleton");
        assertSame(messageService1,messageService2);
    }

    @Test
    public void testPrototypeBean() throws CloneNotSupportedException {
        MessageService messageService1=MessagePrinter.getBean(MessagePrinter.class,"Prototype");
        MessageService messageService2=(MessageService)messageService1.clone();
        assertNotEquals(messageService1,messageService2);
    }
}
