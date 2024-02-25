package site.dayquestion.Member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Member.repository.MemberRepository;
import site.dayquestion.domain.Member;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memRepo;

    //가입
    public Long join(Member member){
        memRepo.save(member);
        return member.getId();
    }

    //회원 하나 조회
    public Member findOne(Long id){
        return memRepo.findMemberById(id);
    }
    //회원 다건 조회
    public List<Member> findMemList(int limit){ return memRepo.findMemberList(limit); }

    //프로필수정
    public Member update(Long id, String newNickname, String newIntroduce, String newPassword, String newProfileImageUrl){
        Member member = memRepo.findMemberById(id);
        member.editProfile(id, newNickname, newIntroduce, newPassword, newProfileImageUrl);
        return member;
    }

}
