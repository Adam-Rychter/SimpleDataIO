package SImpleDataIO;

import java.util.Collection;

public interface SimpleDataIO {

    public Boolean writeCsv(String path, Collection<?> data);
    public Collection<?> readCsv(String path, Class<?> dataClass);

}
