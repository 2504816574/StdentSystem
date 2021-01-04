package view;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 显示学生信息
 *
 * @author Ashen One
 */
public class StudentDisplay extends JFrame {

    private String xb;
    private String bj;
    private String dh;
    private String sj;
    private String dzyx;
    private String txdz;
    private String yzbm;

    private JButton btn1;
    private JButton btn2;
    private StudentService studentService = new StudentServiceImpl();


    public void init() {

        setLayout(new FlowLayout());
        setTitle("学生信息");
        setSize(500, 500);
        setLocationRelativeTo(null);


    }

    public void add() {
        btn1 = new JButton("退出");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });


        btn2 = new JButton("返回");
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                StudentDisplay.this.dispose();
                new StudentQuery();

            }
        });


    }


    public StudentDisplay(String name) {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        add();
        assignment(name);
        setVisible(true);

        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        setContentPane(p);

        p.setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(8, 1));
        p2.setLayout(new FlowLayout());

        p1.add(new JLabel(w0));
        p1.add(new JLabel(w1));
        p1.add(new JLabel(w2));
        p1.add(new JLabel(w3));
        p1.add(new JLabel(w4));
        p1.add(new JLabel(w5));
        p1.add(new JLabel(w6));
        p1.add(new JLabel(w7));
        p2.add(btn1);
        p2.add(btn2);

        p.add(p1, BorderLayout.CENTER);
        p.add(p2, BorderLayout.SOUTH);
        p.add(p3, BorderLayout.EAST);
        p.add(p4, BorderLayout.WEST);
    }

    String w0 = null;
    String w1 = null;
    String w2 = null;
    String w3 = null;
    String w4 = null;
    String w5 = null;
    String w6 = null;
    String w7 = null;

    public void assignment(String studentName) {
        Student student = studentService.queryStudentByName(studentName);
        //姓名
        w0 = student.getName();
        //性别
        w1 = student.getSex();
        //班级
        w2 = student.getClassName();
        //电话
        w3 = student.getTelephone();
        //手机
        w4 = student.getMobilePhone();
        //电子邮箱
        w5 = student.getEmail();
        //通信地址
        w6 = student.getCommunication();
        //邮政编码
        w7 = student.getPostalCode();


    }

/*    public void dq(String name) throws IOException {
        File f = new File("D:\\1907010812李明杰\\学生信息");
        String fname[] = f.list();

        Reader r = new FileReader("D:\\1907010812李明杰\\学生信息\\" + name);
        String b = null;
        char cs[] = new char[1024 * 1024];
        int len = 0;
        while ((len = r.read(cs)) != -1) {
            b = new String(cs, 0, len);
        }
        r.close();

        String[] s = b.split("。");
        w0 = s[0];
        w1 = s[1];
        w2 = s[2];
        w3 = s[3];
        w4 = s[4];
        w5 = s[5];
        w6 = s[6];
        w7 = s[7];

    }*/
}
