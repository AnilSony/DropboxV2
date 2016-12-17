package de.donmanfred.dbxv2.files;

import com.dropbox.core.v2.files.FolderSharingInfo;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("FolderSharingInfo")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class FolderSharingInfoWrapper extends AbsObjectWrapper<FolderSharingInfo> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, FolderSharingInfo meta) {
		this.ba = ba;
		final FolderSharingInfo _obj = meta;
		setObject(_obj);
	}
	public String getParentSharedFolderId(){
		return getObject().getParentSharedFolderId();
	}
	public boolean getNoAccess(){
		return getObject().getNoAccess();
	}
	public boolean getReadOnly(){
		return getObject().getReadOnly();
	}
	public String getSharedFolderId(){
		return getObject().getSharedFolderId();
	}
	public boolean getTraverseOnly(){
		return getObject().getTraverseOnly();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
