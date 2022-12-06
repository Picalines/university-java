package practice24.exercise3;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Optional;

public abstract class BaseApp extends JFrame {
    protected final ICreateDocument documentCreator;

    private IDocument document = null;

    public BaseApp(ICreateDocument documentCreator) {
        super();

        this.documentCreator = documentCreator;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        var menuBar = new MenuBar();
        var fileMenu = new Menu("File");
        menuBar.add(fileMenu);

        var newFileMenuItem = fileMenu.add(new MenuItem("New"));
        var openFileMenuItem = fileMenu.add(new MenuItem("Open"));
        var saveFileMenuItem = fileMenu.add(new MenuItem("Save"));
        var quitFileMenuItem = fileMenu.add(new MenuItem("Quit"));

        quitFileMenuItem.addActionListener(l -> setVisible(false));

        newFileMenuItem.addActionListener(l -> {
            document = documentCreator.createNew();
            onDocumentCreated();
        });

        openFileMenuItem.addActionListener(l -> {
            document = documentCreator.createOpen();
            onDocumentCreated();
        });

        saveFileMenuItem.addActionListener(l -> {
            if (document == null) {
                return;
            }

            var path = document.getPath();

            var stringWriter = new StringWriter();
            document.save(stringWriter);

            var lines = new ArrayList<String>();
            lines.add(stringWriter.toString());

            try {
                Files.write(Paths.get(path), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Failed to write file to " + path);
            }
        });

        setMenuBar(menuBar);
    }

    public Optional<IDocument> getCurrentDocument() {
        return Optional.ofNullable(document);
    }

    protected void onDocumentCreated() {}
}
