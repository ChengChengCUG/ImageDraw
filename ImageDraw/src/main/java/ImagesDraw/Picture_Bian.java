package ImagesDraw;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class Picture_Bian {

    private String URL ;
    private int DOWNLOAD_PAGE_NUM;

    public Picture_Bian(String URL, int IMG_NUM) {
        this.URL = URL;
        this.DOWNLOAD_PAGE_NUM = IMG_NUM;
    }
    //存放每张照片页面的index
    private ArrayList<String> indexs = new ArrayList<>();
    //进入每一个照片的页面，分析网页内容获取下载链接
    private ArrayList<String> Download_links = new ArrayList<>();

    public ArrayList init() {
        try {
            //总共下载多少页
            for (int i = 1; i <= DOWNLOAD_PAGE_NUM; i++) {
                String URl;
                //1.首先请求一个page的页面
                if(i==1){
                    //index为1的页面就是原页面
                    URl = URL;
                }else {
                    //index不为1的页面要对链接进行拼接
                    URl = URL+"/index_" + i + ".html";
                }
                Connection connection = Jsoup.connect(URl)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
                        .timeout(10 * 1000) // 设置超时时间，单位毫秒
                        .ignoreContentType(true) // 忽略内容类型，可选设置
                        .ignoreHttpErrors(true); // 忽略HTTP错误，可选设置
                Document document = connection.get();

                //2.对每一个页面的照片获取ID
                Elements ImgPages_ID = document.select("div.slist ul.clearfix li a");

                //获取每张照片的页面URL
                for (Element imgpage : ImgPages_ID) {

                    String img_href = imgpage.attr("href");
                    if (!img_href.isEmpty()) {
                        //获取到的链接非空就加入数组
                        indexs.add("https://pic.netbian.com" + img_href);//需要拼接链接
                    }
                }

                for (String href : indexs) {
                    Connection connection_1 = Jsoup.connect(href)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
                            .timeout(10 * 1000) // 设置超时时间，单位毫秒
                            .ignoreContentType(true) // 忽略内容类型，可选设置
                            .ignoreHttpErrors(true); // 忽略HTTP错误，可选设置
                    Document document_1 = connection_1.get();
                    // 获取页面源码的img标签的src值，
                    Element Img_src = document_1.select("div.photo-pic img").first();
                    String img_download = Img_src.attr("src");
                    //拼接地址，得到下载地址
                    if (!img_download.isEmpty()) {
                        //获取到的链接非空就加入数组
                        Download_links.add("https://pic.netbian.com" + img_download);//需要拼接链接
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Download_links;
    }
}
