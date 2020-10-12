/*******************************************************************************
 * Copyright (c) 2018 Urs Zeidler.
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Urs Zeidler uz[at]sernet.de - initial API and implementation
 ******************************************************************************/
package de.sernet.eclipse.hui.model.validation.contrains;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import de.sernet.eclipse.hitro.util.HitroModelUtil;
import de.sernet.eclipse.hui.service.localization.LocalizationService;
import de.sernet.eclipse.hui.service.localization.lang.LangEntry;
import de.sernet.eclipse.hui.service.localization.lang.LanguagesEntry;

/**
 * @author uz[at]sernet.de
 *
 */
public class TestNameLocalized extends AbstractModelConstraint {

    private LocalizationService localizationService;
    public static LocalizationService localizationServiceRuntime;

    /**
     * 
     */
    public TestNameLocalized() {
        super();
        if(PlatformUI.isWorkbenchRunning()) {
        IWorkbench workbench = PlatformUI.getWorkbench();
        localizationService = workbench.getService(LocalizationService.class);
        } else {
            localizationService = localizationServiceRuntime;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.
     * emf.validation.IValidationContext)
     */
    @Override
    public IStatus validate(IValidationContext ctx) {
        EObject target = ctx.getTarget();
        Resource eResource = target.eResource();

        Map<EObject, LanguagesEntry> languageEntries = localizationService
                .getLanguageEntries(eResource);
        if (languageEntries != null) {
            LanguagesEntry languagesEntry = languageEntries.get(target);
            List<LangEntry> entries = languagesEntry.getEntries();
            String result = validateEntries(entries);
            if (result != null && !result.isEmpty()) {
                return ctx.createFailureStatus(HitroModelUtil.getIdSwitch().doSwitch(target), result);
            }
        }
        return null;
    }

    private String validateEntries(List<LangEntry> entries) {
        return entries.stream().filter(e->e.getSuffix()==null || e.getSuffix().isEmpty())//
        		.filter(e -> e.getText() == null || e.getText().isEmpty())//
                .map( TestNameLocalized::getLanguageName).collect(Collectors.joining(","));
    }

	private static String getLanguageName(LangEntry e) {
		switch (e.getLang()) {
		case "":
			return "english";
		case "_de":
			return "german";
		case "_it":
			return "italian";
		default:
			break;
		}
		return "no_name";
	}

}
