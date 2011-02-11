/* Copyright c 2005-2012.
 * Licensed under GNU  LESSER General Public License, Version 3.
 * http://www.gnu.org/licenses
 */
package org.beangle.packagekit.wagon;

public class WagonException extends RuntimeException {

	private static final long serialVersionUID = -8844123628638795912L;

	public WagonException() {
		super();
	}

	public WagonException(String message) {
		super(message);
	}

	public WagonException(String message, Throwable cause) {
		super(message, cause);
	}

}
