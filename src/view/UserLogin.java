package view;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登陆界面
 *
 * @author Ashen One
 */
public class UserLogin extends JFrame {

    private JButton btn1;
    private JButton btn2;
    private JTextField tf;
    private JPasswordField pf;
    private UserService userService = new UserServiceImpl();

    public void init() {

        /*setLayout(new FlowLayout());*/
        setTitle("学生登记系统");
        setSize(420, 200);//设置宽高
        Image icon = Toolkit.getDefaultToolkit().getImage("src/loginsystem/logo.jpg");

        this.setIconImage(icon);
        //设置logo
        setLocationRelativeTo(null);

        tf = new JTextField(5);
        pf = new JPasswordField(5);
    }

    public void add1() {

        btn1 = new JButton("登陆");
        btn1.setBackground(new Color(0, 255, 255));
        btn1.setFont(new Font("宋体", Font.BOLD | Font.PLAIN, 13));

        JLabel name = new JLabel("                          账号:");
        JLabel password = new JLabel("                          密码:");
        JLabel bq1 = new JLabel("  ");
        JLabel bq2 = new JLabel("  ");

        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        p.setBackground(new Color(144, 238, 144));
        p1.setBackground(new Color(144, 238, 144));
        p2.setBackground(new Color(144, 238, 144));
        p3.setBackground(new Color(144, 238, 144));
        p4.setBackground(new Color(144, 238, 144));
        p5.setBackground(new Color(144, 238, 144));

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pd();
                /*try {
                    pd();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }*/
            }
        });


        btn2 = new JButton("注册");
        btn2.setBackground(new Color(0, 255, 255));
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new UserRegister();
                UserLogin.this.dispose();
            }
        });
        this.setContentPane(p); //设置为内容面板  总布
        p.setLayout(new BorderLayout());
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(2, 2));
        p3.setLayout(new FlowLayout());

        JLabel denglu = new JLabel("登陆系统");
        denglu.setFont(new Font("方正舒体", Font.BOLD | Font.PLAIN, 40));
        denglu.setForeground(new Color(255, 0, 0));
        p1.add(denglu);
        p2.add(name);
        p2.add(tf);
        p2.add(password);
        p2.add(pf);
        p3.add(btn1);
        p3.add(btn2);
        p4.add(bq1);
        p5.add(bq2);


        p.add(p1, BorderLayout.NORTH);
        p.add(p2, BorderLayout.CENTER);
        p.add(p3, BorderLayout.SOUTH);
        p.add(p4, BorderLayout.EAST);

    }


    public UserLogin() {
        JPanel cp = (JPanel) getContentPane();
        cp.setLayout(new FlowLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        add1();
        setVisible(true);
    }

    /**
     * 登录
     */
    public void pd() {
        String username = tf.getText();
        String password = pf.getText();
        User user = userService.getUser(new User(username, password));
        if (user == null) {
            //用户不存在
            // JOptionPane.showConfirmDialog(UserLogin.this, "九组全体成员提醒您，用户密码错误,请重新输入！", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
            JOptionPane.showConfirmDialog(UserLogin.this, "用户密码错误,请重新输入！", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
            UserLogin.this.dispose();
            new UserLogin();
        } else {
            //用户存在
            // JOptionPane.showConfirmDialog(UserLogin.this, "九组全体成员祝贺您输入正确！", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
            new SystenMain();
            UserLogin.this.dispose();
        }

    }
  /*  public void pd() throws IOException {
        File f = new File("D:\\1907010812李明杰\\信息系统账号");
        String fname[] = f.list();
        String a = null;
        for (String s : fname) {
            if (s.equals(tf.getText() + ".txt")) {
                a = s;
                Reader r = new FileReader("D:\\1907010812李明杰\\信息系统账号\\" + s);
                String b = null;
                char cs[] = new char[10];
                int len = 0;
                while ((len = r.read(cs)) != -1) {
                    b = new String(cs, 0, len);
                }
                if (pf.getText().equals(b)) {
                    JOptionPane.showConfirmDialog(UserLogin.this, "九组全体成员祝贺您输入正确！", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                    new SystenMain();

                    UserLogin.this.dispose();
                } else {
                    JOptionPane.showConfirmDialog(UserLogin.this, "九组全体成员提醒您，您输错了哦,请重新输入！", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                    UserLogin.this.dispose();
                    new UserLogin();
                }
            }
        }

    }*/


}
