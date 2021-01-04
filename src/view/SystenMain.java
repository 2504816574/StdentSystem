package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 选择需要进行的操作。
 * 1.录入学生信息
 * 2.修改学生信息
 * 3.删除学生信息
 * 4.注销
 *
 * @author Ashen One
 */
public class SystenMain extends JFrame {
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;

    public void init() {


        Image icon = Toolkit.getDefaultToolkit().getImage("images/logo.jpg");

        this.setIconImage(icon);
        setLayout(new FlowLayout());
        // setTitle("请选择哦！");
        setTitle("学生信息管理系统");
        setSize(275, 405);


        setLocationRelativeTo(null);
    }

    public void add() {
        btn1 = new JButton("录入学生信息");
        btn1.setBackground(new Color(135, 206, 250));
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentInstert();
                SystenMain.this.dispose();

            }
        });


        btn2 = new JButton("查找学生信息");
        btn2.setBackground(new Color(135, 206, 250));
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentQuery();
                SystenMain.this.dispose();
            }
        });

        btn3 = new JButton("删除学生信息");
        btn3.setBackground(new Color(135, 206, 250));
        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentDelete();
                SystenMain.this.dispose();

            }
        });

        btn4 = new JButton("退出信息系统");
        btn4.setBackground(new Color(135, 206, 250));
        btn4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x = JOptionPane.showConfirmDialog(SystenMain.this, "是否退出系统？", "系统提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.CANCEL_OPTION);
                if (x == JOptionPane.OK_OPTION) {


                    System.exit(0);
                }

            }
        });

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
    }

    public JPanel getFilePanel() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(new JLabel("请选择你要进行的操作！"));
        p.setBackground(new Color(30, 144, 255));
        return p;


    }

    public SystenMain() {
        JPanel cp = (JPanel) getContentPane();
        cp.setLayout(new FlowLayout());
        cp.setBackground(new Color(144, 238, 144));

        cp.add(getFilePanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        add();
        setVisible(true);
    }

}
