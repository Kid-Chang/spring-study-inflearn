package hello.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

    // private DataSource dataSource;
    //
    // @Autowired
    // public SpringConfig(DataSource dataSource){
    //     this.dataSource = dataSource;
    // }

    // private EntityManager em;
    //
    // @Autowired
    // public SpringConfig(EntityManager em) {
    //     this.em = em;
    // }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
    // 기존에는 아래 memberRepository()를 통해 구현체를 호출해서 리턴했지만, 스프링 데이터 JPA를 이용할때는 구현체가 알아서 생성되므로, private final MemberRepository memberRepository; 하나 만들고 넣어주면 끝.

    // @Bean
    // public MemberRepository memberRepository(){
    //     // return new MemoryMemberRepository();
    //     // return new JdbcMemberRepository(dataSource);
    //     // return new JdbcTemplateMemberRepository(dataSource);
    //     return new JpaMemberRepository(em);
    // }
}
