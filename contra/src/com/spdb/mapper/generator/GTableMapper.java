package com.spdb.mapper.generator;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.spdb.pojo.generator.TableForm;
import com.spdb.pojo.generator.TablePojo;

/**
 * 生成器：获取表结构信息
 * 
 * @author Chan
 * 
 */
@MapperScan
public interface GTableMapper {

	public List<TablePojo> getTableXq(TableForm form) throws Exception;

}
