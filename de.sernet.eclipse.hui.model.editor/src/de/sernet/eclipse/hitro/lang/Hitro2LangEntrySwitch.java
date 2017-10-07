package de.sernet.eclipse.hitro.lang;

import de.sernet.eclipse.hitro.Huientity;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Huipropertygroup;
import de.sernet.eclipse.hitro.Huirelation;
import de.sernet.eclipse.hitro.Option;
import de.sernet.eclipse.hitro.Param;
import de.sernet.eclipse.hitro.util.HitroSwitch;

public class Hitro2LangEntrySwitch extends HitroSwitch<LanguagesEntry> {

	@Override
	public LanguagesEntry caseHuiproperty(Huiproperty object) {
		return new LanguagesEntry(object.getId());
	}

	@Override
	public LanguagesEntry caseHuipropertygroup(Huipropertygroup object) {
		return new LanguagesEntry(object.getId());
	}

	@Override
	public LanguagesEntry caseHuirelation(Huirelation object) {
		return new LanguagesEntry(object.getId());
	}
	
	@Override
	public LanguagesEntry caseHuientity(Huientity object) {
		return new LanguagesEntry(object.getId());
	}
	
	@Override
	public LanguagesEntry caseOption(Option object) {
		return new LanguagesEntry(object.getId());
	}
	
	@Override
	public LanguagesEntry caseParam(Param object) {
		return new LanguagesEntry(object.getId());
	}
}