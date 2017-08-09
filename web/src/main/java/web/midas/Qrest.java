package web.midas;

import java.io.IOException;

import com.google.zxing.WriterException;

public class Qrest {

    public static void main(String[] args) {

       String content="大家好，我是李庆文，很高兴认识大家";
       String logUri="/Users/huanghuang/Midas/eclipse-workspace/ecplise-maven/web/img/0.png";
       String outFileUri="/Users/huanghuang/Midas/eclipse-workspace/ecplise-maven/web/img/";
       String outFileUri2=outFileUri;
       int[]  size=new int[]{100,100};
       String format = "jpg";  

       try {
    	   
    	   for(int i = 1;i<200;i++) {
    		   outFileUri += i+".jpg";
    		   new QRCodeFactory().CreatQrImage(content, format, outFileUri, logUri,size);
    		   outFileUri = outFileUri2;
    	   }
    	  
        
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (WriterException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }   
  }

}