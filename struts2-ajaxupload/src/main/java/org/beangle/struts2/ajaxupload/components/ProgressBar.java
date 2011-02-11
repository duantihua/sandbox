/**
 * 17 Oct 2007 13:41:07
 */
package org.beangle.struts2.ajaxupload.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.util.ValueStack;

public class ProgressBar extends ClosingUIBean {

	private final Logger logger = LoggerFactory.getLogger(ProgressBar.class);

	private String action;
	private String dobefore;
	private String doafter;

	private static final String OPEN_TEMPLATE = "progressbar";
	private static final String CLOSE_TEMPLATE = "progressbar-close";

	public ProgressBar(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	protected void evaluateExtraParams() {
		super.evaluateExtraParams();
		logger.info("");
		if (action != null)
			addParameter("action", findString(action));
		if (doafter != null)
			addParameter("doafter", findString(doafter));
		if (dobefore != null)
			addParameter("dobefore", findString(dobefore));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.components.ClosingUIBean#getDefaultOpenTemplate()
	 */
	@Override
	public String getDefaultOpenTemplate() {
		logger.info("");
		return OPEN_TEMPLATE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.components.UIBean#getDefaultTemplate()
	 */
	@Override
	protected String getDefaultTemplate() {
		logger.info("");
		return CLOSE_TEMPLATE;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setDoafter(String doafter) {
		this.doafter = doafter;
	}

	public String getDoafter() {
		return doafter;
	}

	public void setDobefore(String dobefore) {
		this.dobefore = dobefore;
	}

	public String getDobefore() {
		return dobefore;
	}

	public String getTheme() {
		return "simple";
	}

	@Override
	public String getTemplateDir() {
		return "template/ajaxupload";
	}
}
