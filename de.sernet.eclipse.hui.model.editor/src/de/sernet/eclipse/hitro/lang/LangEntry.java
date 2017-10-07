/**
 * 
 */
package de.sernet.eclipse.hitro.lang;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Holds a single language entry for one language.
 * 
 * @author urszeidler
 *
 */
public class LangEntry {
	private PropertyChangeSupport changeSupport;
	private String lang;
	private String text;
	public LangEntry(String lang) {
		super();
		this.lang = lang;
		changeSupport = new PropertyChangeSupport(this);
	}
	public LangEntry(String lang, String text) {
		this(lang);
		this.text = text;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		String oldText = this.text;
		this.text = text;
		changeSupport.firePropertyChange("text", oldText, text);
	}
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(propertyName, listener);
	}
	public PropertyChangeListener[] getPropertyChangeListeners() {
		return changeSupport.getPropertyChangeListeners();
	}
	public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
		return changeSupport.getPropertyChangeListeners(propertyName);
	}
	public boolean hasListeners(String propertyName) {
		return changeSupport.hasListeners(propertyName);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}
	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(propertyName, listener);
	}

}
