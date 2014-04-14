package com.capstone.fbvol.common.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;


public class ImageUtil {
    private Image inImage;
	private String thumb;
	private int maxX;
    private int maxY;
    private int margin;

	public ImageUtil(){}
	/**
	 * Method Thumbnailer.
	 * @param orig
	 * @param thumb
	 * @param xx
	 * @param yy
	 */
    // ����
    public ImageUtil(String orig, String thumb, int xx, int yy) {
        initLocal(orig, thumb, xx, yy, 0);
    }

	/**
	 * Method Thumbnailer.
	 * @param remotePath
	 * @param thumb
	 * @param xx
	 * @param yy
	 */
    // ����̹��� ����
    public ImageUtil(URL remotePath, String thumb, int xx, int yy) {
        initRemote(remotePath, thumb, xx, yy, 0);
    }

	/**
	 * Method Thumbnailer.
	 * @param orig
	 * @param thumb
	 * @param xx
	 * @param yy
	 * @param margin
	 */
    // ����
    public ImageUtil(String orig, String thumb, int xx, int yy, int margin) {
        initLocal(orig, thumb, xx, yy, margin);
    }

	/**
	 * Method Thumbnailer.
	 * @param remotePath
	 * @param thumb
	 * @param xx
	 * @param yy
	 * @param margin
	 */
    // ����̹��� ����
    public ImageUtil(URL remotePath, String thumb, int xx, int yy, int margin) {
        initRemote(remotePath, thumb, xx, yy, margin);
    }
	
	//ġ�� �� ����
	public void setResize(String thumb, int xx, int yy) {
        this.thumb = thumb;
		this.maxX = xx;
        this.maxY = yy;
    }

	/**
	 * Method initLocal.
	 * @param orig
	 * @param thumb
	 * @param xx
	 * @param yy
	 * @param margin
	 */
    private void initLocal(String orig, String thumb, int xx, int yy, int margin) {
        this.inImage = new ImageIcon(orig).getImage();
        this.thumb = thumb;
        this.maxX = xx;
        this.maxY = yy;
        this.margin = margin;
    }

	/**
	 * Method initRemote.
	 * @param remotePath
	 * @param thumb
	 * @param xx
	 * @param yy
	 * @param margin
	 */
    private void initRemote(URL remotePath, String thumb, int xx, int yy, int margin) {
        this.inImage = new ImageIcon(remotePath).getImage();
        this.thumb = thumb;
        this.maxX = xx;
        this.maxY = yy;
        this.margin = margin;
    }

	// ���� �̹����� �����.
	public boolean exec() {
		try {
			long stime =System.currentTimeMillis();
						// Get the image from a file.
			long midtime = System.currentTimeMillis();
			System.out.println("loaded:"+(midtime-stime));
			// Determine the scale.
            double scaleX = (double) (maxX - margin * 2) / inImage.getWidth(null);
            double scaleY = (double) (maxY - margin * 2) / inImage.getHeight(null);
            double scale = scaleX;
			if (scaleX > scaleY) {
				scale = scaleY;
			}

			// Determine size of new image.
			//One of them
			// should equal maxDim.
			int scaledW = (int) (scale * inImage.getWidth(null));
			int scaledH = (int) (scale * inImage.getHeight(null));

            // Create an image buffer in
			//which to paint on.
			BufferedImage outImage =
				new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_RGB);

			// Set the scale.
			AffineTransform tx = new AffineTransform();

			// If the image is smaller than
			//the desired image size,
			// don't bother scaling.
			// if (scale < 1.0d) {
				tx.scale(scale, scale);
			// }
            AffineTransform toCenterAt = new AffineTransform();
            int startx = (maxX - scaledW) / 2 ;
            int starty = (maxY - scaledH) / 2 ;
            toCenterAt.translate(startx, starty);
            toCenterAt.concatenate(tx);

            // Paint image.
			Graphics2D g2d = outImage.createGraphics();
            RenderingHints qualityHints;
			qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		    g2d.setRenderingHints(qualityHints);
            g2d.fillRect(0,0,maxX,maxY);
			g2d.drawImage(inImage, toCenterAt, null);
			g2d.dispose();

			// JPEG-encode the image
			//and write to file.
			OutputStream os = new FileOutputStream(thumb);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
			/*
			 * JPEGEncodeParam  param = encoder.getDefaultJPEGEncodeParam(outImage);
	         * float quality = 10/100.0f;
             * param.setQuality(quality, false);
			 */
			JPEGEncodeParam  param = encoder.getDefaultJPEGEncodeParam(outImage);
			float quality = 1.00000f;
			param.setQuality(quality, true);

 			encoder.encode(outImage);
			os.close();
			System.out.println("finished:"+(System.currentTimeMillis()-midtime));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
