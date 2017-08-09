package web.midas.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.QRCode;

/**
 * Servlet implementation class QRCodeServlet
 */
public class QRCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QRCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String qrtext = new String(request.getParameter("qrtext").getBytes("utf-8"), "ISO-8859-1") ;
		
		String linename = new String(request.getParameter("qrtext").getBytes("ISO-8859-1"),"UTF-8");
		
		String linename2 = new String(request.getParameter("qrtext").getBytes("GBK"),"UTF-8");
		
		getqcode(response,qrtext);
		/*
		QRCode dd = new QRCode();
		 
        ByteArrayOutputStream out =   (qrtext).to(ImageType.PNG).stream();
 
        response.setContentType("image/png");
        response.setContentLength(out.size());
 
        OutputStream outStream = response.getOutputStream();
 
        outStream.write(out.toByteArray());
 
        outStream.flush();
        outStream.close();
        */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//@RequestMapping(value = "/getQ", method = { RequestMethod.POST, RequestMethod.GET })
    public void getqcode(HttpServletResponse resp, String id) throws IOException {
        String url = id;
        if (url != null && !"".equals(url)) {
            ServletOutputStream stream = null;
            try {

                int width = 200;//图片的宽度
                int height = 200;//高度
                stream = resp.getOutputStream();
                QRCodeWriter writer = new QRCodeWriter();
                BitMatrix m = writer.encode(url, BarcodeFormat.QR_CODE, height, width);
                MatrixToImageWriter.writeToStream(m, "png", stream);
            } catch (WriterException e) {
                e.printStackTrace();
            } finally {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            }
        }
    }

}
