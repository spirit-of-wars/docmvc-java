package docmvc.utils;

import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.Socket;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileOperations {
    private static final int KB_SIZE = 1024;
    private static final int DEFAULT_DOWNLOAD_RATE = 2000;

    /**
     * Copy file to new folder from property saveFilePath
     */
    public static void copyFile(String filePath, String newFilePath) {
        File newFileObj = new File(newFilePath);
        File prevFileObj = new File(filePath);
        String newDir = newFileObj.getParent();
        File newDirFileObj = new File(newDir);

        if (!newDirFileObj.isDirectory()) {
            //todo exception
//            throw new FileNotExistedException(sprintf("Directory '%s' is not existed", $newDir));
        }

        if (!newDirFileObj.canWrite()) {
            //todo exception
            //throw new DirectoryPermissionException(sprintf("Directory '%s' not allowed for writable", $newDir));
        }

        if (!prevFileObj.isFile()) {
            //todo exception
//            throw new FileNotExistedException(sprintf("Origin file '%s' is not existed", $filePath));
        }

        try {
            Files.copy(prevFileObj.toPath(), newFileObj.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException exception) {
            //todo exception
//            throw new FileOperationException(sprintf("File '%s' copying error", $newFilePath));
        }
    }

    /**
     * Remove file from filePath
     */
    public static void removeFile(String filePath)
    {
        File fileObj = new File(filePath);
        if (!fileObj.isFile()) {
            //todo exception
//            throw new FileNotExistedException(sprintf("File '%s' is not existed", $filePath));
        }

        if (!fileObj.delete()) {
            //todo exception
//            throw new FileOperationException("File removing error", $filePath);
        }
    }

    public static void downloadFileBySocket(String filePath, Socket socket, int downloadRate) throws IOException {
        downloadByStreamFile(filePath, socket.getOutputStream(), downloadRate);
    }

    public static void downloadFileByHttp(String filePath, HttpExchange httpExchange, int downloadRate)
    {
        downloadByStreamFile(filePath, httpExchange.getResponseBody(), downloadRate);
    }

    private static void downloadByStreamFile(String filePath, OutputStream outputStream, int downloadRate) {
        FileInputStream fis;
        BufferedInputStream bis;
        BufferedOutputStream out;
        byte[] buffer = new byte[8 * KB_SIZE];
        try {
            File file = new File(filePath);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            out = new BufferedOutputStream(outputStream);
            int count;
            while ((count = bis.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
            out.close();
            fis.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
            //todo exception
//            throw new FileOperationException("File '%s' stream downloading error", $filePath);
        }
    }
}
