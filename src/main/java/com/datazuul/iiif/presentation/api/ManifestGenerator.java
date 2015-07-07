/*
 * Copyright 2015 Ralf Eichinger.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datazuul.iiif.presentation.api;

import com.datazuul.iiif.presentation.api.json.CanvasMixIn;
import com.datazuul.iiif.presentation.api.json.ImageMixIn;
import com.datazuul.iiif.presentation.api.json.ManifestMixIn;
import com.datazuul.iiif.presentation.api.json.ResourceMixIn;
import com.datazuul.iiif.presentation.api.json.SequenceMixIn;
import com.datazuul.iiif.presentation.api.json.ServiceMixIn;
import com.datazuul.iiif.presentation.api.model.Canvas;
import com.datazuul.iiif.presentation.api.model.Image;
import com.datazuul.iiif.presentation.api.model.Manifest;
import com.datazuul.iiif.presentation.api.model.Resource;
import com.datazuul.iiif.presentation.api.model.Sequence;
import com.datazuul.iiif.presentation.api.model.Service;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author Ralf Eichinger
 */
public class ManifestGenerator {

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        Options options = new Options();
        options.addOption("d", true, "Absolute file path to the directory containing the image files.");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("d")) {
            String imageDirectoryPath = cmd.getOptionValue("d");
            Path imageDirectory = Paths.get(imageDirectoryPath);
            final List<Path> files = new ArrayList<>();
            try {
                Files.walkFileTree(imageDirectory, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        if (!attrs.isDirectory()) {
                            files.add(file);
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Path file : files) {
                Path fileName = file.getFileName();
                System.out.println(fileName.toString());
            }
        } else {
            // automatically generate the help statement
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("ManifestGenerator", options);
        }
    }

    public ManifestGenerator() {
    }

    public String generateJson(Manifest manifest) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(Canvas.class, CanvasMixIn.class);
        mapper.addMixIn(Image.class, ImageMixIn.class);
        mapper.addMixIn(Manifest.class, ManifestMixIn.class);
        mapper.addMixIn(Resource.class, ResourceMixIn.class);
        mapper.addMixIn(Sequence.class, SequenceMixIn.class);
        mapper.addMixIn(Service.class, ServiceMixIn.class);
        mapper.setSerializationInclusion(Include.NON_NULL);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(manifest);
        return json;
    }
}
