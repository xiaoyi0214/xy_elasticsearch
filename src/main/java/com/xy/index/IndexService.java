package com.xy.index;

import java.io.IOException;

public interface IndexService {

    boolean createIndex(String index);

    void deleteIndex(String index);

    boolean existIndex(String index) throws IOException;

}
