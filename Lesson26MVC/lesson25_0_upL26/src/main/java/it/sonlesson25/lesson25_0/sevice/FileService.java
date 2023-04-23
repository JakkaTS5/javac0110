package it.sonlesson25.lesson25_0.sevice;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    //add file upload folder
    private Path root = Paths.get("upload");

    public void saveFile(MultipartFile file) {
        //get FileName
        String fileName = file.getOriginalFilename();
        //ex : D\\java\\upload + fileName
        try {
            Files.copy(file.getInputStream(), this.root.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);//overide file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Resource downloadFile(String fileName) {//Resource Springframework
        Path file = this.root.resolve(fileName);
        //tao the hien resource tu class URL resource
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
