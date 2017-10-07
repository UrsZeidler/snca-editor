/**
 * 
 */
package de.sernet.eclipse.hitro.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * Hold the {@link LangEntry} for one element.
 * 
 * @author urszeidler
 *
 */
public class LanguagesEntry {
	private String id;
	private List<LangEntry> entries = new ArrayList<LangEntry>(2);
	public LanguagesEntry(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<LangEntry> getEntries() {
		return entries;
	}
	public void setEntries(List<LangEntry> entries) {
		this.entries = entries;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LanguagesEntry other = (LanguagesEntry) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
