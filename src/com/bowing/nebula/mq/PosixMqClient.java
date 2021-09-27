package com.bowing.nebula.mq;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class PosixMqClient
{

    private interface CustomLibrary extends Library
    {
        // linux (fedora20)
        CustomLibrary INSTANCE = Native.load("nebulamq", CustomLibrary.class);

        int bmAddx100(int a, int b);

        int bmSend(String mqName, byte[] data, int dataSize);
    }

    public static int bmSend(String mqName, byte[] data)
    {
        return CustomLibrary.INSTANCE.bmSend(mqName, data, data.length);
    }

}