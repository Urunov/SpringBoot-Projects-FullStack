package com.urunov.profile;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Service
public class UserProfileService {

    @Autowired
    AmazonS3 amazonS3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    private String subFolder = "";

    @Autowired
    UserProfileDataAccessService userProfileDataAccessService;

    List<UserProfile> getUserProfiles(){
        return userProfileDataAccessService.getUserProfile();
    }

    @Async
    void uploadUserProfileImage(String userProfileId, MultipartFile multipartFile) throws Exception {

            final File file = convertMultiPartFileToFile(multipartFile);

            String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

            uploadFileToS3Bucket(bucketName, file, extension);
            file.delete();

        }

        private void uploadFileToS3Bucket(final String bucketName, final File file, String filename) {
            final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filename, file);
            amazonS3Client.putObject(putObjectRequest);
        }

        private File convertMultiPartFileToFile(final MultipartFile multipartFile) throws Exception{
            final File file = new File(multipartFile.getOriginalFilename());
            try (final FileOutputStream outputStream = new FileOutputStream(file)) {
                outputStream.write(multipartFile.getBytes());
            } catch (final IOException ex) {

            }
            return file;
        }
    }


