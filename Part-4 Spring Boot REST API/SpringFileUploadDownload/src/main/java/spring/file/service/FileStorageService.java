package spring.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import spring.file.exception.FileNotFoundException;
import spring.file.exception.FileStorageException;
import spring.file.property.FileStorageProperties;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @Created 06 / 04 / 2020 - 2:46 PM
 * @project SpringFileUpDown
 * @Author Hamdamboy
 */

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties){
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();


    try{
        Files.createDirectories(this.fileStorageLocation);
    } catch(Exception ex) {
        throw new FileStorageException("Cloud not create the directory where the upload file will ", ex);
    }
}
    public String storeFile(MultipartFile file){
        // Normalize file name

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequense " + fileName);
            }

            //Copy file to the target location (Replacing existing file with the same name_)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException e){
            throw new FileStorageException("Could not store file " + fileName + ". Please try again. ", e);

        }
    }

    public Resource loadFileAsResource(String fileName){

        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found" + fileName);
            }
        } catch (MalformedURLException ex) {

            throw new FileNotFoundException("File not found " + fileName, ex);

        }
    }
}
