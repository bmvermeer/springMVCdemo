package nl.brianvermeer.snyk.springmvc.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;


public class FileDisplay {

    public String name;
    public String type = "unknown";
    public String date = "unknown";
    public String size = "unknown";
    public boolean directory = false;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getSize() {
        return size;
    }

    public boolean isDirectory() {
        return directory;
    }

    public static FileDisplay fromFile(File file) {
        var display = new FileDisplay();
        display.name = file.getName();

        try {
            display.type = Files.probeContentType(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            var attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            display.date = attributes.creationTime().toString();
            display.size = String.valueOf(attributes.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        display.directory = file.isDirectory();

        return display;
    }
}
