package view;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 注册账号
 *
 * @author Ashen One
 */
public class UserRegister extends JFrame {
    private JTextField tf;
    private JPasswordField pf1;
    private JPasswordField pf2;
    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JLabel lb4;
    private JButton btn1;
    private JButton btn2;
    private JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();
    private UserService userService = new UserServiceImpl();

    public void init() {

        setTitle("学生登记系统注册账号");
        Image icon = Toolkit.getDefaultToolkit().getImage("src/loginsystem/logo.jpg");
        this.setIconImage(icon);
        setSize(420, 200);

        setLocationRelativeTo(null);
        lb1 = new JLabel("  账号");
        lb2 = new JLabel("  密码");
        lb3 = new JLabel("  再次输入密码");
        lb4 = new JLabel("注册账号");
        lb4.setFont(new Font("方正舒体", Font.BOLD | Font.PLAIN, 40));
        lb4.setForeground(Color.RED);
        btn1 = new JButton("确定");
        btn1.setBackground(Color.pink);
        btn2 = new JButton("取消");
        btn2.setBackground(Color.pink);
        tf = new JTextField(20);
        pf1 = new JPasswordField(20);
        pf2 = new JPasswordField(20);

        this.setContentPane(p);
        p.setLayout(new BorderLayout());
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(3, 2));

        p.setBackground(new Color(144, 238, 144));
        p1.setBackground(new Color(144, 238, 144));
        p2.setBackground(new Color(144, 238, 144));
        p3.setBackground(new Color(144, 238, 144));
        p4.setBackground(new Color(144, 238, 144));
        p5.setBackground(new Color(144, 238, 144));

        p1.add(lb4);
        p2.add(lb1);
        p2.add(tf);
        p2.add(lb2);
        p2.add(pf1);
        p2.add(lb3);
        p2.add(pf2);
        p3.add(btn1);
        p3.add(btn2);
        p.add(p1, BorderLayout.NORTH);
        p.add(p2, BorderLayout.CENTER);
        p.add(p3, BorderLayout.SOUTH);
        p.add(p4, BorderLayout.EAST);
        p.add(p5, BorderLayout.WEST);
    }

    public void add() {


        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tf.getText().trim();
                String password01 = pf1.getText().trim();
                String password02 = pf2.getText().trim();
                if ("".equals(username) || "".equals(password01) || "".equals(password02)) {
                    //出现输入为空的情况
                    JOptionPane.showConfirmDialog(UserRegister.this, "不能输入空值，请重新输入", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                    UserRegister.this.dispose();
                    new UserRegister();
                } else {
                    if (password01.equals(password02)) {
                        //两次密码输入一致
                        boolean isExist = userService.checkUserName(username);
                        if (isExist) {
                            //如果数据库中已有该用户
                            //两次密码输入不一致
                            JOptionPane.showConfirmDialog(UserRegister.this, "已存在该用户，请重新输入", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                            UserRegister.this.dispose();
                            new UserRegister();
                        } else {
                            boolean isSave = userService.saveUser(new User(username, password01));
                            if (isSave) {
                                //注册成功
                                JOptionPane.showConfirmDialog(UserRegister.this, "注册成功", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                                toLogin();
                            } else {
                                //注册失败
                                JOptionPane.showConfirmDialog(UserRegister.this, "注册失败，请联系管理员", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                                UserRegister.this.dispose();
                                new UserLogin();
                            }
                        }
                    } else {
                        //两次密码输入不一致
                        JOptionPane.showConfirmDialog(UserRegister.this, "两次密码输入不一致，请重新输入", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                        UserRegister.this.dispose();
                        new UserRegister();
                    }
                }

 /*               if (pf2.getText().toString().trim().equals(pf1.getText().toString().trim())) {

                    try {
                        save();
                        int x = JOptionPane.showConfirmDialog(UserRegister.this, "恭喜您注册成功", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                        if (x == JOptionPane.OK_OPTION) {
                            fh();

                        }
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showConfirmDialog(UserRegister.this, "输入密码不一致，请重新输入", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                    UserRegister.this.dispose();
                    new UserRegister();
                }*/

            }
        });


        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                toLogin();

            }
        });

         /*add(tf);
         add(pf1);
         add(pf2);
         add(btn1);
         add(btn2);*/


    }
/*   public  JPanel getFilePanel(){
        JPanel p=new JPanel();
         p.setLayout(new FlowLayout());
         p.add(new JLabel("注册账号！"));
         return p;
    }*/

    public UserRegister() {
        JPanel cp = (JPanel) getContentPane();
        cp.setLayout(new FlowLayout());

        /*cp.add(getFilePanel());*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        add();
        setVisible(true);
    }

/*    public void save() throws IOException {
        File f1 = new File("D://1907010812李明杰//信息系统账号");
        f1.mkdir();
        String name = "D://1907010812李明杰//信息系统账号//" + tf.getText() + ".txt";
        OutputStream os = new FileOutputStream(name);
        //os.write(tf.getText().getBytes());
        os.write(pf1.getText().getBytes());
        os.close();

    }*/

    /**
     * 跳转到登录页面
     */
    public void toLogin() {
        UserRegister.this.dispose();
        new UserLogin();
    }

}
