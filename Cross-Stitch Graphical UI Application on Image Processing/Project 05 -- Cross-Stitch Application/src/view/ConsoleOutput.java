package view;

import java.io.IOException;
import javax.swing.JTextArea;

/**
 * It displays messages to the view about the current operations. This helps the user to view the
 * operation being performed and task executed.
 */
public class ConsoleOutput implements Appendable {
  private JTextArea textArea;

  public ConsoleOutput(JTextArea textArea) {
    this.textArea = textArea;
  }

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    textArea.append(String.valueOf(csq));
    textArea.setCaretPosition(textArea.getDocument().getLength());
    return null;
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    textArea.append(String.valueOf(csq));
    textArea.setCaretPosition(textArea.getDocument().getLength());
    return null;
  }

  @Override
  public Appendable append(char c) throws IOException {
    textArea.append(String.valueOf(c));
    textArea.setCaretPosition(textArea.getDocument().getLength());
    return null;
  }
}
