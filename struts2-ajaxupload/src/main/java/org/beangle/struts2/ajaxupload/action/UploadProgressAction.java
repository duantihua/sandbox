package org.beangle.struts2.ajaxupload.action;

import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.SessionAware;
import org.beangle.struts2.ajaxupload.multipart.ProgressMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.Action;

/**
 * @author chaostone
 */
public class UploadProgressAction implements SessionAware {

	private static Logger logger = LoggerFactory
			.getLogger(UploadProgressAction.class);

	private static final String SESSION_BYTES_UPLOADED_NOTCHANGED_COUNT = "SESSION_BYTES_UPLOADED_NOTCHANGED_COUNT";

	private Map sessionMap;

	private String rnd; // just a random number
	private String stringResult;

	public String execute() {
		if (logger.isDebugEnabled())
			logger.debug("Executing the UploadProgressAction action");

		Object mon_obj = sessionMap
				.get(ProgressMonitor.SESSION_PROGRESS_MONITOR);

		JSONObject json = new JSONObject();
		if (mon_obj != null) {
			ProgressMonitor monitor = (ProgressMonitor) mon_obj;
			json.accumulate("bytesSent", "" + monitor.getBytesRead());
			json.accumulate("bytesTotal", "" + monitor.getBytesLength());
			json.accumulate("percentComplete", "" + monitor.percentComplete());

			if (!monitor.isStillProcessing() || monitor.isAborted()) {
				json.accumulate("aborted", true);
			} else {
				json.accumulate("aborted", false);
			}

		} else {
			json.accumulate("bytesSent", "" + 0);
			json.accumulate("bytesTotal", "" + 0);
			json.accumulate("percentComplete", "" + 0);
			json.accumulate("aborted", false);
		}

		setStringResult(json.toString());
		if (logger.isDebugEnabled())
			logger.debug("JSON Result is: " + getStringResult());

		return Action.SUCCESS;
	}

	public void setSession(Map sessionMap) {
		this.sessionMap = sessionMap;
	}

	public void setRnd(String rnd) {
		this.rnd = rnd;
	}

	public String getRnd() {
		return rnd;
	}

	public void setStringResult(String stringResult) {
		this.stringResult = stringResult;
	}

	public String getStringResult() {
		return stringResult;
	}

}
