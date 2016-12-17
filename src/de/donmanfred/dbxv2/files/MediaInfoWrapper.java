package de.donmanfred.dbxv2.files;

import java.util.List;

import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FileSharingInfo;
import com.dropbox.core.v2.files.MediaInfo;
import com.dropbox.core.v2.files.MediaInfo.Tag;
import com.dropbox.core.v2.files.MediaMetadata;
import com.dropbox.core.v2.properties.PropertyGroup;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("MediaInfo")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class MediaInfoWrapper extends AbsObjectWrapper<MediaInfo> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, MediaInfo meta) {
		this.ba = ba;
		final MediaInfo _obj = meta;
		setObject(_obj);
	}
	public MediaMetadata getMetadataValue(){
		return getObject().getMetadataValue();
	}
	public Tag gettag(){
		return getObject().tag();
	}
	public boolean isPending(){
		return getObject().isPending();
	}
	public boolean isMetadata(){
		return getObject().isMetadata();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
