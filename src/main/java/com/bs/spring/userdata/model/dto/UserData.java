package com.bs.spring.userdata.model.dto;

import com.bs.spring.member.model.dto.Storage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserData implements Serializable {

    private String nickname;  // 사용자 닉네임
    private String userId;    // 사용자 ID
    private String email;
    private Integer  totalRevenue; // 총 수익

    private Integer cash;
    private Integer loan;
    private Integer storageLevel;
    private Integer playNo;

    private List<Storage> storage;
}
