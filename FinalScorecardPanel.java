import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.event.*;



public class FinalScorecardPanel extends JFrame implements ActionListener {
	private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
    
    private JButton doneButton = new JButton("Done");
    private JPanel cardPanel = new JPanel();
    
    public FinalScorecardPanel(String[] players) {
    	setSize(defaultWidth, defaultHeight);
    	this.setLayout(new BorderLayout());
    	
    	formatDoneButton();
    	cardPanel = createCardPanel(players);
    	
    	addButton();
    	add(cardPanel);
    }
    
    private void addButton() {
    	JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new java.awt.Color(40,23,35));
        buttonPanel.add(doneButton);
        this.add(buttonPanel,BorderLayout.NORTH);
    }
    
    private void formatDoneButton() {
    	doneButton.setOpaque(true);
        doneButton.setFont(new Font("Krungthep",Font.BOLD,20));
        doneButton.setBackground(new Color(67,39,59));
        doneButton.setForeground(Color.WHITE);
        doneButton.setFocusPainted(false);
        doneButton.setBorderPainted(false);
        doneButton.addActionListener(this);
    }
    
    private JPanel createCardPanel(String[] players) {
    	JPanel returnPanel = new JPanel();
    	returnPanel.setLayout(new BoxLayout(returnPanel, BoxLayout.PAGE_AXIS));
    	returnPanel.setBackground(new java.awt.Color(40,23,35));
        returnPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
        JPanel title = new JPanel();
        JLabel cardTitle = new JLabel("Final Game Scorecard");
        cardTitle.setFont(new Font("Krungthep",1,65));
        cardTitle.setForeground(Color.white);
        title.setBackground(new java.awt.Color(40,23,35));
        title.add(cardTitle);
        returnPanel.add(title, BorderLayout.NORTH);
        
        //player labels
        JPanel scoresPanel = new JPanel();
        scoresPanel.setLayout(new GridLayout(7,2,1,1));
        scoresPanel.setBackground(new java.awt.Color(40,23,35));
        scoresPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        JLabel[] playerLabels = new JLabel[players.length];
        JLabel[] playerScoreLabels = new JLabel[players.length];
        // convert players scores to strings
        String[] playerScores = new String[players.length];
        for(int i = 0; i < players.length; i++) {
        	playerScores[i] = players[i].playerCard.totalScore.toString();
        }
        
        for(int i = 0; i < players.length; i++) {
        	playerLabels[i] = new JLabel("Player " + (i+1));
        	playerScoreLabels[i] = new JLabel(playerScores[i]);
        	scoresPanel.add(playerLabels[i]);
        }
        
        /*String[] columnNames = {"Player",
                                "Total Points"
                               };
        
        Object[][] scores = {
        	    {players, 0,},
        	    {"Venus", stringScores[1],},
        	    {"Mars", stringScores[2],},
        	    {"Jupiter", stringScores[3],},
        	    {"Saturn", stringScores[4],},
        	    {"Uranus", stringScores[5],},
        	    {"Neptune", stringScores[6],},
        	    {"Small Straight", String.valueOf(smallStraight),},
        	    {"Large Straight", String.valueOf(largeStraight),},
        	    {"Tri Force", String.valueOf(triForce),},
        	    {"Total Score", String.valueOf(totalScore),}
        	};*/
        
        JTable table = new JTable(scores, columnNames);
        table.setPreferredSize(new Dimension(defaultWidth - 500, defaultHeight));
        table.setBackground(new java.awt.Color(40,23,35));
        table.setFont(new Font("Krungthep",1,24));
        table.setForeground(Color.white);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        
        int rowHeight = 50;
        table.setRowHeight(0,rowHeight);
        table.setRowHeight(1,rowHeight);
        table.setRowHeight(2,rowHeight);
        table.setRowHeight(3,rowHeight);
        table.setRowHeight(4,rowHeight);
        table.setRowHeight(5,rowHeight);
        table.setRowHeight(6,rowHeight);
        table.setRowHeight(7,rowHeight);
        table.setRowHeight(8,rowHeight);
        table.setRowHeight(9,rowHeight);
        table.setRowHeight(10,rowHeight);
        table.setRowHeight(11,rowHeight);
        
        
        scoresPanel.add(table);
        returnPanel.add(scoresPanel,BorderLayout.NORTH);
        returnPanel.setOpaque(true);
        return returnPanel; 
    }
    
    public void actionPerformed(ActionEvent e)
    { 
    	this.setVisible(false);
    }
}