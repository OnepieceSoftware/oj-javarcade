package org.example.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jakarta.rs.json.annotation.JSONP;
import com.google.common.collect.ImmutableList;
import jakarta.activation.CommandObject;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Lib {

    public List<String> process(ObjectMapper mapper) {
        return ImmutableList.of("ABC", StringUtils.abbreviate("abc", 1));
    }

    @JSONP
    @Deprecated
    public static void doWork() {
        CommandObject o = (s, dataHandler) -> { };
        if (o.toString().equals("conf")) {
            return;
        }
        new Lib();
    }
}
