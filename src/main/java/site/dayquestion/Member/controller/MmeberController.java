package site.dayquestion.Member.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.dayquestion.Member.service.MemberService;
import site.dayquestion.domain.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MmeberController {
    private final MemberService memSer;

    @PostMapping("/api/auth/register")
    public CreateMemberResponse joinMember(@RequestBody CreateMemberRequest request){
        Member member = Member.builder()
                .email(request.email)
                .password(request.password)
                .nickname(request.nickname)
                .build();
        Long id = memSer.join(member);
        return new CreateMemberResponse(id);
    }

    @PutMapping("/api/members/my-info")
    public UpdateMemberResponse updateMember(@RequestBody UpdateMemberRequest request){
        Member updateMem = memSer.update(request.memberId, request.nickname, request.introduction, request.password, request.profileImage);
        return new UpdateMemberResponse(updateMem);
    }

    @GetMapping("/api/members/{member-id}")
    public findMemberResponse findMember(@PathVariable("member-id") Long id){
        Member member = memSer.findOne(id);
        return new findMemberResponse(member);
    }

    @GetMapping("/api/members/profile")
    public findMeResponse findMember(@RequestBody idRequestDTO request){
        Member member = memSer.findOne(request.memberId);
        return new findMeResponse(member);
    }

    @GetMapping("/api/members/feeds")
    public Result randomMemList(@RequestParam("limit") int limit){
        List<Member> nTTList = memSer.findMemList(limit);
        List<MemberDTO> memList = nTTList.stream()
                .map(MemberDTO::new)
                .toList();
        return new Result(memList);
    }
    @Data
    static class MemberDTO {
        private Long memberId;
        private String nickname;
        private String introduction;
        private String profileImage;
        public MemberDTO(Member member){
            this.memberId = member.getId();
            this.nickname = member.getNickname();
            this.introduction = member.getIntroduce();
            this.profileImage = member.getProfileImageUrl();
        }
    }

    @Data
    static class randomMemberResponse {
        private Long memberId;
        private String nickname;
        private String introduction;
        private String profileImage;
        public randomMemberResponse(Member member){
            this.memberId = member.getId();
            this.nickname = member.getNickname();
            this.introduction = member.getIntroduce();
            this.profileImage = member.getProfileImageUrl();
        }
    }

    @Data
    static class findMeResponse{
        private int answeredDays;
        private int questionDays;
        private int followerNum;
        private int followingNum;
        private LocalDate signUpDate;
        private String email;
        private String nickname;
        private String introduction;
        private String password;
        private String profileImage;

        public findMeResponse(Member member){
            this.answeredDays = 10;
            this.questionDays = Period.between(member.getCreatedAt().toLocalDate(), LocalDateTime.now().toLocalDate()).getDays()+1;
            this.followerNum = 10;
            this.followingNum = 10;
            this.signUpDate = member.getCreatedAt().toLocalDate();
            this.email = member.getEmail();
            this.nickname = member.getNickname();
            this.introduction = member.getIntroduce();
            this.password = member.getPassword();
            this.profileImage = member.getProfileImageUrl();
        }
    }

    @Data
    static class idRequestDTO{
        private Long memberId;

    }

    @Data
    static class findMemberResponse {
        private String profileImage;
        private String nickname;
        private int answeredDays;
        private int questionDays;
        private String introduction;
        private int followerNum;
        private int followingNum;
        private boolean isFollowedByMe;
        public findMemberResponse(Member member){
            this.profileImage = member.getProfileImageUrl();
            this.nickname = member.getNickname();
            this.answeredDays = 10;
            this.questionDays = Period.between(member.getCreatedAt().toLocalDate(), LocalDateTime.now().toLocalDate()).getDays()+1;
            this.introduction = member.getIntroduce();
            this.followerNum = 10;
            this.followingNum = 10;
            this.isFollowedByMe = true;
        }
    }

    @Data
    static class UpdateMemberResponse{
        private String nickname;
        private String introduction;
        private String password;
        private String profileImage;
        private Long memberId;
        public UpdateMemberResponse(Member member){
            this.memberId = member.getId();
            this.nickname = member.getNickname();
            this.introduction = member.getIntroduce();
            this.password = member.getPassword();
            this.profileImage = member.getProfileImageUrl();
        }
    }
    @Data //이걸 써야 할텐데?
    static class memberProfileDTO{
        private String nickname;
        private String introduction;
        private String password;
        private String profileImg;
        private Long memberId;
    }

    @Data
    static class UpdateMemberRequest{
        private String nickname;
        private String introduction;
        private String password;
        private String profileImage;
        private Long memberId;
    }

    @Data
    static class CreateMemberResponse{
        private Long memberId;
        public CreateMemberResponse(Long id){
            this.memberId = id;
        }
    }
    @Data
    static class CreateMemberRequest{
        private String email;
        private String password;
        private String nickname;
    }

    @Data
    @AllArgsConstructor
    public class Result<T>{
        private T result;
    }
}
