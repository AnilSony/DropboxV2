package de.donmanfred.dbxv2.sharing;

import java.util.Date;
import java.util.List;

import com.dropbox.core.v2.sharing.AccessLevel;
import com.dropbox.core.v2.sharing.FolderPermission;
import com.dropbox.core.v2.sharing.FolderPolicy;
import com.dropbox.core.v2.sharing.LinkPermissions;
import com.dropbox.core.v2.sharing.MemberSelector;
import com.dropbox.core.v2.sharing.RequestedVisibility;
import com.dropbox.core.v2.sharing.MemberSelector.Tag;
import com.dropbox.core.v2.sharing.SharedFileMetadata;
import com.dropbox.core.v2.sharing.SharedFolderMetadata;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import com.dropbox.core.v2.sharing.SharedLinkSettings;
import com.dropbox.core.v2.sharing.SharedLinkSettings.Builder;
import com.dropbox.core.v2.users.Name;
import com.dropbox.core.v2.users.Team;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("SharedLinkSettings")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class SharedLinkSettingsWrapper extends AbsObjectWrapper<SharedLinkSettings> {
	private BA ba;

	@SuppressWarnings("static-access")
	public void Initialize(final BA ba, String requestedVisibility, String linkPassword, long expires) {
		
		this.ba = ba;
		Date exp = new Date();
		exp.setTime(expires);
		@SuppressWarnings("static-access")
		final SharedLinkSettings _obj = new SharedLinkSettings().newBuilder().withLinkPassword(linkPassword).withExpires(exp).withRequestedVisibility(RequestedVisibility.valueOf(requestedVisibility)).build();
		setObject(_obj);
	}
  public long getExpires() {
  	return getObject().getExpires().getTime();
  }
  public String getLinkPassword() {
  	return getObject().getLinkPassword();
  }
  public String getRequestedVisibility() {
  	return getObject().getRequestedVisibility().toString();
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

  /**
   * Returns a String representation of this object formatted for easier
   * readability.
   *
   * <p> The returned String may contain newlines. </p>
   *
   * @return Formatted, multiline String representation of this object
   */
  public String toStringMultiline() {
  	return getObject().toStringMultiline();
  }

		
}
