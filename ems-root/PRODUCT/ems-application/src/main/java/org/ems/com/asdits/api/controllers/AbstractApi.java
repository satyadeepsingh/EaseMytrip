package org.ems.com.asdits.api.controllers;

import java.security.NoSuchAlgorithmException;

import org.ems.com.asdits.api.action.ApiAction;
import org.ems.com.asdits.api.model.BasicRestResponse;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractApi {
	
	protected <R extends BasicRestResponse, T> ResponseEntity<R> executeRequest(String sessionId, ApiAction<R,T> action, T bodyRequest) throws NoSuchAlgorithmException {
//		logStartMethod(getMethodName(), getUrlParams(), headerParam, bodyParam);
		R response = action.execute(bodyRequest);
		final ResponseEntity<R> resp = new ResponseEntity<R>(response, HttpStatus.OK);
		return resp;
	}
	
	protected void logStartMethod (String methodName, Object urlParam, Object headerParam, Object bodyParam) {
        getLOGGER ().info ("Start method [" + methodName + "]");

        // url param
        if (urlParam != null) {
            getLOGGER ().debug ("Url parameter [{}]", urlParam);
        }

        // header param
        if (headerParam != null) {
            getLOGGER ().debug ("Header parameter [{}]", headerParam);
        }

        // body param
        if (bodyParam != null) {
            getLOGGER ().debug ("Body parameter [{}]", bodyParam);
        }

    }
	
//	   protected void logEnd (RESTField.Builder restBuilder, GeneralLoggingFields.Builder generalBuilder,
//	            ResponseEntity<? extends BasicRestResponse> response, long begin) {
//
//	        RESTField restField = restBuilder.contentLength (response.getHeaders ().getContentLength ())
//	                .responseTime (System.currentTimeMillis () - begin).status (Long.valueOf (HttpStatus.OK.value ()))
//	                .build ();
//
//	        GeneralLoggingFields generalFields = generalBuilder.rest (restField)
//	                .applicationData (new GeneralApplicationData (this.applicationSettings))
//	                .event (MonitoringUtils.EventType.REST_RESPONSE_IN_EVENT.getName ()).build ();
//
//	        logEndMethod (restField.getOperationName (), response);
//	        LOGGER_MONITORING.info (MonitoringUtils.toJSONMonitoring (generalFields));
//	        RequestSharedDataHolder.setSessionId (null);
//	    }

	protected abstract Logger getLOGGER();
}
