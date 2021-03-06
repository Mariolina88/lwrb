/*
 * JGrass - Free Open Source Java GIS http://www.jgrass.org 
 * (C) HydroloGIS - www.hydrologis.com 
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Library General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Library General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Library General Public License
 * along with this library; if not, write to the Free Foundation, Inc., 59
 * Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.jgrasstools.utils.service;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

import org.jgrasstools.Modules;
import org.jgrasstools.gears.utils.files.FileUtilities;

/**
 * Class that generates the service file.
 * 
 * @author Andrea Antonello (www.hydrologis.com)
 */
public class ServiceGenerator {

    public static void main( String[] args ) throws IOException {
        File serviceFile = new File("./src/main/resources/META-INF/services/org.jgrasstools.gears.libs.modules.JGTModel");
        if (!serviceFile.exists()) {
            throw new IOException();
        }

        StringBuilder sb = new StringBuilder();

        Modules jgg = Modules.getInstance();
        Set<Entry<String, Class< ? >>> cls = jgg.moduleName2Class.entrySet();
        for( Entry<String, Class< ? >> cl : cls ) {
            sb.append(cl.getValue().getCanonicalName()).append("\n");;
        }

        FileUtilities.writeFile(sb.toString(), serviceFile);

    }
}
