package org.example.lib;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Lib {

    public List<String> process() {
        return ImmutableList.of("ABC", StringUtils.abbreviate("abc", 1));
    }

    @Deprecated
    public static void doWork() {
        new Lib();
    }
}
