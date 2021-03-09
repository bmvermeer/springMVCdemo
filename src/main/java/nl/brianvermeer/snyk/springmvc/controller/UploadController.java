package nl.brianvermeer.snyk.springmvc.controller;

import nl.brianvermeer.snyk.springmvc.controller.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UploadController {

    public static final String UPLOADED_FOLDER = "upload/";

    @RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
    public String displayForm() {
        return "fileUploadForm";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(HttpServletResponse response, @RequestParam("file") MultipartFile file, ModelMap modelMap, @CookieValue(value="userId", required=false) String userID) {
        createUploadFolder();
        if (userID == null) {
            userID = CookieUtil.createUserCookie(response);
        }

        if (file.isEmpty()) {
            return "fileUploadView";
        }

        try {

            byte[] bytes = file.getBytes();
            if(file.getContentType().equals("application/zip")) { //unzip
                System.out.println("ZIPFILE");
                unzip(bytes, UPLOADED_FOLDER);
                System.out.println("File upload: " + file.getOriginalFilename() + " and unzipped by user: " +userID);
            } else { //upload
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                System.out.println("File upload: " + file.getOriginalFilename() + " by user: " +userID);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        modelMap.addAttribute("file", file);
        return "fileUploadView";
    }

    private static void unzip(byte[] bytes, String destDir) {
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(bytes));
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createUploadFolder() {
        File directory = new File(UPLOADED_FOLDER);
        if (! directory.exists()){
            directory.mkdir();
        }
    }



}
