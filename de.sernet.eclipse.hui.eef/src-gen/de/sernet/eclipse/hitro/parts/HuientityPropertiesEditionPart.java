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
package de.sernet.eclipse.hitro.parts;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public interface HuientityPropertiesEditionPart {

    /**
     * @return the id
     * 
     */
    public String getId();

    /**
     * Defines a new id
     * 
     * @param newValue
     *            the new id to set
     * 
     */
    public void setId(String newValue);

    /**
     * @return the name
     * 
     */
    public String getName();

    /**
     * Defines a new name
     * 
     * @param newValue
     *            the new name to set
     * 
     */
    public void setName(String newValue);

    // Start of user code for TestName specific getters and setters declaration

    // End of user code

    /**
     * Returns the internationalized title text.
     * 
     * @return the internationalized title text.
     * 
     */
    public String getTitle();

    // Start of user code for additional methods

    // End of user code

}
