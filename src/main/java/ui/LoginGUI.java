package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginGUI {

    //创建各个组件
    JFrame jframe = new JFrame("登录窗口");
    JPanel panel = new JPanel(null);

    JLabel username = new JLabel("账号:");
    JLabel password = new JLabel("密码:");

    // 创建字体对象，设置字体名称、样式和大小
    Font labelFont = new Font("SansSerif", Font.PLAIN, 18); // 设置字体为 Arial，普通样式，大小为 18
    Font jtextFont = new Font("SansSerif", Font.PLAIN, 15); // 设置字体为 Arial，普通样式，大小为 18
    Color fontColor = Color.WHITE; // 设置字体颜色为白色
    //账号和密码的输入文本框
    JTextField nametext = new JTextField(20);
    JPasswordField passwordtext = new JPasswordField(20); // 使用 JPasswordField

    //登录和注册按钮
    JButton login = new JButton("登录");
    JButton signup = new JButton("注册");


    public void init() {

        // 创建用于放置登录页面的背景图片的 JLabel
        JLabel Login_background = new JLabel();
        // 替换为背景图片路径
        ImageIcon Login_background_Image = new ImageIcon("src/main/java/background_png/Login_bd.png");
        Login_background.setIcon(Login_background_Image);
        Login_background.setBounds(-450, -400, 1920, 1200); // 设置背景大小，与 JFrame 大小相同
        // 将背景放在最底层
        jframe.getLayeredPane().add(Login_background, Integer.valueOf(Integer.MIN_VALUE));
        Container contentPane = jframe.getContentPane();
        ((JPanel) contentPane).setOpaque(false); // 设置内容面板为透明，以便能够看到背景

        // 确保其他组件显示在最顶层
        panel.setOpaque(false);
        panel.setLayout(null); // 设置布局为 null，方便控制组件位置
        //添加组件
        panel.add(username);
        panel.add(password);
        panel.add(nametext);
        panel.add(passwordtext);
        panel.add(login);
        panel.add(signup);
        jframe.add(panel);

        // 将字体应用于 JLabel
        username.setFont(labelFont);
        username.setForeground(fontColor); // 设置字体颜色为白色
        password.setFont(labelFont);
        password.setForeground(fontColor); // 设置字体颜色为白色
        nametext.setFont(jtextFont);

        // 设置组件位置和大小
        username.setBounds(150, 90, 80, 25);
        password.setBounds(150, 130, 80, 25);
        nametext.setBounds(200, 90, 180, 30);
        passwordtext.setBounds(200, 130, 180, 30);
        login.setBounds(200, 200, 80, 30);
        signup.setBounds(300, 200, 80, 30);

        //注册监听
        //关闭按钮
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // 在窗口关闭时退出程序
            }
        });
        //登录按钮
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //使用 trim() 方法去除前后的空白字符
                String name = nametext.getText().trim();
                String password = new String(passwordtext.getPassword()).trim();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(jframe, "请输入用户名", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(jframe, "请输入密码", "提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    // 在这里进行用户名密码匹配的验证逻辑，这里假设用户名为 "CUGer"，密码为 "password"
                    if (name.equals("CUGer") && password.equals("123456")) {
                        JOptionPane.showMessageDialog(jframe, "登录成功",
                                "提示", JOptionPane.INFORMATION_MESSAGE);
                        mainGUI mainGUI = new mainGUI();
                        mainGUI.init();
                        jframe.dispose(); // 关闭当前窗口
                    } else {
                        JOptionPane.showMessageDialog(jframe, "用户名或密码错误",
                                "提示", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        //注册按钮
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击注册按钮时调用 SignupGUI 类
                SignupGUI signupGUI = new SignupGUI();
                signupGUI.init();
            }
        });
        //固定窗口大小
        jframe.setResizable(false);
        //窗口大小及展示
        jframe.setBounds(380, 200, 600, 400);
        jframe.setVisible(true);

    }


}
