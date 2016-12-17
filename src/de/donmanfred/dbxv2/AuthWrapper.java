package de.donmanfred.dbxv2;

import com.dropbox.core.android.Auth;
import com.dropbox.core.v2.sharing.MemberSelector;
import com.dropbox.core.v2.sharing.MemberSelector.Tag;
import com.dropbox.core.v2.users.Name;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("DbxAuth")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class AuthWrapper extends AbsObjectWrapper<Auth> {
	private BA ba;
	private String key;
	@SuppressWarnings("static-access")
	public void Initialize(final BA ba, String appKey) {
		this.ba = ba;
		this.key = appKey;
		@SuppressWarnings("static-access")
		final Auth _obj = new Auth();
		setObject(_obj);
	}
  public String getOAuth2Token() {
  	return getObject().getOAuth2Token();
  }
  public void startOAuth2Authentication() {
  	getObject();
		Auth.startOAuth2Authentication(ba.context, key);
  }

  public int hashCode() {
  	return getObject().hashCode();
  }

  public boolean equals(Object obj) {
  	return getObject().equals(obj);
  }

  public String toString() {
  	return getObject().toString();
  }
		
}
