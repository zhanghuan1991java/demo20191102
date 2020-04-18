package zhanghuan.example.demo20191102.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

/**
 * 网上找的生成二维码，解析二维码案例2
 */
@RestController
public class ZxingController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello,idea Controller";
    }

    @RequestMapping(value = "/qr/{content}/{width}/{height}",method = RequestMethod.GET)
    public String createQRcode(String filePath, @PathVariable String content,@PathVariable int width,@PathVariable int height) throws Exception{
        filePath = "e:";
        //如果文件夹不存在就创建文件夹
        File temp = new File(filePath);
        if (!temp.exists()){
            temp.mkdirs();
        }

        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//设置字符的编码
        hints.put(EncodeHintType.MARGIN, 1);//设置外边距的距离
        BitMatrix bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

        MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(Color.BLACK.getRGB(), Color.WHITE.getRGB());

        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);

        String fileName = UUID.randomUUID() + ".jpg";//随机生成二维码的名称
        ImageIO.write(bufferedImage, "jpg", new File(filePath + File.separator + fileName));//将图片写到磁盘

        return fileName;
    }

    public String analysisQRcode(String path) throws Exception{

        File file = new File(path);
        if (!file.isFile()) return null;//判断该文件是否存在

        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file))));

        HashMap hints = new HashMap();
        hints.put(DecodeHintType.CHARACTER_SET, "utf-8");//设置字符集

        //获取二维码的内容
        String result = new QRCodeReader().decode(bitmap, hints).getText();

        return result;
    }


}
