package practice24.exercise3;

import java.io.StringWriter;

public interface IDocument {
    String getPath();
    void save(StringWriter writer);
}
