package de.donmanfred.dbxv2;

import com.dropbox.core.DbxHost;
import com.dropbox.core.v2.properties.PropertyField;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("DbxHost")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class DbxHostWrapper extends AbsObjectWrapper<DbxHost> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize2(final BA ba, String api, String content, String web, String notify) {
		this.ba = ba;
		final DbxHost _obj = new DbxHost(api,content,web,notify);
		setObject(_obj);
	}
	public void Initialize(final BA ba) {
		this.ba = ba;
		final DbxHost _obj = DbxHost.DEFAULT;
		setObject(_obj);
	}
	public String getContent(){
		return getObject().getContent();
	}
	public String getNotify(){
		return getObject().getNotify();
	}
	public String getWeb(){
		return getObject().getWeb();
	}
	public String toString(){
		return getObject().toString();
	}

	
		
}
