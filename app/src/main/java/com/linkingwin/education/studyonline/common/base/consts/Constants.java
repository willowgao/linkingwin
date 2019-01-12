package com.linkingwin.education.studyonline.common.base.consts;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc
 * @Author Willowgao
 * @Version V1.0
 * @Date 2017/12/26
 */

public class Constants {
    public static String APP_SIGN = "ewidecloud";
    /**
     * 系统请求连接
     */
    public static Map<String, String> systemLink;

    static {
        if (systemLink == null) {
            systemLink = new HashMap();


            /** real
             systemLink.put(SystemID.SAASOP, "http://192.168.8.106:8080/saasop");


             systemLink.put(SystemID.SAASOP, "https://op.ewidecloud.com/saasop");
             **/

            /** al-test  **/
            systemLink.put(SystemID.SAASOP, "http://47.94.159.136:18000/saasop");

        }
    }


    /**
     * 系统id
     */
    public static class SystemID {
        /**
         * 营收系统
         */
        public static final String SAASOC = "1";
        /**
         * 运营系统
         */
        public static final String SAASOP = "2";
        /**
         * 企业门户
         */
        public static final String SAASPT = "3";
        /**
         * 消息平台
         */
        public static final String SAASMS = "4";
        /**
         * 短信网关
         */
        public static final String SAASWG = "8";
        /**
         * 支付平台
         */
        public static final String SAASPAY = "11";
        /**
         * 发票平台
         */
        public static final String SAASINV = "12";
        /**
         * 管网监测
         */
        public static final String SAASGWJC = "13";
        /**
         * 邮件平台
         */
        public static final String SAASMAIL = "13";
        /**
         * 微信平台
         */
        public static final String SAASWECHART = "15";
        /**
         * 支付平台
         */
        public static final String SAASZF = "16";
        /**
         * 物联平台
         */
        public static final String SAASIOT = "17";
        /**
         * 统一远传平台
         */
        public static final String SAASRTP = "18";
    }


    public static class HttpConsts {
        public static String SYSTTEM_ID = "systemId";
        public static String TOKEN_ID = "token";
        public static String RESULT_OK = "ok";
        public static String RESULT_ERR = "err";


        public static String getServerUrl(String systemId) {
            return systemLink.get(systemId);
        }

        /**
         * 检查APP【版本信息】
         */
        public static final String URL_SELECT_VERSION = "/saas/app/selectVersion";

        /**
         * 数据字典查询
         */
        public static final String SYS_DIC = "/bf/dc/dictionary/selectDicList.do";


        public class PerfectUrls {


            /**
             * 用户【登录】
             */
            public static final String OP_URL_LOGIN = "/user/mobileLogin";
            /**
             * 查询所有用户
             */
            public static final String OP_QUERY_ALL_USER = "/role/queryAllUser";

        }

    }


}
