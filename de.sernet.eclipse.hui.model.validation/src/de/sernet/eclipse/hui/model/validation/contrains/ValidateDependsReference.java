/*******************************************************************************
 * Copyright (c) ${year} <Vorname> <Nachname>.
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
 *     <FirstName> <LastName> <Email> - initial API and implementation
 ******************************************************************************/
package de.sernet.eclipse.hui.model.validation.contrains;

import java.util.Optional;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import de.sernet.eclipse.hitro.Depends;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Option;

/**
 * @author urszeidler
 *
 */
public class ValidateDependsReference extends AbstractModelConstraint {

    /**
     * 
     */
    public ValidateDependsReference() {
        // TODO Auto-generated constructor stub
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
        if (target instanceof Depends) {
            Depends depens = (Depends) target;
            String value = depens.getValue();
            Huiproperty property = depens.getOption();
            switch (property.getInputtype()) {
            case NUMERICOPTION:
            case MULTIOPTION:
            case SINGLEOPTION:

                if (!property.getOption().stream().filter(o -> value.equals(o.getId())).findAny()
                        .isPresent()) {
                    return ctx.createFailureStatus(property, value);
                }
                break;

            default:
                break;
            }
        }
        return null;
    }

}
