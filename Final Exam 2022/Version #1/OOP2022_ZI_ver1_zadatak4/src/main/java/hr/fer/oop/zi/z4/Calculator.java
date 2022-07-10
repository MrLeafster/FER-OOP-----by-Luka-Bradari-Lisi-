package hr.fer.oop.zi.z4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Calculator extends JFrame {

  private JPanel contentPane;
  private JTextField display;
  private JButton number0;
  private JButton number1;
  private JButton number2;
  private JButton number3;
  private JButton number4;
  private JButton number5;
  private JButton number6;
  private JButton number7;
  private JButton number8;
  private JButton number9;
  private JButton decimalPoint;
  private JPanel buttonsPanel;
  private JButton buttonDivide;
  private JButton buttonMultiply;
  private JButton buttonMinus;
  private JButton buttonEquals;
  private JButton buttonPlus;

  // you can put here additional fields
  private boolean pressedEquals;

  public Calculator() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane = new JPanel();
    setContentPane(contentPane);

    display = new JTextField("0");
    display.setHorizontalAlignment(SwingConstants.RIGHT);
    display.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
    display.setColumns(10);
    display.setEnabled(false);

    buttonsPanel = new JPanel();

    number0 = new JButton("0");
    number1 = new JButton("1");
    number2 = new JButton("2");
    number3 = new JButton("3");
    number4 = new JButton("4");
    number5 = new JButton("5");
    number6 = new JButton("6");
    number7 = new JButton("7");
    number8 = new JButton("8");
    number9 = new JButton("9");
    decimalPoint = new JButton(".");

    buttonDivide = new JButton("/");
    buttonMultiply = new JButton("*");
    buttonMinus = new JButton("-");
    buttonEquals = new JButton("=");
    buttonPlus = new JButton("+");

    pressedEquals = false;

    setupLayout();
    registerListeners();
  }

  void setupLayout() {
    // Buttons setup
    buttonsPanel.setLayout(new GridLayout(4,4));

    buttonsPanel.add(number7);
    buttonsPanel.add(number8);
    buttonsPanel.add(number9);
    buttonsPanel.add(buttonDivide);

    buttonsPanel.add(number4);
    buttonsPanel.add(number5);
    buttonsPanel.add(number6);
    buttonsPanel.add(buttonMultiply);

    buttonsPanel.add(number1);
    buttonsPanel.add(number2);
    buttonsPanel.add(number3);
    buttonsPanel.add(buttonMinus);

    buttonsPanel.add(number0);
    buttonsPanel.add(decimalPoint);
    buttonsPanel.add(buttonEquals);
    buttonsPanel.add(buttonPlus);

    // Add all up
    contentPane.setLayout(new BorderLayout());
    contentPane.add(display, BorderLayout.NORTH);
    contentPane.add(buttonsPanel, BorderLayout.CENTER);

    pack();
  }
  
  void registerListeners() {
    number0.addActionListener((e) -> numberPressed(e));
    number1.addActionListener((e) -> numberPressed(e));
    number2.addActionListener((e) -> numberPressed(e));
    number3.addActionListener((e) -> numberPressed(e));
    number4.addActionListener((e) -> numberPressed(e));
    number5.addActionListener((e) -> numberPressed(e));
    number6.addActionListener((e) -> numberPressed(e));
    number7.addActionListener((e) -> numberPressed(e));
    number8.addActionListener((e) -> numberPressed(e));
    number9.addActionListener((e) -> numberPressed(e));
    decimalPoint.addActionListener((e) -> numberPressed(e));

    buttonDivide.addActionListener((e) -> operatorPressed(e));
    buttonEquals.addActionListener((e) -> operatorPressed(e));
    buttonPlus.addActionListener((e) -> operatorPressed(e));
    buttonMinus.addActionListener((e) -> operatorPressed(e));
    buttonMultiply.addActionListener((e) -> operatorPressed(e));
  }

  void numberPressed(ActionEvent e) {
    JButton buttonPressed = (JButton) e.getSource();
    String btnString = buttonPressed.getText();

    if(!btnString.equals(".")){
      if(display.getText().equals("0") || pressedEquals)
        display.setText("");

      display.setText(display.getText() + btnString);
    } else {
      if(display.getText().charAt(display.getText().length() - 1) == ' ')
        display.setText(display.getText() + "0.");
      else
        display.setText(display.getText() + ".");
    }

    pressedEquals = false;
  }
  
  void operatorPressed(ActionEvent e) {
    JButton buttonPressed = (JButton) e.getSource();
    String btnString = buttonPressed.getText();

    if(!btnString.equals("="))
      display.setText(display.getText() + " " + btnString + " ");
    else
      formatDisplay();

    pressedEquals = btnString.equals("=");
  }

  private void formatDisplay() {
    String[] elements = display.getText().split(" ");

    double buffer = Double.parseDouble(elements[0]);

    for(int i = 1; i < elements.length; i+=2){
      if(elements[i].equals("+"))
        buffer += Double.parseDouble(elements[i+1]);
      else if(elements[i].equals("-"))
        buffer -= Double.parseDouble(elements[i+1]);
      else if(elements[i].equals("*"))
        buffer *= Double.parseDouble(elements[i+1]);
      else if(elements[i].equals("/"))
        buffer /= Double.parseDouble(elements[i+1]);
    }

    display.setText(String.valueOf(buffer));
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      try {
        Calculator frame = new Calculator();
        frame.pack();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}
