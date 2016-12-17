package de.donmanfred.dbxv2.users;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.users.BasicAccount;
import com.dropbox.core.v2.users.DbxUserUsersRequests;
import com.dropbox.core.v2.users.FullAccount;
import com.dropbox.core.v2.users.SpaceUsage;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;

@ShortName("DbxUserUsersRequests")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={
		"getAccount(account As BasicAccount)",
		"getCurrentAccount(account As FullAccount)",
		"getAccountBatch(batch As List)",
		"getSpaceUsage(usage As SpaceUsage)"
		
})

/**
 * DONE! :D
 */
public class DbxUserUsersRequestsWrapper extends AbsObjectWrapper<DbxUserUsersRequests> {
	private BA ba;
	private String eventName;

	@Hide
	public void Initialize(final BA ba, String EventName, DbxRawClientV2 client) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;

		final DbxUserUsersRequests _obj = new DbxUserUsersRequests(client);
		final String eventName = EventName.toLowerCase(BA.cul);
		setObject(_obj);
	}
	public void setEventname(final BA ba, final String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
	}
	
	public void Account(final String accountId){		
		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("getAccount()");
      	BasicAccount acc;
				try {
					acc = getObject().getAccount(accountId);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_getaccount", true, new Object[] {AbsObjectWrapper.ConvertToWrapper(new BasicAccountWrapper(), acc)});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();

	}
	public void AccountBatch(final java.util.List<String> accountIds){		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("getAccountBatch()");
      	List acclist = new List();
      	acclist.Initialize();
      	java.util.List<BasicAccount> accounts;
				try {
					accounts = getObject().getAccountBatch(accountIds);
	      	for (BasicAccount acc : accounts) {
	      		acclist.Add(AbsObjectWrapper.ConvertToWrapper(new BasicAccountWrapper(), acc));
	      	}
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_getaccountbatch", true, new Object[] {acclist});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();
	}
	
	public void CurrentAccount(){		
		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("getCurrentAccount()");
      	FullAccount acc;
				try {
					acc = getObject().getCurrentAccount();
					
					ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_getcurrentaccount", true, new Object[] {AbsObjectWrapper.ConvertToWrapper(new FullAccountWrapper(), getObject().getCurrentAccount())});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();
	}
	public void getSpaceUsage(){		
		
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("getSpaceUsage()");
      	SpaceUsage usage;
				try {
					usage = getObject().getSpaceUsage();
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_getspaceusage", true, new Object[] {AbsObjectWrapper.ConvertToWrapper(new SpaceUsageWrapper(), usage)});
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();
	}

	
		
}
