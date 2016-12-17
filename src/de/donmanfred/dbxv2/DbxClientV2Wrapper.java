package de.donmanfred.dbxv2;

import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.auth.DbxUserAuthRequests;
import com.dropbox.core.v2.files.DbxUserFilesRequests;
import com.dropbox.core.v2.sharing.AccessLevel;
import com.dropbox.core.v2.sharing.DbxUserSharingRequests;
import com.dropbox.core.v2.sharing.FolderAction;
import com.dropbox.core.v2.users.DbxUserUsersRequests;
import com.dropbox.core.v2.sharing.AclUpdatePolicy;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("DbxClientV2")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})
//@DependsOn(values={"com.android.support:support-v4"})

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

public class DbxClientV2Wrapper extends AbsObjectWrapper<DbxClientV2> {
	private BA ba;
	private String eventName;

	public void Initialize(final BA ba, String EventName, DbxRequestConfig requestConfig, String accessToken, DbxHost host) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;

		final DbxClientV2 _obj = new DbxClientV2(requestConfig, accessToken, host);
		final String eventName = EventName.toLowerCase(BA.cul);
		setObject(_obj);
	}
	public DbxUserAuthRequests auth(){
		return getObject().auth();
	}
	public DbxUserFilesRequests files(){
		return getObject().files();
	}
	public DbxUserSharingRequests sharing(){
		return getObject().sharing();
	}
	public DbxUserUsersRequests users(){
		return getObject().users();
	}
	
	
}
