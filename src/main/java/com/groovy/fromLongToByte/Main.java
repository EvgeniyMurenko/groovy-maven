package com.groovy.fromLongToByte;

import java.nio.ByteBuffer;

public class Main {
    public static void main(String[] args) {

        Long val = 139904L;
        byte[] arr = longToBytes(val);
        System.out.println(arr);

        long newVal = bytesToLong(arr);
        System.out.println(newVal);
    }


    private static ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);

    public static byte[] longToBytes(long x) {
        buffer.putLong(0, x);
        return buffer.array();
    }

    public static long bytesToLong(byte[] bytes) {
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();//need flip
        return buffer.getLong();
    }
}
