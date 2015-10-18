/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

/**
 * @Author Kamal Wickramanayake
 */
@ManagedBean(name = "uploadFormController")
@RequestScoped
public class UploadController {

    // The upload directory
    private String uploadPath = "/tmp/uploads/";

    // Uploaded files will be saved with a file name containing the following prefix
    // and suffix.
    private String uploadFilePrefix = "upload-";
    private String uploadFileSuffix = "";

    // Set to true if upload is successful
    private boolean uploadSuccessful = false;
    // After processing form submission, set this to true to reset the form.
    private boolean resetForm = false;
    // Holds a message that will be displayed in the browser after form submission
    // is processed.
    private String statusMessage = "";

    // Upload button triggers this method
    public String upload() {

        HttpServletRequest httpRequest = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        // Access the uploaded file from the HTTPServletRequest
        Object fileObject = httpRequest.getAttribute("uploadFile");

        if (fileObject == null) {
            // No file uploaded.
            statusMessage = "No file has been uploaded.";
            resetForm = false;
            uploadSuccessful = false;

        } else if (fileObject instanceof FileUploadException) {
            // File upload failed.
            FileUploadException fileUploadException = (FileUploadException) fileObject;
            statusMessage = "File uploading caused an error: " + fileUploadException.getMessage();
            resetForm = false;
            uploadSuccessful = false;
        } else {
            FileItem fileItem = (FileItem) fileObject;

            try {
                File uploadDir = new File(uploadPath);
                uploadDir.mkdir();

                // If the saved file name should be based on upload file name, use fileName as accessed below to
                // set the uploadFilePrefix
                // String fileName = FilenameUtils.getName(fileItem.getName());
                // uploadFilePrefix = fileName;
                // Create a unique file name
                File file = File.createTempFile(uploadFilePrefix, uploadFileSuffix, uploadDir);

                // Write the file
                fileItem.write(file);

                statusMessage = "File upload successful.";
                resetForm = true;
                uploadSuccessful = true;
            } catch (Exception e) {
                statusMessage = "File uploading caused an error: " + e.getMessage();
                resetForm = false;
                uploadSuccessful = false;
            }

        }

        // We want this specific html page containing JavaScript code to go
        // to the target iframe
        return "index_response";
    }

    public boolean isUploadSuccessful() {
        return uploadSuccessful;
    }

    public void setUploadSuccessful(boolean uploadSuccessful) {
        this.uploadSuccessful = uploadSuccessful;
    }

    public boolean isResetForm() {
        return resetForm;
    }

    public void setResetForm(boolean resetForm) {
        this.resetForm = resetForm;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFilePrefix() {
        return uploadFilePrefix;
    }

    public void setUploadFilePrefix(String uploadFilePrefix) {
        this.uploadFilePrefix = uploadFilePrefix;
    }

    public String getUploadFileSuffix() {
        return uploadFileSuffix;
    }

    public void setUploadFileSuffix(String uploadFileSuffix) {
        this.uploadFileSuffix = uploadFileSuffix;
    }

}
