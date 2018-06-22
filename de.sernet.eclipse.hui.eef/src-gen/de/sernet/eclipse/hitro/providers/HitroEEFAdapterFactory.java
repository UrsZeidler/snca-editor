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

import org.eclipse.emf.common.notify.Adapter;

import de.sernet.eclipse.hitro.util.HitroAdapterFactory;

/**
 * @author Urs Zeidler
 * 
 */
public class HitroEEFAdapterFactory extends HitroAdapterFactory {

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createDefaultRuleAdapter()
     * 
     */
    public Adapter createDefaultRuleAdapter() {
        return new DefaultRulePropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createDependsAdapter()
     * 
     */
    public Adapter createDependsAdapter() {
        return new DependsPropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createDocumentRootAdapter()
     * 
     */
    public Adapter createDocumentRootAdapter() {
        return new DocumentRootPropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createHuientitiesAdapter()
     * 
     */
    public Adapter createHuientitiesAdapter() {
        return new HuientitiesPropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createHuientityAdapter()
     * 
     */
    public Adapter createHuientityAdapter() {
        return new HuientityPropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createHuipropertyAdapter()
     * 
     */
    public Adapter createHuipropertyAdapter() {
        return new HuipropertyPropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createHuipropertygroupAdapter()
     * 
     */
    public Adapter createHuipropertygroupAdapter() {
        return new HuipropertygroupPropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createHuirelationAdapter()
     * 
     */
    public Adapter createHuirelationAdapter() {
        return new HuirelationPropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createOptionAdapter()
     * 
     */
    public Adapter createOptionAdapter() {
        return new OptionPropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createParamAdapter()
     * 
     */
    public Adapter createParamAdapter() {
        return new ParamPropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createReferenceAdapter()
     * 
     */
    public Adapter createReferenceAdapter() {
        return new ReferencePropertiesEditionProvider();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createValidationRuleAdapter()
     * 
     */
    public Adapter createValidationRuleAdapter() {
        return new ValidationRulePropertiesEditionProvider();
    }

}
