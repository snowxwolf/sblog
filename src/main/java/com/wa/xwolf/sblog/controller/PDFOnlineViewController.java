package com.wa.xwolf.sblog.controller;


import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
/**
 * pdf 在线预览实现
 * @author xwolf
 * @Date 2015-06-16 09:32
 *
 */
@Controller
@RequestMapping("pdf")
public class PDFOnlineViewController  {
	
	@RequestMapping("/pdfView")
	public void online(HttpServletRequest request,HttpServletResponse response,Writer writer){
		
		//File file =new File("G:\\view.pdf");
		
	}
	
	 private static void changePdfToImg() {  

	        try {  

	        File file = new File("G:\\view.pdf");  

	        RandomAccessFile raf = new RandomAccessFile(file, "r");  

	       FileChannel channel = raf.getChannel();  

	       MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());  
	        PDFFile pdffile = new PDFFile(buf);  

	       for (int i = 1; i <= pdffile.getNumPages(); i++) {  

	        PDFPage page = pdffile.getPage(i);  

	        Rectangle rect = new Rectangle(0, 0, ((int) page.getBBox().getWidth()), ((int) page.getBBox().getHeight()));  

	        Image img = page.getImage(rect.width, rect.height, rect,  

	        null, // null for the ImageObserver  

	        true, // fill background with white  

	        true // block until drawing is done  

	        );  

	        BufferedImage tag = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);  

	       tag.getGraphics().drawImage(img, 0, 0, rect.width, rect.height, null);  


	        FileOutputStream out = new FileOutputStream("G:\\" + i + ".jpg"); // 输出到文件流  

	       JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  

	        JPEGEncodeParam param2 = encoder.getDefaultJPEGEncodeParam(tag);  

	        param2.setQuality(1f, false);// 1f是提高生成的图片质量  

	        encoder.setJPEGEncodeParam(param2);  

	        encoder.encode(tag); // JPEG编码  

	        out.close();  

	        }  

	        channel.close();  

	        raf.close();  

	        unmap(buf);//如果要在转图片之后删除pdf，就必须要这个关闭流和清空缓冲的方法  

	        } catch (FileNotFoundException e) {  

	        e.printStackTrace();  

	        } catch (IOException e) {  

	            e.printStackTrace();  

	        }  

	    }  

	    @SuppressWarnings({ "unchecked", "rawtypes" })
		private static void unmap(final Object buffer) {  

	        AccessController.doPrivileged(new PrivilegedAction() {  

	        public Object run() {  

	        try {  

	        Method getCleanerMethod = buffer.getClass().getMethod("cleaner", new Class[0]);  

	        getCleanerMethod.setAccessible(true);  

	        sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(buffer, new Object[0]);  

	        cleaner.clean();  

	        } catch (Exception e) {  

	        e.printStackTrace();  

	        }  

	        return null;  

	        }  

	        });  

	    }  
	    
	    public static void main(String[] args) {
			
	    	changePdfToImg();
		}

	
}
