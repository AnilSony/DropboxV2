package de.donmanfred.dbxv2.files;

import java.util.List;

import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FileSharingInfo;
import com.dropbox.core.v2.files.MediaInfo;
import com.dropbox.core.v2.properties.PropertyGroup;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("FileMetadata")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class FileMetadataWrapper extends AbsObjectWrapper<FileMetadata> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, FileMetadata meta) {
		this.ba = ba;
		final FileMetadata _obj = meta;
		setObject(_obj);
	}
	public long getClientModified(){
		return getObject().getClientModified().getTime();
	}
	public String getName(){
		return getObject().getName();
	}
	public String getParentSharedFolderId(){
		return getObject().getParentSharedFolderId();
	}
	public MediaInfo getMediaInfo(){
		return getObject().getMediaInfo();
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
	public String getRev(){
		return getObject().getRev();
	}
	public long getServerModified(){
		return getObject().getServerModified().getTime();
	}
	public FileSharingInfo getSharingInfo(){
		return getObject().getSharingInfo();
	}
	public long getSize(){
		return getObject().getSize();
	}
	public String getId(){
		return getObject().getId();
	}
	public Boolean getHasExplicitSharedMembers(){
		return getObject().getHasExplicitSharedMembers();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
