package ru.spb.push;

import ru.spb.push.PushModifier;
import ru.spb.push.Pushdata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guiconsole {

    private final JTextField titleNews;
    private final JTextArea contentNews;
    private final JButton pushNews;

    String mtitle;
    String mcontent;

    public Guiconsole() {

        final JFrame jFrame = new JFrame("Консоль для пуш-уведомлений");

        jFrame.setSize(230, 150);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleNews = new JTextField(30);
        contentNews = new JTextArea(10, 39);
        pushNews = new JButton();

        jFrame.add(titleNews);
        jFrame.add(contentNews);
        jFrame.add(pushNews);

        jFrame.setLayout(new FlowLayout());
        jFrame.setVisible(true);

       final ActionListener actionlistener = new SQLActionListener();

        pushNews.addActionListener(actionlistener);
    }

    public class SQLActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            final PushModifier pushModifier = new PushModifier();

            mtitle = titleNews.getText();
            mcontent = contentNews.getText();

            final Pushdata pushdata = new Pushdata(mtitle, mcontent);
            pushModifier.savePushdata(pushdata);
        }
    }

}
