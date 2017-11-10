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
package de.sernet.eclipse.hui.model.validation.contrains;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.google.common.collect.Sets;

import de.sernet.eclipse.hitro.DefaultRule;
import de.sernet.eclipse.hitro.util.HitroSwitch;

/**
 * @author urszeidler
 *
 */
public class TestRuleClasses extends AbstractModelConstraint {

	private static final Set<String> KNOWN_RULES = Sets.newHashSet("SimpleValue", "Today", "NullRule");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.
	 * validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();

		HitroSwitch<String> hitroSwitch = new HitroSwitch<String>() {
			@Override
			public String caseDefaultRule(DefaultRule object) {
				return object.getClass_();
			}
		};

		String doSwitch = hitroSwitch.doSwitch(target);
		if (!KNOWN_RULES.contains(doSwitch)) {
			return ctx.createFailureStatus(doSwitch, target);
		}

		return null;
	}

}
