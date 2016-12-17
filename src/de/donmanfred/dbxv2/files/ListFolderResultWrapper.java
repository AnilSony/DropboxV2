package de.donmanfred.dbxv2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;

@ShortName("ListFolderResult")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={"FolderEntries(result As List)"})

public class ListFolderResultWrapper extends AbsObjectWrapper<ListFolderResult> {
	private BA ba;
	private String eventName;

	public void Initialize(final BA ba, String EventName, ListFolderResult result) {
		this.ba = ba;
		this.eventName = EventName.toLowerCase(BA.cul);

		final ListFolderResult _obj = result;
		setObject(_obj);
		
	}
	public void getEntries(){
		new Thread(new Runnable() {
      @Override
      public void run() {
      	BA.Log("getEntries()");
      	List l = new List();
    		l.Initialize();
    		java.util.List<Metadata> entries = getObject().getEntries();
    		for (Metadata meta: entries){
    			l.Add(meta);
    		}
      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_folderentries", true, new Object[] {l});
      }
		}).start();

	}
	public String getCursor(){
		return getObject().getCursor();
	}
	public boolean getHasMore(){
		return getObject().getHasMore();
	}
	
		
}
