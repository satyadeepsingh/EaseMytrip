package org.emt.com.asdits.api.action;

import java.security.NoSuchAlgorithmException;

import org.emt.com.asdits.api.model.BasicRestResponse;


public interface ApiAction<R extends BasicRestResponse, T> {
	
	R execute (T request) throws NoSuchAlgorithmException;

}
