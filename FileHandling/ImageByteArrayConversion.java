import java.io.*;

public class ImageByteArrayConversion {

    public static void main(String[] args) {
        String sourceImagePath = "original_image.jpg";
        String targetImagePath = "copied_image.jpg";

        try {
            // Step 1: Read original image into byte array using ByteArrayOutputStream
            FileInputStream fis = new FileInputStream(sourceImagePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            fis.close();

            byte[] imageBytes = baos.toByteArray();

            // Step 2: Write byte array to new image using ByteArrayInputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(targetImagePath);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();

            System.out.println("Image successfully copied from " + sourceImagePath + " to " + targetImagePath);

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
