/**
 * 
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
 */
package de.sernet.eclipse.hitro.providers;

import de.sernet.eclipse.hitro.parts.HitroViewsRepository;

import de.sernet.eclipse.hitro.parts.forms.DefaultRulePropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.DependsPropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.DocumentRootPropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.HuientitiesPropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.HuientityPropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.HuipropertyPropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.HuipropertygroupPropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.HuirelationPropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.OptionPropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.ParamPropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.ReferencePropertiesEditionPartForm;
import de.sernet.eclipse.hitro.parts.forms.ValidationRulePropertiesEditionPartForm;

import de.sernet.eclipse.hitro.parts.impl.DefaultRulePropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.DependsPropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.DocumentRootPropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.HuientitiesPropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.HuientityPropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.HuipropertyPropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.HuipropertygroupPropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.HuirelationPropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.OptionPropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.ParamPropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.ReferencePropertiesEditionPartImpl;
import de.sernet.eclipse.hitro.parts.impl.ValidationRulePropertiesEditionPartImpl;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

/**
 * @author Urs Zeidler
 * 
 */
public class HitroPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
     * 
     */
    public boolean provides(Object key) {
        return key == HitroViewsRepository.class;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object,
     *      int,
     *      org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
     * 
     */
    public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind,
            IPropertiesEditionComponent component) {
        if (key == HitroViewsRepository.DefaultRule.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new DefaultRulePropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new DefaultRulePropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.Depends.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new DependsPropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new DependsPropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.DocumentRoot.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new DocumentRootPropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new DocumentRootPropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.Huientities.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new HuientitiesPropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new HuientitiesPropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.Huientity.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new HuientityPropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new HuientityPropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.Huiproperty.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new HuipropertyPropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new HuipropertyPropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.Huipropertygroup.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new HuipropertygroupPropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new HuipropertygroupPropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.Huirelation.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new HuirelationPropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new HuirelationPropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.Option.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new OptionPropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new OptionPropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.Param.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new ParamPropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new ParamPropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.Reference.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new ReferencePropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new ReferencePropertiesEditionPartForm(component);
        }
        if (key == HitroViewsRepository.ValidationRule.class) {
            if (kind == HitroViewsRepository.SWT_KIND)
                return new ValidationRulePropertiesEditionPartImpl(component);
            if (kind == HitroViewsRepository.FORM_KIND)
                return new ValidationRulePropertiesEditionPartForm(component);
        }
        return null;
    }

}
