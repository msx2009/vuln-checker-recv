package com.msx2009.vulns.server.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msx2009.vulns.server.mapper.ReverseDataMapper;
import com.msx2009.vulns.server.model.ReverseData;
import com.msx2009.vulns.server.service.ReverseDataService;
import com.msx2009.vulns.server.utils.PortUtil;
import com.msx2009.vulns.server.utils.ShadowsocksUtil;

@Service
public class ReverseDataServiceImpl implements ReverseDataService {


	@Autowired
	ReverseDataMapper reverseDataMapper;
	


	public String getFastJsonReverseAddr() {
		
		return PortUtil.assginPort();
	}
	
	public int getReverseRet(ReverseData reverseData) {
		return reverseDataMapper.getDataByUuidAndPort(reverseData);
	}

	public String getShadowsocksAddr() {
		return ShadowsocksUtil.assginPort();
		//return
	}
	
}
