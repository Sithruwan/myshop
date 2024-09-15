package com.sith.ecom.myshop.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonFileSaveBinaryDataDto {
    private Blob hash;
    private String directory;
    private Blob fileName;
    private Blob resourceUrl;
}
