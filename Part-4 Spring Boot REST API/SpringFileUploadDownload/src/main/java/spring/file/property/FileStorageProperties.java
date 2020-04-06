package spring.file.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Created 06 / 04 / 2020 - 2:30 PM
 * @project SpringFileUpDown
 * @Author Hamdamboy
 */

@Component
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    //
    private String uploadDir;

    public String getUploadDir(){
        return uploadDir;
    }

    public void setUploadDir(String uploadDir){
        this.uploadDir = uploadDir;
    }
}
