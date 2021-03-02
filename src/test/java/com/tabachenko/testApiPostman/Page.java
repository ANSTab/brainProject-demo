package com.tabachenko.testApiPostman;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Page {
    private int page;
    private String per_page;
    private String total;
    private String total_pages;
    private Data [] data;
    private Support support;

    @Getter
    @Setter
    public class Data {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

    }
    @Getter
    @Setter
    public class Support {
        private String url;
        private String text;
    }
}