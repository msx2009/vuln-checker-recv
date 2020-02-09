package com.msx2009.vulns.server.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;
import java.util.UUID;

public class PortUtil {
	
	public static String assginPort() {
		int n=65535;
		int m=30000;
		
		int randNumber=0;
		String uuid = UUID.randomUUID().toString();
		do {
			Random rand = new Random();
			randNumber =rand.nextInt(n -m + 1) +m;
	
		} while(!isPortUseful(randNumber));
		
		
		System.out.println("assgin port:"+randNumber);
  
        MainThread s2=new MainThread(randNumber,uuid);
        s2.start();
        return "{\"port\":"+randNumber+",\"client_uuid\":\""+uuid+"\"}";
	}
	
	
	public static boolean isPortUseful(int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("127.0.0.1", port),500);
            System.out.println(port+" is not useful!");
            return false;
        } catch (IOException e) {
            System.out.println(port+" is useful!");
            return true;
        } 
      
       // return false;
    }

}
