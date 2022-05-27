package capstone.thecloset;

import capstone.thecloset.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
  class H2DbApplicationTests {
    private final MemberRepository memberRepository;
       //의존성 주입
    @Autowired
    public H2DbApplicationTests(MemberRepository memberRepository){
        this.memberRepository =memberRepository;
    }
    @Test
    void 회원가입(){
        //멤버 저장
        Member member = new Member();
        member.setName("skyepodium");
        memberRepository.save(member);

        //저장한 멤버 아이디로 검색
        Member findMember=memberRepository.findById(member.getID()).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }
}
