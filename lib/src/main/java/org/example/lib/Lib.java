package org.example.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Lib {

    public List<String> process(ObjectMapper mapper) {
        return ImmutableList.of("ABC", StringUtils.abbreviate("abc", 1));
    }
}
