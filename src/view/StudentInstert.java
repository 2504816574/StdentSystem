package view;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 信息录入
 *
 * @author Ashen One
 */
public class StudentInstert extends JFrame {
    private String xb;
    private String bj;
    private String dh;
    private String sj;
    private String dzyx;
    private String txdz;
    private String yzbm;

    private JMenuBar bar;
    private JMenu my_file;
    private JMenu my_edit;
    private JMenu my_Source;
    private JMenu my_Refactor;
    private JMenu my_Navigate;
    private JMenu my_Search;
    private JMenu my_Project;
    private JMenu my_Run;
    private JMenu my_Help;

    private static JTextField tf1;
    private static JTextField tf2;
    private static JTextField tf3;
    private static JTextField tf4;
    private static JTextField tf5;
    private static JTextField tf6;
    private static JTextField tf7;
    private static JTextField tf8;
    private static JButton btn1;
    private static JButton btn2;
    private StudentService studentService = new StudentServiceImpl();

    public void init() {

        setLayout(new FlowLayout());
        setTitle("学生信息录入");
        setSize(500, 300);
        setLocationRelativeTo(null);


    }

    public void add() {
        bar = new JMenuBar();
        my_file = new JMenu("开始");
        my_edit = new JMenu("插入  ");
        my_Source = new JMenu("页面布局");
        my_Refactor = new JMenu("引用");
        my_Navigate = new JMenu("审阅");
        my_Search = new JMenu("章节");
        my_Project = new JMenu("开发工具");
        my_Run = new JMenu("云服务");
        my_Help = new JMenu("帮助");

        bar.add(my_file);
        bar.add(my_edit);
        bar.add(my_Source);
        bar.add(my_Refactor);
        bar.add(my_Navigate);
        bar.add(my_Search);
        bar.add(my_Project);
        bar.add(my_Run);
        bar.add(my_Help);


        setJMenuBar(bar);
    }

    public StudentInstert() {

        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p.setLayout(new BorderLayout());

        p1.setLayout(new GridLayout(4, 2));
        p2.setLayout(new FlowLayout());

        p1.add(new JLabel("姓名"));
        tf1 = new JTextField(10);
        p1.add(tf1);
        p1.add(new JLabel("性别"));
        tf2 = new JTextField(10);
        p1.add(tf2);
        p1.add(new JLabel("班级"));
        tf3 = new JTextField(10);
        p1.add(tf3);
        p1.add(new JLabel("电话"));
        tf4 = new JTextField(10);
        p1.add(tf4);
        p1.add(new JLabel("手机"));
        tf5 = new JTextField(10);
        p1.add(tf5);
        p1.add(new JLabel("电子邮箱"));
        tf6 = new JTextField(10);
        p1.add(tf6);
        p1.add(new JLabel("通信地址"));
        tf7 = new JTextField(10);
        p1.add(tf7);
        p1.add(new JLabel("邮政编码"));
        tf8 = new JTextField(10);
        p1.add(tf8);
        btn1 = new JButton("保存");
        btn2 = new JButton("取消");
        p1.add(tf8);
        p2.add(btn1);
        p2.add(btn2);


        this.setContentPane(p);
        p.add(p1, BorderLayout.CENTER);
        p.add(p2, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        add();
        setVisible(true);

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x = JOptionPane.showConfirmDialog(StudentInstert.this, "是否保存？", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                //是否保存
                if (x == JOptionPane.OK_OPTION) {
                    String name = tf1.getText();
                    String sex = tf2.getText();
                    String className = tf3.getText();
                    String telephone = tf4.getText();
                    String mobilePhone = tf5.getText();
                    String email = tf6.getText();
                    String communication = tf7.getText();
                    String postalCode = tf8.getText();
                    boolean isExist = studentService.checkStudentName(name);
                    if (isExist) {
                        //学生存在
                        JOptionPane.showConfirmDialog(StudentInstert.this, "该学生("+name+")已存在", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                    } else {
                        Student student = new Student(name, sex, className, telephone, mobilePhone, email, communication, postalCode);
                        boolean isSave = studentService.saveStudent(student);
                        if (isSave) {
                            //保存成功
                            JOptionPane.showConfirmDialog(StudentInstert.this, "保存成功", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                            StudentInstert.this.dispose();
                            new StudentInstert();
                        } else {
                            //保存失败（代码或者数据库有问题）
                            JOptionPane.showConfirmDialog(StudentInstert.this, "保存失败，请联系管理员", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                            StudentInstert.this.dispose();
                            //跳转到系统界面
                            new SystenMain();
                        }
                    }


                }
               /* if (x == JOptionPane.OK_OPTION) {
                    try {
                        cj();
                        test01();
                        JOptionPane.showConfirmDialog(StudentInstert.this, "保存成功", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                        StudentInstert.this.dispose();
                        new StudentInstert();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();

                    }
                }
                else {
                    JOptionPane.showConfirmDialog(StudentInstert.this, "保存失败", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                }*/


            }
        });
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SystenMain();
                StudentInstert.this.dispose();

            }
        });
    }

  /*  public static void test01() throws IOException {

        String name = "D:\\1907010812李明杰\\学生信息\\" + tf1.getText() + ".txt";

        OutputStream os = new FileOutputStream(name);
        os.write("姓名：".getBytes());
        os.write(tf1.getText().getBytes());
        os.write("。".getBytes());
        os.write("性别：".getBytes());
        os.write(tf2.getText().getBytes());
        os.write("。".getBytes());
        os.write("班级：".getBytes());
        os.write(tf3.getText().getBytes());
        os.write("。".getBytes());
        os.write("电话：".getBytes());
        os.write(tf4.getText().getBytes());
        os.write("。".getBytes());
        os.write("手机：".getBytes());
        os.write(tf5.getText().getBytes());
        os.write("。".getBytes());
        os.write("电子邮箱：".getBytes());
        os.write(tf6.getText().getBytes());
        os.write("。".getBytes());
        os.write("通信地址：".getBytes());
        os.write(tf7.getText().getBytes());
        os.write("。".getBytes());
        os.write("邮政编码：".getBytes());
        os.write(tf8.getText().getBytes());
        os.close();
    }*/

/*    public static void cj() {
        File f1 = new File("D:\\1907010812李明杰\\学生信息");
        f1.mkdir();
    }*/

}
