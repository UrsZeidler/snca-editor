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
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Huipropertygroup;
import de.sernet.eclipse.hitro.Huirelation;
import de.sernet.eclipse.hitro.Option;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
				HitropPropertiesUtil.TO_FILE, Collections.emptySet());
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
	public void testGetFile() {
		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		File file = new File("testdata/test/test_de.properties");
		URI uri = URI.createFileURI(file.getAbsolutePath());
		Resource resource = resourceSetImpl.createResource(uri);
		IFile file2 = HitropPropertiesUtil.getFile(resource);
		assertNull(file2);
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
		huientity.setId("id:e1");
		huientities.getHuientity().add(huientity);

		propertyResources = HitropPropertiesUtil.loadPropertyResources(list, basePath, HitropPropertiesUtil.TO_FILE);
		assertEquals(1, propertyResources.size());

		LanguagesEntry languagesEntry = propertyResources.get(huientity);
		assertEquals("id:e1", languagesEntry.getId());
		assertEquals(8, languagesEntry.getEntries().size());
		
		Huipropertygroup huipropertygroup = HitroFactory.eINSTANCE.createHuipropertygroup();
		huipropertygroup.setId("id:g1");
		huientity.getHuipropertygroup().add(huipropertygroup);
		
		propertyResources = HitropPropertiesUtil.loadPropertyResources(list, basePath, HitropPropertiesUtil.TO_FILE);
		assertEquals(2, propertyResources.size());

		languagesEntry = propertyResources.get(huipropertygroup);
		assertEquals("id:g1", languagesEntry.getId());
		assertEquals(8, languagesEntry.getEntries().size());

		Huiproperty huiproperty = HitroFactory.eINSTANCE.createHuiproperty();
		huiproperty.setId("id:p1");
		huipropertygroup.getHuiproperty().add(huiproperty);
		
		propertyResources = HitropPropertiesUtil.loadPropertyResources(list, basePath, HitropPropertiesUtil.TO_FILE);
		assertEquals(3, propertyResources.size());

		languagesEntry = propertyResources.get(huiproperty);
		assertEquals("id:p1", languagesEntry.getId());
		assertEquals(8, languagesEntry.getEntries().size());
		
		Huirelation huirelation = HitroFactory.eINSTANCE.createHuirelation();
		huirelation.setId("id:r1");
		huientity.getHuirelation().add(huirelation);
		
		propertyResources = HitropPropertiesUtil.loadPropertyResources(list, basePath, HitropPropertiesUtil.TO_FILE);
		assertEquals(4, propertyResources.size());

		languagesEntry = propertyResources.get(huirelation);
		assertEquals("id:r1", languagesEntry.getId());
		assertEquals(12, languagesEntry.getEntries().size());
		
		Option option = HitroFactory.eINSTANCE.createOption();
		option.setId("id:o1");
		huiproperty.getOption().add(option);
		
		propertyResources = HitropPropertiesUtil.loadPropertyResources(list, basePath, HitropPropertiesUtil.TO_FILE);
		assertEquals(5, propertyResources.size());

		languagesEntry = propertyResources.get(option);
		assertEquals("id:o1", languagesEntry.getId());
		assertEquals(4, languagesEntry.getEntries().size());
	}

}
