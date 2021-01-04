package view;

import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * 查找
 *
 * @author Ashen One
 */
public class StudentQuery extends JFrame {

    private JButton btn1;
    private JButton btn2;
    private StudentService studentService = new StudentServiceImpl();

    private JTextField tf;

    public void init() {

        setLayout(new FlowLayout());
        setTitle("查看界面");
        setSize(500, 500);
        setLocationRelativeTo(null);

    }

    public void add() {
        btn1 = new JButton("确定");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x = JOptionPane.showConfirmDialog(StudentQuery.this, "是否查看", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                if (x == JOptionPane.OK_OPTION) {
                    String studentName = tf.getText();
                    boolean isExist = studentService.checkStudentName(studentName);
                    if (isExist){
                        StudentQuery.this.dispose();
                        new StudentDisplay(studentName);
                    }else {
                        //学生不存在
                        JOptionPane.showConfirmDialog(StudentQuery.this, "查看失败：学生信息不存在", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                        new StudentQuery();
                    }


                }
 /*               if (x == JOptionPane.OK_OPTION) {
                    try {
                        ck();
                        StudentQuery.this.dispose();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showConfirmDialog(StudentQuery.this, "查看失败", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                    new StudentQuery();
                }*/
            }
        });


        btn2 = new JButton("取消");
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                StudentQuery.this.dispose();
                new SystenMain();

            }
        });

        add(btn1);
        add(btn2);


    }

    public JPanel getFilePanel() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(new JLabel("请输入要查找学生的名字"));
        tf = new JTextField(10);
        p.add(tf);
        return p;

    }

    public StudentQuery() {
        JPanel cp = (JPanel) getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(getFilePanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add();
        init();

        setVisible(true);
    }

   /* public void ck() throws IOException {
        File f = new File("D:\\1907010812李明杰\\学生信息");
        String fname[] = f.list();
        *//*String a=null;*//*
        boolean b = false;
        for (String s : fname) {
            if (s.equals(tf.getText() + ".txt")) {
                new StudentDisplay(tf.getText() + ".txt");
                b = true;
            }
        }
        if (!b) {
            JOptionPane.showConfirmDialog(StudentQuery.this, "查看失败：学生信息不存在", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
            new StudentQuery();
        }
        StudentQuery.this.dispose();

    }*/
}
