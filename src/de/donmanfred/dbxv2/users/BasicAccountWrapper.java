package de.donmanfred.dbxv2.users;

import com.dropbox.core.v2.users.Account;
import com.dropbox.core.v2.users.BasicAccount;
import com.dropbox.core.v2.users.Name;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("BasicAccount")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class BasicAccountWrapper extends AbsObjectWrapper<BasicAccount> {
	private BA ba;
	private String eventName;

	public void Initialize(final BA ba, BasicAccount usage) {
		this.ba = ba;
		final BasicAccount _obj = usage;
		setObject(_obj);
	}

  /**
   * Whether this user is a teammate of the current user. If this account is
   * the current user's account, then this will be {@code true}.
   *
   * @return value for this field.
   */
	public boolean getIsTeammate(){
		return getObject().getIsTeammate();
	}
  /**
   * The user's unique team member id. This field will only be present if the
   * user is part of a team and {@link BasicAccount#getIsTeammate} is {@code
   * true}.
   *
   * @return value for this field, or {@code null} if not present.
   */
	public String getTeamMemberId(){
		return getObject().getTeamMemberId();
	}
  /**
   * URL for the photo representing the user, if one is set.
   *
   * @return value for this field, or {@code null} if not present.
   */
	public String getProfilePhotoUrl(){
		return getObject().getProfilePhotoUrl();
	}
  /**
   * Details of a user's name.
   *
   * @return value for this field, never {@code null}.
   */
	public Name getName(){
		return getObject().getName();
	}
  /**
   * Whether the user has verified their e-mail address.
   *
   * @return value for this field.
   */
	public boolean getEmailVerified(){
		return getObject().getEmailVerified();
	}
	/**
   * Whether the user has been disabled.
   *
   * @return value for this field.
   */
	public boolean getDisabled(){
		return getObject().getDisabled();
	}
	/**
   * The user's unique Dropbox ID.
   *
   * @return value for this field, never {@code null}.
   */
	public String getAccountId(){
		return getObject().getAccountId();
	}
  /**
   * The user's e-mail address. Do not rely on this without checking the
   * {@link Account#getEmailVerified} field. Even then, it's possible that the
   * user has since lost access to their e-mail.
   *
   * @return value for this field, never {@code null}.
   */
	public String getEmail(){
		return getObject().getEmail();
	}

	
		
}
