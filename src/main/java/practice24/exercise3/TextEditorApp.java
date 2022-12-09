package practice24.exercise3;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.AccessDeniedException;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.function.Consumer;

class TextDocument implements IDocument {
    private final String path;
    private String text;

    public TextDocument(String path) throws IOException {
        this.path = path;

        var file = new File(path);
        if (!file.exists() && !file.createNewFile()) {
            throw new AccessDeniedException("failed to create file");
        }

        var scanner = new Scanner(file);
        var builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
            builder.append('\n');
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        text = builder.toString();
    }

    @Override
    public String getPath() {
        return path;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void save(StringWriter writer) {
        writer.write(text);
    }
}

class CreateTextDocument implements ICreateDocument {
    private Frame dialogParentFrame;

    public void setDialogParentFrame(Frame frame) {
        dialogParentFrame = frame;
    }

    @Override
    public TextDocument createNew() {
        while (true) {
            var fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("TXT file", "txt"));
            fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            if (fileChooser.showOpenDialog(dialogParentFrame) != JFileChooser.APPROVE_OPTION) {
                throw new CancellationException();
            }

            var fileName = JOptionPane.showInputDialog(dialogParentFrame, "Enter file name") + ".txt";
            var filePath = fileChooser.getSelectedFile().getPath() + fileName;

            try {
                return new TextDocument(filePath);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(dialogParentFrame, "Failed to create file at " + filePath);
            }
        }
    }

    @Override
    public TextDocument createOpen() {
        while (true) {
            var fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("TXT file", "txt"));
            fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            if (fileChooser.showOpenDialog(dialogParentFrame) != JFileChooser.APPROVE_OPTION) {
                throw new CancellationException();
            }

            var filePath = fileChooser.getSelectedFile().getPath();

            try {
                return new TextDocument(filePath);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(dialogParentFrame, "Failed to open file at " + filePath);
            }
        }
    }
}

class ChangedDocumentListener implements DocumentListener {
    private final Consumer<DocumentEvent> eventConsumer;

    public ChangedDocumentListener(Consumer<DocumentEvent> eventConsumer) {
        this.eventConsumer = eventConsumer;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.eventConsumer.accept(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.eventConsumer.accept(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.eventConsumer.accept(e);
    }
}

public class TextEditorApp extends BaseApp {
    private final JTextArea textArea;

    public TextEditorApp() {
        super(new CreateTextDocument());
        ((CreateTextDocument)documentCreator).setDialogParentFrame(this);

        setTitle("Text editor");
        setSize(400, 300);
        setResizable(true);

        textArea = new JTextArea();
        add(textArea);

        var changedDocumentListener = new ChangedDocumentListener(e -> {
            getCurrentDocument().ifPresent(doc -> ((TextDocument) doc).setText(textArea.getText()));
        });

        textArea.getDocument().addDocumentListener(changedDocumentListener);

        setVisible(true);
    }

    @Override
    protected void onDocumentCreated() {
        super.onDocumentCreated();

        textArea.setText(((TextDocument)getCurrentDocument().orElseThrow()).getText());
    }

    public static void main(String[] args) {
        new TextEditorApp();
    }
}
