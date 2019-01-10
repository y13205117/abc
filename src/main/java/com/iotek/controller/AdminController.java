package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Resource(name = "departmentServiceImpl")
    private DepartmentService departmentService;
    @Resource(name = "recruitServiceImpl")
    private RecruitService recruitService;
    @Resource(name = "memberShowCVServiceImpl")
    private MemberShowCVService memberShowCVService;
    @Resource(name = "trainServiceImpl")
    private TrainService trainService;
    @Resource(name = "gateCardServiceImpl")
    private GateCardService gateCardService;
    @Resource(name = "awardRecordServiceImpl")
    private AwardRecordService awardRecordService;
    @Resource(name = "leaveServiceImpl")
    private LeaveService leaveService;
    @RequestMapping("/goAdmin")
    public String goAdmin(HttpSession session)throws Exception{
        List<Recruit2> recruits = recruitService.queryRecruit();
        List<Department> departments = departmentService.queryDepartment();
        List<Train> trains=trainService.queryAll();
        List<GateCard> gateCards=gateCardService.queryAll();
        List<AwardRecord> awardRecords = awardRecordService.queryAll();
        List<Leave> leaves = leaveService.queryByState();
        session.setAttribute("department",departments);
        session.setAttribute("recruit",recruits);
        session.setAttribute("train",trains);
        session.setAttribute("gateCard",gateCards);
        session.setAttribute("awardRecord",awardRecords);
        session.setAttribute("leave",leaves);
        return "admin";
    }
    @RequestMapping("/amdinSendRecruit")
    public void sendRecruit(HttpSession session, Recruit recruit, HttpServletResponse response) throws Exception{
        boolean res = recruitService.saveRecruit(recruit);
        if(res){
            List<Recruit2> recruits = recruitService.queryRecruit();
            session.setAttribute("recruit",recruits);
            response.getWriter().print("<script language='javascript'>alert('发布成功');</script>");
            response.sendRedirect("goAdmin");
        }else{
            response.getWriter().print("<script language='javascript'>alert('发布失败');</script>");
        }
    }
    @RequestMapping("queryMCV")
    @ResponseBody
    public List<MemberShowCV> queryMCV(Integer mid)throws Exception{
        List<MemberShowCV> memberShowCVS = memberShowCVService.queryByRid(mid);
        return memberShowCVS;
    }
    @RequestMapping("updateMCV")
    public void updateMCV(Integer mid)throws Exception{
        boolean res = memberShowCVService.updateMemberShowCV(mid);
    }
    @RequestMapping("invMCV")
    public void invMCV(Integer mid,HttpServletResponse response)throws Exception{
        int i = memberShowCVService.updateInv(mid);
        if(i==2){
            response.getWriter().write("已发送面试邀请");
        }else if(i==3){
            response.getWriter().write("面试邀请失败");
        }else if(i==1){
            response.getWriter().write("已发送邀请,请不要重复发送");
        }else {
            response.getWriter().write("无效数据");
        }
    }
    @RequestMapping("addTrain")
    public String addTrain(Train train,HttpSession session)throws Exception{
        boolean res = trainService.saveTrain(train);
        if(res){
            List<Train> trains = trainService.queryAll();
            session.setAttribute("train",trains);
        }
        return "admin";
    }
    @RequestMapping("delTrain")
    public void delTrain(Integer id,HttpSession session,HttpServletResponse response)throws Exception{
        boolean res = trainService.deleteTrain(id);
        if(res){
            List<Train> trains = trainService.queryAll();
            session.setAttribute("train",trains);
            response.getWriter().write("删除成功");
        }else{
            response.getWriter().write("删除失败");
        }
    }
    @RequestMapping("quLea")
    @ResponseBody
    public List<Leave> quLea(HttpSession session)throws Exception{
        List<Leave> leaves= (List<Leave>) session.getAttribute("leave");
        return leaves;
    }
    @RequestMapping("upLea")
    public void upLea(Integer eid,HttpSession session,HttpServletResponse response)throws Exception{
        boolean res = leaveService.updateLeave(eid);
        if(res){
            List<Leave> leaves = leaveService.queryByState();
            session.setAttribute("leave",leaves);
            response.getWriter().write("离职办理成功");
        }
        response.getWriter().write("离职办理失败");
    }
}
