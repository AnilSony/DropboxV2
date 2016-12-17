package de.donmanfred.dbxv2;

import java.util.List;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.auth.DbxUserAuthRequests;
import com.dropbox.core.v2.files.Dimensions;
import com.dropbox.core.v2.files.GpsCoordinates;
import com.dropbox.core.v2.files.MediaInfo;
import com.dropbox.core.v2.files.MediaInfo.Tag;
import com.dropbox.core.v2.files.MediaMetadata;
import com.dropbox.core.v2.properties.PropertyField;
import com.dropbox.core.v2.properties.PropertyGroup;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("DbxUserAuthRequests")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class DbxUserAuthRequestsWrapper extends AbsObjectWrapper<DbxUserAuthRequests> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, DbxUserAuthRequests meta) {
		this.ba = ba;
		final DbxUserAuthRequests _obj = meta;
		setObject(_obj);
	}
	public void tokenRevoke(){
		try {
			getObject().tokenRevoke();
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String toString(){
		return getObject().toString();
	}
		
}
