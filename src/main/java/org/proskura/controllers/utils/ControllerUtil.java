package org.proskura.controllers.utils;

import javax.servlet.http.HttpServletRequest;

public final class ControllerUtil {
    public static String getRemoutIp (HttpServletRequest request) {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }
}
