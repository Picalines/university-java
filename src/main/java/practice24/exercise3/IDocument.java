package practice24.exercise3;

import java.io.Writer;

public interface IDocument {
    String getPath();
    void save(Writer writer);
}
