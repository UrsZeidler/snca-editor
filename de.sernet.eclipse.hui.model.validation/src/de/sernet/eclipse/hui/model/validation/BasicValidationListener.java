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
package de.sernet.eclipse.hui.model.validation;

import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ValidationEvent;

/**
 * @author urszeidler
 *
 */
public class BasicValidationListener implements IValidationListener {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.emf.validation.service.IValidationListener#validationOccurred
     * (org.eclipse.emf.validation.service.ValidationEvent)
     */
    @Override
    public void validationOccurred(ValidationEvent event) {
        System.out.println("BasicValidationListener:->" + event);
    }

}
