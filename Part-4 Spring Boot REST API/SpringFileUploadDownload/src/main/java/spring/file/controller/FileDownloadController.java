package spring.file.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.file.service.FileStorageService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Created 06 / 04 / 2020 - 2:42 PM
 * @project SpringFileUpDown
 * @Author Hamdamboy
 */

@RestController
public class FileDownloadController {
    //
    private static final Logger logger= LoggerFactory.getLogger(FileDownloadController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/downloadFile/{fileName::.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        //Load file as Resource

        Resource resource = fileStorageService.loadFileAsResource(fileName);

        //Try to determine file's content type
        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex){
            logger.info("Could not determine file type.");
        }

        //Fallback to the default content if type cloud not be determined
        if(contentType==null){
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
