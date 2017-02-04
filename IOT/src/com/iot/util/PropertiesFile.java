package com.iot.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Ritesh Resource Bundle loader to dynamically reload props on changes
 */
public final class PropertiesFile {
  private final String _propsFile;
  public String getPropsFile() {return _propsFile;}
  
  private ResourceBundle _props;
  
  /**
   * ctor
   */
  public PropertiesFile(String propsFile) {
    _propsFile = propsFile;
    _props = ResourceBundle.getBundle(_propsFile);
  }
  
  public String getValue(String key) {
    if (null == key)
      throw new NullPointerException("Key is null!");
    synchronized (_props) {
      return _props.getString(key);
    }
  }
  
  public String getValue(String key, String defaultValue) {
    if (null == key)
      throw new NullPointerException("Key is null!");
    String ret = null;
    synchronized (_props) {
      try {
        ret = _props.getString(key);
        return null == ret ? defaultValue : ret;
      } catch (MissingResourceException mre) {
        return defaultValue;
      }
    }
  }
  
}