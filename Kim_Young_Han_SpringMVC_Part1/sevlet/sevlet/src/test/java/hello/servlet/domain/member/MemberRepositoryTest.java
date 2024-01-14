package hello.servlet.domain.member;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    // 순서가 보장이 안되기 때문에 하나의 테스트가 끝나면 계속 클리어 해주어야 한다.
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
            Member member = new Member("hello", 20);
        // when
            Member savedMember = memberRepository.save(member);
        // then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member = new Member("hello", 20);
        Member member1 = new Member("kim", 30);

        memberRepository.save(member);
        memberRepository.save(member1);

        // when
        List<Member> result = memberRepository.findAll();


        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member, member1);

    }
}