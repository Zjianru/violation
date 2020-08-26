package com.code.vv.common;

import com.code.vv.model.ViolationContextTb;
import com.code.vv.model.ViolationInfoTb;
import com.code.vv.vo.ViolationDetails;

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
        details.setLicensePlate(info.getLicensePlate());
        details.setTime(info.getTime());
        details.setPlace(info.getPlace());
        details.setDriverLicense(info.getDriverLicense());

        details.setViolationContextId(info.getViolationContext());

        details.setContext(context.getContext());
        details.setDeduction(context.getDeduction());
        details.setAmerce(context.getAmerce());

        return details;
    }
}
