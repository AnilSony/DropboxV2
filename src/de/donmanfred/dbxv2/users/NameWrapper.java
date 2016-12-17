package de.donmanfred.dbxv2.users;

import com.dropbox.core.v2.users.Name;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("Name")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
//@Events(values={"onSigned(sign As Object)"})

public class NameWrapper extends AbsObjectWrapper<Name> {
	private BA ba;
	private String eventName;

	public void Initialize(final BA ba, String EventName, String givenName, String surname, String familiarName, String displayName, String abbreviatedName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;

		final Name _obj = new Name(givenName, surname, familiarName, displayName, abbreviatedName);
		final String eventName = EventName.toLowerCase(BA.cul);
		setObject(_obj);
	}

  /**
   * Also known as a first name.
   *
   * @return value for this field, never {@code null}.
   */
  public String getGivenName() {
  	return getObject().getGivenName();
  }

  /**
   * Also known as a last name or family name.
   *
   * @return value for this field, never {@code null}.
   */
  public String getSurname() {
  	return getObject().getSurname();
  }

  /**
   * Locale-dependent name. In the US, a person's familiar name is their
   * {@link Name#getGivenName}, but elsewhere, it could be any combination of
   * a person's {@link Name#getGivenName} and {@link Name#getSurname}.
   *
   * @return value for this field, never {@code null}.
   */
  public String getFamiliarName() {
  	return getObject().getFamiliarName();
  }

  /**
   * A name that can be used directly to represent the name of a user's
   * Dropbox account.
   *
   * @return value for this field, never {@code null}.
   */
  public String getDisplayName() {
  	return getObject().getDisplayName();
  }

  /**
   * An abbreviated form of the person's name. Their initials in most locales.
   *
   * @return value for this field, never {@code null}.
   */
  public String getAbbreviatedName() {
  	return getObject().getAbbreviatedName();
  }

  public int hashCode() {
  	return getObject().hashCode();
  }

  public boolean equals(Object obj) {
  	return getObject().equals(obj);
  }

  public String toString() {
  	return getObject().toString();
  }

  /**
   * Returns a String representation of this object formatted for easier
   * readability.
   *
   * <p> The returned String may contain newlines. </p>
   *
   * @return Formatted, multiline String representation of this object
   */
  public String toStringMultiline() {
  	return getObject().toStringMultiline();
  }

		
}
