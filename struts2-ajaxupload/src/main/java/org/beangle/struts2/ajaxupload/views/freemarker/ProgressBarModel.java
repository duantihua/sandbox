package org.beangle.struts2.ajaxupload.views.freemarker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.freemarker.tags.TagModel;
import org.beangle.struts2.ajaxupload.components.ProgressBar;

import com.opensymphony.xwork2.util.ValueStack;

public class ProgressBarModel extends TagModel{

	public ProgressBarModel(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		super(stack, req, res);
	}

	@Override
	protected Component getBean() {
		return new ProgressBar(stack,req,res);
	}
}
