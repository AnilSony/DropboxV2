package de.donmanfred.dbxv2.files;

import com.dropbox.core.v2.files.GpsCoordinates;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("GpsCoordinates")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class GpsCoordinatesWrapper extends AbsObjectWrapper<GpsCoordinates> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, GpsCoordinates meta) {
		this.ba = ba;
		final GpsCoordinates _obj = meta;
		setObject(_obj);
	}
	public double getLatitude(){
		return getObject().getLatitude();
	}
	public double getLongitude(){
		return getObject().getLongitude();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
