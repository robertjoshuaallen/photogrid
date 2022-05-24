/*
Copyright 2021 under the MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package tech.rallen.photogrid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) throws Exception {

        String path;
        if (args != null && args.length > 0) {
            path = args[0];
        } else {
            path = "./testimages";
        }
        int outputImageWidth;
        if (args != null && args.length > 1) {
            outputImageWidth = Integer.parseInt(args[1]);
        } else {
            outputImageWidth = 1000;
        }
        int outputImageHeight;
        if (args != null && args.length > 2) {
            outputImageHeight = Integer.parseInt(args[2]);
        } else {
            outputImageHeight = 1000;
        }

        File[] files = (new File(path)).listFiles();

        int numFiles = files.length;

        int numFilesPerRow;
        int numFilesPerColumn;

        if (args != null && args.length > 4) {
            numFilesPerRow = Integer.parseInt(args[3]);
            numFilesPerColumn = Integer.parseInt(args[4]);
        } else {
            numFilesPerRow = (int) Math.round(0.5f + Math.sqrt(numFiles));
            numFilesPerColumn = (int) Math.round(0.5f + Math.sqrt(numFiles));
        }

        String outputPathAndFilename;
        if (args != null && args.length > 5) {
            outputPathAndFilename = args[5];
        } else {
            outputPathAndFilename = "2print";
        }

        BufferedImage comboImage = new BufferedImage(outputImageWidth * numFilesPerRow, outputImageHeight * numFilesPerColumn, BufferedImage.TYPE_INT_ARGB);
        Graphics g = comboImage.getGraphics();
        Graphics2D g2 = (Graphics2D) g;

        int xpos = 0;
        int ypos = 0;
        int imageNum = 0;
        for (File f : files) {
            try {
                BufferedImage img = ImageIO.read(new FileInputStream(f));

                float scale = ((float) outputImageWidth) / img.getWidth();
                float scaleY = ((float) outputImageHeight) / img.getHeight();
                if (scaleY < scale) {
                    scale = scaleY;
                }
                AffineTransform scaleInstance = AffineTransform.getScaleInstance(scale, scale);
                AffineTransformOp scaleOp = new AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_BICUBIC);

                g2.drawImage(img, scaleOp, (xpos * outputImageWidth), (ypos * outputImageHeight));
                xpos++;
                if (xpos >= numFilesPerRow) {
                    xpos = 0;
                    ypos++;
                    if (ypos >= numFilesPerColumn) {
                        ImageIO.write(comboImage, "PNG", new File(outputPathAndFilename + imageNum + ".png"));
                        imageNum++;
                        g.dispose();
                        comboImage = new BufferedImage(outputImageWidth * numFilesPerRow, outputImageHeight * numFilesPerRow, BufferedImage.TYPE_INT_ARGB);
                        g = comboImage.getGraphics();
                        g2 = (Graphics2D) g;
                        ypos = 0;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        ImageIO.write(comboImage, "PNG", new File(outputPathAndFilename + imageNum + ".png"));
        g.dispose();

    }
}
