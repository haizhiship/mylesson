package ch10.convert;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;

public class ListTypeEditSupport extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] aNames = text.split(",");
		setValue(Arrays.asList(aNames));
	}

	@Override
	public String getAsText() {
		return getValue().toString();
	}

}
