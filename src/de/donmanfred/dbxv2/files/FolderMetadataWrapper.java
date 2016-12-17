package de.donmanfred.dbxv2.files;

import java.util.List;

import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FileSharingInfo;
import com.dropbox.core.v2.files.FolderMetadata;
import com.dropbox.core.v2.files.FolderSharingInfo;
import com.dropbox.core.v2.files.MediaInfo;
import com.dropbox.core.v2.properties.PropertyGroup;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("FolderMetadata")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class FolderMetadataWrapper extends AbsObjectWrapper<FolderMetadata> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, FolderMetadata meta) {
		this.ba = ba;
		final FolderMetadata _obj = meta;
		setObject(_obj);
	}
	public String getParentSharedFolderId(){
		return getObject().getParentSharedFolderId();
	}
	public FolderSharingInfo getSharingInfo(){
		return getObject().getSharingInfo();
	}
	public String getName(){
		return getObject().getName();
	}
	public String getPathLower(){
		return getObject().getPathLower();
	}
	public String getPathDisplay(){
		return getObject().getPathDisplay();
	}
	public List<PropertyGroup> getPropertyGroups(){
		return getObject().getPropertyGroups();
	}
	public String getId(){
		return getObject().getId();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
