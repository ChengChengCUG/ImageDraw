package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SignupGUI {

    //创建各个组件
    JFrame jframe = new JFrame("登录窗口");
    JPanel panel = new JPanel(null);

    //三个输入框标签
    JLabel username = new JLabel("账号:");
    JLabel password = new JLabel("密码:");
    JLabel confirmpassword = new JLabel("确认密码:");

    // 创建字体对象，设置字体名称、样式和大小
    Font labelFont = new Font("SansSerif", Font.PLAIN, 18); // 设置字体为 Arial，普通样式，大小为 18
    Font jtextFont = new Font("SansSerif", Font.PLAIN, 15); // 设置字体为 Arial，普通样式，大小为 18
    Color fontColor = Color.WHITE; // 设置字体颜色为白色

    //三个账号和密码的输入文本框
    JTextField nametext = new JTextField(20);
    JPasswordField passwordtext = new JPasswordField(20); // 使用 JPasswordField
    JPasswordField confirmpasswordtext = new JPasswordField(20); // 使用 JPasswordField

    //登录和注册按钮
    JButton signup = new JButton("注册");

    public void init() {

        // 创建用于放置登录页面的背景图片的 JLabel
        JLabel Login_background = new JLabel();
        // 替换为背景图片路径
        ImageIcon Login_background_Image = new ImageIcon("src/main/java/background_png/SignUP_bd.jpg");
        Login_background.setIcon(Login_background_Image);
        Login_background.setBounds(-150, -550, 1920, 1200); // 设置背景大小，与 JFrame 大小相同
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
        panel.add(confirmpassword);
        panel.add(confirmpasswordtext);
        panel.add(signup);
        jframe.add(panel);

        // 将字体应用于 JLabel
        username.setFont(labelFont);
        username.setForeground(fontColor); // 设置字体颜色为白色
        password.setFont(labelFont);
        password.setForeground(fontColor); // 设置字体颜色为白色
        confirmpassword.setFont(labelFont);
        confirmpassword.setForeground(fontColor);
        nametext.setFont(jtextFont);

        // 设置组件位置和大小
        username.setBounds(160, 90, 80, 25);
        password.setBounds(160, 130, 80, 25);
        confirmpassword.setBounds(124, 170, 80, 25);
        nametext.setBounds(210, 90, 180, 30);
        passwordtext.setBounds(210, 130, 180, 30);
        confirmpasswordtext.setBounds(210,170,180, 30);
        signup.setBounds(260, 250, 80, 30);

        //注册监听
        //关闭按钮
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 当点击窗口的关闭按钮时只关闭当前的 SignupGUI 窗口
                jframe.dispose(); // 关闭当前窗口
            }
        });
        //注册按钮
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击注册按钮时

            }
        });
        //固定窗口大小
        jframe.setResizable(false);
        //窗口大小及展示
        jframe.setBounds(520, 320, 600, 400);
        jframe.setVisible(true);

    }


}
