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
package de.sernet.eclipse.hitro.util;

import org.eclipse.emf.ecore.EObject;

import de.sernet.eclipse.hitro.Huientity;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Huipropertygroup;

/**
 * @author uz[at]sernet.de
 *
 */
public class HitroModelUtil {
    /**
     * Create an id for the given object.
     * 
     * @param object
     * @return
     */
    public static String createId(EObject object) {
        HitroSwitch<String> hitroSwitch = new HitroSwitch<String>() {

            @Override
            public String caseHuientity(Huientity object) {
                String name = object.getName();
                return trasformName(name);
            }

            @Override
            public String caseHuipropertygroup(Huipropertygroup object) {
                EObject eContainer = object.eContainer();
                if (eContainer instanceof Huientity) {
                    Huientity he = (Huientity) eContainer;
                    String id = he.getId();
                    return id + "_" + trasformName(object.getName());
                }
                return super.caseHuipropertygroup(object);
            }

            @Override
            public String caseHuiproperty(Huiproperty object) {
                EObject eContainer = object.eContainer();
                if (eContainer instanceof Huientity) {
                    Huientity he = (Huientity) eContainer;
                    String id = he.getId();
                    return id + "_" + trasformName(object.getName());
                } else if (eContainer instanceof Huipropertygroup) {
                    Huipropertygroup hg = (Huipropertygroup) eContainer;
                    String id = hg.getId();
                    return id + "_" + trasformName(object.getName());
                }
                return super.caseHuiproperty(object);
            }
        };

        return hitroSwitch.doSwitch(object);
    }

    protected static String trasformName(String name) {
        return name.toLowerCase().replaceAll(" ", "_");
    }
}
