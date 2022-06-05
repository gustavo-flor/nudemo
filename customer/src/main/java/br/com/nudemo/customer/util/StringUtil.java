package br.com.nudemo.customer.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtil {
    private static final Pattern ONLY_DIGITS = Pattern.compile("\\d+");

    public static String getOnlyDigits(final String value) {
        return ONLY_DIGITS.matcher(value)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.joining());
    }
}
