package com.springbootacademy.batch7.pos.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardResponse {
    private int statusCode;
    private String statusMessage;
    private Object body;
}
