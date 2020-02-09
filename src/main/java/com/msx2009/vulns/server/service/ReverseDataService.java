package com.msx2009.vulns.server.service;

import com.msx2009.vulns.server.model.ReverseData;

public interface ReverseDataService {
	
	public String getFastJsonReverseAddr();
	
	public int getReverseRet(ReverseData reverseData);
	
	public String getShadowsocksAddr();
	

}
