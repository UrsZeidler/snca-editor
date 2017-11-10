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
package de.sernet.eclipse.hitro;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Huientities</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.sernet.eclipse.hitro.Huientities#getHuientity <em>Huientity</em>}</li>
 * </ul>
 *
 * @see de.sernet.eclipse.hitro.HitroPackage#getHuientities()
 * @model extendedMetaData="name='huientities_._type' kind='elementOnly'"
 * @generated
 */
public interface Huientities extends EObject {
    /**
     * Returns the value of the '<em><b>Huientity</b></em>' containment reference list.
     * The list contents are of type {@link de.sernet.eclipse.hitro.Huientity}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Huientity</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Huientity</em>' containment reference list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuientities_Huientity()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='huientity'"
     * @generated
     */
    EList<Huientity> getHuientity();

} // Huientities
