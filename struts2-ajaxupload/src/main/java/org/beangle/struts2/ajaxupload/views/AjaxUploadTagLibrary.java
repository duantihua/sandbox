package org.beangle.struts2.ajaxupload.views;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.TagLibrary;

import com.opensymphony.xwork2.util.ValueStack;

public class AjaxUploadTagLibrary implements TagLibrary {

	public Object getFreemarkerModels(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new AjaxUploadModels(stack, req, res);
	}

	public List<Class> getVelocityDirectiveClasses() {
		return null;
	}

}
