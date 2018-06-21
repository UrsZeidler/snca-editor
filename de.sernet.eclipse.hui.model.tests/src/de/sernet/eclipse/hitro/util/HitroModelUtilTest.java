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
package de.sernet.eclipse.hitro.util;

import de.sernet.eclipse.hitro.DocumentRoot;
import de.sernet.eclipse.hitro.HitroFactory;
import de.sernet.eclipse.hitro.Huientities;
import de.sernet.eclipse.hitro.Huientity;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Huipropertygroup;
import junit.framework.TestCase;

/**
 * @author uz[at]sernet.de
 *
 */
public class HitroModelUtilTest extends TestCase {

    private Huientity huientity;

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        DocumentRoot documentRoot = HitroFactory.eINSTANCE.createDocumentRoot();
        Huientities huientities = HitroFactory.eINSTANCE.createHuientities();
        huientity = HitroFactory.eINSTANCE.createHuientity();

        documentRoot.setHuientities(huientities);
        huientities.getHuientity().add(huientity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreateId_HuiEntity() {
        huientity.setName("Test1");
        assertEquals("test1", HitroModelUtil.createId(huientity));
        huientity.setName("Test Name");
        assertEquals("test_name", HitroModelUtil.createId(huientity));
    }

    public void testCreateId_HuiEntity_Huiproperty() {
        huientity.setName("Test1");
        huientity.setId(HitroModelUtil.createId(huientity));
        Huiproperty huiproperty = HitroFactory.eINSTANCE.createHuiproperty();
        huiproperty.setName("Test");
        huientity.getHuiproperty().add(huiproperty);
        assertEquals("test1_test", HitroModelUtil.createId(huiproperty));

        huiproperty.setName("Test Name");
        assertEquals("test1_test_name", HitroModelUtil.createId(huiproperty));
    }

    public void testCreateId_HuiEntity_HuipropertyGroup_Huiproperty() {
        huientity.setName("Test1");
        huientity.setId(HitroModelUtil.createId(huientity));
        Huipropertygroup huipropertygroup = HitroFactory.eINSTANCE.createHuipropertygroup();
        huientity.getHuipropertygroup().add(huipropertygroup);
        huipropertygroup.setName("Test");
        huipropertygroup.setId(HitroModelUtil.createId(huipropertygroup));

        Huiproperty huiproperty = HitroFactory.eINSTANCE.createHuiproperty();
        huiproperty.setName("Test1");
        huipropertygroup.getHuiproperty().add(huiproperty);
        assertEquals("test1_test_test1", HitroModelUtil.createId(huiproperty));

        huiproperty.setName("Test Name");
        assertEquals("test1_test_test_name", HitroModelUtil.createId(huiproperty));

        huiproperty.setName("Test Name ende3");
        assertEquals("test1_test_test_name_ende3", HitroModelUtil.createId(huiproperty));
    }

    public void testCreateId_HuiEntity_HuipropertyGroup() {
        huientity.setName("Test1");
        huientity.setId(HitroModelUtil.createId(huientity));
        Huipropertygroup huipropertygroup = HitroFactory.eINSTANCE.createHuipropertygroup();
        huipropertygroup.setName("Test");
        huientity.getHuipropertygroup().add(huipropertygroup);
        assertEquals("test1_test", HitroModelUtil.createId(huipropertygroup));

        huipropertygroup.setName("Test Name");
        assertEquals("test1_test_name", HitroModelUtil.createId(huipropertygroup));
    }

}
