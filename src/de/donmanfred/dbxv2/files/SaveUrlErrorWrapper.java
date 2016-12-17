package de.donmanfred.dbxv2.files;

import com.dropbox.core.v2.files.SaveUrlError;
import com.dropbox.core.v2.files.WriteError;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("SaveUrlError")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class SaveUrlErrorWrapper extends AbsObjectWrapper<SaveUrlError> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, SaveUrlError err) {
		this.ba = ba;
		final SaveUrlError _obj = err;
		setObject(_obj);
	}
	public WriteError getFields(){
		return getObject().getPathValue();
	}
	public boolean isDownloadFailed(){
		return getObject().isDownloadFailed();
	}
	public boolean isInvalidUrl(){
		return getObject().isInvalidUrl();
	}
	public boolean isNotFound(){
		return getObject().isNotFound();
	}
	public boolean isOther(){
		return getObject().isOther();
	}
	public boolean isPath(){
		return getObject().isPath();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
