package com.ui.component;

import com.ui.model.Model_Card;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import java.awt.*;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class Card extends JPanel {

    private JLabel lbDescription, lbIcon, lbTitle, lbValues;

    private Color color1;
    private Color color2;

    public Card() {
        initComponents();
        setOpaque(false);
        color1 = Color.BLACK;
        color2 = Color.WHITE;
    }

    public void setData(Model_Card data) {
        lbIcon.setIcon(data.getIcon());
        lbTitle.setText(data.getTitle());
        lbValues.setText(data.getValues());
        lbDescription.setText(data.getDescription());
    }

    private void initComponents() {

        lbIcon = new JLabel();
        lbTitle = new JLabel();
        lbValues = new JLabel();
        lbDescription = new JLabel();

        lbIcon.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/ui/icon/stock.png")))); // NOI18N

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("Title");

        lbValues.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbValues.setForeground(new java.awt.Color(255, 255, 255));
        lbValues.setText("Values");

        lbDescription.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDescription.setForeground(new java.awt.Color(255, 255, 255));
        lbDescription.setText("Description");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lbDescription)
                                        .addComponent(lbValues)
                                        .addComponent(lbTitle)
                                        .addComponent(lbIcon))
                                .addContainerGap(283, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(lbIcon)
                                .addGap(18, 18, 18)
                                .addComponent(lbTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbValues)
                                .addGap(18, 18, 18)
                                .addComponent(lbDescription)
                                .addContainerGap(25, Short.MAX_VALUE))
        );
    }
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }


}
