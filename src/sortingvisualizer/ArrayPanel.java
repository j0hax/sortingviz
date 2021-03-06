package sortingvisualizer;

import javax.swing.*;
import java.awt.*;

public class ArrayPanel extends JPanel {

  public static int UNITS = 200;

  public int[] bits = new int[UNITS];
  //private int[] active = new int[UNITS];
  private String currentOperation = "";
  private String operationDescription = "";

  public ArrayPanel() {
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(512, 512));

    for (int i = 0; i < bits.length; i++) {
      bits[i] = i;
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int i = 0; i < UNITS; i++) {
      g.setColor(Color.getHSBColor((bits[i] / (float) UNITS), 1, 1));
      int x = (int) Math.floor(i * (getWidth() / (float) UNITS));
      int y = (int) Math.floor(getHeight() - (bits[i] / (float) UNITS) * getHeight()) - 1;
      int width = (int) Math.ceil(getWidth() / (float) UNITS);
      int height = getHeight() - y;
      g.fillRect(x, y, width, height);
      /*if (i == active[0] || i == active[1]) {
          g.setColor(Color.WHITE);
          g.drawRect(x, y, width, height);
      }*/
    }

    // Text drawing
    int textHeight = g.getFontMetrics().getHeight();
    g.setColor(Color.WHITE);
    g.drawString(currentOperation, 0, textHeight);
    g.drawString(operationDescription, 0, textHeight * 2);
    //g.drawString("Accesses: " + accesses, 0, textHeight * 3);
  }

  public void resetStatistics() {
    currentOperation = "";
    operationDescription = "";
  }

  public void setCurrentOperation(String currentOperation) {
    this.currentOperation = currentOperation;
  }

  public void setOperationDescription(String OperationDescription) {
    this.operationDescription = OperationDescription;
  }
}
