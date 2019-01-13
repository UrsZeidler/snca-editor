/*******************************************************************************
 * Copyright (c) 2017 Urs Zeidler.
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
package de.sernet.eclipse.hui.service.localization.lang;

import java.util.List;

import com.google.common.collect.Lists;

import de.sernet.eclipse.hitro.Huientity;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Huipropertygroup;
import de.sernet.eclipse.hitro.Huirelation;
import de.sernet.eclipse.hitro.Option;
import de.sernet.eclipse.hitro.Param;
import de.sernet.eclipse.hitro.util.HitroSwitch;

public class Hitro2LangEntrySuffixesSwitch extends HitroSwitch<List<String>> {

    @Override
    public List<String> caseHuiproperty(Huiproperty object) {
        return Lists.newArrayList("","_tooltip");
    }

    @Override
    public List<String> caseHuipropertygroup(Huipropertygroup object) {
        return Lists.newArrayList("","_doc");
    }

    @Override
    public List<String> caseHuirelation(Huirelation object) {
        return Lists.newArrayList("_name","_revervename","_tooltip");
    }

    @Override
    public List<String> caseHuientity(Huientity object) {
        return Lists.newArrayList("","_doc");
    }

    @Override
    public List<String> caseOption(Option object) {
        return Lists.newArrayList("");
    }

    @Override
    public List<String> caseParam(Param object) {
        return Lists.newArrayList("");
    }
}