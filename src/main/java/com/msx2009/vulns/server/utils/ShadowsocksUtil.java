package com.msx2009.vulns.server.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;
import java.util.UUID;

public class ShadowsocksUtil {
	
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
  
		String configString = "{\n" + 
				"    \"server\":\"0.0.0.0\",\n" + 
				"    \"server_port\":"+Integer.toString(randNumber)+",\n" + 
				"    \"local_address\": \"127.0.0.1\",\n" + 
				"    \"local_port\":1080,\n" + 
				"    \"password\":\"wang123456\",\n" + 
				"    \"timeout\":300,\n" + 
				"    \"method\":\"aes-256-cfb\",\n" + 
				"    \"fast_open\": false\n" + 
				"}";
		String dataPathString = "/tmp/shadowConfig.json";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(dataPathString));
            out.write(configString);
            out.close();
            //System.out.println("文件创建成功！");
        } catch (IOException e) {
        }
        String cmdString = null;
        
        if(OSUtil.isMacOSX()) {
        	cmdString = "/usr/local/bin/ssserver -c "+dataPathString;
        }else {
        	cmdString = "/usr/bin/ssserver -c "+dataPathString;
        }
    
        System.out.println(cmdString);
        
        try {
			Process proc =Runtime.getRuntime().exec(cmdString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // MainThread s2=new MainThread(randNumber,uuid);
       // s2.start();
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
