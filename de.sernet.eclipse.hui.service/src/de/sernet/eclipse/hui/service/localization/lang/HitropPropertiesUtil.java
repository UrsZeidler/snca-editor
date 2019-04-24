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
package de.sernet.eclipse.hui.service.localization.lang;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.io.Files;

import de.sernet.eclipse.hitro.DocumentRoot;
import de.sernet.eclipse.hitro.Huientities;
import de.sernet.eclipse.hui.service.Activator;

/**
 * Collection of useful methods.
 * 
 * @author urszeidler
 *
 */
public class HitropPropertiesUtil {

	private static final Hitro2LangEntrySuffixesSwitch SUFFIXES_SWITCH = new Hitro2LangEntrySuffixesSwitch();
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
            return file.getRawLocation().toFile();
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
    public static Map<EObject, LanguagesEntry> loadPropertyResources(List<EObject> contents,
            String basePath, ToFile toFile) {
        if (contents.isEmpty())
            return Collections.emptyMap();

        Map<EObject, LanguagesEntry> entryMap = new HashMap<>();
        Hitro2LangEntrySwitch hitroSwitch = new Hitro2LangEntrySwitch();
        Map<String, Properties> map = HitropPropertiesUtil.getLangProperties(basePath, toFile);

        EObject eObject = contents.get(0);
        if (eObject instanceof DocumentRoot) {
            DocumentRoot dr = (DocumentRoot) eObject;
            Huientities huientities = dr.getHuientities();
            if(huientities==null) {
            	return entryMap;
            }
            TreeIterator<EObject> eAllContents = huientities.eAllContents();
            while (eAllContents.hasNext()) {
                EObject next = eAllContents.next();
                LanguagesEntry languagesEntry = hitroSwitch.doSwitch(next);
                if (languagesEntry == null) {
                    continue;
                }
                entryMap.put(next, languagesEntry);
                initalizeEntry(map, languagesEntry, next);
            }
        }
        return entryMap;
    }

	private static void initalizeEntry(Map<String, Properties> map, LanguagesEntry languagesEntry, EObject next) {
		
		for (Entry<String, Properties> lang : map.entrySet()) {
		    Properties properties = lang.getValue();
		    List<String> entrySuffixes = SUFFIXES_SWITCH.doSwitch(next);
		    for (String suffix : entrySuffixes) {
		    	String property = languagesEntry.getId() == null ? null
		    			: properties.getProperty(languagesEntry.getId()+suffix);
		    	if (property != null)
		    		languagesEntry.getEntries().add(new LangEntry(lang.getKey(),suffix, property));
		    	else {
		    		languagesEntry.getEntries().add(new LangEntry(lang.getKey(),suffix, ""));
		    	}
			}
		}
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

        List<String> locales = getAllLocalesForFile(basePath, toFile);        
        for (String lang : locales) {
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
                Activator.logError("Error getting " + lang + " propperty file.", e);
            }
            map.put(lang, properties);
        }

        return map;
    }

    public static List<String> getAllLocalesForFile(String basePath, ToFile toFile) {
        File file = toFile.toFile(basePath);
        String fullName = file.getName();
        String fileExtension = Files.getFileExtension(fullName);
        String filename = Files.getNameWithoutExtension(fullName);
        
        File parentFile = file.getParentFile();
        File[] listFiles = parentFile.listFiles(f-> f.getName().startsWith(filename) && f.getName().endsWith(fileExtension));
        return Arrays.stream(listFiles).map(f-> toLocalExtension(f,filename,fileExtension)).collect(Collectors.toList());
    }
    
    /**
     * Extract the locale from the file.
     * @param file the file
     * @param filePrefix the start of the filename 
     * @param fileExtension the extension of the file
     */
    public static String toLocalExtension(File file, String filePrefix, String fileExtension) {
        String name = file.getName();
        return name.substring(filePrefix.length(), name.length()-fileExtension.length()-1);
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
    public static void syncPropertyFile(Resource resource, String basePath,
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
                    String text = langEntry.getText();// TODO: write in ISO-8859
                    properties.put(languagesEntry.getId()+langEntry.getSuffix(), text);
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
            try {
            	OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(javaFile));
                try {
                    e.getValue().store(outputStream,
                            "automatic generated properties file for " + e.getKey());
                } finally {
                    outputStream.close();
                }
            } catch (IOException e1) {
                Activator.logError("Error saving property file: ", e1);
            }
        }
    }
    
	public static void importSncaInWorkspace(final IFile container, String orgFilename) throws CoreException {
		File source = new File(orgFilename);
        String fileBasePath = HitropPropertiesUtil.fileBasePath(source);
        String platformBasePath = HitropPropertiesUtil.platformBasePath(container);
        List<String> allLocales = HitropPropertiesUtil.getAllLocalesForFile(fileBasePath, HitropPropertiesUtil.TO_FILE);
        for (String lang : allLocales) {
            File targetFile = HitropPropertiesUtil.TO_WORKSPACE_FILE
                    .toFile(platformBasePath + lang);
            File sourceFile = HitropPropertiesUtil.TO_FILE.toFile(fileBasePath + lang);
            try {
            	java.nio.file.Files.copy(sourceFile.toPath(), targetFile.toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new CoreException(Status.CANCEL_STATUS);
            }
        }
	}

	
	public static ByteArrayInputStream transformSnca(String inputsnca) {
        try {
            String defaultCharset = "UTF-8";
			FileInputStream fileInputStream = new FileInputStream(
                    new File(inputsnca));
            BufferedReader d = new BufferedReader(
                    new InputStreamReader(fileInputStream, defaultCharset));
            try {
                String collect = d.lines().collect(Collectors.joining("\n"));
                collect = collect.replaceAll("huientities", "hitro:huientities");
                collect = collect.replaceFirst("xmlns=", "xmlns:hitro=");
                
                return new ByteArrayInputStream(collect.getBytes(defaultCharset));
            } finally {
                d.close();
            }
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

	}
	
	
	public static void exportSncaFlies(IFile sourceFile, File targetFile) throws CoreException, IOException {
		InputStream contents = sourceFile.getContents(true);
        BufferedReader d = new BufferedReader(new InputStreamReader(contents));

        String collect = d.lines().collect(Collectors.joining("\n"));
        collect = collect.replaceAll("hitro:huientities", "huientities");
        collect = collect.replaceFirst("xmlns:hitro=", "xmlns=");
        FileWriter fileWriter = new FileWriter(targetFile, false);
        
        try {
            fileWriter.append(collect);
        } finally {
            fileWriter.close();
            d.close();
        }

        String basePath = HitropPropertiesUtil.platformBasePath(sourceFile);
        String fileBasePath = HitropPropertiesUtil.fileBasePath(targetFile);
        List<String> allLocales = HitropPropertiesUtil.getAllLocalesForFile(basePath, HitropPropertiesUtil.TO_WORKSPACE_FILE);
        for (String lang : allLocales) {
            File source = HitropPropertiesUtil.TO_WORKSPACE_FILE.toFile(basePath + lang);
            File target = HitropPropertiesUtil.TO_FILE.toFile(fileBasePath + lang);
            java.nio.file.Files.copy(source.toPath(), target.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        }
	}

}
