package ImagesDraw;

import ui.mainGUI;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class app {

    //主页面的设置参数的接受
    private String URL;
    public static String SAVE_PATH = "";
    private int THREAD_NUM;
    private int DOWNLOAD_PAGE_NUM;
    public static List<String> imageUrls = new ArrayList<>();

    public app(String URL, String SAVE_PATH, int THREAD_NUM, int DOWNLOAD_PAGE_NUM) {
        this.URL = URL;
        this.SAVE_PATH = SAVE_PATH;
        this.THREAD_NUM = THREAD_NUM;
        this.DOWNLOAD_PAGE_NUM = DOWNLOAD_PAGE_NUM;
    }

    public void Draw() {
        SwingWorker<ArrayList<String>, Void> worker = new SwingWorker<>() {
            @Override
            protected ArrayList<String> doInBackground() {
                mainGUI.detail_input.append("----- 网页源码解析中...... ------");
                return new Picture_Bian(URL, DOWNLOAD_PAGE_NUM).init();
            }

            @Override
            protected void done() {
                try {
                    mainGUI.detail_input.append("-----网页源码解析完成！------"+"\n"+"------ 开始多线程下载任务 ------"+"\n");
                    // get()方法获取doInBackground()方法返回的结果
                    ArrayList<String> imageUrls = get();
                    // 设置多线程
                    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);
                    for (int i = 1; i < imageUrls.size(); i++) {
                        Runnable task = new ImageDownloader(imageUrls.get(i), i);
                        executorService.execute(task);
                    }
                    executorService.shutdown();
                    while (!executorService.isTerminated()) {
                        // 等待所有任务完成
                    }
                    mainGUI.detail_input.append("All images downloaded successfully！！"
                            + "\n"+"-----一共" + imageUrls.size() + "张图片----"+"\n" );
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };
        worker.execute();
    }


}
