package org.beangle.struts2.ajaxupload.views;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beangle.struts2.ajaxupload.views.freemarker.HeadModel;
import org.beangle.struts2.ajaxupload.views.freemarker.ProgressBarModel;

import com.opensymphony.xwork2.util.ValueStack;

public class AjaxUploadModels {
	private ValueStack stack;
	private HttpServletRequest req;
	private HttpServletResponse res;

	private HeadModel head;

	private ProgressBarModel progressBar;

	public AjaxUploadModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		this.stack = stack;
		this.req = req;
		this.res = res;
	}

	public HeadModel getHead() {
		if (head == null) {
			head = new HeadModel(stack, req, res);
		}
		return head;
	}

	public ProgressBarModel getProgressBar() {
		if (progressBar == null) {
			progressBar = new ProgressBarModel(stack, req, res);
		}
		return progressBar;
	}

}
