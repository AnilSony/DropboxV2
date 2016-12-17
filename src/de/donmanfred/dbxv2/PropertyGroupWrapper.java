package de.donmanfred.dbxv2;

import java.util.List;

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

@ShortName("PropertyGroup")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class PropertyGroupWrapper extends AbsObjectWrapper<PropertyGroup> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, PropertyGroup meta) {
		this.ba = ba;
		final PropertyGroup _obj = meta;
		setObject(_obj);
	}
	public List<PropertyField> getFields(){
		return getObject().getFields();
	}
	public String getTemplateId(){
		return getObject().getTemplateId();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
