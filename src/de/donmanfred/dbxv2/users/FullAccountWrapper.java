package de.donmanfred.dbxv2.users;

import com.dropbox.core.v2.users.Account;
import com.dropbox.core.v2.users.AccountType;
import com.dropbox.core.v2.users.FullAccount;
import com.dropbox.core.v2.users.FullTeam;
import com.dropbox.core.v2.users.Name;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("FullAccount")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class FullAccountWrapper extends AbsObjectWrapper<FullAccount> {
	public void Initialize(final BA ba, FullAccount usage) {
		final FullAccount _obj = usage;
		setObject(_obj);
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
   * Whether the user has been disabled.
   *
   * @return value for this field.
   */
	public boolean getDisabled(){
		return getObject().getDisabled();
	}
  /**
   * Whether the user has a personal and work account. If the current account
   * is personal, then {@link FullAccount#getTeam} will always be {@code
   * null}, but {@link FullAccount#getIsPaired} will indicate if a work
   * account is linked.
   *
   * @return value for this field.
   */
	public boolean getIsPaired(){
		return 	getObject().getIsPaired();				
	}
  /**
   * Whether the user has verified their e-mail address.
   *
   * @return value for this field.
   */
	public boolean getEmailVerified(){
		return 	getObject().getEmailVerified();
	}
  /**
   * The language that the user specified. Locale tags will be <a
   * href="http://en.wikipedia.org/wiki/IETF_language_tag">IETF language
   * tags</a>.
   *
   * @return value for this field, never {@code null}.
   */
	public String getLocale(){
		return 	getObject().getLocale();
	}
  /**
   * Details of a user's name.
   *
   * @return value for this field, never {@code null}.
   */
	public Name getName(){
		return 	getObject().getName();
	}
  /**
   * If this account is a member of a team, information about that team.
   *
   * @return value for this field, or {@code null} if not present.
   */
	public FullTeam getTeam(){
		return 	getObject().getTeam();
	}
  /**
   * URL for the photo representing the user, if one is set.
   *
   * @return value for this field, or {@code null} if not present.
   */
	public String getProfilePhotoUrl(){
		return 	getObject().getProfilePhotoUrl();
	}
  /**
   * The user's <a href="https://www.dropbox.com/referrals">referral link</a>.
   *
   * @return value for this field, never {@code null}.
   */
	public String getReferralLink(){
		return 	getObject().getReferralLink();
	}
  /**
   * The user's e-mail address. Do not rely on this without checking the
   * {@link Account#getEmailVerified} field. Even then, it's possible that the
   * user has since lost access to their e-mail.
   *
   * @return value for this field, never {@code null}.
   */
	public String getEmail(){
		return 	getObject().getEmail();
	}
  /**
   * The user's two-letter country code, if available. Country codes are based
   * on <a href="http://en.wikipedia.org/wiki/ISO_3166-1">ISO 3166-1</a>.
   *
   * @return value for this field, or {@code null} if not present.
   */
	public String getCountry(){
		return getObject().getCountry();
	}
  /**
   * This account's unique team member id. This field will only be present if
   * {@link FullAccount#getTeam} is present.
   *
   * @return value for this field, or {@code null} if not present.
   */
	public String getTeamMemberId(){
		return getObject().getTeamMemberId();
	}
  /**
   * What type of account this user has.
   *
   * @return value for this field, never {@code null}.
   */
	public AccountType getAccountType(){
		return getObject().getAccountType();
	}
	
		
}
