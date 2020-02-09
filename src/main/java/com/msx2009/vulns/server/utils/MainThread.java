package com.msx2009.vulns.server.utils;


public class MainThread extends Thread {
	
	int port=0;
	String uuid=null;
	
	
	
	public MainThread(int port,String uuid) {
		this.port=port;
		this.uuid=uuid;
	}
    public void run() {
            try {
                ListenThread s=new ListenThread(port,uuid);
                s.start();
                
                //一分钟后停止监听线程
            	Thread.sleep(60000);
            	
            	while(s.isAlive()) {
            		s.interrupt();
            		s.serverSocket.close();
            		Thread.sleep(1000);
            	}
            	
            } catch (Exception e) {
                 //e.printStackTrace();
            	System.out.println(port+" close!");
            }
    }
}
