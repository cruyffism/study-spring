package ch04_ex01.center;


import org.springframework.context.support.GenericXmlApplicationContext;

import ch04_ex01.center.member.Member;
import ch04_ex01.center.member.service.CenterInformationService;
import ch04_ex01.center.member.service.MemberDeleteService;
import ch04_ex01.center.member.service.MemberModifyService;
import ch04_ex01.center.member.service.MemberRegisterService;
import ch04_ex01.center.member.service.MemberSelectService;
import ch04_ex01.center.member.service.PrintMemberInformationService;
import ch04_ex01.center.utils.InitSampleData;

public class MainClass {

    public static void main(String[] args) {

        /*
         * IoC 컨테이너 생성
         */
        GenericXmlApplicationContext ctx = 
                new GenericXmlApplicationContext("classpath:applicationContext.xml");
        
//        GenericXmlApplicationContext ctx = 
//                new GenericXmlApplicationContext("classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml");
        
//        String[] appCtxs = {"classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml"}; 
//        GenericXmlApplicationContext ctx = 
//                new GenericXmlApplicationContext(appCtxs);
        
//        GenericXmlApplicationContext ctx = 
//                new GenericXmlApplicationContext("classpath:appCtxImport.xml");
        
        /*
         * 샘플 데이터
         */
        InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
        String[] mIds = initSampleData.getmIds();
        String[] mPws = initSampleData.getmPws();
        String[] mNames = initSampleData.getmNames();
        String[] mPhones = initSampleData.getmPhones();
        String[] mMails = initSampleData.getmMails();
		/*
		 * String[] newDates = initSampleData.getNewDates(); String[] changeDates =
		 * initSampleData.getChangeDates();
		 */
        
        /*
         * 데이터베이스에 샘플 데이터 등록
         */
        MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
        for (int i = 0; i < mIds.length; i++) {
            registerService.register(new Member(mIds[i], mPws[i], mNames[i], mPhones[i], mMails[i], Member.nowDate(), Member.nowDate()));
            
        }
        
        /*
         * 학생 리스트
         */
        System.out.println("샘플데이터 조회");
        PrintMemberInformationService printMemberInformatinService =  ctx.getBean("printMemberInformationService", PrintMemberInformationService.class);
        printMemberInformatinService.printMembersInfo();   // 학생 리스트
        
        
        /*
         * 학생 등록
         */
        registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
        registerService.register(new Member("hbs006", "p0006", "melissa", "0100000000", "qwert@naver.com", Member.nowDate(), Member.nowDate()));
        
        System.out.println("신규 회원 등록 후");
        printMemberInformatinService.printMembersInfo();   // 학생 리스트
        
        System.out.println("중복 회원 등록 후");
        registerService.register(new Member("hbs006", "p0006", "melissa", "0100000000", "qwert@naver.com", Member.nowDate(), Member.nowDate()));
        /*
         * 학생 조회
         */
        MemberSelectService selectService = ctx.getBean("memberSelectService", MemberSelectService.class);
        Member selectedMember = selectService.select("hbs006");
        
        System.out.println("회원 한명만 조회");
        System.out.println("MEMBER START ------------------");
        System.out.print("mId:" + selectedMember.getmId() + "\t");
        System.out.print("|mPw:" + selectedMember.getmPw() + "\t");
        System.out.print("|mName:" + selectedMember.getmName() + "\t");
        System.out.print("|mPhone:" + selectedMember.getmPhone() + "\t");
        System.out.print("|mMails:" + selectedMember.getmMail() + "\t");
        System.out.print("|newDate:" + selectedMember.getNewDate()+ "\t");
        System.out.println("|changeDate:" + selectedMember.getChangeDate());
        System.out.println("END ----------------------------");
        
        /*
         * 학생 수정
         */
        MemberModifyService modifyService = ctx.getBean("memberModifyService", MemberModifyService.class);
        modifyService.modify(new Member("hbs006", "p0006", "melissa", "0101234567", "qwert@naver.com", Member.nowDate(), Member.nowDate()));
        
        System.out.println("회원 정보 수정 후 조회");
        printMemberInformatinService.printMembersInfo();   // 학생 리스트
        
        /*
         * 학생 삭제
         */
        MemberDeleteService deleteService = ctx.getBean("memberDeleteService", MemberDeleteService.class);
        deleteService.delete("hbm005");
        
        System.out.println("회원 삭제 후 조회");
        printMemberInformatinService.printMembersInfo();   // 학생 리스트
        
        /*
         * 시스템 정보
         */
        
        System.out.println("센터 정보 조회");
        CenterInformationService centerInformationService = ctx.getBean("centerInformationService", CenterInformationService.class);
        centerInformationService.printEMSInformation();
        
        ctx.close();

    }

}
