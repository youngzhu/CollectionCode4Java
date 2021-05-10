package github.workflow;

import org.young.util.DateUtil;
import org.young.util.EDSUtil;

import java.util.Date;

public class EDSLogger {
    public static void main(String[] args) throws Exception {
        // 登陆
        EDSUtil.login(args[0], args[1]);

        // 周报
        String today = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, new Date());
        EDSUtil.weekReportToEDS(today);

        // 日报
        Date logDate = new Date();

        for (int i = 0; i < 5; i++) {
            String dateStr = DateUtil.getFormatDate(DateUtil.DATE_PATTERN_YMD, logDate);
            System.out.println(dateStr);
            EDSUtil.logToEDS(dateStr);
            long interval = (long)(Math.random() * 5000L);
            System.out.println(interval);
            Thread.sleep(interval);
            logDate = DateUtil.addDay(1, logDate);
        }
    }
}
