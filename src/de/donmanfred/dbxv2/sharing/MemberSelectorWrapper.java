package de.donmanfred.dbxv2.sharing;

import com.dropbox.core.v2.sharing.MemberSelector;
import com.dropbox.core.v2.sharing.MemberSelector.Tag;
import com.dropbox.core.v2.users.Name;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("MemberSelector")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class MemberSelectorWrapper extends AbsObjectWrapper<MemberSelector> {
	private BA ba;

	@SuppressWarnings("static-access")
	public void Initialize(final BA ba, String tag, String dropboxID, String email) {
		this.ba = ba;
		Tag t = Tag.valueOf(tag);
		
		@SuppressWarnings("static-access")
		final MemberSelector _obj = MemberSelector.dropboxId(dropboxID).email(email);
		setObject(_obj);
		getObject().tag().valueOf(tag);
	}
  public String getDropboxId() {
  	return getObject().getDropboxIdValue();
  }
  public String getEmail() {
  	return getObject().getEmailValue();
  }
  public boolean isDropboxId() {
  	return getObject().isDropboxId();
  }
  public boolean isEmail() {
  	return getObject().isEmail();
  }
  public boolean isOther() {
  	return getObject().isOther();
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
