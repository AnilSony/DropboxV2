package de.donmanfred.dbxv2.files;

import com.dropbox.core.v2.files.Dimensions;
import com.dropbox.core.v2.files.GpsCoordinates;
import com.dropbox.core.v2.files.MediaInfo;
import com.dropbox.core.v2.files.MediaInfo.Tag;
import com.dropbox.core.v2.files.MediaMetadata;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("Dimensions")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class DimensionsWrapper extends AbsObjectWrapper<Dimensions> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, Dimensions meta) {
		this.ba = ba;
		final Dimensions _obj = meta;
		setObject(_obj);
	}
	public long getHeight(){
		return getObject().getHeight();
	}
	public long getWidth(){
		return getObject().getWidth();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
