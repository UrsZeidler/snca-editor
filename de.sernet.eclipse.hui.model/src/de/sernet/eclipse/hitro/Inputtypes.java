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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Inputtypes</b></em>', and utility methods for working with them. <!--
 * end-user-doc -->
 * 
 * @see de.sernet.eclipse.hitro.HitroPackage#getInputtypes()
 * @model extendedMetaData="name='inputtypes'"
 * @generated
 */
public enum Inputtypes implements Enumerator {
    /**
     * The '<em><b>Line</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #LINE_VALUE
     * @generated
     * @ordered
     */
    LINE(0, "line", "line"),

    /**
     * The '<em><b>Singleoption</b></em>' literal object. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #SINGLEOPTION_VALUE
     * @generated
     * @ordered
     */
    SINGLEOPTION(1, "singleoption", "singleoption"),

    /**
     * The '<em><b>Multioption</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #MULTIOPTION_VALUE
     * @generated
     * @ordered
     */
    MULTIOPTION(2, "multioption", "multioption"),

    /**
     * The '<em><b>Text</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #TEXT_VALUE
     * @generated
     * @ordered
     */
    TEXT(3, "text", "text"),

    /**
     * The '<em><b>Reference</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #REFERENCE_VALUE
     * @generated
     * @ordered
     */
    REFERENCE(4, "reference", "reference"),

    /**
     * The '<em><b>Cnalink Reference</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #CNALINK_REFERENCE_VALUE
     * @generated
     * @ordered
     */
    CNALINK_REFERENCE(5, "cnalinkReference", "cnalink-reference"),

    /**
     * The '<em><b>Date</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #DATE_VALUE
     * @generated
     * @ordered
     */
    DATE(6, "date", "date"),

    /**
     * The '<em><b>Numericoption</b></em>' literal object. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #NUMERICOPTION_VALUE
     * @generated
     * @ordered
     */
    NUMERICOPTION(7, "numericoption", "numericoption"),

    /**
     * The '<em><b>Booleanoption</b></em>' literal object. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #BOOLEANOPTION_VALUE
     * @generated
     * @ordered
     */
    BOOLEANOPTION(8, "booleanoption", "booleanoption");

    /**
     * The '<em><b>Line</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Line</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #LINE
     * @model name="line"
     * @generated
     * @ordered
     */
    public static final int LINE_VALUE = 0;

    /**
     * The '<em><b>Singleoption</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Singleoption</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #SINGLEOPTION
     * @model name="singleoption"
     * @generated
     * @ordered
     */
    public static final int SINGLEOPTION_VALUE = 1;

    /**
     * The '<em><b>Multioption</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Multioption</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #MULTIOPTION
     * @model name="multioption"
     * @generated
     * @ordered
     */
    public static final int MULTIOPTION_VALUE = 2;

    /**
     * The '<em><b>Text</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Text</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #TEXT
     * @model name="text"
     * @generated
     * @ordered
     */
    public static final int TEXT_VALUE = 3;

    /**
     * The '<em><b>Reference</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Reference</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #REFERENCE
     * @model name="reference"
     * @generated
     * @ordered
     */
    public static final int REFERENCE_VALUE = 4;

    /**
     * The '<em><b>Cnalink Reference</b></em>' literal value. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Cnalink Reference</b></em>' literal object
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #CNALINK_REFERENCE
     * @model name="cnalinkReference" literal="cnalink-reference"
     * @generated
     * @ordered
     */
    public static final int CNALINK_REFERENCE_VALUE = 5;

    /**
     * The '<em><b>Date</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Date</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #DATE
     * @model name="date"
     * @generated
     * @ordered
     */
    public static final int DATE_VALUE = 6;

    /**
     * The '<em><b>Numericoption</b></em>' literal value. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of '<em><b>Numericoption</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #NUMERICOPTION
     * @model name="numericoption"
     * @generated
     * @ordered
     */
    public static final int NUMERICOPTION_VALUE = 7;

    /**
     * The '<em><b>Booleanoption</b></em>' literal value. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of '<em><b>Booleanoption</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #BOOLEANOPTION
     * @model name="booleanoption"
     * @generated
     * @ordered
     */
    public static final int BOOLEANOPTION_VALUE = 8;

    /**
     * An array of all the '<em><b>Inputtypes</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final Inputtypes[] VALUES_ARRAY = new Inputtypes[] { LINE, SINGLEOPTION,
            MULTIOPTION, TEXT, REFERENCE, CNALINK_REFERENCE, DATE, NUMERICOPTION, BOOLEANOPTION, };

    /**
     * A public read-only list of all the '<em><b>Inputtypes</b></em>'
     * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<Inputtypes> VALUES = Collections
            .unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Inputtypes</b></em>' literal with the specified
     * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static Inputtypes get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            Inputtypes result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Inputtypes</b></em>' literal with the specified name.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static Inputtypes getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            Inputtypes result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Inputtypes</b></em>' literal with the specified
     * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static Inputtypes get(int value) {
        switch (value) {
        case LINE_VALUE:
            return LINE;
        case SINGLEOPTION_VALUE:
            return SINGLEOPTION;
        case MULTIOPTION_VALUE:
            return MULTIOPTION;
        case TEXT_VALUE:
            return TEXT;
        case REFERENCE_VALUE:
            return REFERENCE;
        case CNALINK_REFERENCE_VALUE:
            return CNALINK_REFERENCE;
        case DATE_VALUE:
            return DATE;
        case NUMERICOPTION_VALUE:
            return NUMERICOPTION;
        case BOOLEANOPTION_VALUE:
            return BOOLEANOPTION;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    private Inputtypes(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string
     * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} // Inputtypes
