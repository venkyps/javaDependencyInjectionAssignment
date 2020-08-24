package com;

public interface MessagePrinter {

    String SINGLETON_SCOPE="Singleton";
    String SINGLETON_PROTOTYPE="Prototype";

    String getService();

    /**
     * Getting bean based on the bean scope and interface type
     * @param theInterface
     * @param scopeType
     * @return
     * @throws CloneNotSupportedException
     */
    static MessageService getBean(Class theInterface, String scopeType) throws CloneNotSupportedException {
        if (theInterface == MessagePrinter.class) {
            if(SINGLETON_SCOPE.equals(scopeType)){
                return Singleton.<MessageService>Instance("com.MessageService");
            }else if(SINGLETON_PROTOTYPE.equals(scopeType)){
                MessageService messageService = new MessageService();
                return messageService;
            }
        }
        return null;
    }
}
