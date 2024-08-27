package org.scoula.member.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
    private String username;
    private String email;
    private Date regDate;
    private Date updateDate;
    private String mbti;

    MultipartFile avatar;

    private List<String> authList;

    public static MemberDTO of(MemberVO m) {
        return MemberDTO.builder()
                .username(m.getUsername())
                .email(m.getEmail())
                .regDate(m.getRegDate())
                .updateDate(m.getUpdateDate())
                .mbti(m.getMbti())
                .authList(m.getAuthList().stream().map(a->a.getAuth()).toList())
                .build();
    }
}
