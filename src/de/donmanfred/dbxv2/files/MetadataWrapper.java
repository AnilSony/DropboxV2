package de.donmanfred.dbxv2.files;

import com.dropbox.core.v2.files.Metadata;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("Metadata")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class MetadataWrapper extends AbsObjectWrapper<Metadata> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, Metadata meta) {
		this.ba = ba;
		final Metadata _obj = meta;
		setObject(_obj);
	}
	public String getName(){
		return getObject().getName();
	}
	public String getParentSharedFolderId(){
		return getObject().getParentSharedFolderId();
	}
	public String getPathLower(){
		return getObject().getPathLower();
	}
	public String getPathDisplay(){
		return getObject().getPathDisplay();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
