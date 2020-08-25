package com.code.vv.common;

import com.code.vv.model.ViolationContextTb;
import com.code.vv.model.ViolationInfoTb;
import com.code.vv.vo.ViolationDetails;

/**
 * Created on 2020/8/25.
 * com.code.vv.common
 *
 * @author Zjianru
 */
public class VoTransfer {
    public static ViolationDetails detailVoTransfer(ViolationInfoTb info, ViolationContextTb context) {
        return new ViolationDetails(info.getId(), info.getLicensePlate(),
                info.getTime(), info.getPlace(),
                context.getId(), context.getContext(),
                context.getDeduction(), context.getAmerce(),
                context.getDriverLicense());
    }
}
