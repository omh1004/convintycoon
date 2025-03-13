package com.bs.spring.member.model.dto;


import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member{
    private String userId;
    private String password;
    private String nick;
    private String email;

}
