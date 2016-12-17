package de.donmanfred.dbxv2;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.http.OkHttpRequestor;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("DbxRequestConfig")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})
//@DependsOn(values={"com.android.support:support-v4"})

public class DbxRequestConfigWrapper extends AbsObjectWrapper<DbxRequestConfig> {
	private BA ba;
	private String eventName;

	public void Initialize(final BA ba, String EventName, String accessToken, String clientIdentifier, String userLocale, int maxRetries) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
		if (maxRetries > 0) {
			new DbxRequestConfig(accessToken);
			final DbxRequestConfig _obj = DbxRequestConfig.newBuilder(clientIdentifier).withUserLocale(userLocale).withAutoRetryEnabled(maxRetries).build();
			setObject(_obj);
		}else{
			new DbxRequestConfig(accessToken);
			final DbxRequestConfig _obj = DbxRequestConfig.newBuilder(clientIdentifier).withUserLocale(userLocale).withAutoRetryDisabled().withHttpRequestor(OkHttpRequestor.INSTANCE).build();
			setObject(_obj);
		}
		final String eventName = EventName.toLowerCase(BA.cul);
	}
	public String getClientIdentifier(){
		return getObject().getClientIdentifier();
	}
	public HttpRequestor getHttpRequestor(){
		return getObject().getHttpRequestor();
	}
	public int getMaxRetries(){
		return getObject().getMaxRetries();
	}
	public String getUserLocale(){
		return getObject().getUserLocale();
	}
	public boolean isAutoRetryEnabled(){
		return getObject().isAutoRetryEnabled();
	}
	
		
}
