package de.donmanfred.dbxv2.sharing;

import java.util.Date;
import java.util.List;

import com.dropbox.core.v2.sharing.AccessLevel;
import com.dropbox.core.v2.sharing.FolderPermission;
import com.dropbox.core.v2.sharing.FolderPolicy;
import com.dropbox.core.v2.sharing.MemberSelector;
import com.dropbox.core.v2.sharing.MemberSelector.Tag;
import com.dropbox.core.v2.sharing.SharedFileMetadata;
import com.dropbox.core.v2.sharing.SharedFolderMetadata;
import com.dropbox.core.v2.users.Name;
import com.dropbox.core.v2.users.Team;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("SharedFileMetadata")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class SharedFileMetadataWrapper extends AbsObjectWrapper<SharedFileMetadata> {
	private BA ba;

	@SuppressWarnings("static-access")
	public void Initialize(final BA ba, FolderPolicy policy, String name, String id, String previewUrl) {
		this.ba = ba;
		
		@SuppressWarnings("static-access")
		final SharedFileMetadata _obj = new SharedFileMetadata(policy, previewUrl, name, id);
		setObject(_obj);
	}
  public Team getOwnerTeam() {
  	return getObject().getOwnerTeam();
  }
  public String getId() {
  	return getObject().getId();
  }
  public String getName() {
  	return getObject().getName();
  }
  public String getParentSharedFolderId() {
  	return getObject().getParentSharedFolderId();
  }
  public String getPathLower() {
  	return getObject().getPathLower();
  }
  public FolderPolicy getPolicy() {
  	return getObject().getPolicy();
  }
  public String getPreviewUrl() {
  	return getObject().getPreviewUrl();
  }
  public long getTimeInvited() {
  	return getObject().getTimeInvited().getTime();
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
