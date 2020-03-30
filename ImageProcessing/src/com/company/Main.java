package com.company;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.awt.*;
import java.io.File;

public class Main {

    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for (Pixel pixel: outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            int average = (inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3;
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        }
        return outImage;
    }

    public void selectAndConvert(){
        DirectoryResource directoryResource = new DirectoryResource();
        for (File f: directoryResource.selectedFiles()) {

            ImageResource inFile = new ImageResource(f);
            String oldFileName = inFile.getFileName();
            String newFileName = "gray-"+oldFileName;

            ImageResource grayImage = makeGray(inFile);
            grayImage.setFileName(newFileName);
            grayImage.draw();
            grayImage.save();
        }
    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.selectAndConvert();
    }
}
