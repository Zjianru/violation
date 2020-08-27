package com.code.vv.common;

import com.code.vv.model.ViolationContextTb;
import com.code.vv.model.ViolationInfoTb;
import com.code.vv.vo.ViolationDetails;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2020/8/25.
 * com.code.vv.common
 * VO 封装转换工具
 * @author Zjianru
 */
public class VoTransfer {
    /**
     * ViolationDetails 对象转换工具
     * @param info ViolationInfoTb 对象
     * @param context ViolationContextTb 对象
     * @return ViolationDetails 对象
     */
    public static ViolationDetails detailVoTransfer(ViolationInfoTb info, ViolationContextTb context) {
        ViolationDetails details = new ViolationDetails();
        details.setViolationId(info.getId());
        details.setLicensePlate(info.getLicensePlate());
        details.setTime(DateFormat.dateToString(info.getTime()));
        details.setPlace(info.getPlace());details.setDeductionStatus(info.getDeductionStatus());
        details.setDriverLicense(info.getDriverLicense());
        details.setAmerceStatus(info.getAmerceStatus());
        details.setViolationContextId(info.getViolationContext());
        details.setContext(context.getContext());
        details.setDeduction(context.getDeduction());
        details.setAmerce(context.getAmerce());
        return details;
    }

    /**
     * 两个 List 的组装逻辑
     * @param infoList 违章信息 List
     * @param contextList 违章内容 List
     * @return  List<ViolationDetails>
     */
    public static List<ViolationDetails> detailVoTransfer(List<ViolationInfoTb> infoList, List<ViolationContextTb> contextList) {
        LinkedList<ViolationDetails> detailsList = new LinkedList<>();
        for (ViolationInfoTb info : infoList) {
            Integer violationContextId = info.getViolationContext();
            for (ViolationContextTb context : contextList) {
                Integer contextId = context.getId();
                if (contextId.equals(violationContextId)) {
                    ViolationDetails details = detailVoTransfer(info, context);
                    detailsList.add(details);
                }
            }
        }
        return detailsList;
    }
}
