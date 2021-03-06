package com.zbcn.socket.udp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description: udp socket
 * @Auther: zbcn8
 * @Date: 2019/4/18 15:33
 */
public class UDPClient {

    //设置接收数据的超时时间
    private static final int TIMEOUT= 5000;

    //设置重发数据的次数
    private static int MAX = 5;

    /**
     * 创建一个 DatagramSocket 实例，可以有选择对本地地址和端口号进行设置，如果设置了端口号，则客户端会在该端口号上监听从服务器端发送来的数据；
     使用 DatagramSocket 实例的 send()和 receive()方法来发送和接收 DatagramPacket 实例，进行通信；
     通信完成后，调用 DatagramSocket 实例的 close()方法来关闭该套接字。
     * @param args
     */
    public static void main(String[] args) throws IOException {

        String sendStr = "hello i`m udp socket";

        byte[] buff = new byte[1024];
        //客户端在9000端口监听接收到的数据
        DatagramSocket socket = new DatagramSocket(9000);
        InetAddress localHost = InetAddress.getLocalHost();
        //定义用来发送数据的DatagramPacket实例
        DatagramPacket dp_send = new DatagramPacket(sendStr.getBytes(), sendStr.length(), localHost, 3000);
        //定义用来接收数据的DatagramPacket实例
        DatagramPacket dp_receive = new DatagramPacket(buff, 1024);
        //数据发向本地3000端口
        socket.setSoTimeout(TIMEOUT);  //设置接收数据时阻塞的最长时间
        int tries = 0;                         //重发数据的次数
        boolean receivedResponse = false;     //是否接收到数据的标志位
        //直到接收到数据，或者重发次数达到预定值，则退出循环
        while(!receivedResponse  && tries <MAX){
          socket.send(dp_send);
            try {
                //接收从服务端发送回来的数据
                socket.receive(dp_receive);
                //如果接收到的数据不是来自目标地址，则抛出异常
                if(!dp_receive.getAddress().equals(localHost)){
                    throw new IOException("Received packet from an umknown source");
                }
                //如果接收到数据。则将receivedResponse标志位改为true，从而退出循环
                receivedResponse = true;
            } catch (InterruptedIOException e) {
                //如果接收数据时阻塞超时，重发并减少一次重发的次数
                tries += 1;
            }
        }
        if(receivedResponse){

            //如果收到数据，则打印出来
            System.out.println("client received data from server：");
            String str_receive = new String(dp_receive.getData(),0,dp_receive.getLength()) +
                    " from " + dp_receive.getAddress().getHostAddress() + ":" + dp_receive.getPort();
            System.out.println(str_receive);
            //由于dp_receive在接收了数据之后，其内部消息长度值会变为实际接收的消息的字节数，
            //所以这里要将dp_receive的内部消息长度重新置为1024
            dp_receive.setLength(1024);
        }else {
            //如果重发MAXNUM次数据后，仍未获得服务器发送回来的数据，则打印如下信息
            System.out.println("No response -- give up.");
        }
        socket.close();
    }
}
