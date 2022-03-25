package com.alex.imagedemo.controller;

import com.alex.imagedemo.utils.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author jixnLbj
 * @date 2019-11-06 18:35
 * @desc Handler
 **/

public class Handler {

    public final static String BASEPATH = "E:\\workspace\\imageDemo\\src\\main\\resources\\pic\\";

    public static void main(String[] args) throws IOException {
        String file1 = ImageBase64Converter.convertFileToBase64(BASEPATH + "pic2.jpg");
        String file2 = ImageBase64Converter.convertFileToBase64(BASEPATH + "pic3.jpeg");
        boolean equals = file1.equals(file2);
        System.out.println("图片"+(equals ? "相同":"不相同"));

        BufferedImage bi = PicUtil.getPicFromPath(BASEPATH + "zp1645936999.jpg");
        BufferedImage bi2 = PicUtil.getPicFromPath(BASEPATH + "zp1645971821.jpg");
        method1(bi, bi2);
//        ImageIO.write(PicUtil.myGreyful(bi), "jpg", new File(BASEPATH + "pic2_grey.jpg"));
    }

    private static void method1(BufferedImage bi1, BufferedImage bi2) {
        BufferedImage grey1 = PicUtil.greyful(PicUtil.zoomBySize(bi1, 64, 64));
        BufferedImage grey2 = PicUtil.greyful(PicUtil.zoomBySize(bi2, 64, 64));
        byte[] average1 = HashImg.hash(grey1);
        byte[] average2 = HashImg.hash(grey2);
        System.out.println(HashImg.diff(average1, average2));
    }

    private static void method2(BufferedImage bi1, BufferedImage bi2) {
        int[] histogram1 = HistogramImg.getHistogram(bi1);
        int[] histogram2 = HistogramImg.getHistogram(bi2);
        System.out.println(HistogramImg.calculate(histogram1, histogram2));
    }

    private static void method3(BufferedImage bi1, BufferedImage bi2) throws IOException {
        System.out.println(OtsuImg.compare(bi1, bi2));
    }


}
