package practice24.exercise3;

import javax.swing.*;
import java.awt.*;
import java.io.StringWriter;
import java.nio.file.Paths;

class TextDocument implements IDocument {
    private final String path;
    private String text;

    public TextDocument(String path) {
        this.path = path;
        text = "";
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

class CreateTextDocument extends ICreateDocument {
    private final Frame parentFrame;

    public CreateTextDocument(Frame parentFrame) {
        this.parentFrame = parentFrame;
    }

    @Override
    public IDocument createNew() {
        var fileDialog = new FileDialog(parentFrame, "Choose directory", FileDialog.LOAD);
        fileDialog.setDirectory("C:\\");
        fileDialog.setVisible(true);

        var directory = fileDialog.getDirectory();

        var fileName = JOptionPane.showInputDialog(parentFrame, "Enter file name") + ".txt";

        return new TextDocument(Paths.get(directory, fileName).toAbsolutePath().toString());
    }

    @Override
    public IDocument createOpen() {

        return null;
    }
}

public class TextEditorApp extends BaseApp {
    public TextEditorApp(ICreateDocument documentCreator) {
        super(documentCreator);
    }
}
