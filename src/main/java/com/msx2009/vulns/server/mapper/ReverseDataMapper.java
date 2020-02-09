package com.msx2009.vulns.server.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.msx2009.vulns.server.model.ReverseData;

@Mapper
public interface ReverseDataMapper {

	int addData(ReverseData reverseData);
	int getDataByUuidAndPort(ReverseData reverseData);
	
}
