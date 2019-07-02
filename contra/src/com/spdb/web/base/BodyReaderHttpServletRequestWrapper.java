package com.spdb.web.base;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;



import jodd.io.StreamUtil;

/**
 * 该类用于复制一个request
 * @author Administrator
 *
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private final byte[] body; //用于保存读取body中数据   
    
    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request)     
throws IOException {    
        super(request);    
        body = StreamUtil.readBytes(request.getInputStream());  
    }    
    
    @Override    
    public BufferedReader getReader() throws IOException {    
        return new BufferedReader(new InputStreamReader(getInputStream()));    
    }    
    
    @Override    
    public ServletInputStream getInputStream() throws IOException {    
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);    
        return new ServletInputStream() {    
    
            @Override    
            public int read() throws IOException {    
                return bais.read();    
            }

			public boolean isFinished() {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean isReady() {
				// TODO Auto-generated method stub
				return false;
			}

			public void setReadListener(ReadListener arg0) {
				// TODO Auto-generated method stub
				
			}

        };    
    }    
}  