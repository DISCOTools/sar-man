package org.sarman.common.i18n;

/**
 * Interface to represent the constants contained in resource bundle:
 * 	'/home/kennethg/src/eclipse/workspace/sarm-lib/src/org/sarman/common/i18n/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Constants {
  
  /**
   * Translated "Password".
   * 
   * @return translated "Password"
   */
  @DefaultStringValue("Password")
  @Key("Password")
  String Password();

  /**
   * Translated "Sign In".
   * 
   * @return translated "Sign In"
   */
  @DefaultStringValue("Sign In")
  @Key("SignIn")
  String SignIn();

  /**
   * Translated "Stay signed in".
   * 
   * @return translated "Stay signed in"
   */
  @DefaultStringValue("Stay signed in")
  @Key("StayIn")
  String StayIn();

  /**
   * Translated "sar-man".
   * 
   * @return translated "sar-man"
   */
  @DefaultStringValue("sar-man")
  @Key("Title")
  String Title();

  /**
   * Translated "Username".
   * 
   * @return translated "Username"
   */
  @DefaultStringValue("Username")
  @Key("Username")
  String Username();
}
