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

import de.sernet.eclipse.hitro.util.HitroModelUtil;

/**
 * @author uz[at]sernet.de
 *
 */
public class TestIdFormat extends AbstractModelConstraint {

    /**
     * 
     */
    public TestIdFormat() {
    }

    @Override
    public IStatus validate(IValidationContext ctx) {
        EObject target = ctx.getTarget();
        String id = HitroModelUtil.createId(target);
        String org_id = HitroModelUtil.getIdSwitch().doSwitch(target);

        if (id != null && !id.equals(org_id)) {
            return ctx.createFailureStatus(target);
        }
        return null;
    }

}
