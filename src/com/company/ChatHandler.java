package com.company;

import org.jgroups.*;

import java.util.Scanner;

public class ChatHandler extends ReceiverAdapter {
    JChannel channel;
    String userName;
    Scanner scanner = new Scanner(System.in);

    public void startChannel() throws ChannelException {

        System.out.print("Type in your name: ");
        userName = scanner.nextLine();

        channel= new JChannel();
        channel.setReceiver(this);
        channel.connect("AlarmChannel");
        getInputAndSend();
        channel.close();

    }

    void getInputAndSend(){

            while (true){
                try {

                System.out.print("TEXT HERE: ");
                String text = scanner.nextLine();

                if(text.toLowerCase() == "quit")
                    break;

                String message = userName + " > "+ text;

                Message msg=new Message(null, null, message);

                    channel.send(msg);
                } catch (ChannelNotConnectedException e) {
                    e.printStackTrace();
                } catch (ChannelClosedException e) {
                    e.printStackTrace();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
    }


    @Override
    public void receive(Message msg) {
        System.out.println(msg.getSrc() + ": " + msg.getObject());

    }

}
