package multithreading;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

public class BadProgress extends JFrame implements ActionListener {

    JEditorPane pane = new JEditorPane();
    JProgressBar progressBar = new JProgressBar();

    public BadProgress() {
        super("Progress");

        pane.setText("File's contents go here...");
        JScrollPane scroll = new JScrollPane(pane,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel south = new JPanel(new BorderLayout());
        JButton exploreBtn = new JButton("Explore");
        exploreBtn.addActionListener(this);
        south.add(progressBar, BorderLayout.CENTER);
        south.add(exploreBtn, BorderLayout.EAST);

        add(scroll, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BadProgress();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            File longFile = new File("veryLongFile.txt");
            Scanner reader = new Scanner(longFile);
            progressBar.setMaximum(1024);
            int nbOfLines = 0;
            while (reader.hasNext()) {
                pane.setText(pane.getText() + reader.nextLine() + "\n");
                nbOfLines++;
                progressBar.setValue(nbOfLines);
            }
            reader.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
