package de.donmanfred.dbxv2.files;

import java.io.IOException;
import java.io.OutputStream;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.DownloadBuilder;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.RelocationPath;
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

@ShortName("DownloadBuilder")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class DownloadBuilderWrapper extends AbsObjectWrapper<DownloadBuilder> {
	private BA ba;
	private String eventName;

	public void Initialize(final BA ba, DownloadBuilder builder) {
		this.ba = ba;
		final DownloadBuilder _obj = builder;
		setObject(_obj);
	}
	public void download(final OutputStream out){
		new Thread(new Runnable() {
      @Override
      public void run() {
      	ba.Log("download()");
      	FileMetadata meta;
				try {
					meta = getObject().download(out);
	      	ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_downloadfinished", true, new Object[] {true,meta});
				} catch (DbxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      }
		}).start();
	}
	public DownloadBuilderWrapper range(long start){
		getObject().range(start);
		return this;
	}
	public String toString(){
		return getObject().toString();
	}
	public DownloadBuilderWrapper range2(long start, long length){
		getObject().range(start, length);
		return this;
	}

	
		
}
