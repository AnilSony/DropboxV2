package de.donmanfred.dbxv2.users;

import com.dropbox.core.v2.users.SpaceAllocation;
import com.dropbox.core.v2.users.SpaceUsage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DesignerProperties;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Pixel;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Property;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.CustomViewWrapper;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;
import anywheresoftware.b4a.objects.collections.Map;

@ShortName("objectname")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class SpaceUsageWrapper extends AbsObjectWrapper<SpaceUsage> {
	private BA ba;
	private String eventName;

	public void Initialize(final BA ba, SpaceUsage usage) {
		this.ba = ba;
		final SpaceUsage _obj = usage;
		setObject(_obj);
	}
	public SpaceAllocation getAllocation(){
		return getObject().getAllocation();
	}
	public long getUsed(){
		return getObject().getUsed();
	}
	public String toString(){
		return getObject().toString();
	}
	public String toStringMultiline(){
		return getObject().toStringMultiline();
	}

	
		
}
