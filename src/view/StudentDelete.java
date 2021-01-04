package view;

import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 删除学生信息
 *
 * @author Ashen One
 */
public class StudentDelete extends JFrame {
    private JButton btn1;
    private JButton btn2;

    private JTextField tf;
    private StudentService studentService = new StudentServiceImpl();

    public void init() {

        setLayout(new FlowLayout());
        setTitle("学生信息删除系统");
        setSize(500, 500);
        setLocationRelativeTo(null);

    }

    public void add() {
        btn1 = new JButton("确定");
        btn1.addActionListener(new ActionListener() {

            @Override


            public void actionPerformed(ActionEvent e) {
                int y = JOptionPane.showConfirmDialog(StudentDelete.this, "是否删除",
                        "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                //是否删除
                if (y == JOptionPane.OK_OPTION) {
                    String studentName = tf.getText();
                    boolean isExist = studentService.checkStudentName(studentName);
                    if (isExist) {
                        //学生存在
                        boolean isDel = studentService.deleteStudentByName(studentName);
                        if (isDel) {
                            //成功删除
                            JOptionPane.showConfirmDialog(StudentDelete.this, "删除成功",
                                    "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                            StudentDelete.this.dispose();
                            new StudentDelete();
                        } else {
                            //代码数据库出现问题
                            JOptionPane.showConfirmDialog(StudentDelete.this, "删除失败,请联系管理员", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                            StudentDelete.this.dispose();
                            new SystenMain();
                        }
                    } else {
                        //学生不存在
                        JOptionPane.showConfirmDialog(StudentDelete.this, "删除失败：学生信息不存在", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                        StudentDelete.this.dispose();
                        new StudentDelete();
                    }
                }
            }

        });


        btn2 = new JButton("取消");
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SystenMain();
                StudentDelete.this.dispose();


            }
        });

        add(btn1);

        add(btn2);


    }

    public JPanel getFilePanel() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(new JLabel("请输入要删除学生的名字"));
        tf = new JTextField(10);
        p.add(tf);
        return p;

    }

    public StudentDelete() {
        JPanel cp = (JPanel) getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(getFilePanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add();
        init();

        setVisible(true);
    }

/*    public void test02() {
        String name = "D://1907010812李明杰//学生信息//" + tf.getText() + ".txt";
//File f=new File(name); 
        File f = new File("D://1907010812李明杰//学生信息");
        String fname[] = f.list();
        File f1 = new File(name);

        boolean b = false;
        for (String s : fname) {

            if (s.equals(tf.getText() + ".txt")) {
                int y = JOptionPane.showConfirmDialog(StudentDelete.this, "是否删除",
                        "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                if (y == JOptionPane.OK_OPTION) {
                    f1.delete();

                    JOptionPane.showConfirmDialog(StudentDelete.this, "删除成功",
                            "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                    StudentDelete.this.dispose();
                    new StudentDelete();

                    b = true;
                }

            }

        }
        if (!b) {
            JOptionPane.showConfirmDialog(StudentDelete.this, "是否删除?", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);

            JOptionPane.showConfirmDialog(StudentDelete.this, "删除失败：学生信息不存在", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
            StudentDelete.this.dispose();
            new StudentDelete();
        }
    }*/
}
