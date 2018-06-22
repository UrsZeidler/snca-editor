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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.providers.impl.PropertiesEditingProviderImpl;
import org.eclipse.jface.viewers.IFilter;

import de.sernet.eclipse.hitro.DefaultRule;
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.components.DefaultRulePropertiesEditionComponent;

/**
 * @author Urs Zeidler
 * 
 */
public class DefaultRulePropertiesEditionProvider extends PropertiesEditingProviderImpl {

    /**
     * Constructor without provider for super types.
     */
    public DefaultRulePropertiesEditionProvider() {
        super();
    }

    /**
     * Constructor with providers for super types.
     * 
     * @param superProviders
     *            providers to use for super types.
     */
    public DefaultRulePropertiesEditionProvider(List<PropertiesEditingProvider> superProviders) {
        super(superProviders);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext)
     * 
     */
    public boolean provides(PropertiesEditingContext editingContext) {
        return (editingContext.getEObject() instanceof DefaultRule)
                && (HitroPackage.Literals.DEFAULT_RULE == editingContext.getEObject().eClass());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext,
     *      java.lang.String)
     * 
     */
    public boolean provides(PropertiesEditingContext editingContext, String part) {
        return (editingContext.getEObject() instanceof DefaultRule)
                && (DefaultRulePropertiesEditionComponent.BASE_PART.equals(part));
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext,
     *      java.lang.Class)
     * 
     */
    @SuppressWarnings("rawtypes")
    public boolean provides(PropertiesEditingContext editingContext, java.lang.Class refinement) {
        return (editingContext.getEObject() instanceof DefaultRule)
                && (refinement == DefaultRulePropertiesEditionComponent.class);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext,
     *      java.lang.String, java.lang.Class)
     * 
     */
    @SuppressWarnings("rawtypes")
    public boolean provides(PropertiesEditingContext editingContext, String part,
            java.lang.Class refinement) {
        return (editingContext.getEObject() instanceof DefaultRule)
                && ((DefaultRulePropertiesEditionComponent.BASE_PART.equals(part)
                        && refinement == DefaultRulePropertiesEditionComponent.class));
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext,
     *      java.lang.String)
     * 
     */
    public IPropertiesEditionComponent getPropertiesEditingComponent(
            PropertiesEditingContext editingContext, String mode) {
        if (editingContext.getEObject() instanceof DefaultRule) {
            return new DefaultRulePropertiesEditionComponent(editingContext,
                    editingContext.getEObject(), mode);
        }
        return super.getPropertiesEditingComponent(editingContext, mode);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext,
     *      java.lang.String, java.lang.String)
     * 
     */
    public IPropertiesEditionComponent getPropertiesEditingComponent(
            PropertiesEditingContext editingContext, String mode, String part) {
        if (editingContext.getEObject() instanceof DefaultRule) {
            if (DefaultRulePropertiesEditionComponent.BASE_PART.equals(part))
                return new DefaultRulePropertiesEditionComponent(editingContext,
                        editingContext.getEObject(), mode);
        }
        return super.getPropertiesEditingComponent(editingContext, mode, part);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext,
     *      java.lang.String, java.lang.String, java.lang.Class)
     */
    @SuppressWarnings("rawtypes")
    public IPropertiesEditionComponent getPropertiesEditingComponent(
            PropertiesEditingContext editingContext, String mode, String part,
            java.lang.Class refinement) {
        if (editingContext.getEObject() instanceof DefaultRule) {
            if (DefaultRulePropertiesEditionComponent.BASE_PART.equals(part)
                    && refinement == DefaultRulePropertiesEditionComponent.class)
                return new DefaultRulePropertiesEditionComponent(editingContext,
                        editingContext.getEObject(), mode);
        }
        return super.getPropertiesEditingComponent(editingContext, mode, part, refinement);
    }

    /**
     * Provides the filter used by the plugin.xml to assign part forms.
     */
    public static class EditionFilter implements IFilter {

        /**
         * {@inheritDoc}
         * 
         * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
         */
        public boolean select(Object toTest) {
            EObject eObj = EEFUtils.resolveSemanticObject(toTest);
            return eObj != null && HitroPackage.Literals.DEFAULT_RULE == eObj.eClass();
        }

    }

}
