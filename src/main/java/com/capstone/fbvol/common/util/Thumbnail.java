/* 
 * Thumbnail.java (requires Java 1.2+) 
 */ 
package com.capstone.fbvol.common.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Thumbnail { 
	public static boolean exec(String inFile,String outFile,String nailWidth,String nailHeight,String nailQuality)
	{
		try{
			// load image from INFILE 
			Image image = Toolkit.getDefaultToolkit().getImage(inFile); 
			MediaTracker mediaTracker = new MediaTracker(new Container()); 
			mediaTracker.addImage(image, 0); 
			mediaTracker.waitForID(0); 
			// determine thumbnail size from WIDTH and HEIGHT 
			int thumbWidth = image.getWidth(null);
			int thumbHeight = image.getHeight(null);
			int nailWidth1 = Integer.parseInt(nailWidth);
			int nailHeight1 = Integer.parseInt(nailHeight);
			double thumbRatio = (double)thumbWidth / (double)thumbHeight; 			
			while(thumbWidth > nailWidth1 || thumbHeight > nailHeight1){
				thumbWidth  = (int)(thumbWidth * 0.9);
				thumbHeight = (int)(thumbHeight * 0.9);
			}

			if(thumbWidth==0 || thumbHeight==0){
				thumbWidth=100;
				thumbHeight=100;
			}
			
			BufferedImage thumbImage = new BufferedImage(thumbWidth,  
			  thumbHeight, BufferedImage.TYPE_INT_RGB); 
			Graphics2D graphics2D = thumbImage.createGraphics(); 
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
			  RenderingHints.VALUE_INTERPOLATION_BILINEAR); 
			graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null); 
			// save thumbnail image to OUTFILE 
			BufferedOutputStream out = new BufferedOutputStream(new 
			  FileOutputStream(outFile)); 
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
			JPEGEncodeParam param = encoder. 
			  getDefaultJPEGEncodeParam(thumbImage); 
			int quality = Integer.parseInt(nailQuality); 
			quality = Math.max(0, Math.min(quality, 100)); 
			param.setQuality((float)quality / 100.0f, false); 
			encoder.setJPEGEncodeParam(param); 
			encoder.encode(thumbImage); 
			//System.out.println("Done."); 
			return true;
		}catch(Exception e){
			return false;
		}finally{
			
		}
  } 


  public static boolean exec(String inFile, String nailWidth, String nailHeight, String nailQuality)
	{
		String outFile="";

		try{	

			String fileExt = inFile.substring(inFile.lastIndexOf("."),inFile.length());
			String fileNam = inFile.substring(0,inFile.lastIndexOf("."));
			outFile = fileNam +"_"+fileExt;
			

			// load image from INFILE 
			Image image = Toolkit.getDefaultToolkit().getImage(inFile); 
			MediaTracker mediaTracker = new MediaTracker(new Container()); 
			mediaTracker.addImage(image, 0); 
			mediaTracker.waitForID(0); 
			
			// determine thumbnail size from WIDTH and HEIGHT 
			int thumbWidth = image.getWidth(null);
			int thumbHeight = image.getHeight(null);
			int nailWidth1 = Integer.parseInt(nailWidth);
			int nailHeight1 = Integer.parseInt(nailHeight);


			double thumbRatio = (double)thumbWidth / (double)thumbHeight; 			
			while(thumbWidth > nailWidth1 || thumbHeight > nailHeight1){
				thumbWidth  = (int)(thumbWidth * 0.9);
				thumbHeight = (int)(thumbHeight * 0.9);
			}

			if(thumbWidth==0 || thumbHeight==0){
				thumbWidth=100;
				thumbHeight=100;
			}
			
			BufferedImage thumbImage = new BufferedImage(thumbWidth,  
			  thumbHeight, BufferedImage.TYPE_INT_RGB); 
			Graphics2D graphics2D = thumbImage.createGraphics(); 
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
			  RenderingHints.VALUE_INTERPOLATION_BILINEAR); 
			graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null); 
			// save thumbnail image to OUTFILE 
			BufferedOutputStream out = new BufferedOutputStream(new 
			  FileOutputStream(outFile)); 
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
			JPEGEncodeParam param = encoder. 
			  getDefaultJPEGEncodeParam(thumbImage); 
			int quality = Integer.parseInt(nailQuality); 
			quality = Math.max(0, Math.min(quality, 100)); 
			param.setQuality((float)quality / 100.0f, false); 
			encoder.setJPEGEncodeParam(param); 
			encoder.encode(thumbImage); 
			//System.out.println("Done."); 
			return true;
		}catch(Exception e){
			return false;
		}finally{
			
		}
  } 
}