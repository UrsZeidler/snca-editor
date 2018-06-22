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

/**
 * @author Urs Zeidler
 * 
 */
public class HitroViewsRepository {

    public static final int SWT_KIND = 0;

    public static final int FORM_KIND = 1;

    /**
     * DefaultRule view descriptor
     * 
     */
    public static class DefaultRule {
        public static class Properties {

            public static String param = "hitro::DefaultRule::properties::param";

            public static String class_ = "hitro::DefaultRule::properties::class";

        }

    }

    /**
     * Depends view descriptor
     * 
     */
    public static class Depends {
        public static class Properties {

            public static String inverse = "hitro::Depends::properties::inverse";

            public static String option = "hitro::Depends::properties::option";

            public static String value = "hitro::Depends::properties::value";

        }

    }

    /**
     * DocumentRoot view descriptor
     * 
     */
    public static class DocumentRoot {
        public static class Properties {

            public static String mixed = "hitro::DocumentRoot::properties::mixed";

        }

    }

    /**
     * Huientities view descriptor
     * 
     */
    public static class Huientities {
        public static class Properties {

            public static String huientity = "hitro::Huientities::properties::huientity";

        }

    }

    /**
     * Huientity view descriptor
     * 
     */
    public static class Huientity {
        public static class Base {

            public static String id = "hitro::Huientity::base::id";

            public static String name = "hitro::Huientity::base::name";

        }

        public static class Test {

            // Start of user code for TestName ElementEditor key
            public static String testName = "hitro::Huientity::Test::TestName";
            // End of user code

        }

    }

    /**
     * Huiproperty view descriptor
     * 
     */
    public static class Huiproperty {
        public static class Base {

            public static String id = "hitro::Huiproperty::base::id";

            public static String name = "hitro::Huiproperty::base::name";

        }

        public static class Type {

            public static String inputtype = "hitro::Huiproperty::type::inputtype";

            public static String isURL = "hitro::Huiproperty::type::isURL";

            public static String min = "hitro::Huiproperty::type::min";

            public static String max = "hitro::Huiproperty::type::max";

        }

        public static class Properties {

            public static String crudButtons = "hitro::Huiproperty::properties::crudButtons";

            public static String defaultValue = "hitro::Huiproperty::properties::defaultValue";

            public static String editable = "hitro::Huiproperty::properties::editable";

            public static String focus = "hitro::Huiproperty::properties::focus";

            public static String report = "hitro::Huiproperty::properties::report";

            public static String required = "hitro::Huiproperty::properties::required";

            public static String showInObjectBrowser = "hitro::Huiproperty::properties::showInObjectBrowser";

            public static String tags = "hitro::Huiproperty::properties::tags";

            public static String textrows = "hitro::Huiproperty::properties::textrows";

            public static String tooltip = "hitro::Huiproperty::properties::tooltip";

            public static String visible = "hitro::Huiproperty::properties::visible";

        }

        public static class Childs {

            public static String depends = "hitro::Huiproperty::childs::depends";

            public static String validationRule = "hitro::Huiproperty::childs::validationRule";

            public static String option = "hitro::Huiproperty::childs::option";

        }

    }

    /**
     * Huipropertygroup view descriptor
     * 
     */
    public static class Huipropertygroup {
        public static class Base {

            public static String id = "hitro::Huipropertygroup::base::id";

            public static String name = "hitro::Huipropertygroup::base::name";

        }

        public static class Properties {

            public static String columns = "hitro::Huipropertygroup::properties::columns";

            public static String tags = "hitro::Huipropertygroup::properties::tags";

            public static String huiproperty = "hitro::Huipropertygroup::properties::huiproperty";

            public static String depends = "hitro::Huipropertygroup::properties::depends";

        }

    }

    /**
     * Huirelation view descriptor
     * 
     */
    public static class Huirelation {
        public static class Base {

            public static String id = "hitro::Huirelation::base::id";

            public static String name = "hitro::Huirelation::base::name";

        }

        public static class Properties {

            public static String reversename = "hitro::Huirelation::properties::reversename";

            public static String to = "hitro::Huirelation::properties::to";

            public static String tooltip = "hitro::Huirelation::properties::tooltip";

        }

    }

    /**
     * Option view descriptor
     * 
     */
    public static class Option {
        public static class Properties {

            public static String id = "hitro::Option::properties::id";

            public static String name = "hitro::Option::properties::name";

            public static String value = "hitro::Option::properties::value";

        }

    }

    /**
     * Param view descriptor
     * 
     */
    public static class Param {
        public static class Properties {

            public static String id = "hitro::Param::properties::id";

            public static String mixed = "hitro::Param::properties::mixed";

        }

    }

    /**
     * Reference view descriptor
     * 
     */
    public static class Reference {
        public static class Properties {

            public static String entitytype = "hitro::Reference::properties::entitytype";

            public static String linkType = "hitro::Reference::properties::linkType";

        }

    }

    /**
     * ValidationRule view descriptor
     * 
     */
    public static class ValidationRule {
        public static class Properties {

            public static String param = "hitro::ValidationRule::properties::param";

            public static String class_ = "hitro::ValidationRule::properties::class";

            public static String hint = "hitro::ValidationRule::properties::hint";

        }

    }

}
