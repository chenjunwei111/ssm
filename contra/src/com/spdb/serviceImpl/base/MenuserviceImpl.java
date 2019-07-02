package com.spdb.serviceImpl.base;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spdb.mapper.base.MenuMapper;
import com.spdb.pojo.base.Menu;
import com.spdb.service.base.MenuService;

@Service("MenuService")
@Transactional
public class MenuserviceImpl implements MenuService{

	@Resource
	MenuMapper mapper;

	@Override
	public List<Menu> queryMenuList() {
		return mapper.queryMenuList();
	}

	@Override
	@Transactional
	public Integer insert(Menu menu) {
		return mapper.insert(menu);
	}

	@Override
	@Transactional
	public Integer update(Menu menu) throws Exception {
		return mapper.update(menu);
	}

	@Override
	public List<Menu> queryMenuListCode(String userCode) {
		return mapper.queryMenuListCode(userCode);
	}
	
}
