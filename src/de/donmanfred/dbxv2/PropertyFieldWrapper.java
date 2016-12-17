package de.donmanfred.dbxv2;

import com.dropbox.core.v2.properties.PropertyField;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("PropertyField")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class PropertyFieldWrapper extends AbsObjectWrapper<PropertyField> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, PropertyField meta) {
		this.ba = ba;
		final PropertyField _obj = meta;
		setObject(_obj);
	}
	public String getName(){
		return getObject().getName();
	}
	public String getValue(){
		return getObject().getValue();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
