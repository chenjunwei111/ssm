package com.spdb.serviceImpl.generator;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spdb.common.StrTras;
import com.spdb.mapper.generator.GTableMapper;
import com.spdb.pojo.generator.TableForm;
import com.spdb.pojo.generator.TablePojo;
import com.spdb.service.generator.IGTableService;

@Service("gTableService")
public class GTableServiceImpl implements IGTableService {
	@Resource
	GTableMapper Mapper;

	@Override
	public List<TableForm> getTableXq(TableForm form) throws Exception {
		List<TablePojo> pojoList = Mapper.getTableXq(form);
		List<TableForm> fromList = new ArrayList<TableForm>();
		TableForm pf = null;
		for (TablePojo pojo : pojoList) {
			pf = new TableForm();
			pf.setTable_name(form.getTable_name());
			pf.setJavaName(StrTras.transform(pojo.getColumn_name()));// 转换成驼峰命名
			pf.setData_type(pojo.getData_type());
			pf.setData_length(pojo.getData_length());
			pf.setColumn_name(pojo.getColumn_name());
			pf.setData_precision(pojo.getData_precision());
			pf.setData_scale(pojo.getData_scale());
			fromList.add(pf);
		}
		return fromList;
	}

}
