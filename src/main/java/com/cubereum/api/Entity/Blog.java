package com.cubereum.api.Entity;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    private String _id;

    private String title;

    private String blogDetails;

    @DBRef
    @Nullable
    private User user;

    @CreatedDate
    private Date uploadDate;
}
