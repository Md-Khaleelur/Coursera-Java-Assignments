package com.company;
//question link - https://www.coursera.org/learn/java-programming/supplement/X0D39/programming-exercise-batch-grayscale-and-image-inversion
import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;
import java.io.File;


public class InvertedImage {

        public ImageResource makeInverted(ImageResource inImage){
            ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
            for (Pixel pixel: outImage.pixels()) {

                Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
                pixel.setRed(255-inPixel.getRed());
                pixel.setBlue(255-inPixel.getBlue());
                pixel.setGreen(255-inPixel.getGreen());

            }
            return outImage;
        }

        public void selectAndConvert(){
            DirectoryResource directoryResource = new DirectoryResource();
            for (File f: directoryResource.selectedFiles()) {

                ImageResource inFile = new ImageResource(f);
                String oldFileName = inFile.getFileName();
                String newFileName = "inverted-"+oldFileName;

                ImageResource grayImage = makeInverted(inFile);
                grayImage.setFileName(newFileName);
                grayImage.draw();
                grayImage.save();
            }
        }

        public static void main(String[] args) {
            // write your code here
            InvertedImage  invertedImage = new InvertedImage();
            invertedImage.selectAndConvert();
        }
    }


