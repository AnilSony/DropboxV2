package de.donmanfred.dbxv2.files;

import com.dropbox.core.v2.files.LookupError;
import com.dropbox.core.v2.files.RelocationBatchError;
import com.dropbox.core.v2.files.WriteError;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("RelocationBatchError")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class RelocationBatchErrorWrapper extends AbsObjectWrapper<RelocationBatchError> {
	private BA ba;
	private String eventName;

	public void Initialize(final BA ba, RelocationBatchError error) {
		this.ba = ba;
		final RelocationBatchError _obj = error;
		setObject(_obj);
	}
	public LookupError getFromPath(){
		return getObject().getFromLookupValue();
	}
	public WriteError getUsed(){
		return getObject().getFromWriteValue();
	}
	public WriteError getToValue(){
		return getObject().getToValue();
	}
	public boolean isCantCopySharedFolder(){
		return getObject().isCantCopySharedFolder();
	}
	public boolean isCantMoveFolderIntoItself(){
		return getObject().isCantMoveFolderIntoItself();
	}
	public boolean isCantNestSharedFolder(){
		return getObject().isCantNestSharedFolder();
	}
	public boolean isDuplicatedOrNestedPaths(){
		return getObject().isDuplicatedOrNestedPaths();
	}
	public boolean isFromLookup(){
		return getObject().isFromLookup();
	}
	public boolean isFromWrite(){
		return getObject().isFromWrite();
	}
	public boolean isOther(){
		return getObject().isOther();
	}
	public boolean isTo(){
		return getObject().isTo();
	}
	public boolean isTooManyFiles(){
		return getObject().isTooManyFiles();
	}
	public boolean isTooManyWriteOperations(){
		return getObject().isTooManyWriteOperations();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
