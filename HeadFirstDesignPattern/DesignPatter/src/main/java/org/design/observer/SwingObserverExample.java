package org.design.observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserverExample {

    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }
    
    public void go() {
        frame = new JFrame();
        JButton button = new JButton("할까 말까");
        button.addActionListener(angel -> System.out.println("할 수 있어"));
        button.addActionListener(devil -> System.out.println("할 수 없엉"));
    }


}
