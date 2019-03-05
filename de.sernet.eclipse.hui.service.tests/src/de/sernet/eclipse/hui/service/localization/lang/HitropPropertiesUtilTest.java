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
package de.sernet.eclipse.hui.service.localization.lang;

import static org.junit.Assert.*;

import de.sernet.eclipse.hitro.DocumentRoot;
import de.sernet.eclipse.hitro.HitroFactory;
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huientities;
import de.sernet.eclipse.hitro.Huientity;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author uz[at]sernet.de
 *
 */
public class HitropPropertiesUtilTest {

	private String basePath;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		File file = new File("testdata/test");
		basePath = file.getAbsolutePath();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link de.sernet.eclipse.hui.service.localization.lang.HitropPropertiesUtil#getLangProperties(java.lang.String, de.sernet.eclipse.hui.service.localization.lang.HitropPropertiesUtil.ToFile)}.
	 */
	@Test
	public void testGetLangProperties() {
		Map<String, Properties> langProperties = HitropPropertiesUtil.getLangProperties(basePath,
				HitropPropertiesUtil.TO_FILE);
		assertEquals(4, langProperties.size());
	}

	/**
	 * Test method for
	 * {@link de.sernet.eclipse.hui.service.localization.lang.HitropPropertiesUtil#getAllLocalesForFile(java.lang.String, de.sernet.eclipse.hui.service.localization.lang.HitropPropertiesUtil.ToFile)}.
	 */
	@Test
	public void testGetAllLocalesForFile() {
		List<String> allLocalesForFile = HitropPropertiesUtil.getAllLocalesForFile(basePath,
				HitropPropertiesUtil.TO_FILE);
		assertEquals(4, allLocalesForFile.size());

		assertTrue(allLocalesForFile.contains(""));
		assertTrue(allLocalesForFile.contains("_de"));
		assertTrue(allLocalesForFile.contains("_de_DE"));
		assertTrue(allLocalesForFile.contains("_jp"));
	}

	@Test
	public void testToLocalExtension() {
		File file = new File("testdata/test/test_de.properties");
		assertEquals("_de", HitropPropertiesUtil.toLocalExtension(file, "test", "properties"));
	}

	@Test
	public void testLoadPropertyResources() {
		DocumentRoot documentRoot = HitroFactory.eINSTANCE.createDocumentRoot();

		List<EObject> list = Collections.singletonList(documentRoot);
		Map<EObject, LanguagesEntry> propertyResources = HitropPropertiesUtil.loadPropertyResources(list, basePath,
				HitropPropertiesUtil.TO_FILE);
		assertEquals(0, propertyResources.size());

		Huientities huientities = HitroFactory.eINSTANCE.createHuientities();
		documentRoot.setHuientities(huientities);

		propertyResources = HitropPropertiesUtil.loadPropertyResources(list, basePath, HitropPropertiesUtil.TO_FILE);
		assertEquals(0, propertyResources.size());

		Huientity huientity = HitroFactory.eINSTANCE.createHuientity();
		huientity.setId("id1");
		huientities.getHuientity().add(huientity);

		propertyResources = HitropPropertiesUtil.loadPropertyResources(list, basePath, HitropPropertiesUtil.TO_FILE);
		assertEquals(1, propertyResources.size());

		LanguagesEntry languagesEntry = propertyResources.get(huientity);
		assertEquals("id1", languagesEntry.getId());
		assertEquals(8, languagesEntry.getEntries().size());
	}

}
