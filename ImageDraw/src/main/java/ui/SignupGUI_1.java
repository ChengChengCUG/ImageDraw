package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SignupGUI_1 {

    JFrame jframe = new JFrame("注册窗口");
    JPanel panel = new JPanel(null);

    JLabel username = new JLabel("账号:");
    JLabel password = new JLabel("密码:");
    JLabel confirmpassword = new JLabel("确认密码:");

    // 创建字体对象，设置字体名称、样式和大小
    Font labelFont = new Font("SansSerif", Font.PLAIN, 18); // 设置字体为 Arial，普通样式，大小为 18

    JTextField nametext = new JTextField(20);
    JPasswordField passwordtext = new JPasswordField(20); // 使用 JPasswordField
    JPasswordField confirmpasswordtext = new JPasswordField(20); // 使用 JPasswordField
    JButton signup = new JButton("注册");

    public  void init(){

        // 创建用于放置注册页面的背景图片的 JLabel

        JLabel Login_background = new JLabel();
        // 替换为背景图片路径
        ImageIcon Login_background_Image = new ImageIcon("src/main/java/background_png/SignUP_bd.jpg");
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
        panel.add(confirmpassword);
        panel.add(nametext);
        panel.add(passwordtext);
        panel.add(confirmpasswordtext);
        panel.add(signup);
        jframe.add(panel);

        // 将字体应用于 JLabel
        username.setFont(labelFont);
        password.setFont(labelFont);
        confirmpassword.setFont(labelFont);
        // 设置组件位置和大小
        username.setBounds(120, 45, 80, 25);
        password.setBounds(120, 85, 80, 25);
        confirmpassword.setBounds(115,120,80, 25);
        nametext.setBounds(200, 40, 150, 30);
        passwordtext.setBounds(200, 80, 150, 30);
        confirmpasswordtext.setBounds(200, 120, 150, 30);
        signup.setBounds(180, 200, 100, 35);

        // 添加窗口事件监听器
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 当点击窗口的关闭按钮时只关闭当前的 SignupGUI 窗口
                jframe.dispose(); // 关闭当前窗口
            }
        });
        //窗口大小及展示
        jframe.setBounds(500,300,600,400);
        jframe.setVisible(true);

    }


}
