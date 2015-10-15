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

import com.datazuul.iiif.presentation.api.json.AbstractIiifResourceMixIn;
import com.datazuul.iiif.presentation.api.json.CanvasMixIn;
import com.datazuul.iiif.presentation.api.json.ManifestMixIn;
import com.datazuul.iiif.presentation.api.json.MetadataLocalizedValueMixIn;
import com.datazuul.iiif.presentation.api.json.ServiceMixIn;
import com.datazuul.iiif.presentation.api.model.AbstractIiifResource;
import com.datazuul.iiif.presentation.api.model.Canvas;
import com.datazuul.iiif.presentation.api.model.Manifest;
import com.datazuul.iiif.presentation.api.model.Sequence;
import com.datazuul.iiif.presentation.api.model.other.Image;
import com.datazuul.iiif.presentation.api.model.other.ImageResource;
import com.datazuul.iiif.presentation.api.model.other.MetadataLocalizedValue;
import com.datazuul.iiif.presentation.api.model.other.Resource;
import com.datazuul.iiif.presentation.api.model.other.Service;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.imageio.ImageIO;
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

  public static void main(String[] args) throws ParseException, JsonProcessingException, IOException {
    Options options = new Options();
    options.addOption("d", true, "Absolute file path to the directory containing the image files.");
    options.
            addOption("sortnum", false, "set option if filenames are representing the order by integer value, e.g. 1.jpg, 2.jpg ...");

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
              // TODO there must be a more elegant solution for filtering jpeg files...
              if (file.getFileName().toString().endsWith("jpg")) {
                files.add(file);
              }
            }
            return FileVisitResult.CONTINUE;
          }
        });
      } catch (IOException e) {
        e.printStackTrace();
      }
      Collections.sort(files, new Comparator() {
        @Override
        public int compare(Object fileOne, Object fileTwo) {
          String filename1 = ((Path) fileOne).getFileName().toString();
          String filename2 = ((Path) fileTwo).getFileName().toString();

          if (cmd.hasOption("sortnum")) {
            Integer number1 = Integer.parseInt(filename1.substring(0, filename1.lastIndexOf(".")));
            Integer number2 = Integer.parseInt(filename2.substring(0, filename2.lastIndexOf(".")));
            return number1.compareTo(number2);
          } else {
            return filename1.compareToIgnoreCase(filename2);
          }
        }
      });

      generateManifest(imageDirectory.getFileName().toString(), files);
    } else {
      // automatically generate the help statement
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp("ManifestGenerator", options);
    }
  }

  private static void generateManifest(final String imageDirectoryName, final List<Path> files)
          throws JsonProcessingException, IOException {
    // Start Manifest
    String urlPrefix = "http://www.alexandria.de/beta/demo/bookreader/";
    Manifest manifest = new Manifest(urlPrefix + imageDirectoryName + "/manifest.json", "Walters MS 168");

    List<Sequence> sequences = new ArrayList<>();
    manifest.setSequences(sequences);

    Sequence seq1 = new Sequence("Current page order");
    seq1.setId(urlPrefix + imageDirectoryName + "/sequence/normal");
    sequences.add(seq1);

    List<Canvas> canvases = new ArrayList<>();
    seq1.setCanvases(canvases);

    int i = 0;
    for (Path file : files) {
      i = i + 1;
      addPage(urlPrefix, imageDirectoryName, canvases, i, file);
    }

    ManifestGenerator mg = new ManifestGenerator();
    String json = mg.generateJson(manifest);
    System.out.println(json);
  }

  private static void addPage(String urlPrefix, String imageDirectoryName, List<Canvas> canvases, int pageCounter, Path file)
          throws IOException {
    Path fileName = file.getFileName();
    System.out.println(fileName.toAbsolutePath());

    BufferedImage bimg = ImageIO.read(file.toFile());
    int width = bimg.getWidth();
    int height = bimg.getHeight();

    // add a new page
    Canvas canvas1 = new Canvas(urlPrefix + imageDirectoryName + "/canvas/canvas-" + pageCounter, "p-" + pageCounter, height, width);
    canvases.add(canvas1);

    List<Image> images = new ArrayList<>();
    canvas1.setImages(images);

    Image image1 = new Image();
    image1.setOn(canvas1.getId());
    images.add(image1);

    ImageResource imageResource1 = new ImageResource(urlPrefix + imageDirectoryName + "/" + fileName.
            toString());
    imageResource1.setHeight(height);
    imageResource1.setWidth(width);
    image1.setResource(imageResource1);

    Service service1 = new Service(urlPrefix + imageDirectoryName + "/" + fileName.toString() + "?");
    service1.setContext("http://iiif.io/api/image/2/context.json");
    service1.setProfile("http://iiif.io/api/image/2/level1.json");
    imageResource1.setService(service1);
  }

  public ManifestGenerator() {
  }

  public String generateJson(Manifest manifest) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();

    mapper.addMixIn(AbstractIiifResource.class, AbstractIiifResourceMixIn.class);
    mapper.addMixIn(Canvas.class, CanvasMixIn.class);
    mapper.addMixIn(Image.class, AbstractIiifResourceMixIn.class);
    mapper.addMixIn(Manifest.class, ManifestMixIn.class);
    mapper.addMixIn(MetadataLocalizedValue.class, MetadataLocalizedValueMixIn.class);
    mapper.addMixIn(Resource.class, AbstractIiifResourceMixIn.class);
    mapper.addMixIn(Service.class, ServiceMixIn.class);

    mapper.setSerializationInclusion(Include.NON_NULL);
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(manifest);
    return json;
  }
}
