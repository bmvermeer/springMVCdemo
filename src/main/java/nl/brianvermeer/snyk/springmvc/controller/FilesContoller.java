package nl.brianvermeer.snyk.springmvc.controller;

import nl.brianvermeer.snyk.springmvc.model.FileDisplay;
import nl.brianvermeer.snyk.springmvc.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FilesContoller {


    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public String displayFiles(Model model, @RequestParam(required = false) String folder) {
        UploadController.createUploadFolder();
        String destination = UploadController.UPLOADED_FOLDER;
        if (folder != null) {
            destination += "/"+folder;
        }
        model.addAttribute("folder", folder);
        model.addAttribute("files", getFileListing(destination));
        return "files";
    }

    private List getFileListing(String folder) {
        var dir = new File(folder);
        var files = dir.listFiles();

        return Arrays.stream(files)
                .map(FileDisplay::fromFile)
                .collect(Collectors.toList());
    }




}
