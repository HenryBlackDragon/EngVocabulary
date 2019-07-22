package com.alex.util;

import com.alex.model.TitleVocabulary;

public class Util {

    public static TitleVocabulary convert(final TitleVocabulary vocFromDB) {
        return TitleVocabulary.builder()
                .title(vocFromDB.getTitle().toLowerCase())
                .build();

    }
}
