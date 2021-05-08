package com.company;

import org.jgroups.ChannelException;
import org.jgroups.JChannel;
import org.jgroups.Message;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            new ChatHandler().startChannel();
        } catch (ChannelException e) {
            e.printStackTrace();
        }

    }
}
