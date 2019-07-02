package com.spdb.service.generator;

import java.util.List;

import com.spdb.pojo.generator.TableForm;

public interface IGTableService {

	// 根据用户名，查询
	public List<TableForm> getTableXq(TableForm form) throws Exception;

}