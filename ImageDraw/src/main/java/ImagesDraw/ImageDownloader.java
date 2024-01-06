package ImagesDraw;

import ui.mainGUI;
import ImagesDraw.app;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

// 图片下载器类，实现了 Runnable 接口
public class ImageDownloader implements Runnable {
    private String imageUrl;
    private int id;

    // 构造函数
    public ImageDownloader(String imageUrl, int id) {
        this.imageUrl = imageUrl;
        this.id = id;
    }

    // 实现 Runnable 接口的 run 方法
    @Override
    public void run() {
        try {
            // 打开图片链接并获取输入流
            URL target = new URL(imageUrl);
            URLConnection urlConnection = target.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            // 创建文件输出流
            OutputStream fileOutputStream = new FileOutputStream(
                    app.SAVE_PATH+ File.separator+ id + ".jpg");

            // 读取输入流并写入输出流
            int temp;
            while ((temp = inputStream.read()) != -1) {
                fileOutputStream.write(temp);
            }

            // 输出下载完成信息
            mainGUI.detail_input.append("------"+Thread.currentThread().getName()+"线程下载："+id + ".jpg 下载完成！"+"------"+"\n");
            fileOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
