package de.donmanfred.dbxv2;

import com.dropbox.core.v2.files.ThumbnailFormat;
import com.dropbox.core.v2.files.ThumbnailSize;
import com.dropbox.core.v2.sharing.AccessLevel;
import com.dropbox.core.v2.sharing.AclUpdatePolicy;
import com.dropbox.core.v2.sharing.FolderAction;
import com.dropbox.core.v2.sharing.Visibility;
import com.dropbox.core.v2.users.AccountType;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@Version(0.26f)
@ShortName("DropboxV2")
@Author(value = "DonManfred (wrapper)")
@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})
@DependsOn(values={"dropbox-core-sdk-2.1.2","jackson-core-2.7.4"})

/**
 * com.android.support:support-v4
 * com.android.support:appcompat-v7
 * com.android.support:cardview-v7
 * com.android.support:gridlayout-v7
 * com.android.support:mediarouter-v7
 * com.android.support:palette-v7
 * com.android.support:recyclerview-v
 * com.android.support:preference-v7
 * com.android.support:support-v13
 */

public class DropboxWrapper  {
	private BA ba;
	private String eventName;

	/**
   * The Dropbox library allows you to communicate with Dropbox
   */
  public static void LIBRARY_DOC() {     
  }	
	
	public void Initialize(final BA ba, String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
	}
	
	public ThumbnailSize getThumbnailSize_W1024H768(){
		return ThumbnailSize.W1024H768; 
	}
	public ThumbnailSize getThumbnailSize_W128H128(){
		return ThumbnailSize.W128H128; 
	}
	public ThumbnailSize getThumbnailSize_W32H32(){
		return ThumbnailSize.W32H32; 
	}
	public ThumbnailSize getThumbnailSize_W640H480(){
		return ThumbnailSize.W640H480; 
	}
	public ThumbnailFormat getThumbnailFormat_JPEG(){
		return ThumbnailFormat.JPEG; 
	}
	public ThumbnailFormat getThumbnailFormat_PNG(){
		return ThumbnailFormat.PNG; 
	}
	
	public AccessLevel getAccessLevel_EDITOR(){
		return AccessLevel.EDITOR; 
	}
	public AccessLevel getAccessLevel_OTHER(){
		return AccessLevel.OTHER; 
	}
	public AccessLevel getAccessLevel_OWNER(){
		return AccessLevel.OWNER; 
	}
	public AccessLevel getAccessLevel_VIEWER(){
		return AccessLevel.VIEWER; 
	}
	public AccessLevel getAccessLevel_VIEWER_NO_COMMENT(){
		return AccessLevel.VIEWER_NO_COMMENT; 
	}
		
	public FolderAction getFolderAction_CHANGE_OPTIONS(){
		return FolderAction.CHANGE_OPTIONS; 
	}
	public FolderAction getFolderAction_CREATE_LINK(){
		return FolderAction.CREATE_LINK; 
	}
	public FolderAction getFolderAction_EDIT_CONTENTS(){
		return FolderAction.EDIT_CONTENTS; 
	}
	public FolderAction getFolderAction_INVITE_EDITOR(){
		return FolderAction.INVITE_EDITOR; 
	}
	public FolderAction getFolderAction_INVITE_VIEWER(){
		return FolderAction.INVITE_VIEWER; 
	}
	public FolderAction getFolderAction_INVITE_VIEWER_NO_COMMENT(){
		return FolderAction.INVITE_VIEWER_NO_COMMENT; 
	}
	public FolderAction getFolderAction_LEAVE_A_COPY(){
		return FolderAction.LEAVE_A_COPY; 
	}
	public FolderAction getFolderAction_OTHER(){
		return FolderAction.OTHER; 
	}
	public FolderAction getFolderAction_RELINQUISH_MEMBERSHIP(){
		return FolderAction.RELINQUISH_MEMBERSHIP; 
	}
	public FolderAction getFolderAction_SHARE_LINK(){
		return FolderAction.SHARE_LINK; 
	}
	public FolderAction getFolderAction_UNMOUNT(){
		return FolderAction.UNMOUNT; 
	}
	public FolderAction getFolderAction_UNSHARE(){
		return FolderAction.UNSHARE; 
	}
	
	public AclUpdatePolicy getAclUpdatePolicy_EDITORS(){
		return AclUpdatePolicy.EDITORS; 
	}
	public AclUpdatePolicy getAclUpdatePolicy_OWNER(){
		return AclUpdatePolicy.OWNER; 
	}
	public AclUpdatePolicy getAclUpdatePolicy_OTHER(){
		return AclUpdatePolicy.OTHER; 
	}

	
	public Visibility getVisibility_OTHER(){
		return Visibility.OTHER; 
	}
	public Visibility getVisibility_PASSWORD(){
		return Visibility.PASSWORD; 
	}
	public Visibility getVisibility_PUBLIC(){
		return Visibility.PUBLIC; 
	}
	public Visibility getVisibility_SHARED_FOLDER_ONLY(){
		return Visibility.SHARED_FOLDER_ONLY; 
	}
	public Visibility getVisibility_TEAM_AND_PASSWORD(){
		return Visibility.TEAM_AND_PASSWORD; 
	}
	public Visibility getVisibility_TEAM_ONLY(){
		return Visibility.TEAM_ONLY; 
	}
		
	
	
	public AccountType getAccountType_BASIC(){
		return AccountType.BASIC; 
	}
	public AccountType getAccountType_PRO(){
		return AccountType.PRO; 
	}
	public AccountType getAccountType_BUSINESS(){
		return AccountType.BUSINESS; 
	}
}
