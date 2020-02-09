package com.msx2009.vulns.server.utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.msx2009.vulns.server.mapper.ReverseDataMapper;
import com.msx2009.vulns.server.model.ReverseData;


public class ListenThread extends Thread {
	
	
	ReverseDataMapper reverseDataMapper = SpringBeanUtil.getBean(ReverseDataMapper.class);
	
	int port=0;
	String uuid=null;
	public ServerSocket serverSocket;
	
	public ListenThread(int port,String uuid) {
		this.port=port;
		this.uuid=uuid;
	}
    public void run() {
            //int port=55667;
            try {
                    serverSocket = new ServerSocket(port);
                    System.out.println("Listen:"+port);
                    // 轮流等待请求
                    while(true) {
                        // 等待客户端请求,无请求则闲置;有请求到来时,返回一个对该请求的socket连接
                        Socket clientSocket = serverSocket.accept();
                        String clientIpInfo = clientSocket.getRemoteSocketAddress().toString(); // /127.0.0.1:53555
                    
                        String clientIp = clientIpInfo.split(":")[0].split("/")[1];
                        
                        System.out.println(clientIp);
                        
                        ReverseData reverseData = new ReverseData();
                        
                        reverseData.setClient_ip(clientIp);
                        reverseData.setPort(port);
                        reverseData.setClient_uuid(uuid);
                        //reverseData.setIp("127");
                        
                       // ReverseDataMapper reverseDataMapper 
                       // ReverseDataServiceImpl reverseDateService = new ReverseDataServiceImpl();
                       // reverseDateService.addReverseData(reverseData);
                        reverseDataMapper.addData(reverseData);
                 
                        
                        clientSocket.close();

                    }
            } catch (IOException e) {
                 //e.printStackTrace();
            	System.out.println(port+" close!");
                 
            }
    }
}
