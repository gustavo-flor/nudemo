package br.com.nudemo.customerservice.util;

import lombok.experimental.UtilityClass;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@UtilityClass
public class StringUtil {
    private static final Pattern ONLY_NUMBERS = Pattern.compile("\\d+");

    public String getOnlyNumbers(final String value) {
        return ONLY_NUMBERS.matcher(value)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.joining());
    }
}
