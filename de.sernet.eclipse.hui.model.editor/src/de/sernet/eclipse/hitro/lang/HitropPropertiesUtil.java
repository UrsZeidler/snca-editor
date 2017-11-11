/*******************************************************************************
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
 ******************************************************************************/
package de.sernet.eclipse.hitro.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.sernet.eclipse.hitro.DocumentRoot;
import de.sernet.eclipse.hitro.Huientities;
import de.sernet.eclipse.hitro.presentation.HitroEditorPlugin;

/**
 * Collection of useful methods.
 * 
 * @author urszeidler
 *
 */
public class HitropPropertiesUtil {
    public static final String[] LANGS = { "", "_de" };

    /**
     * Transformer from basePath to a file.
     */
    public interface ToFile {
        File toFile(String basePath);
    }

    /**
     * Transform to a workspace file.
     */
    public static final ToFile TO_WORKSPACE_FILE = new ToFile() {

        @Override
        public File toFile(String baseNamePath) {
            IPath filePath = new Path(baseNamePath + ".properties");
            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
            File javaFile = file.getRawLocation().toFile();
            return javaFile;
        }
    };

    /**
     * Transform to a filesystem file.
     */
    public static final ToFile TO_FILE = new ToFile() {

        @Override
        public File toFile(String basePath) {
            return new File(basePath + ".properties");
        }

    };

    /**
     * Return the base file plus path from a platfrom file.
     * 
     * @param file
     * @return
     */
    public static String platformBasePath(IFile file) {
        String filename = file.getFullPath().removeFileExtension().lastSegment();
        return file.getFullPath().removeFileExtension().toString().replaceFirst(filename,
                filename.toLowerCase()) + "-messages";
    }

    /**
     * Return the base file name plus path from a file.
     * 
     * @param file
     * @return
     */
    public static String fileBasePath(File file) {
        String extension = file.getName().substring(file.getName().lastIndexOf('.'),
                file.getName().length());
        return file.getParentFile().getAbsolutePath() + "/"
                + file.getName().replace(extension, "").toLowerCase() + "-messages";
    }

    /**
     * Loads the languages properties and build the mapping structure.
     * 
     * @param contents
     * @param basePath
     * @param toFile
     * @return
     */
    public static Map<EObject, LanguagesEntry> loadPropertyResources(EList<EObject> contents,
            String basePath, ToFile toFile) {
        if (contents.isEmpty())
            return Collections.emptyMap();

        Map<EObject, LanguagesEntry> entryMap = new HashMap<EObject, LanguagesEntry>();
        Hitro2LangEntrySwitch hitroSwitch = new Hitro2LangEntrySwitch();
        Map<String, Properties> map = HitropPropertiesUtil.getLangProperties(basePath, toFile);

        EObject eObject = contents.get(0);
        if (eObject instanceof DocumentRoot) {
            DocumentRoot dr = (DocumentRoot) eObject;
            Huientities huientities = dr.getHuientities();
            TreeIterator<EObject> eAllContents = huientities.eAllContents();
            for (; eAllContents.hasNext();) {
                EObject next = eAllContents.next();
                LanguagesEntry languagesEntry = hitroSwitch.doSwitch(next);
                if (languagesEntry == null) {
                    continue;
                }
                entryMap.put(next, languagesEntry);
                for (String lang : map.keySet()) {
                    Properties properties = map.get(lang);
                    String property = languagesEntry.getId() == null ? null
                            : properties.getProperty(languagesEntry.getId());
                    if (property != null)
                        languagesEntry.getEntries().add(new LangEntry(lang, property));
                    else {
                        languagesEntry.getEntries().add(new LangEntry(lang, ""));
                    }
                }
            }
        }
        return entryMap;
    }

    /**
     * Load the properties from the given path.
     * 
     * @param basePath
     * @param toFile
     * @return
     */
    public static Map<String, Properties> getLangProperties(String basePath, ToFile toFile) {
        Map<String, Properties> map = new HashMap<>();

        for (String lang : LANGS) {
            Properties properties = new Properties() {
                private static final long serialVersionUID = 5598658684137906202L;

                @Override
                public synchronized Enumeration<Object> keys() {
                    return Collections.enumeration(new TreeSet<Object>(super.keySet()));
                }
            };

            File file2 = toFile.toFile(basePath + lang);
            try {
                if (file2 != null && file2.exists()) {
                    FileInputStream in = new FileInputStream(file2);
                    Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);

                    try {
                        properties.load(reader);
                    } finally {
                        reader.close();
                        in.close();
                    }
                }
            } catch (IOException e) {
                HitroEditorPlugin.INSTANCE.log(e);
            }
            map.put(lang, properties);
        }

        return map;
    }

    /**
     * Get the file from a resource.
     * 
     * @param resource
     * @return
     */
    public static IFile getFile(Resource resource) {
        if (resource != null) {
            org.eclipse.emf.common.util.URI uri = resource.getURI();
            uri = resource.getResourceSet().getURIConverter().normalize(uri);
            String scheme = uri.scheme();
            if ("platform".equals(scheme) && uri.segmentCount() > 1
                    && "resource".equals(uri.segment(0))) {
                StringBuffer platformResourcePath = new StringBuffer();
                for (int j = 1, size = uri.segmentCount(); j < size; ++j) {
                    platformResourcePath.append('/');
                    platformResourcePath.append(uri.segment(j));
                }
                return ResourcesPlugin.getWorkspace().getRoot()
                        .getFile(new Path(platformResourcePath.toString()));
            }
        }
        return null;
    }

    /**
     * Sync the languages entries than save the properties.
     * 
     * @param resource
     * @param basePath
     * @param entryMap
     * @param toFile
     */
    public static void savePropertyFile(Resource resource, String basePath,
            Map<EObject, LanguagesEntry> entryMap, ToFile toFile) {
        Hitro2LangEntrySwitch entrySwitch = new Hitro2LangEntrySwitch();
        Map<String, Properties> langProperties = getLangProperties(basePath, toFile);

        EList<EObject> contents = resource.getContents();
        EObject eObject = contents.get(0);
        TreeIterator<EObject> eAllContents = eObject.eAllContents();

        for (; eAllContents.hasNext();) {
            EObject next = eAllContents.next();
            LanguagesEntry languagesEntry = entryMap.get(next);
            if (languagesEntry != null) {
                languagesEntry.setId(entrySwitch.doSwitch(next).getId());
                if (languagesEntry.getId() == null)
                    continue;

                List<LangEntry> entries = languagesEntry.getEntries();
                for (LangEntry langEntry : entries) {
                    Properties properties = langProperties.get(langEntry.getLang());
                    String text = langEntry.getText();
                    // try {
                    // text = new
                    // String(langEntry.getText().getBytes("ISO-8859-1"),
                    // "UTF-8");
                    // } catch (UnsupportedEncodingException e1) {
                    // e1.printStackTrace();
                    // }
                    properties.put(languagesEntry.getId(), text);
                }
            }
        }
        savePropertyFile(basePath, langProperties, toFile);
    }

    /**
     * Save all the property files.
     * 
     * @param basePath
     * @param langProperties
     * @param toFile
     */
    public static void savePropertyFile(String basePath, Map<String, Properties> langProperties,
            ToFile toFile) {
        for (Entry<String, Properties> e : langProperties.entrySet()) {
            File javaFile = toFile.toFile(basePath + e.getKey());
            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(javaFile);
                try {
                    e.getValue().store(fileWriter,
                            "automatic generated properties file for " + e.getKey());
                } finally {
                    fileWriter.close();
                }
            } catch (IOException e1) {
                HitroEditorPlugin.INSTANCE.log(e);
            }
        }

    }
}
