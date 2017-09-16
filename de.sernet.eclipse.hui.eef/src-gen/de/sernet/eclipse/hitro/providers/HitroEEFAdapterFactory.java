/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.providers;

import de.sernet.eclipse.hitro.util.HitroAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;

/**
 * 
 * 
 */
public class HitroEEFAdapterFactory extends HitroAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createDefaultRuleAdapter()
	 * 
	 */
	public Adapter createDefaultRuleAdapter() {
		return new DefaultRulePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createDependsAdapter()
	 * 
	 */
	public Adapter createDependsAdapter() {
		return new DependsPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createDocumentRootAdapter()
	 * 
	 */
	public Adapter createDocumentRootAdapter() {
		return new DocumentRootPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createHuientitiesAdapter()
	 * 
	 */
	public Adapter createHuientitiesAdapter() {
		return new HuientitiesPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createHuientityAdapter()
	 * 
	 */
	public Adapter createHuientityAdapter() {
		return new HuientityPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createHuipropertyAdapter()
	 * 
	 */
	public Adapter createHuipropertyAdapter() {
		return new HuipropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createHuipropertygroupAdapter()
	 * 
	 */
	public Adapter createHuipropertygroupAdapter() {
		return new HuipropertygroupPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createHuirelationAdapter()
	 * 
	 */
	public Adapter createHuirelationAdapter() {
		return new HuirelationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createOptionAdapter()
	 * 
	 */
	public Adapter createOptionAdapter() {
		return new OptionPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createParamAdapter()
	 * 
	 */
	public Adapter createParamAdapter() {
		return new ParamPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createReferenceAdapter()
	 * 
	 */
	public Adapter createReferenceAdapter() {
		return new ReferencePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see de.sernet.eclipse.hitro.util.HitroAdapterFactory#createValidationRuleAdapter()
	 * 
	 */
	public Adapter createValidationRuleAdapter() {
		return new ValidationRulePropertiesEditionProvider();
	}

}
