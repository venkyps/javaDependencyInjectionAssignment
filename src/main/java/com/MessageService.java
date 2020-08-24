package com;

class MessageService implements MessagePrinter, Cloneable {

   public MessageService(){
    }

    public String getService(){
        return "Message service is up";
    }

    /**
     * To instantiate the bean all time
     * @return
     */
    @Override
    public Object clone() {
        return new MessageService();
    }
}