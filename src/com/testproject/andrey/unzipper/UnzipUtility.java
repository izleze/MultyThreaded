package com.testproject.andrey.unzipper;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipUtility {
    /**
     * Size of the buffer to read/write data
     */
    private static final long BUFFER_SIZE = Runtime.getRuntime().maxMemory() / 2;

    public static void unzipPathAndDest() {
        String dest = "data";
        File destDir = new File(dest);
        if (!destDir.exists()) {
            try {
                UnzipUtility.unzip(dest);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     * @param destDirectory
     * @throws IOException
     */
    private static void unzip(String destDirectory) throws IOException {
        File dir = new File("zippedData");
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        FileOutputStream fos = new FileOutputStream(new File(
                destDirectory + "/data.zip"));
        FileInputStream fis = null;

        Set<String> files = new TreeSet<>();
        for (String fname : dir.list()) {
            files.add(fname);
        }

        for (String fname : files) {
            try {
                fis = new FileInputStream(new File(dir.getAbsolutePath(), fname));
                byte[] b = new byte[fis.available()];
                fis.read(b);
                fos.write(b);
            } finally {
                if (fis != null) {
                    fis.close();
                }
                fos.flush();
            }
        }
        fos.close();

        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(destDirectory + "/data.zip"));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File directory = new File(filePath);
                directory.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[(int) BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}