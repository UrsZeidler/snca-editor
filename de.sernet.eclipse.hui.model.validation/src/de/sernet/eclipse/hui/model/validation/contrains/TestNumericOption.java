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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import de.sernet.eclipse.hitro.Huiproperty;

/**
 * @author uz[at]sernet.de
 *
 */
public class TestNumericOption extends AbstractModelConstraint {

    /**
     * 
     */
    public TestNumericOption() {
    }

    @Override
    public IStatus validate(IValidationContext ctx) {
        EObject target = ctx.getTarget();
        if (target instanceof Huiproperty) {
            Huiproperty hp = (Huiproperty) target;
            switch (hp.getInputtype()) {
            case NUMERICOPTION:
            case SINGLEOPTION:
                String result = validateOption(hp);
                if (result != null) {
                    return ctx.createFailureStatus(target, result);
                }
            default:
                break;
            }
        }
        return null;
    }

    private String validateOption(Huiproperty hp) {
        int diff = (hp.getMax() - hp.getMin())+1;
        if (diff < 1) {
            return String.format("Max (%d) seems larger as Min (%d)", hp.getMax(), hp.getMin());
        } else if (diff != hp.getOption().size()) {
            return String.format("The definition of the option is inconsitent, expected %d options but found %d.", diff, hp.getOption().size());
        }
        return null;
    }

}
