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
package de.sernet.eclipse.hui.service.localization;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.sernet.eclipse.hui.service.localization.lang.HitropPropertiesUtil;
import de.sernet.eclipse.hui.service.localization.lang.LanguagesEntry;

/**
 * @author uz[at]sernet.de
 *
 */
public class LocalizationServiceImpl implements LocalizationService {

    private Map<Resource, Map<EObject, LanguagesEntry>> entries = new HashMap<>();

    public Map<EObject, LanguagesEntry> getLanguageEntries(Resource resource) {
        Map<EObject, LanguagesEntry> map = entries.get(resource);
        if (map == null) {
            map = loadLanguage(resource);
            entries.put(resource, map);
        }
        return map;
    }

    private Map<EObject, LanguagesEntry> loadLanguage(Resource resource) {
        IFile file = HitropPropertiesUtil.getFile(resource);
        String basePath = HitropPropertiesUtil.platformBasePath(file);
        Map<EObject, LanguagesEntry> entryMap = HitropPropertiesUtil.loadPropertyResources(
                resource.getContents(), basePath, HitropPropertiesUtil.TO_WORKSPACE_FILE);

        return entryMap;
    }
}
