package de.donmanfred.dbxv2.users;

import com.dropbox.core.v2.users.IndividualSpaceAllocation;
import com.dropbox.core.v2.users.SpaceAllocation;
import com.dropbox.core.v2.users.SpaceAllocation.Tag;
import com.dropbox.core.v2.users.TeamSpaceAllocation;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("SpaceAllocation")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class SpaceAllocationWrapper extends AbsObjectWrapper<SpaceAllocation> {
	private BA ba;
	private String eventName;

	public void Initialize(final BA ba, SpaceAllocation alloc) {
		this.ba = ba;
		final SpaceAllocation _obj = alloc;
		setObject(_obj);
	}
	public SpaceAllocation getindividual(IndividualSpaceAllocation value){
		getObject();
		return SpaceAllocation.individual(value);
	}
	public SpaceAllocation getteam(TeamSpaceAllocation value){
		getObject();
		return SpaceAllocation.team(value);
	}
	public SpaceAllocation getOTHER(){
		return getObject().OTHER;
	}
	public Tag getTag(){
		return getObject().tag();
	}
	public boolean isOther(){
		return getObject().isOther();
	}
	public boolean isTeam(){
		return getObject().isTeam();
	}
	public boolean isIndividual(){
		return getObject().isIndividual();
	}
	public IndividualSpaceAllocation getIndividualValue(){
		return getObject().getIndividualValue();
	}
	public TeamSpaceAllocation getTeamValue(){
		return getObject().getTeamValue();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
