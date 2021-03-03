package com.tabachenko.testApiPostman;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
public class Page {
    private int page;
    private String per_page;
    private String total;
    private String total_pages;
    private Data1 [] data;
    private Support support;
}