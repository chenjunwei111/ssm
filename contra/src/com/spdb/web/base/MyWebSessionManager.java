package com.spdb.web.base;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

public class MyWebSessionManager extends DefaultWebSessionManager{
	
	@Override
	public boolean isServletContainerSessions() {
		return true;
	}

}
