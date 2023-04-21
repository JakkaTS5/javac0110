package it.sonlesson25.lesson25_0.sevice;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    private Path root = Paths.get("upload");
    public void saveFile(MultipartFile file){
        //get FileName
        String fileName = file.getOriginalFilename();
        //ex : D\\java\\upload + fileName
        try {
            Files.copy(file.getInputStream(),this.root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
