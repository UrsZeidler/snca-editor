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
package de.sernet.eclipse.hitro.util;

import de.sernet.eclipse.hitro.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.sernet.eclipse.hitro.HitroPackage
 * @generated
 */
public class HitroAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static HitroPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HitroAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = HitroPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HitroSwitch<Adapter> modelSwitch =
        new HitroSwitch<Adapter>() {
            @Override
            public Adapter caseDefaultRule(DefaultRule object) {
                return createDefaultRuleAdapter();
            }
            @Override
            public Adapter caseDepends(Depends object) {
                return createDependsAdapter();
            }
            @Override
            public Adapter caseDocumentRoot(DocumentRoot object) {
                return createDocumentRootAdapter();
            }
            @Override
            public Adapter caseHuientities(Huientities object) {
                return createHuientitiesAdapter();
            }
            @Override
            public Adapter caseHuientity(Huientity object) {
                return createHuientityAdapter();
            }
            @Override
            public Adapter caseHuiproperty(Huiproperty object) {
                return createHuipropertyAdapter();
            }
            @Override
            public Adapter caseHuipropertygroup(Huipropertygroup object) {
                return createHuipropertygroupAdapter();
            }
            @Override
            public Adapter caseHuirelation(Huirelation object) {
                return createHuirelationAdapter();
            }
            @Override
            public Adapter caseOption(Option object) {
                return createOptionAdapter();
            }
            @Override
            public Adapter caseParam(Param object) {
                return createParamAdapter();
            }
            @Override
            public Adapter caseReference(Reference object) {
                return createReferenceAdapter();
            }
            @Override
            public Adapter caseValidationRule(ValidationRule object) {
                return createValidationRuleAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.DefaultRule <em>Default Rule</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.DefaultRule
     * @generated
     */
    public Adapter createDefaultRuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.Depends <em>Depends</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.Depends
     * @generated
     */
    public Adapter createDependsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.DocumentRoot
     * @generated
     */
    public Adapter createDocumentRootAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.Huientities <em>Huientities</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.Huientities
     * @generated
     */
    public Adapter createHuientitiesAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.Huientity <em>Huientity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.Huientity
     * @generated
     */
    public Adapter createHuientityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.Huiproperty <em>Huiproperty</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.Huiproperty
     * @generated
     */
    public Adapter createHuipropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.Huipropertygroup <em>Huipropertygroup</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.Huipropertygroup
     * @generated
     */
    public Adapter createHuipropertygroupAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.Huirelation <em>Huirelation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.Huirelation
     * @generated
     */
    public Adapter createHuirelationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.Option <em>Option</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.Option
     * @generated
     */
    public Adapter createOptionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.Param <em>Param</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.Param
     * @generated
     */
    public Adapter createParamAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.Reference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.Reference
     * @generated
     */
    public Adapter createReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.sernet.eclipse.hitro.ValidationRule <em>Validation Rule</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.sernet.eclipse.hitro.ValidationRule
     * @generated
     */
    public Adapter createValidationRuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //HitroAdapterFactory
