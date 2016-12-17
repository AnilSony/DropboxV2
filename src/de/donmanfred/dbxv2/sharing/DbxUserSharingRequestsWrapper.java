package de.donmanfred.dbxv2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.SearchMatch;
import com.dropbox.core.v2.sharing.AclUpdatePolicy;
import com.dropbox.core.v2.sharing.CreateSharedLinkWithSettingsErrorException;
import com.dropbox.core.v2.sharing.DbxUserSharingRequests;
import com.dropbox.core.v2.sharing.FileAction;
import com.dropbox.core.v2.sharing.FileMemberActionResult;
import com.dropbox.core.v2.sharing.FolderAction;
import com.dropbox.core.v2.sharing.GetSharedLinksResult;
import com.dropbox.core.v2.sharing.ListFilesResult;
import com.dropbox.core.v2.sharing.ListFoldersResult;
import com.dropbox.core.v2.sharing.ListSharedLinksResult;
import com.dropbox.core.v2.sharing.MemberPolicy;
import com.dropbox.core.v2.sharing.MemberSelector;
import com.dropbox.core.v2.sharing.ShareFolderErrorException;
import com.dropbox.core.v2.sharing.ShareFolderLaunch;
import com.dropbox.core.v2.sharing.SharedFileMetadata;
import com.dropbox.core.v2.sharing.SharedFolderMetadata;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import com.dropbox.core.v2.sharing.SharedLinkPolicy;
import com.dropbox.core.v2.sharing.SharedLinkSettings;

import de.donmanfred.dbxv2.files.MetadataWrapper;
import de.donmanfred.dbxv2.users.FullAccountWrapper;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;

@ShortName("DbxUserSharingRequests")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})


@Events(values={
		"SharedFolderMetadata(success As boolean, meta As SharedFolderMetadata, error As String)",
		"SharedFolder(success As boolean, info As Map, info As String)",
		"AddFileMember(success As boolean, members As List, error As String)",
		"listSharedLinks(success As boolean, sharedLinks As List, error As String)",
		"listReceivedFiles(success As boolean, receivedFiles As List, error As String)",
		"listFolders(success As boolean, folders As List, error As String)",
		"listMountableFolders(success As boolean, folders As List, error As String)"
})

public class DbxUserSharingRequestsWrapper extends AbsObjectWrapper<DbxUserSharingRequests> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, String EventName, DbxRawClientV2 client) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;

		final DbxUserSharingRequests _obj = new DbxUserSharingRequests(client);
		final String eventName = EventName.toLowerCase(BA.cul);
		setObject(_obj);

		// Missing
		//getObject().addFolderMember(sharedFolderId, members);
		//getObject().addFolderMemberBuilder(sharedFolderId, members)
		//getObject().changeFileMemberAccess(file, member, accessLevel)
		//getObject().checkJobStatus(asyncJobId)
		//getObject().checkRemoveMemberJobStatus(asyncJobId)
		//getObject().checkShareJobStatus(asyncJobId)
		//getObject().createSharedLink(path)
		//getObject().createSharedLinkBuilder(path)
		
		
		//getObject().getFileMetadata(file)
		//getObject().getFileMetadata(file, actions)
		//getObject().getFileMetadataBatch(files)
		//getObject().getFileMetadataBatch(files, actions)
		//getObject().getFolderMetadata(sharedFolderId)
		//getObject().getFolderMetadata(sharedFolderId, actions)
		//getObject().getSharedLinkFile(url)
		//getObject().getSharedLinkFileBuilder(url)
		//getObject().getSharedLinkMetadata(url)
		//getObject().getSharedLinkMetadataBuilder(url)
		//getObject().getSharedLinks(path)
		//getObject().listFileMembers(file)
		//getObject().listFileMembersBatch(files)
		//getObject().listFileMembersBatch(files, limit)
		//getObject().listFileMembersBuilder(file)
		//getObject().listFileMembersContinue(cursor)
		//getObject().listFolderMembers(sharedFolderId)
		//getObject().listFolderMembersBuilder(sharedFolderId)
		//getObject().listFolderMembersContinue(cursor)
		//getObject().modifySharedLinkSettings(url, settings)
		//getObject().modifySharedLinkSettings(url, settings, removeExpiration)
		//getObject().mountFolder(sharedFolderId)
		//getObject().relinquishFileMembership(file);
		//getObject().relinquishFolderMembership(sharedFolderId)
		//getObject().relinquishFolderMembership(sharedFolderId, leaveACopy)
		//getObject().removeFileMember(file, member)
		//getObject().removeFileMember2(file, member)
		//getObject().removeFolderMember(sharedFolderId, member, leaveACopy)
		//getObject().revokeSharedLink(url);
		//getObject().transferFolder(sharedFolderId, toDropboxId);
		//getObject().unmountFolder(sharedFolderId);
		//getObject().unshareFile(file);
		//getObject().unshareFolder(sharedFolderId)
		//getObject().updateFolderMember(sharedFolderId, member, accessLevel)
		//getObject().unshareFolder(sharedFolderId, leaveACopy)
	}
	public void createSharedLinkWithSettings(final String path, final SharedLinkSettings settings){		
		new Thread(new Runnable() {
      private SharedLinkMetadata result;

			@Override
      public void run() {
      	ba.Log("createSharedLinkWithSettings()");
      	try {
					result = getObject().createSharedLinkWithSettings(path, settings);
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_CreateShareLink", true, new Object[] {AbsObjectWrapper.ConvertToWrapper(new SharedLinkMetadataWrapper(), result)});
      	} catch (CreateSharedLinkWithSettingsErrorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	public void setEventname(final BA ba, final String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
	}
	
	public void dummy(){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	//result = getObject();
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	public void shareFolder(final String path, final AclUpdatePolicy aclUpdatePolicy, final MemberPolicy memberPolicy, final SharedLinkPolicy sharedLinkPolicy, final boolean forceAsync){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	try {
					ShareFolderLaunch result = getObject().shareFolderBuilder(path).withAclUpdatePolicy(aclUpdatePolicy).withMemberPolicy(memberPolicy).withSharedLinkPolicy(sharedLinkPolicy).withForceAsync(forceAsync).start();
					Map m = new Map();
					m.Initialize();
					m.Put("AsyncJobId", result.getAsyncJobIdValue());
					m.Put("isAsyncJobId", result.isAsyncJobId());
					m.Put("isComplete", result.isComplete());
					m.Put("Tag", result.tag());
					m.Put("path", path);
					if (result.isComplete()){
						m.Put("meta", result.getCompleteValue());						
					}
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_sharefolder", true, new Object[] {true,m,"sharefolder"});
					
				} catch (ShareFolderErrorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	public void updateFolderPolicy(final String sharedFolderId, final AclUpdatePolicy aclPolicy,final MemberPolicy memberPolicy, final SharedLinkPolicy sharedLinkPolicy){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("dummy()");
      	try {
					SharedFolderMetadata meta = getObject().updateFolderPolicyBuilder(sharedFolderId).withAclUpdatePolicy(aclPolicy).withMemberPolicy(memberPolicy).withSharedLinkPolicy(sharedLinkPolicy).start();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_sharedfoldermetadata", true, new Object[] {true,AbsObjectWrapper.ConvertToWrapper(new SharedFolderMetadataWrapper(), meta),"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_sharedfoldermetadata", true, new Object[] {true,null,e.getMessage()});
				}
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}

	public void listMountableFolders(){		
		//getObject().listMountableFolders()
		//getObject().listMountableFoldersBuilder()
		//getObject().listMountableFoldersContinue(cursor)

		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("listSharedLinks()");
				List l = new List();
    		l.Initialize();
      	try {
					ListFoldersResult result = getObject().listMountableFolders();
					for (SharedFolderMetadata metadata : result.getEntries()) {
						l.Add(AbsObjectWrapper.ConvertToWrapper(new SharedFolderMetadataWrapper(), metadata));
					}
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listmountablefolders", true, new Object[] {true,l,"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listmountablefolders", true, new Object[] {false,l,e.getMessage()});
				}
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}

	public void listFolders(){		
		//getObject().listFolders()
		//getObject().listFoldersBuilder()
		//getObject().listFoldersContinue(cursor)
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("sharing:listFolders()");
				List l = new List();
    		l.Initialize();
      	ListFoldersResult result;
      	try {
					result = getObject().listFoldersBuilder().start();
					for (SharedFolderMetadata metadata : result.getEntries()) {
						l.Add(metadata);
					}
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listfolders", true, new Object[] {true,l,"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();
	}

	public void listReceivedFiles(final java.util.List<FileAction> actions, final long limit){		
		//getObject().listReceivedFilesBuilder()
		//getObject().listReceivedFilesContinue(cursor)

		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("listReceivedFiles()");
				List l = new List();
    		l.Initialize();
      	try {
					ListFilesResult result = getObject().listReceivedFilesBuilder().withActions(actions).withLimit(limit).start();
					for (SharedFileMetadata metadata : result.getEntries()) {
						l.Add(metadata);
					}
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listreceivedfiles", true, new Object[] {true,l,"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listreceivedfiles", true, new Object[] {false,l,e.getMessage()});
				}
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}

	public void listSharedLinks(final String path, final boolean directOnly){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("listSharedLinks()");
				List l = new List();
    		l.Initialize();
      	try {
					ListSharedLinksResult result = getObject().listSharedLinksBuilder().withPath(path).withDirectOnly(directOnly).start();
	      	while (true) {
	      		for (SharedLinkMetadata metadata : result.getLinks()) {
	      			l.Add(metadata);
	      		}
	      		if (!result.getHasMore()) {
	      			break;
	      		}
	        	ba.Log("listSharedLinksContinue("+result.getCursor()+")");
	      		result = getObject().listSharedLinksBuilder().withCursor(result.getCursor()).start();
	      	}
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listsharedlinks", true, new Object[] {true,l,"OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_listsharedlinks", true, new Object[] {false,l,e.getMessage()});
				}
      	//ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_dummy", true, new Object[] {result});
      }
		}).start();
	}
	
	public void addFileMember(final String file, final java.util.List<MemberSelector> members){		
		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("getAccount()");
      	java.util.List<FileMemberActionResult> acc;
				try {
					 
					acc = getObject().addFileMemberBuilder(file, members).start();
					List l = new List();
					l.Initialize();
					for (FileMemberActionResult match: acc){
						Map m = new Map();
						m.Initialize();
						m.Put("MemberSelector",  match.getMember() );
						m.Put("isMemberError", match.getResult().isMemberError());
						m.Put("isSuccess", match.getResult().isSuccess());
						m.Put("MemberErrorValue", match.getResult().getMemberErrorValue().toString());
						m.Put("SuccessAccessLevel", match.getResult().success().getSuccessValue().toString());
						l.Add(m);
					}					
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_addfilemember", true, new Object[] {true, l, "OK"});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();

	}

	
		
}
