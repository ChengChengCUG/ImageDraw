package ui;

import ImagesDraw.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class mainGUI {
    JFrame jframe = new JFrame("主窗口");
    JPanel panel = new JPanel(null);
    //设置标签组件
    JLabel url = new JLabel("输入URL", JLabel.LEFT);
    JLabel threadnum = new JLabel("线程数量", JLabel.LEFT);
    JLabel downloadnum = new JLabel("下载页数", JLabel.LEFT);
    JLabel download_detail = new JLabel("下载详情", JLabel.LEFT);
    //设置文本域
    JTextArea url_input = new JTextArea("https://pic.netbian.com",1,40);
    JScrollPane urlScrollPane = new JScrollPane(url_input);
    JTextArea savepath_input = new JTextArea(1,40);
    JScrollPane savepath_input_ScrollPane = new JScrollPane(savepath_input);
    public static JTextArea detail_input = new JTextArea(10,60);
    JScrollPane detail_input_ScrollPane = new JScrollPane(detail_input);
    //设置复选框
    JComboBox<String> threadnum_input = new JComboBox();
    JComboBox<String> downloadnum_input = new JComboBox();

    //设置按钮
    JButton savepath = new JButton("保存路径");
    JButton start = new JButton("开始下载");

    // 创建字体对象，设置字体名称、样式和大小
    Font labelFont = new Font("SansSerif", Font.BOLD, 16); // 设置字体为 SansSerif，普通样式，大小为 18

    public  void init(){

        //组装组件
        panel.add(url);
        panel.add(urlScrollPane);
        panel.add(threadnum);
        for (int i = 1; i <= 16; i++) {
            threadnum_input.addItem(i+"");
        }
        panel.add(threadnum_input);
        panel.add(downloadnum);
        for (int i = 1; i <=40; i++) {
            if(i<=10){
                downloadnum_input.addItem(i+""); }
            else if(i%5==0){
                downloadnum_input.addItem(i+"");
            }
        }
        panel.add(downloadnum_input);
        panel.add(savepath);
        panel.add(savepath_input_ScrollPane);
        panel.add(download_detail);
        panel.add(detail_input_ScrollPane);
        panel.add(start);
        jframe.add(panel);
        // 将字体应用于 JLabel
        url.setFont(labelFont);
        threadnum.setFont(labelFont);
        downloadnum.setFont(labelFont);
        download_detail.setFont(labelFont);
        url_input.setFont(labelFont);
        savepath_input.setFont(labelFont);
        savepath.setFont(labelFont);
        downloadnum_input.setFont(labelFont);
        threadnum_input.setFont(labelFont);
        start.setFont(labelFont);
        detail_input.setFont(labelFont);

        //设置组件位置
        url.setBounds(160,30,80,30);
        urlScrollPane.setBounds(250,30,400,40);
        threadnum.setBounds(160,90,80,30);
        threadnum_input.setBounds(250,90,80,30);
        downloadnum.setBounds(400,90,80,30);
        downloadnum_input.setBounds(480,90,80,30);
        savepath.setBounds(145,150,100,30);
        savepath_input_ScrollPane.setBounds(270,150,370,40);
        download_detail.setBounds(160,200,80,30);
        detail_input_ScrollPane.setBounds(160,240,480,200);
        start.setBounds(660,390,100,40);

        //注册监听
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //保存路径按钮事件绑定
        savepath.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int option = fileChooser.showOpenDialog(jframe);
            if (option == JFileChooser.APPROVE_OPTION) {
                String selectedPath = fileChooser.getSelectedFile().getPath();
                savepath_input.setText(selectedPath);
            }
        });
        //开始下载按钮事件绑定
        start.addActionListener(e -> {
            //获取参数
            String URL = url_input.getText().trim();
            String SAVE_PATH = savepath_input.getText();
            int THREAD_NUM = Integer.parseInt((String) threadnum_input.getSelectedItem());
            int DOWNLOAD_PAGE_NUM  = Integer.parseInt((String)downloadnum_input.getSelectedItem());
            if(URL.isEmpty()){
                JOptionPane.showMessageDialog(jframe, "请输入URL", "提示", JOptionPane.WARNING_MESSAGE);
            }else if(SAVE_PATH.isEmpty()){
                JOptionPane.showMessageDialog(jframe, "请选择保存路径", "提示", JOptionPane.WARNING_MESSAGE);
            }else {
                app app = new app(URL,SAVE_PATH,THREAD_NUM,DOWNLOAD_PAGE_NUM);
                app.Draw();
            }
        });

        //固定窗口大小
        jframe.setResizable(false);
        //窗口大小及展示
        jframe.setBounds(250,150,800,500);
        jframe.setVisible(true);

    }

    public static void main(String[] args) {

        try {
            // 尝试设置 Mac 特定的外观和感觉
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Name");

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // 创建并显示 Swing 窗口
        SwingUtilities.invokeLater(() -> {
            // 实例化登录界面类并调用 init() 方法
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.init();
        });
    }
}
